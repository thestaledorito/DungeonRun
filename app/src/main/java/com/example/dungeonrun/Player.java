package com.example.dungeonrun;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


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
    private ArrayList<Boots> bootsInv;
    private ArrayList<Chestpiece> chestInv;
    private ArrayList<Pants> pantsInv;
    private ArrayList<Sword> swordInv;
    private Boots equippedBoots;
    private Chestpiece equippedChest;
    private Pants equippedPants;
    private Sword equippedSword;


    Player(int l, int atk, int xp, double hp){
        playerLVL = l;
        playerATK = atk;
        playerXP = xp;
        maxHP = hp;
        currentHP = hp;
        bootsInv = new ArrayList<>();
        chestInv = new ArrayList<>();
        pantsInv = new ArrayList<>();
        swordInv = new ArrayList<>();
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

    public void removeSkillPoint(){skillPoints--;}

    public void gainATK(){playerATK++;}

    public void gainDEX(){playerDex++;}

    public void gainVIT(){playerVit++;}

    public void gainHP(){maxHP+=5;}

    public void gainATK(int n){playerATK+=n;}

    public void gainDEX(int n){playerDex+=n;}

    public void gainVIT(int n){playerVit+=n;}

    public void gainHP(int n){maxHP+=n;}

    public void removeATK(int n){
        if(playerATK-n > 0) {
            playerATK -= n;
        } else {
            playerATK = 0;
        }
    }

    public void removeDEX(int n){
        if(playerDex-n > 0) {
            playerDex -= n;
        } else {
            playerDex = 0;
        }
    }

    public void removeVIT(int n){
        if(playerVit-n > 0) {
            playerVit -= n;
        } else {
            playerVit = 0;
        }
    }

    public void removeHP(int n){
        if(maxHP-n > 0) {
            maxHP -= n;
        } else {
            maxHP = 0;
        }
    }

    public void obtainItem(Equipment e){

        if(e.getClass() == Boots.class){
            bootsInv.add((Boots)e);
            Collections.sort(bootsInv);
        } else if(e.getClass() == Chestpiece.class){
            chestInv.add((Chestpiece)e);
            Collections.sort(chestInv);
        } else if(e.getClass() == Sword.class){
            swordInv.add((Sword)e);
            Collections.sort(swordInv);
        } else if(e.getClass() == Pants.class){
            pantsInv.add((Pants)e);
            Collections.sort(pantsInv);
        }

    }

    public ArrayList<Boots> getBootsInv(){
        return bootsInv;
    }

    public ArrayList<Pants> getPantsInv(){
        return pantsInv;
    }

    public ArrayList<Chestpiece> getChestInv(){
        return chestInv;
    }

    public ArrayList<Sword> getSwordInv(){
        return swordInv;
    }

    public void equipItem(Equipment e){
        if(e.getClass() == Boots.class){
            if(equippedBoots == null){
                equippedBoots = (Boots) e;
                bootsInv.remove(e);
                gainDEX(e.getStat());
            } else {
                unequipItem(getEquippedBoots());
                equippedBoots = (Boots) e;
                bootsInv.remove(e);
                gainDEX(e.getStat());
            }

        }else if (e.getClass() == Chestpiece.class){
            if(equippedChest == null){
                equippedChest = (Chestpiece) e;
                chestInv.remove(e);
                gainHP(e.getStat());
            } else {
                unequipItem(getEquippedChest());
                equippedChest = (Chestpiece) e;
                chestInv.remove(e);
                gainHP(e.getStat());
            }
        } else if(e.getClass() == Sword.class){
            if(equippedSword == null){
                equippedSword = (Sword) e;
                swordInv.remove(e);
                gainATK(e.getStat());
            } else {
                unequipItem(getEquippedSword());
                equippedSword = (Sword) e;
                swordInv.remove(e);
                gainATK(e.getStat());
            }
        } else if(e.getClass() == Pants.class){
            if(equippedPants == null){
                equippedPants = (Pants) e;
                pantsInv.remove(e);
                gainVIT(e.getStat());
            } else {
                unequipItem(getEquippedPants());
                equippedPants = (Pants) e;
                pantsInv.remove(e);
                gainVIT(e.getStat());
            }
        }

    }

    public void unequipItem(Equipment e){

        if(e.getClass() == Boots.class){
            if(equippedBoots != null){
                obtainItem(e);
                equippedBoots = null;
                removeDEX(e.getStat());
            }

        } else if(e.getClass() == Chestpiece.class){
            if(equippedChest != null){
                obtainItem(e);
                equippedChest = null;
                removeHP(e.getStat());
            }
        } else if(e.getClass() == Sword.class){
            if(equippedBoots != null){
                obtainItem(e);
                equippedSword = null;
                removeATK(e.getStat());
            }
        } else if(e.getClass() == Pants.class){
            if(equippedBoots != null){
                obtainItem(e);
                equippedPants = null;
                removeVIT(e.getStat());
            }
        }

    }

    public Boots getEquippedBoots(){
        return equippedBoots;
    }

    public Sword getEquippedSword(){
        return equippedSword;
    }

    public Pants getEquippedPants(){
        return equippedPants;
    }

    public Chestpiece getEquippedChest(){
        return equippedChest;
    }






}
