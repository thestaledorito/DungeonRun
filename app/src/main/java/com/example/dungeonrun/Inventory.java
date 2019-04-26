package com.example.dungeonrun;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Inventory extends AppCompatActivity  {
    Player player;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        player = setPlayer();

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
