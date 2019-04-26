package com.example.dungeonrun;

import java.io.Serializable;

public abstract class Equipment implements Comparable<Equipment>, Serializable {

    private int stat;
    private String name;
    private int quality;
    private int bonus;

    public abstract String getName();

    public abstract int getStat();

    public abstract int getQuality();
}
