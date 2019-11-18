package com.example.cardgame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    ImageButton home, one, two, three, four, five, six, seven, eight;
    TextView count_txt;

    private static final int TOTAL_CARD_NUM = 8;

    private int[] cardId = {R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight,};


    private static final int MILLISINFUTURE = 11*1000;
    private static final int COUNT_DOWN_INTERVAL = 1000;
    private int count = 10;
    private TextView countTxt ;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTxt = (TextView)findViewById(R.id.count_txt);
        countDownTimer();
        countDownTimer.start();
    }

    public void countDownTimer(){

        countDownTimer = new CountDownTimer(MILLISINFUTURE, COUNT_DOWN_INTERVAL) {
            public void onTick(long millisUntilFinished) {
                countTxt.setText(String.valueOf(count));
                count --;
            }
            public void onFinish() {
                countTxt.setText(String.valueOf("TIME OVER"));
            }
        };
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        try{
            countDownTimer.cancel();
        } catch (Exception e) {}
        countDownTimer=null;
    }


}



