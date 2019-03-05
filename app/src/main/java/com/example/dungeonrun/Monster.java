package com.example.dungeonrun;
public class Monster{
	private double monsterHP;
	private double monsterATK;
	private double monsterValue;
	private boolean dead;
	
Monster(double h, double atk, double val){
	monsterHP = h;
	monsterATK = atk;
	monsterValue = val;
	dead = false;
}

public void takeDMG(double dmg){
	if((monsterHP - dmg) <= 0){
		monsterHP = 0;
		killMonster();
	} else {
		monsterHP -= dmg;
	}
}

public void killMonster(){
	dead = true;
}

public boolean isDead(){
	if(dead == false){
		return false;
	} else {
		return true;
	}
}

	
public double getATK(){
	return monsterATK;
}
	
public double getValue(){
	return monsterValue;
}

public double getHP(){
	return monsterHP;
}
}

