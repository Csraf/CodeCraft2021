package com.huawei.java.model;

import java.util.ArrayList;
import java.util.List;

public class Server implements Comparable<Server>{
    private final String type;
    private final int core;
    private final int memory;
    private final int hardwareCost;
    private final int energyCost;
    private int a;
    private int b;

    public Server(String type, int core, int memory, int hardwareCost, int energyCost) {
        this.type = type;
        this.core = core;
        this.memory = memory;
        this.hardwareCost = hardwareCost;
        this.energyCost = energyCost;
        a = 1000;
        b = 910;
    }

    public String getType() {
        return type;
    }

    public int getCore() {
        return core;
    }

    public int getMemory() {
        return memory;
    }

    public boolean isEnough(int core, int memory) {
        return this.core / 2 >= core && this.memory / 2 >= memory;
    }

    public boolean isEnoughDual(int core, int memory) {
        return this.core >= core && this.memory >= memory;
    }

    public int getHardwareCost() {
        return hardwareCost;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public int compareTo(Server o) {
//        return this.hardwareCost - o.hardwareCost;
        return this.energyCost - o.energyCost;
//        return (int) Math.round(this.hardwareCost * (1.0 - (double) a / this.hardwareCost / (this.core * 0.75 + this.memory * 0.25) - (double) b / this.energyCost) - o.hardwareCost * (1.0 - (double) a / o.hardwareCost / (o.core * 0.75 + o.memory * 0.25) - (double) b / o.energyCost));
//        return (int) Math.round(5000 * this.hardwareCost / (this.core * 0.7 + this.memory * 0.3) - 5000 * o.hardwareCost / (o.core * 0.7 + o.memory * 0.3)) + this.hardwareCost - o.hardwareCost + 1000 * this.energyCost - 1000 * o.energyCost;
    }
}
