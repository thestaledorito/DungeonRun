package com.example.dungeonrun;

public abstract class Room {
	// Room types: 1=Monster
	boolean finished;
	int dungeonLevel;


	
	public abstract void roomFunction(Player player);
	
	public abstract String getRoomType();
}