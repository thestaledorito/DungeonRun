package com.example.dungeonrun;

import java.util.Random;

public class MonsterRoom extends Room {
	Monster roomMonster;
	double hpScaling = 5;
	double atkScaling = .5;
	double xpScaling = 1.2;
	int dungeonLevel;

	//Creates a new Monster for the player. Monster stats start at 10 hp, 1atk, and 10xp, and scale up based on the scaling variables
	MonsterRoom(int level) {
	    dungeonLevel = level;
		roomMonster = new Monster(10+(hpScaling*dungeonLevel),1+(atkScaling*dungeonLevel),(10*Math.pow(xpScaling,dungeonLevel)));
		this.finished = false;
	}

	//Deals the players damage to the monster and deals the monsters damage to the player. If the monster is dead after this hit, set the room to finished and dish out xp
	public void roomFunction(Player player) {
		roomMonster.takeDMG(player.getATK());
		player.damagePlayer(roomMonster.getATK());
		if (roomMonster.isDead()) {
			Random randomGen = new Random();
			int itemValue = (randomGen.nextInt(dungeonLevel)+1);
			int itemType = (randomGen.nextInt(4)+1);
			int itemBonus;
			int bonusRoll = (randomGen.nextInt(100));
			if(bonusRoll < 70){
				itemBonus = 0;
			} else if(bonusRoll<80){
				itemBonus = 1;
			} else if(bonusRoll<85){
				itemBonus = 2;
			} else if(bonusRoll<95){
				itemBonus = 3;
			} else if(bonusRoll<99){
				itemBonus = 4;
			} else {
				itemBonus = 5;
			}

			switch(itemType){
				case 1: Boots b = new Boots(itemValue,itemBonus);
				player.obtainItem(b);
					System.out.println("Got" + b.getName());
				break;
				case 2: Pants p = new Pants(itemValue,itemBonus);
					player.obtainItem(p);
					System.out.println("Got" + p.getName());
					break;
				case 3: Sword s = new Sword(itemValue,itemBonus);
					player.obtainItem(s);
					System.out.println("Got" + s.getName());
					break;
				case 4: Chestpiece c = new Chestpiece(itemValue,itemBonus);
					player.obtainItem(c);
					System.out.println("Got" + c.getName());
					break;
				default: break;
			}

			player.gainXP(roomMonster.getValue());
			player.damagePlayer(roomMonster.getATK());
			this.finished = true;
		} else {

		}
	}
	
	public String getRoomType() {
		return "Monster";
	}

	public Monster getRoomMonster(){
		return roomMonster;
	}


}
