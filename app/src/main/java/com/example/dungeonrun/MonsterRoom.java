package com.example.dungeonrun;
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
