package com.cookandroid.lockscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

/**
 *
 */
public class ReviewActivity extends Activity {

    /** 단어를 저장하는 TextView 선언 */
    TextView tvWord;

    /* 네 개의 뜻을 저장해줄 TextView 선언 */
    Button btnAnswer1;
    Button btnAnswer2;
    Button btnAnswer3;
    Button btnAnswer4;

    /* 필요한 정보 목록
     *
     * 1. 오늘의 공부에 저장된 10개의 단어가 저장되어 있는 배열
     * 2. 거짓 답변으로 적을 뜻만 저장되어 있는 배열
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_study);
        setTitle("복습");

        // 초기화
        tvWord = (TextView)findViewById(R.id.tvWord);

        btnAnswer1 = (Button)findViewById(R.id.btnAnswer1);
        btnAnswer2 = (Button)findViewById(R.id.btnAnswer2);
        btnAnswer3 = (Button)findViewById(R.id.btnAnswer3);
        btnAnswer4 = (Button)findViewById(R.id.btnAnswer4);

        final Intent intent = getIntent();
        int cnt = intent.getIntExtra("count", 0);
        final String words[] = intent.getStringArrayExtra("words");
        final String meanings[] = intent.getStringArrayExtra("meanings");
        final boolean isCorrect[] = intent.getBooleanArrayExtra("correct");


        tvWord.setText(words[cnt]);


        final int count = cnt + 1;

        // TODO 정답을 저장해서 보내야 한다.

        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // count 가 몇인지 모름
                if (count == 10) {
                    Intent resultIntent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("words", words);
                    intent.putExtra("meanings", meanings);
                    intent.putExtra("correct", isCorrect);
                    startActivity(resultIntent);
                }
                if (count != 10) {
                    Intent todayIntent = new Intent(getApplicationContext(), TodayActivity.class);
                    todayIntent.putExtra("cnt", count);
                    startActivity(todayIntent);
                }
            }
        });

        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // count 가 몇인지 모름
                if (count == 10) {
                    Intent resultIntent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("words", words);
                    intent.putExtra("meanings", meanings);
                    intent.putExtra("correct", isCorrect);
                    startActivity(resultIntent);
                }
                if (count != 10) {
                    Intent todayIntent = new Intent(getApplicationContext(), TodayActivity.class);
                    todayIntent.putExtra("cnt", count);
                    startActivity(todayIntent);
                }
            }
        });

        btnAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // count 가 몇인지 모름
                if (count == 10) {
                    Intent resultIntent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("words", words);
                    intent.putExtra("meanings", meanings);
                    intent.putExtra("correct", isCorrect);
                    startActivity(resultIntent);
                }
                if (count != 10) {
                    Intent todayIntent = new Intent(getApplicationContext(), TodayActivity.class);
                    todayIntent.putExtra("cnt", count);
                    startActivity(todayIntent);
                }
            }
        });

        btnAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // count 가 몇인지 모름
                if (count == 10) {
                    Intent resultIntent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("words", words);
                    intent.putExtra("meanings", meanings);
                    intent.putExtra("correct", isCorrect);
                    startActivity(resultIntent);
                }
                if (count != 10) {
                    Intent todayIntent = new Intent(getApplicationContext(), TodayActivity.class);
                    todayIntent.putExtra("cnt", count);
                    startActivity(todayIntent);
                }
            }
        });



    }

    /**
     * 븨로가기 버튼 눌렀을 떄 동작을 정의
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        super.onBackPressed();
    }
}
