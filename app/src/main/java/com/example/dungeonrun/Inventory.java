package com.example.dungeonrun;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class Inventory extends AppCompatActivity  {
    Player player;
    LinearLayout parent;
    Button e1;
    LinearLayout.LayoutParams params;
    Button Pants;
    Button Chestpeice;
    Button Sword;
    Button Boots;
    Button Loadout;
    Button Back;
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.inventory);
        super.onCreate(savedInstanceState);
        player = setPlayer();
         parent = new LinearLayout(this);
         params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
         parent.setOrientation(LinearLayout.VERTICAL);

        refresh();

       Pants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            generateButtons(1,0);
            }
        });
        Boots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateButtons(2,0);
            }
        });
        Chestpeice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateButtons(3,0);
            }
        });
        Sword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateButtons(4,0);
            }
        });
        Loadout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateButtons(5,0);



            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Inventory.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("P",player);
                myIntent.putExtras(bundle);
                startActivity(myIntent);
            }
        });
        }
        public void refresh(){
             Pants= findViewById(R.id.Pants);
            Chestpeice = findViewById(R.id.Chestplate);
             Sword = findViewById(R.id.Sword);
             Boots = findViewById(R.id.Boots);
             Loadout = findViewById(R.id.Loadout);
             Back = findViewById(R.id.Back);
        }


    public void generateButtons(final int e,final int c) {
        parent.removeAllViews();

        final ArrayList<Pants> Pants = player.getPantsInv();
        final ArrayList<Boots> Boots = player.getBootsInv();
        final ArrayList<Chestpiece> Chest = player.getChestInv();
        final ArrayList<Sword> Sword = player.getSwordInv();
        e1 = new Button(this);
        e1.setId(-1);
        e1.setText("Back");
        e1.setTag(-1);
        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

        parent.addView(e1, params);
        this.setContentView(parent, params);
        if (e == 1) {

            for (int i = c, j = c + 6; i < Pants.size() && i < j; i++) {

                e1 = new Button(this);
                e1.setId(i);

                e1.setText(Pants.get(i).getName());
                e1.setTag(i);

                parent.addView(e1, params);
                this.setContentView(parent, params);
                e1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        player.equipItem(Pants.get(v.getId()));


                        generateButtons(1, 0);
                    }
                });
            }


        } else if (e == 2) {

            for (int i = c, j = c + 6; i < Boots.size() && i < j; i++) {

                e1 = new Button(this);
                e1.setId(i);

                e1.setText(Boots.get(i).getName());
                e1.setTag(i);

                parent.addView(e1, params);
                this.setContentView(parent, params);
                e1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        player.equipItem(Boots.get(v.getId()));


                        generateButtons(2, 0);
                    }
                });
            }
        } else if (e == 3) {

            for (int i = c, j = c + 6; i < Chest.size() && i < j; i++) {

                e1 = new Button(this);
                e1.setId(i);

                e1.setText(Chest.get(i).getName());
                e1.setTag(i);

                parent.addView(e1, params);
                this.setContentView(parent, params);
                e1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        player.equipItem(Chest.get(v.getId()));


                        generateButtons(3, 0);
                    }
                });
            }
        } else if(e ==4) {

            for (int i = c, j = c + 6; i < Sword.size() && i < j; i++) {

                e1 = new Button(this);
                e1.setId(i);

                e1.setText(Sword.get(i).getName());
                e1.setTag(i);

                parent.addView(e1, params);
                this.setContentView(parent, params);
                e1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        player.equipItem(Sword.get(v.getId()));


                        generateButtons(4, 0);
                    }
                });
            }
        }
        else{

            if(player.getEquippedPants() != null) {
                e1 = new Button(this);
                e1.setText(player.getEquippedPants().getName());
                parent.addView(e1, params);
                this.setContentView(parent, params);
                e1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        player.unequipItem(player.getEquippedPants());
                        generateButtons(e, 0);
                    }
                });
            }
            else{
                e1 = new Button(this);
                e1.setText("No Pants");
                parent.addView(e1,params);
                this.setContentView(parent,params);
                e1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        generateButtons(1,0);
                    }
                });
            }
            if(player.getEquippedBoots() != null) {
                e1 = new Button(this);
                e1.setText(player.getEquippedBoots().getName());
                parent.addView(e1, params);
                this.setContentView(parent, params);
                e1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        player.unequipItem(player.getEquippedBoots());
                        generateButtons(e, 0);
                    }
                });
            }
            else{
                e1 = new Button(this);
                e1.setText("No Boots");
                parent.addView(e1,params);
                this.setContentView(parent,params);
                e1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        generateButtons(2,0);
                    }
                });
            }
            if(player.getEquippedChest() != null) {
                e1 = new Button(this);
                e1.setText(player.getEquippedChest().getName());
                parent.addView(e1, params);
                this.setContentView(parent, params);
                e1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        player.unequipItem(player.getEquippedChest());
                        generateButtons(e, 0);
                    }
                });
            }
            else{
                e1 = new Button(this);
                e1.setText("No Chest");
                parent.addView(e1,params);
                this.setContentView(parent,params);
                e1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        generateButtons(3,0);
                    }
                });
            }
            if(player.getEquippedSword() != null) {
                e1 = new Button(this);
                e1.setText(player.getEquippedSword().getName());
                parent.addView(e1, params);
                this.setContentView(parent, params);
                e1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        player.unequipItem(player.getEquippedSword());
                        generateButtons(e, 0);
                    }
                });
            }
            else{
                e1 = new Button(this);
                e1.setText("No Sword");
                parent.addView(e1,params);
                this.setContentView(parent,params);
                e1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        generateButtons(4,0);
                    }
                });
            }
        }
        if(e <=4) {
            e1 = new Button(this);
            e1.setText("Prev Page");
            parent.addView(e1, params);
            this.setContentView(parent, params);
            e1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (e == 1) {
                        if (c - 6 < 0) {
                            generateButtons(1, 0);
                        } else {
                            generateButtons(1, c - 6);
                        }
                    } else if (e == 2) {
                        if (c - 6 < 0) {
                            generateButtons(2, 0);
                        } else {
                            generateButtons(2, c - 6);
                        }
                    } else if (e == 3) {
                        if (c - 6 < 0) {
                            generateButtons(3, 0);
                        } else {
                            generateButtons(3, c - 6);
                        }

                    } else {
                        if (c - 6 < 0) {
                            generateButtons(4, 0);
                        } else {
                            generateButtons(4, c - 6);
                        }

                    }
                }
            });
            e1 = new Button(this);
            e1.setText("Next Page");
            parent.addView(e1, params);
            this.setContentView(parent, params);
            e1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (e == 1) {
                        if (c + 6 > Pants.size()) {
                            generateButtons(1, Pants.size() - 6);
                        } else {
                            generateButtons(1, c + 6);
                        }
                    } else if (e == 2) {
                        if (c + 6 > Boots.size()) {
                            generateButtons(2, Boots.size() - 6);
                        } else {
                            generateButtons(2, c + 6);
                        }
                    } else if (e == 3) {
                        if (c + 6 > Chest.size()) {
                            generateButtons(3, Chest.size() - 6);
                        } else {
                            generateButtons(3, c + 6);
                        }

                    } else {
                        if (c + 6 > Sword.size()) {
                            generateButtons(4, Sword.size() - 6);
                        } else {
                            generateButtons(4, c + 6);
                        }

                    }
                }
            });
        }
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
