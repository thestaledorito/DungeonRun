package com.example.dungeonrun;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class levelUp  extends AppCompatActivity {

    Player player;


    protected void onCreate(Bundle savedInstanceState) {
        player = setPlayer();

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
                Intent myIntent = new Intent(levelUp.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("P",player);
                myIntent.putExtras(bundle);
                startActivity(myIntent);
            }
        });


    }


    public Player setPlayer()
    {


        Player player1 = new Player(1, 1, 0, 100);
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



    public void display() {
        ((TextView) findViewById(R.id.healthText)).setText(Double.toString(player.getMaxHP()));
        ((TextView) findViewById(R.id.atkText)).setText(Double.toString(player.getATK()));
        ((TextView) findViewById(R.id.dexText)).setText(Double.toString(player.getDex()));
        ((TextView) findViewById(R.id.vitText)).setText(Double.toString(player.getVit()));
        ((TextView) findViewById(R.id.skillPoints)).setText(Double.toString(player.getSkillPoints()));








    }
}
