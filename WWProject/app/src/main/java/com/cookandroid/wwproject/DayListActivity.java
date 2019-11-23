package com.cookandroid.wwproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DayListActivity extends AppCompatActivity {

    static String[] words = new String[300];
    static String[] meaning = new String[300];

    GregorianCalendar today = new GregorianCalendar ( );
    int day = today.get ( today.DAY_OF_MONTH );
    int pos = day * 10 - 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_list);

        readWordData();

        if(day == 0) {
            pos = 0;
        }


        // 리스트 생성
        ListView listDay = (ListView)findViewById(R.id.listDay);

        final ArrayList<String> Items = new ArrayList<String>(); // 빈 데이터 리스트 생성

        for (int idx = 1; idx <= 20; idx++) {
            Items.add("" + idx + " 일");
        }

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Items); //어뎁터 생성

        // 리스트뷰 생성 및 어뎁터 지정
        listDay.setAdapter(adapter);


//        final ArrayList<String> ItemWords = new ArrayList<String>(); // 빈 데이터 리스트 생성
//
//        for (int idx = 1; idx <= 10; idx++) {
//            ItemWords.add(words[pos] + " " + meaning[pos]);
//            pos++;
//        }
//
//        final ArrayAdapter adapterWord = new ArrayAdapter(DayListActivity.this, android.R.layout.simple_list_item_1, ItemWords); //어뎁터 생성

        listDay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final ArrayList<String> ItemWords = new ArrayList<String>(); // 빈 데이터 리스트 생성

                pos = (i + 1) * 10 - 11;

                if(i == 0) {
                    pos = 0;
                }

                for (int idx = 1; idx <= 10; idx++) {
                    ItemWords.add(words[pos] + " " + meaning[pos]);
                    pos++;
                }

                final ArrayAdapter adapterWord = new ArrayAdapter(DayListActivity.this, android.R.layout.simple_list_item_1, ItemWords); //어뎁터 생성

                // 팝업창 생성
                final AlertDialog.Builder dayDialog = new AlertDialog.Builder(DayListActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);

                dayDialog.setTitle("복습할 단어 목록");

                dayDialog.setAdapter(adapterWord, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                dayDialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),  "'확인'버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), DayReviewActivity.class);
                        intent.putExtra("pos", pos);
                        startActivity(intent);
                    }
                });

                dayDialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                dayDialog.show();



            }
        });

    }




    private void readWordData() {
        InputStream inS = getResources().openRawResource(R.raw.word);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(inS, Charset.forName("UTF-8"))
        );

        String line = "";
        try {
            // Step over headers
            //reader.readLine();
            int count = 0;
            while ((line = reader.readLine()) != null) {

                // Split by ','
                String[] tokens = line.split(",");

                // read the data
                words[count] = tokens[0];
                meaning[count] = tokens[1];
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
