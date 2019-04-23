package com.example.dungeonrun;

public class Chestpiece extends Equipment{
    private int stat;
    private String name;
    private int quality;
    private int bonus;

    public Chestpiece(int q,int b){

        name = "Wooden Platebody";
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

    @Override
    public int compareTo(Equipment o) {
        return this.getStat() - o.getStat();
    }
}
