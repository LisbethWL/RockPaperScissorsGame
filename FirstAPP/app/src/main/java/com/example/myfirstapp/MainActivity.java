package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button Sten, Saks, Papir, Exit;
    TextView Game, UserScore, AndroidScore;

    int enSten = 0;
    int enSaks = 1;
    int etPapir = 2;

    int CountBruger = 0;
    int CountAndroid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get reference to UI widgets
        Sten = findViewById(R.id.btnSten); // det id jeg har givet i activity-main.xml
        Saks = findViewById(R.id.btnSaks);
        Papir = findViewById(R.id.btnPapir);
        Exit = findViewById(R.id.btnExit);
        UserScore = findViewById(R.id.txtCountMe);
        AndroidScore = findViewById(R.id.txtCountAndroid);

        Sten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EvaluateResult(enSten);
                }
        });
        Game = findViewById(R.id.txtGame);
        // do stuff, like set up on...

        Saks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EvaluateResult(enSaks);
            }
        });

        Papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EvaluateResult(etPapir);
            }
        });

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    void EvaluateResult(int userResult)
    {
        int androidResult = AndroidChoise();

        // Uafgjort
        if(userResult == androidResult)
        {
            Game.setText("It's a tie!");
        }

        // Bruger vinder
        if((userResult == enSten && androidResult == enSaks) ||
                (userResult == enSaks && androidResult == etPapir) ||
                (userResult == etPapir && androidResult == enSten))
        {
            CountBruger ++;
            UserScore.setText("" + CountBruger);
            Game.setText("User Wins :)");
        }

        // Android vinder
        if((androidResult == enSten && userResult == enSaks) ||
                (androidResult == enSaks && userResult == etPapir) ||
                (androidResult == etPapir && userResult == enSten))
        {
            CountAndroid ++;
            AndroidScore.setText("" + CountAndroid);
            Game.setText("Android Wins :)");
        }
    }

    public int AndroidChoise()
    {
        Random rand = new Random();
        return rand.nextInt(3);
    }
}
// HUSK AT SÆTTE USB DEBUGGING TIL I DEVELOPER OPTIONS PÅ TLF