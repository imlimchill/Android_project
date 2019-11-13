package com.cookandroid.lockscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Review extends Activity {

    TextView tvWord;

    Button btnAnswer1;
    Button btnAnswer2;
    Button btnAnswer3;
    Button btnAnswer4;

    final int[] intt = new int[10];
    int i = 0;
    boolean isPushing;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);

        tvWord = (TextView) findViewById(R.id.tvWord0);
        btnAnswer1 = (Button)findViewById(R.id.btnAnswer01);
        btnAnswer2 = (Button)findViewById(R.id.btnAnswer02);
        btnAnswer3 = (Button)findViewById(R.id.btnAnswer03);
        btnAnswer4 = (Button)findViewById(R.id.btnAnswer04);

        final int poss = 0;

//        intt[0] = 1;
//        intt[1] = 2;
//        intt[2] = 3;
//        intt[3] = 4;
//        intt[4] = 5;
//        intt[5] = 6;
//        intt[6] = 7;
//        intt[7] = 8;
//        intt[8] = 9;
//        intt[9] = 10;


        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvWord.setText("" + intt[i++]);
                btnAnswer1.setText("" + poss + 2);
                btnAnswer2.setText("" + poss + 3);
                btnAnswer3.setText("" + poss + 4);
                btnAnswer4.setText("" + poss + 5);

                Intent intent = new Intent(getApplicationContext(), ReviewResult.class);
//                intent.putExtra(isCo);
                startActivity(intent);
            }
        });



//            btnAnswer1.setOnTouchListener( new Button.OnTouchListener(){
//                public boolean onTouch (View v, MotionEvent event){
//                    if(event.getAction()==MotionEvent.ACTION_DOWN){
//                        //버튼을 누를 때
//                        isPushing = true;
//                        tvWord.setText("" + intt[i++]);
//                        btnAnswer1.setText("" + poss + 2);
//                        btnAnswer2.setText("" + poss + 3);
//                        btnAnswer3.setText("" + poss + 4);
//                        btnAnswer4.setText("" + poss + 5);
//                    } else {
//                        //그 이외 (손을 땔 때)
//                        isPushing = false;
//                    }
//                    return false;
//                }
//            });










//        Handler handler = new Handler();
//        for (int idx = 0; idx < 10; idx++) {
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    tvWord.setText("" + intt[0]);
//                    btnAnswer1.setText("" + poss + 2);
//                    btnAnswer2.setText("" + poss + 3);
//                    btnAnswer3.setText("" + poss + 4);
//                    btnAnswer4.setText("" + poss + 5);
//                }
//            }, 500);
//        }
//
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                tvWord.setText("" + intt[1]);
//                btnAnswer1.setText("" + poss + 2);
//                btnAnswer2.setText("" + poss + 3);
//                btnAnswer3.setText("" + poss + 4);
//                btnAnswer4.setText("" + poss + 5);
//            }
//        }, 500);

//        Handler handler = new Handler() {
//
//            @Override
//            public void handleMessage(@NonNull Message msg) {
//                super.handleMessage(msg);
//                for(int pos = 0; pos <= 10; pos++) {
//
//                    tvWord.setText("" + poss + 1);
//                    btnAnswer1.setText("" + poss + 2);
//                    btnAnswer2.setText("" + poss + 3);
//                    btnAnswer3.setText("" + poss + 4);
//                    btnAnswer4.setText("" + poss + 5);
//                }
//            }
//        };
//        handler.sendEmptyMessageDelayed(0, 500);

//        Handler handler2 = new Handler() {
//            @Override
//            public void handleMessage(@NonNull Message msg) {
//                super.handleMessage(msg);
//                for(int pos = 0; pos <= 10; pos++) {
//
//                    tvWord.setText("" + poss + 6);
//                    btnAnswer1.setText("" + poss + 7);
//                    btnAnswer2.setText("" + poss + 8);
//                    btnAnswer3.setText("" + poss + 9);
//                    btnAnswer4.setText("" + poss + 10);
//                }
//            }
//        };
//        handler2.sendEmptyMessageDelayed(0, 500);
    }


}
