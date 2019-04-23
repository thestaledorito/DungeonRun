package com.example.dungeonrun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class levelUp  extends AppCompatActivity {

    Player player = setPlayer();

    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.levelup);
        Button ATK = findViewById(R.id.atkUp);
        Button DEX = findViewById(R.id.dexUp);
        Button VIT = findViewById(R.id.vitUp);
        Button HP = findViewById(R.id.healthUp);
        Button goBack = findViewById(R.id.goBack);
        super.onCreate(savedInstanceState);
        display();
        ATK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player.getSkillPoints() > 0) {
                    player.gainATK();
                    player.removeSkillPoint();

                }
                display();
            }
        });

        DEX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player.getSkillPoints() > 0) {
                    player.gainDEX();
                    player.removeSkillPoint();

                }
                display();
            }
        });
        VIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player.getSkillPoints() > 0) {
                    player.gainVIT();
                    player.removeSkillPoint();

                }
                display();
            }
        });
        HP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player.getSkillPoints() > 0) {
                    player.gainHP();
                    player.removeSkillPoint();

                }
                display();
            }
        });
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                myIntent.putExtra("Player", player);
                startActivity(myIntent);
            }
        });


    }

    public Player setPlayer()
    {


        Player player1 = new Player(1, 1, 0, 100);
        if(getIntent() != null)
        {
            Intent intent = getIntent();
            intent.getStringExtra("Player");
            player1 = (Player)intent.getSerializableExtra("Player");



        }
        return player1;


    }
    public void display() {
        ((TextView) findViewById(R.id.healthText)).setText(Double.toString(player.getHP()));
        ((TextView) findViewById(R.id.atkText)).setText(Double.toString(player.getATK()));
        ((TextView) findViewById(R.id.dexText)).setText(Double.toString(player.getDex()));
        ((TextView) findViewById(R.id.vitText)).setText(Double.toString(player.getVit()));
        ((TextView) findViewById(R.id.skillPoints)).setText(Double.toString(player.getSkillPoints()));




    }
}
