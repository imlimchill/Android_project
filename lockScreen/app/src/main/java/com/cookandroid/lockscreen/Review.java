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
import android.widget.Toast;

import androidx.annotation.NonNull;

public class Review extends Activity {

    TextView tvWord;

    Button btnAnswer1;
    Button btnAnswer2;
    Button btnAnswer3;
    Button btnAnswer4;

    /** 단어 저장된 배열 */
    final String[] words = new String[10];
    int pos;

    /** 정답을 맞췄는지 틀렸는지를 저장할 배열 선언 */
    boolean[] isCorrect = new boolean[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);

        tvWord = (TextView) findViewById(R.id.tvWord0);
        btnAnswer1 = (Button)findViewById(R.id.btnAnswer01);
        btnAnswer2 = (Button)findViewById(R.id.btnAnswer02);
        btnAnswer3 = (Button)findViewById(R.id.btnAnswer03);
        btnAnswer4 = (Button)findViewById(R.id.btnAnswer04);

        words[0] = String.valueOf(1);
        words[1] = String.valueOf(2);
        words[2] = String.valueOf(3);
        words[3] = String.valueOf(4);
        words[4] = String.valueOf(5);
        words[5] = String.valueOf(6);
        words[6] = String.valueOf(7);
        words[7] = String.valueOf(8);
        words[8] = String.valueOf(9);
        words[9] = String.valueOf(10);


        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pos == 10) {
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(intent);
                }

                if (tvWord.getText().equals(btnAnswer1.getText())){
                    Toast.makeText(getApplicationContext(), "정답", Toast.LENGTH_SHORT).show();
                    isCorrect[pos] = true;
                } else {
                    Toast.makeText(getApplicationContext(), "오답", Toast.LENGTH_SHORT).show();
                    isCorrect[pos] = false;
                }
                tvWord.setText("" + words[pos]);
                btnAnswer1.setText("" + words[pos]);
                btnAnswer2.setText("" + words[pos]);
                btnAnswer3.setText("" + words[pos]);
                btnAnswer4.setText("" + words[pos]);
                pos++;
            }
        });
    }


}
