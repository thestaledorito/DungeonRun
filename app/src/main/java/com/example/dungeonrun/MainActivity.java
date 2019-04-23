package com.example.dungeonrun;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;

public class MainActivity extends AppCompatActivity {


    Player player = setPlayer();

    int dungeonLevel = 1;

    Room currentRoom = new startingRoom(dungeonLevel);


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display();
        Button step = findViewById(R.id.step);
        Button levelUp = findViewById(R.id.levelUp);
        step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentRoom = checkRoom(currentRoom);
                currentRoom.roomFunction(player);
                checkPlayer();
                display();
            }
        });
        levelUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), levelUp.class);
                myIntent.putExtra("Player", player);
                startActivity(myIntent);
            }
        });


    }

    public Room checkRoom(Room currentRoom) {
        Random randomGen = new Random();
        if (currentRoom.finished) {
            //Creating a random room besides a starting room
            int type = randomGen.nextInt(3) + 1;
            switch (type) {
                case 1:
                    currentRoom = new MonsterRoom(dungeonLevel);
                    break;
                case 2:
                    currentRoom = new HealRoom(dungeonLevel);
                    break;
                case 3:
                    currentRoom = new TrapRoom(dungeonLevel);
                    break;
            }

        }
        return currentRoom;
    }

    public void checkPlayer() {
        if (player.isDead()) {
            if (dungeonLevel == 1) {
                return;
            } else {
                dungeonLevel--;
            }
            currentRoom = new startingRoom(dungeonLevel);
            player.healPlayer(player.getMaxHP());
            player.isAlive();
        }
    }

    public void display() {
        ((TextView) findViewById(R.id.currentHealth)).setText(Double.toString(player.getHP()));
        ((TextView) findViewById(R.id.currentAttack)).setText(Double.toString(player.getATK()));
        ((TextView) findViewById(R.id.expBar)).setText(Double.toString(player.getXP()));
        ((TextView) findViewById(R.id.currentLevel)).setText(Double.toString(player.getLVL()));
        ((TextView) findViewById(R.id.room)).setText(currentRoom.getRoomType());

        if (currentRoom.getRoomType().equals("Monster")) {
            ((TextView) findViewById(R.id.MonsterHealth)).setText(Double.toString(((MonsterRoom) currentRoom).getRoomMonster().getHP()));
            ((TextView) findViewById(R.id.Monster)).setText("Monster Health");
        } else {
            ((TextView) findViewById(R.id.MonsterHealth)).setText("");
            ((TextView) findViewById(R.id.Monster)).setText("");
        }
        ((TextView) findViewById(R.id.dungeonLevel)).setText(Integer.toString(dungeonLevel));
        //Change this to level up points later on
        if (player.getSkillPoints() > 0) {
            findViewById(R.id.levelUp).setBackgroundColor(getResources().getColor(R.color.colorGreen));
        }
        else
        {
            findViewById(R.id.levelUp).setBackgroundColor(getResources().getColor(R.color.colorRed));
        }


    }


    public Player setPlayer()
    {


        Player player1 = new Player(1, 1, 0, 100);
        if(getIntent() != null)
        {
            Intent intent = getIntent();
            Bundle extras = getIntent().getExtras();
            String extraStr = extras.getString("Player");
            player1 = (Player)intent.getSerializableExtra("Player");



        }
        return player1;


    }


    }


