package com.example.dungeonrun;

import java.io.Serializable;

public class Player implements Serializable {
    private int playerLVL;
    private double playerATK;
    private double playerXP;
    private double maxHP;
    private double currentHP;
    private int playerDex;
    private boolean dead;
    private int playerVit;
    private int skillPoints;

    Player(int l, int atk, int xp, double hp){
        playerLVL = l;
        playerATK = atk;
        playerXP = xp;
        maxHP = hp;
        currentHP = hp;
    }
    public void gainLevel(){
        playerLVL++;
        skillPoints+=2;
    }

    public void gainXP(double xp){
        if((playerXP+xp)>=1000){
            gainLevel();
            playerXP = (playerXP+xp)-1000;
        } else {
            playerXP += xp;
        }
    }

    public int getLVL(){
        return playerLVL;
    }

    public double getATK(){
        return playerATK;
    }

    public double getXP(){
        return playerXP;
    }

    public void healPlayer(double amount) {
        if((currentHP+amount)>maxHP) {
            currentHP = maxHP;
        } else {
            currentHP += amount;
        }
    }

    public double getHP() {
        return currentHP;
    }

    public void damagePlayer(double amount) {
        if((currentHP-amount)<=0) {
            currentHP = 0;
            dead = true;
        } else {
            currentHP -= amount;
        }
    }

    public int getDex() {
        return playerDex;
    }

    public boolean isDead(){
        return dead;
    }

    public double getMaxHP(){ return maxHP;}

    public int getVit(){ return playerVit;}

    public void isAlive() { dead = false;}

    public int getSkillPoints(){
        return skillPoints;
    }
}
