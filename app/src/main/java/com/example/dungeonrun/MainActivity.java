package com.example.dungeonrun;


import android.content.Context;
import android.content.Intent;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity implements SensorEventListener {


    Player player;

    int dungeonLevel = 1;
    int roomsCleared = 0;
    private SensorManager sensorManager;
    private Sensor stepDetector;

    Room currentRoom = new startingRoom(dungeonLevel);
    ProgressBar playerHealth = null;

    ProgressBar monsterHealth = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        player =   setPlayer();
        super.onCreate(savedInstanceState);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        stepDetector = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR),sensorManager.SENSOR_DELAY_NORMAL);

        setContentView(R.layout.activity_main);
        playerHealth = findViewById(R.id.playerHealth);
        monsterHealth = findViewById(R.id.monsterHealth);
        display();
        Button step = findViewById(R.id.step);
        Button levelUp = findViewById(R.id.levelUp);
        Button Inventory = findViewById(R.id.inventory);
        generateEquipment();
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
                Intent myIntent = new Intent(MainActivity.this, levelUp.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("P",player);
                myIntent.putExtras(bundle);
                startActivity(myIntent);
            }
        });
        Inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Inventory.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("P",player);
                myIntent.putExtras(bundle);
                startActivity(myIntent);
            }
        });


    }

    public void onAccuracyChanged(Sensor s, int i) {

    }

    public void onSensorChanged(SensorEvent event) {
        currentRoom = checkRoom(currentRoom);
        currentRoom.roomFunction(player);
        checkPlayer();
        display();
    }

    public Room checkRoom(Room currentRoom) {
        Random randomGen = new Random();
        if (currentRoom.finished) {
            roomsCleared++;
            if (roomsCleared >= 45+(5*dungeonLevel)) {
                dungeonLevel++;
                currentRoom = new startingRoom(dungeonLevel);
                player.healPlayer(player.getMaxHP());
                player.isAlive();
                roomsCleared = 0;
            } else {
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
        }
        return currentRoom;
    }

    public void checkPlayer() {
        if (player.isDead()) {

            if (dungeonLevel == 1) {


            } else {
                dungeonLevel--;
            }
            currentRoom = new startingRoom(dungeonLevel);
            roomsCleared =0;
            player.healPlayer(player.getMaxHP());
            player.isAlive();
        }
    }
    public void generateEquipment(){

        Boots a = new Boots(4,2);
        Boots b = new Boots(1,3);
        Boots c = new Boots(5,1);
        Pants d = new Pants(2,3);
        Pants e = new Pants(2,2);
        Pants f = new Pants(1,1);


        player.obtainItem(a);
        player.obtainItem(b);
        player.obtainItem(c);
        player.obtainItem(d);
        player.obtainItem(e);
        player.obtainItem(f);
        player.obtainItem(a);
        player.obtainItem(b);
        player.obtainItem(c);
        player.obtainItem(d);
        player.obtainItem(e);
        player.obtainItem(f);
        player.obtainItem(a);
        player.obtainItem(b);
        player.obtainItem(c);
        player.obtainItem(d);
        player.obtainItem(e);
        player.obtainItem(f);
        player.obtainItem(a);
        player.obtainItem(b);
        player.obtainItem(c);
        player.obtainItem(d);
        player.obtainItem(e);
        player.obtainItem(f);
    }


    public void display() {

        ((TextView) findViewById(R.id.currentHealth)).setText(Double.toString(player.getHP()));
        ((TextView) findViewById(R.id.currentAttack)).setText(Double.toString(player.getATK()));
        ((TextView) findViewById(R.id.expBar)).setText(Double.toString(player.getXP())+"/100");
        ((TextView) findViewById(R.id.currentLevel)).setText(Double.toString(player.getLVL()));
        ((TextView) findViewById(R.id.room)).setText(currentRoom.getRoomType());

        if (currentRoom.getRoomType().equals("Monster")) {


            monsterHealth.setVisibility(View.VISIBLE);
            monsterHealth.setScaleY(3f);
            monsterHealth.setMax((int)((MonsterRoom) currentRoom).getRoomMonster().getMaxHP());
            monsterHealth.setProgress((int)((MonsterRoom) currentRoom).getRoomMonster().getHP());
            monsterHealth.setProgressDrawable(getResources().getDrawable(R.drawable.greenprogress));

        } else {


            monsterHealth.setVisibility(View.GONE);
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
        playerHealth.setScaleY(.5f);
        playerHealth.setMax((int)player.getMaxHP());
        playerHealth.setProgress((int)player.getHP());
        playerHealth.setProgressDrawable(getResources().getDrawable(R.drawable.greenprogress));
        playerHealth.setVisibility(View.VISIBLE);




    }


    public Player setPlayer()
    {


        Player player1 = new Player(1, 1, 0, 100,1,1);
        Intent intent = getIntent();
        if(intent != null) {
            Bundle extras = getIntent().getExtras();


            if (extras != null) {

                player1 = (Player)intent.getSerializableExtra("P");

            } else if (extras == null) {
                System.out.println("Null");

            }
        }
        System.out.println(intent.toString());
        return player1;


    }


    }


