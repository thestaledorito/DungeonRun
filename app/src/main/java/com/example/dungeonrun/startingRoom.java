package com.example.dungeonrun;
public class startingRoom extends Room{

	int dungeonLevel;

	startingRoom(int level){
		this.finished = true;
		dungeonLevel = level;
	}

	@Override
	public void roomFunction(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getRoomType() {
		return "Starting";
		
	}
}
