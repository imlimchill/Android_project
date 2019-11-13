package com.cookandroid.lockscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

/**
 * 오늘의 단어
 *
 * - 오늘 공부할 단어가 나타난 화면 과
 *   그 단어에 대한 복습을 번갈아 화면 전환
 */
public class TodayActivity extends Activity {

    /** 오늘의 단어의 영어단어를 저장할 TextView 선언 */


    /** 오늘의 단어의 뜻을 저장할 TextView 선언 */
    TextView tvMeaning;

    /* 받아야할 정보
     *
     * 1. 10개의 오늘의 단어
     */

    // TODO 뒤로 갔을 때 메인화면으로 가도록 설정
    // TODO 데이터베이스 안드로이드 스튜디오랑 연결하기
    // TODO 데이터베이스 단어 체우기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.today_study);
        setTitle("오늘의 공부");

        /** 영어 단어 저장할 스트링배열 선언, 초기화 */
        final String[] words = new String[11];
        /** 뜻 저장할 스트링배열 선언, 초기화 */
        final String[] meaning = new String[11];


        // 일단 아무 단어나 체워본다.
        words[0] = "0";
        words[1] = "1";
        words[2] = "2";
        words[3] = "3";
        words[4] = "4";
        words[5] = "5";
        words[6] = "6";
        words[7] = "7";
        words[8] = "8";
        words[9] = "9";
        words[10] = "10";

        meaning[0] = "10";
        meaning[1] = "11";
        meaning[2] = "12";
        meaning[3] = "13";
        meaning[4] = "14";
        meaning[5] = "15";
        meaning[6] = "16";
        meaning[7] = "17";
        meaning[8] = "18";
        meaning[9] = "19";
        meaning[10] = "20";

        // TODO 배열 11로 바꾸고 0에는 무조건 0 집어넣고 그 다음부터 단어 집어넣는 걸로 하자
        final TextView tvWords[] = new TextView[11];
        final TextView tvMeanings[] = new TextView[11];
        final TextView tvCounts[] = new TextView[11];

        /** 10개의 문제가 맞는지 틀린지 결정하는 배열 선언 초기화 */
        final boolean isCorrect[] = new boolean[11];

        Integer tvWordId[] = {R.id.tvWord0, R.id.tvWord1, R.id.tvWord2, R.id.tvWord3, R.id.tvWord4, R.id.tvWord5, R.id.tvWord6, R.id.tvWord7, R.id.tvWord8, R.id.tvWord9, R.id.tvWord9};
        Integer tvMeaningId[] = {R.id.tvMeaning0, R.id.tvMeaning1, R.id.tvMeaning2, R.id.tvMeaning3, R.id.tvMeaning4, R.id.tvMeaning5, R.id.tvMeaning6, R.id.tvMeaning7, R.id.tvMeaning8, R.id.tvMeaning9,  R.id.tvMeaning9};
        Integer tvCountId[] = {R.id.tvCount0, R.id.tvCount1, R.id.tvCount2, R.id.tvCount3, R.id.tvCount4, R.id.tvCount5, R.id.tvCount6, R.id.tvCount7, R.id.tvCount8, R.id.tvCount9, R.id.tvCount9};

        for (int idx = 0; idx < 11; idx++) {
            tvWords[idx] = (TextView)findViewById(tvWordId[idx]);
            tvMeanings[idx] = (TextView)findViewById(tvMeaningId[idx]);
            tvCounts[idx] = (TextView)findViewById(tvCountId[idx]);
            // 일단 다 false 로 초기화
            isCorrect[idx] = false;

            tvWords[idx].setText(words[idx]);
            tvMeanings[idx].setText(meaning[idx]);
        }



        int cnt = 0;
        Intent intent = getIntent();
        cnt = intent.getIntExtra("cnt", 0);


        final int count = cnt;//cnt;

        if (count != 0) {
            tvWords[count - 1].setVisibility(View.INVISIBLE);
            tvMeanings[count - 1].setVisibility(View.INVISIBLE);
            //tvWords[count].setText(count);

            tvWords[0].setVisibility(View.INVISIBLE);
            tvMeanings[0].setVisibility(View.INVISIBLE);

            tvWords[count].setVisibility(View.VISIBLE);
            tvMeanings[count].setVisibility(View.VISIBLE);
        }

        if (count == 10) {
            tvWords[count - 1].setVisibility(View.INVISIBLE);
            tvMeanings[count - 1].setVisibility(View.INVISIBLE);

            tvWords[count].setVisibility(View.VISIBLE);
            tvMeanings[count].setVisibility(View.VISIBLE);
        }


        for (int idx = 0; idx <= count; idx++) {
            tvCounts[idx].setVisibility(View.VISIBLE);
        }

        Handler handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);

                Intent intent = new Intent(getApplicationContext(), ReviewActivity.class);
                intent.putExtra("correct", isCorrect);
                intent.putExtra("count", count);
                intent.putExtra("words", words);
                intent.putExtra("meanings", meaning);

                startActivity(intent);
            }
        };
        handler.sendEmptyMessageDelayed(0, 500);

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
