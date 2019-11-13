package com.cookandroid.lockscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_study);

        Intent intent = getIntent();
        String words[] = intent.getStringArrayExtra("words");
        String meanings[] = intent.getStringArrayExtra("meanings");
        boolean isCorrect[] = intent.getBooleanArrayExtra("correct");


        final ArrayList<String> correctItems = new ArrayList<String>(); // 빈 데이터 리스트 생성
        final ArrayAdapter adapterCor = new ArrayAdapter(this, android.R.layout.simple_list_item_1, correctItems); //어뎁터 생성

        // 리스트뷰 생성 및 어뎁터 지정
        final ListView listCorrect = (ListView)findViewById(R.id.listCorrect);
        listCorrect.setAdapter(adapterCor);


        final ArrayList<String> WorngItems = new ArrayList<String>(); // 빈 데이터 리스트 생성
        final ArrayAdapter adapterWor = new ArrayAdapter(this, android.R.layout.simple_list_item_1, WorngItems); //어뎁터 생성

        // 리스트뷰 생성 및 어뎁터 지정
        final ListView listWorng = (ListView)findViewById(R.id.listWrong);
        listWorng.setAdapter(adapterWor);

        //WorngItems.add("단어:" + words[0] + "뜻 :" + meanings[0]);
        //adapterWor.notifyDataSetChanged();

        /*for (int idx = 0; idx < isCorrect.length; idx++) {
            //int count;
            //count = adapterWor.getCount();
            if (isCorrect[idx] == false) {
                WorngItems.add("단어:" + words[idx] + "뜻 :" + meanings[idx]);
            } else {
                correctItems.add("단어:" + words[idx] + "뜻 :" + meanings[idx]);
            }
        }
        adapterWor.notifyDataSetChanged();
        adapterCor.notifyDataSetChanged();*/

        // tv.setTextColor(Color.WHITE); >> 색갈변경

        // TODO 배열을 받아서 그에 따른 정답과 오답을 가려야 한다.
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
