package com.example.dungeonrun;
import java.util.Random;


public class HealRoom extends Room {

	Random randomNum = new Random();
	int dungeonLevel;
	
	HealRoom(int level) {
		this.finished = false;
		dungeonLevel = level;
	}

	public void roomFunction(Player player) {
		player.healPlayer(2+((player.getVit() * dungeonLevel)));
		if (randomNum.nextInt(2) == 1) {
			this.finished = true;
		}
	}

	@Override
	public String getRoomType() {
		return "Heal";
		
	}
}
