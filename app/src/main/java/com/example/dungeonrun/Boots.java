package com.example.dungeonrun;

public class Boots extends Equipment {
    int stat;
    String name;
    int quality;
    int bonus;

    public Boots(int q,int b){

        name = "Wooden Boots";
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
