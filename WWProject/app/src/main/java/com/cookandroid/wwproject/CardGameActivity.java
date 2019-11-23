package com.cookandroid.wwproject;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.GregorianCalendar;
import java.util.Random;

public class CardGameActivity extends AppCompatActivity {

    static String[] words = new String[300];
    static String[] meaning = new String[300];

    GregorianCalendar today = new GregorianCalendar ( );
    int day = today.get ( today.DAY_OF_MONTH );
    int pos = day * 10 - 11;


    /** 단어카드 버튼 배열 */
    Button[] wordCards = new Button[5];
    /** 뜻카드 버튼 배열 */
    Button[] meanCards = new Button[5];
    /** 다음 화면으로 넘어가는 버튼 */
    Button btnNext;
    /** 문제의 결과 보는 화면을 나타내는 버튼 */
    Button btnResult;
    /** 총 몇번 틀렸는지 결과가 나오는 화면 */
    TextView tvResult;
    /** 총 몇번 맞았는지 결과가 나오는 화면 */
    TextView tvResultC;
    /** 몇 번 틀렸는지 카운트 */
    int WCount;
    /** 몇 번 맞았는지 카운트 */
    int CCont;

    int[] wordN = new int[5];
    int[] meaningN = new int[5];


    TextView count_txt;

    private static final int TOTAL_CARD_NUM = 8;


    private static final int MILLISINFUTURE = 11*1000;
    private static final int COUNT_DOWN_INTERVAL = 1000;
    private int count = 10;
    private TextView countTxt ;
    private CountDownTimer countDownTimer;
    /** 다음화면으로 넘어가는지 확인용 */
    boolean isChange;

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_game);

        /////////////////////////////////////////////////////////////////////////////////////
        // 랜덤으로 숫자를 넣어서 단어카드와 뜻 카드 섞기

        for(int idx = 0; idx < wordN.length; idx++) {
            wordN[idx] = random.nextInt(5);
            for(int ind = 0; ind < idx; ind++){
                if(wordN[idx] == wordN[ind]) {
                    idx--;
                }
            }
            meaningN[idx] = random.nextInt(5);
            for(int ind = 0; ind < idx; ind++){
                if(meaningN[idx] == meaningN[ind]) {
                    idx--;
                }
            }
        }

        readWordData();

        if(day == 0) {
            pos = 0;
        }

        /////////////////////////////////////////////////////////////////////////////////////

        // 버튼들과 결과 화면 초기화
        btnNext = (Button)findViewById(R.id.btnNext);
        btnResult = (Button)findViewById(R.id.btnResult);
        tvResult = (TextView)findViewById(R.id.tvResult);
        tvResultC = (TextView)findViewById(R.id.tvResultC);

        final Integer[] wordCardId = {R.id.word_one, R.id.word_two, R.id.word_there, R.id.word_four, R.id.word_five};
        Integer[] meanCardId = {R.id.mean_one, R.id.mean_two, R.id.mean_there, R.id.mean_four, R.id.mean_five};

        countTxt = (TextView)findViewById(R.id.count_txt);
        countDownTimer();
        countDownTimer.start();

        /*
         * 버튼을 초기화하고 단어카드와 뜻 카드에 단어와 뜻 추가
         */
        for(int idx = 0; idx < wordCards.length; idx++) {
            wordCards[idx] = (Button)findViewById(wordCardId[idx]);
            wordCards[idx].setText("" + words[pos + (wordN[idx])]);
            meanCards[idx] = (Button)findViewById(meanCardId[idx]);
            meanCards[idx].setText("" + meaning[pos + (meaningN[idx])]);
        }

        wordCards[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meanCards[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[0]) == pos + (meaningN[0])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[0].setBackgroundResource(R.drawable.yes);
                            meanCards[0].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[0]) == pos + (meaningN[1])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[0].setBackgroundResource(R.drawable.yes);
                            meanCards[1].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[0]) == pos + (meaningN[2])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[0].setBackgroundResource(R.drawable.yes);
                            meanCards[2].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[3].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[0]) == pos + (meaningN[3])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[0].setBackgroundResource(R.drawable.yes);
                            meanCards[3].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[4].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[0]) == pos + (meaningN[4])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[0].setBackgroundResource(R.drawable.yes);
                            meanCards[4].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });
            }
        });

        wordCards[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meanCards[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[1]) == pos + (meaningN[0])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[1].setBackgroundResource(R.drawable.yes);
                            meanCards[0].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[1]) == pos + (meaningN[1])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[1].setBackgroundResource(R.drawable.yes);
                            meanCards[1].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[1]) == pos + (meaningN[2])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[1].setBackgroundResource(R.drawable.yes);
                            meanCards[2].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[3].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[1]) == pos + (meaningN[3])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[1].setBackgroundResource(R.drawable.yes);
                            meanCards[3].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[4].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[1]) == pos + (meaningN[4])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[1].setBackgroundResource(R.drawable.yes);
                            meanCards[4].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });
            }
        });

        wordCards[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meanCards[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[2]) == pos + (meaningN[0])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[2].setBackgroundResource(R.drawable.yes);
                            meanCards[0].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[2]) == pos + (meaningN[1])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[2].setBackgroundResource(R.drawable.yes);
                            meanCards[1].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[2]) == pos + (meaningN[2])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[2].setBackgroundResource(R.drawable.yes);
                            meanCards[2].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[3].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[2]) == pos + (meaningN[3])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[2].setBackgroundResource(R.drawable.yes);
                            meanCards[3].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[4].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[2]) == pos + (meaningN[4])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[2].setBackgroundResource(R.drawable.yes);
                            meanCards[4].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });
            }
        });

        wordCards[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meanCards[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[3]) == pos + (meaningN[0])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[3].setBackgroundResource(R.drawable.yes);
                            meanCards[0].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[3]) == pos + (meaningN[1])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[3].setBackgroundResource(R.drawable.yes);
                            meanCards[1].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[3]) == pos + (meaningN[2])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[3].setBackgroundResource(R.drawable.yes);
                            meanCards[2].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[3].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[3]) == pos + (meaningN[3])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[3].setBackgroundResource(R.drawable.yes);
                            meanCards[3].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[4].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[3]) == pos + (meaningN[4])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[3].setBackgroundResource(R.drawable.yes);
                            meanCards[4].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });
            }
        });

        wordCards[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meanCards[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[4]) == pos + (meaningN[0])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[4].setBackgroundResource(R.drawable.yes);
                            meanCards[0].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[4]) == pos + (meaningN[1])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[4].setBackgroundResource(R.drawable.yes);
                            meanCards[1].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[4]) == pos + (meaningN[2])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[4].setBackgroundResource(R.drawable.yes);
                            meanCards[2].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[3].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[4]) == pos + (meaningN[3])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[4].setBackgroundResource(R.drawable.yes);
                            meanCards[3].setBackgroundResource(R.drawable.yes);
                            CCont++;
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });

                meanCards[4].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pos + (wordN[4]) == pos + (meaningN[4])) {
                            Toast.makeText(getApplicationContext(), "눌린다", Toast.LENGTH_SHORT).show();
                            wordCards[4].setBackgroundResource(R.drawable.yes);
                            meanCards[4].setBackgroundResource(R.drawable.yes);
                        } else {
                            Toast.makeText(getApplicationContext(), "틀렸다", Toast.LENGTH_SHORT).show();
                            WCount++;
                        }
                    }
                });
            }
        });


        /**
         * 다음으롷 버튼 클릭 했을 때의 동작
         * 5개의 단어와 뜻울 새롭게 바꾸기
         */
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 다시 랜덤 숫자 저장하기
                int[] wordN = new int[5];
                int[] meaningN = new int[5];

                for(int idx = 0; idx < wordN.length; idx++) {
                    wordN[idx] = random.nextInt(5);
                    for(int ind = 0; ind < idx; ind++){
                        if(wordN[idx] == wordN[ind]) {
                            idx--;
                        }
                    }
                    meaningN[idx] = random.nextInt(5);
                    for(int ind = 0; ind < idx; ind++){
                        if(meaningN[idx] == meaningN[ind]) {
                            idx--;
                        }
                    }
                }

                // 랜덤한 숫자 집어넣고 카드 다시 보이기
                for(int idx = 0; idx < wordCards.length; idx++) {
                    wordCards[idx].setText("" + words[pos + (wordN[idx] + 5)]);
                    meanCards[idx].setText("" + meaning[pos + (meaningN[idx] + 5)]);
                    wordCards[idx].setBackgroundResource(0);
                    meanCards[idx].setBackgroundResource(0);
                }

                // 돌아기기 버튼 없애고 결과 보기 버튼으로 바꾸기
                btnNext.setVisibility(View.INVISIBLE);
                btnResult.setVisibility(View.VISIBLE);

                for(int idx = 0; idx < 5; idx++) {
                    int color = Color.parseColor("#fef8f4");
                    wordCards[idx].setBackgroundColor(color);
                    meanCards[idx].setBackgroundColor(color);
                    wordCards[idx].setEnabled(true);
                    meanCards[idx].setEnabled(true);
                }

                // 카운트 다시 시작
                count = 10;
                countDownTimer();
                countDownTimer.start();
            }
        });

        /**
         * 결과보기 버튼을 눌렀을 때 몇번 잘못눌렀는지 (틀렸는지) 알려준다.
         */
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResult.setVisibility(View.INVISIBLE);
                tvResult.setVisibility(View.VISIBLE);
                tvResultC.setVisibility(View.VISIBLE);

                tvResultC.setText("총 " + CCont + " 문제 맞았습니다.");
                tvResult.setText("총 " + WCount + " 번 틀렸습니다.");
            }
        });



    }

    public void countDownTimer(){

        countDownTimer = new CountDownTimer(MILLISINFUTURE, COUNT_DOWN_INTERVAL) {
            public void onTick(long millisUntilFinished) {
                countTxt.setText(String.valueOf(count));
                count --;
            }
            public void onFinish() {

                countTxt.setText(String.valueOf("시간이 종료되었습니다."));

                for(int idx = 0; idx < 5; idx++) {
                    wordCards[idx].setEnabled(false);
                    meanCards[idx].setEnabled(false);
                }

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

    private void readWordData() {
        InputStream inS = getResources().openRawResource(R.raw.word);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(inS, Charset.forName("UTF-8"))
        );

        String line = "";
        try{
            // Step over headers
            //reader.readLine();
            int count = 0;
            while ((line = reader.readLine()) != null){

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
