package com.cookandroid.wwproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /** 오늘의 공부로 넘어가는 버튼 */
    Button btnToStudy;
    /** 단어 복습을 위한 리스트로 넘어가는 버튼 */
    Button btnToWord;
    /** 오늘의 단어로 단어 테스트(게임)으로 넘어가는 버튼 */
    Button btnWordTest;

    /** 메뉴로 사용할 이미지 */
    ImageView menuIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 세 개의 버튼에 대한 초기화
        btnToStudy = (Button)findViewById(R.id.btnToStudy);
        btnToWord = (Button)findViewById(R.id.btnToWord);
        btnWordTest = (Button)findViewById(R.id.btnWordTest);

        menuIcon = (ImageView)findViewById(R.id.menuIcon);
        registerForContextMenu(menuIcon);

        btnToStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TodayActivity.class);
                startActivity(intent);
            }
        });


        btnToWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DayListActivity.class);
                startActivity(intent);
            }
        });



        btnWordTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CardGameActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == menuIcon) {
            getMenuInflater().inflate(R.menu.menu, menu);
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.push:

                Intent intent = new Intent(MainActivity.this, AlarmActivity.class);
                startActivity(intent);

                return true;

            case R.id.lockScreen:
                final AlertDialog.Builder dayDialog = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);

                dayDialog.setTitle("잠금화면 설정");

                dayDialog.setMessage("잠금화면을 설정하시겠습니까?");


                dayDialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), LockScreenService.class);
                        startService(intent);
                        Toast.makeText(getApplicationContext(), "잠금화면이 설정되었습니다.", Toast.LENGTH_SHORT);
                    }
                });

                dayDialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), LockScreenService.class);
                        stopService(intent);
                        Toast.makeText(getApplicationContext(), "잠금화면의 설정이 취소되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });

                dayDialog.show();

                return true;
        }

        return true;
    }

}
