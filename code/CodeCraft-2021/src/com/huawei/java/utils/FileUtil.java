package com.huawei.java.utils;

import com.huawei.java.model.Server;
import com.huawei.java.model.VM;
import com.huawei.java.operation.Operation;
import com.huawei.java.operation.VMOperation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtil {
    public int serverNumber;
    public Map<String, Server> servers;
    public List<Server> serverList;
    public int vmNumber;
    public Map<String, VM> vms;
    public int days;
    public List<List<Operation>> operations;

    public FileUtil(String filePath) {
        File file = new File(filePath);
        servers = new HashMap<>();
        serverList = new ArrayList<>();
        vms = new HashMap<>();
        operations = new ArrayList<>();
        try {
            FileReader fb = new FileReader(file);
            BufferedReader br = new BufferedReader(fb);
            String line;
            String[] information;
            serverNumber = Integer.parseInt(br.readLine());
            for (int i = 0; i < serverNumber; i++) {
                line = br.readLine();
                information = line.substring(1, line.length() - 1).split(",");
                servers.put(information[0], new Server(information[0], Integer.parseInt(information[1].trim()),
                        Integer.parseInt(information[2].trim()), Integer.parseInt(information[3].trim()),
                        Integer.parseInt(information[4].trim())));
                serverList.add(new Server(information[0], Integer.parseInt(information[1].trim()),
                        Integer.parseInt(information[2].trim()), Integer.parseInt(information[3].trim()),
                        Integer.parseInt(information[4].trim())));
            }
            vmNumber = Integer.parseInt(br.readLine());
            for (int i = 0; i < vmNumber; i++) {
                line = br.readLine();
                information = line.substring(1, line.length() - 1).split(",");
                vms.put(information[0], new VM(information[0], Integer.parseInt(information[1].trim()),
                        Integer.parseInt(information[2].trim()), information[3].trim().equals("1")));
            }
            days = Integer.parseInt(br.readLine());
            for (int i = 0; i < days; i++) {
                int orders = Integer.parseInt(br.readLine());
                List<Operation> operations_daily = new ArrayList<>();
                for (int j = 0; j < orders; j++) {
                    line = br.readLine();
                    information = line.substring(1, line.length() - 1).split(",");
                    if (information[0].equals("add"))
                        operations_daily.add(new VMOperation(information[0], information[1].trim(),
                            Integer.parseInt(information[2].trim())));
                    else
                        operations_daily.add(new VMOperation(information[0], null,
                                Integer.parseInt(information[1].trim())));
                }
                operations.add(operations_daily);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getServerNumber() {
        return serverNumber;
    }

    public Map<String, Server> getServers() {
        return servers;
    }

    public List<Server> getServerList() {
        return serverList;
    }

    public int getVmNumber() {
        return vmNumber;
    }

    public Map<String, VM> getVms() {
        return vms;
    }

    public int getDays() {
        return days;
    }

    public List<List<Operation>> getOperations() {
        return operations;
    }
}
