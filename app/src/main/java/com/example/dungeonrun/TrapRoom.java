package com.example.dungeonrun;
import java.util.Random;

public class TrapRoom extends Room{
	Random randomGen = new Random();
	int dungeonLevel;

	TrapRoom (int dungeonLevel){
		this.finished = false;
	}
	
	public void roomFunction(Player player) {
		player.damagePlayer((dungeonLevel*5) - player.getDex());

		if (randomGen.nextInt(2) == 1) {
			this.finished = true;
		}
		
	}

	@Override
	public String getRoomType() {
		return "Trap";
		
	}
}
