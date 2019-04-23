package com.example.dungeonrun;

public class Pants extends Equipment {
    private int stat;
    private String name;
    private int quality;
    private int bonus;

    public Pants(int q,int b){

        name = "Wooden Platelegs";
        quality = q;
        stat = ((quality-1)*5)+b;
        bonus = b;
    }

    public String getName(){
        return name+"+"+bonus;
    }

    public int getStat(){
        return stat;
    }

    public int getQuality(){
        return quality;
    }

    public int compareTo(Equipment o) {
        return this.getStat() - o.getStat();
    }
}
