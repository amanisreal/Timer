package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;


public class MainActivity extends AppCompatActivity {


    int seconds = 0;
    int minuttes = 0;
    int hours = 0;

    int totalSeconds = 0;

    String displaySeconds="00", displayMinutes="00", displayHours="00";


    public String updateTimer (int secondsLeft){
        int min = secondsLeft/60;
        int seconds = secondsLeft - min*60;
        if(hours<10){
            displayHours = "";
            displayHours+="0";
            displayHours += String.valueOf(hours);
        }
        else{
            displayHours = "";
            displayHours = String.valueOf(hours);
        }

        if(minuttes<10){
            displayMinutes = "";
            displayMinutes+="0";
            displayMinutes += String.valueOf(minuttes);
        }
        else{
            displayMinutes = "";
            displayMinutes = String.valueOf(minuttes);
        }

        if(seconds<10){
            displaySeconds = "";
            displaySeconds+="0";
            displaySeconds += String.valueOf(seconds);
        }
        else{
            displaySeconds = "";
            displaySeconds = String.valueOf(seconds);
        }
        String ans =displayHours+":"+displayMinutes+":"+displaySeconds;
        return ans;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button increaseS = (Button) findViewById(R.id.increaseSeconds);
        Button increaseM = (Button) findViewById(R.id.increaseMinutes);
        Button increaseH = (Button) findViewById(R.id.increaseHours);
        TextView timer = (TextView) findViewById(R.id.tv);
        Button startTimer = (Button) findViewById(R.id.button);

        startTimer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int totalSeconds = hours*3600 + minuttes*60 + seconds;
                Log.i("j", String.valueOf(totalSeconds));
                CountDownTimer cdt = new CountDownTimer(totalSeconds*1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        Log.i("sd", "hi");
                        timer.setText(updateTimer((int)millisUntilFinished/1000));
                    }

                    @Override
                    public void onFinish() {

                    }
                }.start();
            }
        });

        increaseS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seconds++;
                while(seconds >= 60){
                    minuttes++;
                    while(minuttes>=60){
                        hours++;
                        minuttes-=60;
                    }
                    seconds-=60;
                }
                timer.setText(setThings());
            }
        });

        increaseM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minuttes++;
                while(minuttes>=60){
                    hours++;
                    minuttes-=60;
                }
                timer.setText(setThings());
            }


        });

        increaseH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hours++;
                timer.setText(setThings());
            }
        });
    }

    public String setThings(){

        if(hours<10){
            displayHours = "";
            displayHours+="0";
            displayHours += String.valueOf(hours);
        }
        else{
            displayHours = "";
            displayHours = String.valueOf(hours);
        }

        if(minuttes<10){
            displayMinutes = "";
            displayMinutes+="0";
            displayMinutes += String.valueOf(minuttes);
        }
        else{
            displayMinutes = "";
            displayMinutes = String.valueOf(minuttes);
        }

        if(seconds<10){
            displaySeconds = "";
            displaySeconds+="0";
            displaySeconds += String.valueOf(seconds);
        }
        else{
            displaySeconds = "";
            displaySeconds = String.valueOf(seconds);
        }

        String ans =displayHours+":"+displayMinutes+":"+displaySeconds;
        return ans;
    }
}

