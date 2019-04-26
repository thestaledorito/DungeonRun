package com.example.dungeonrun;

public class Sword extends Equipment {
    private int stat;
    private String name;
    private int quality;
    private int bonus;

    public Sword(int q,int b){

        name = "Sword";
        quality = q;
        stat = ((quality-1)*5)+b;
        bonus = b;
    }

    public String getName(){
        String type ="";
        switch(quality){
            case 1:type="Wooden";
                break;
            case 2:type="Stone";
                break;
            case 3:type="Iron";
                break;
            case 4:type="Steel";
                break;
            case 5:type="Mithril";
                break;
            case 6:type="Adamantite";
                break;
            case 7:type="Rune";
                break;
            case 8:type="Crystal";
                break;
            case 9:type="Obsidian";
                break;
            case 10:type="Golden";
                break;
            default: type="A";
                break;
        }
        return type+" "+name+"+"+bonus;
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
