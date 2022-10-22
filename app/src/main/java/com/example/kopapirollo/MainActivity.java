package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView ImageViewPlayer, ImageViewComputer;
    private Button ButtonKo, ButtonPapir, ButtonOllo;
    private TextView TextViewEredmeny;
    private int computerpoint, playerpoint;
    private AlertDialog gamefinish;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        ButtonKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageViewPlayer.setImageResource(R.drawable.rock);

                if (getTipp() == 2) {
                    ImageViewComputer.setImageResource(R.drawable.scissors);
                    playerpoint++;

                } else if (getTipp() == 1) {
                    ImageViewComputer.setImageResource(R.drawable.paper);
                    computerpoint++;

                } else {

                    ImageViewComputer.setImageResource(R.drawable.rock);
                }

                TextViewEredmeny.setText("Eredmény: Ember:" + playerpoint + " Computer:" + computerpoint);
                JatekVege();


            }
        });

        ButtonPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageViewPlayer.setImageResource(R.drawable.paper);

                if (getTipp() == 0) {
                    ImageViewComputer.setImageResource(R.drawable.rock);
                    playerpoint++;

                } else if (getTipp() == 2) {
                    ImageViewComputer.setImageResource(R.drawable.scissors);
                    computerpoint++;

                } else {
                    ImageViewComputer.setImageResource(R.drawable.paper);

                }
                TextViewEredmeny.setText("Eredmény: Ember:" + playerpoint + " Computer:" + computerpoint);
                JatekVege();

            }
        });

        ButtonOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageViewPlayer.setImageResource(R.drawable.scissors);

                if (getTipp() == 1) {
                    ImageViewComputer.setImageResource(R.drawable.paper);
                    playerpoint++;

                } else if (getTipp() == 0) {
                    ImageViewComputer.setImageResource(R.drawable.rock);
                    computerpoint++;

                } else {
                    ImageViewComputer.setImageResource(R.drawable.scissors);
                }
                TextViewEredmeny.setText("Eredmény: Ember:" + playerpoint + " Computer:" + computerpoint);
                JatekVege();

            }
        });

    }


    private void init() {


        ImageViewPlayer = findViewById(R.id.ImageViewPlayer);
        ImageViewComputer = findViewById(R.id.ImageViewComputer);
        ButtonKo = findViewById(R.id.ButtonKo);
        ButtonPapir = findViewById(R.id.ButtonPapir);
        ButtonOllo = findViewById(R.id.ButtonOllo);
        TextViewEredmeny = findViewById(R.id.TextViewEredmeny);
        playerpoint = 0;
        computerpoint = 0;
        gamefinish = new AlertDialog.Builder(MainActivity.this)
                .setCancelable(false)
                .setMessage("Szeretne új játékot kezdeni?")
                .setTitle("Nyertél/Vesztettél")
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                            UjJatek();
                    }
                }).create();

    }

    private void JatekVege() {
        AlertDialog gamefinish = this.gamefinish;
        if (playerpoint == 3) {
            gamefinish.setTitle("Nyertél");
            gamefinish.show();


        } else if(computerpoint==3) {
            gamefinish.setTitle("Vesztettél");
            gamefinish.show();
        }


    }


    private void UjJatek(){

        computerpoint=0;
        playerpoint=0;
        TextViewEredmeny.setText("Eredmény: Ember: 0 Computer: 0" );
        ImageViewComputer.setImageResource(R.drawable.rock);
        ImageViewPlayer.setImageResource(R.drawable.rock);



    }


    private int getTipp(){

        Random rnd = new Random();
        int geptipp = rnd.nextInt(3); //0 ko, 1 papir, 2 ollo



        return geptipp;

    }





    }










