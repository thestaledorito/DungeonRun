package com.example.dungeonrun;

public abstract class Equipment implements Comparable<Equipment> {

    private int stat;
    private String name;
    private int quality;
    private int bonus;

    public abstract String getName();

    public abstract int getStat();

    public abstract int getQuality();
}
