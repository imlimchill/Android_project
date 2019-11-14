package com.cookandroid.lockscreen;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LockActivity extends Activity {

//    Context context;

    /** 퀴즈에서 사용될  */
    TextView tvWord;

    /** 잠금화면에서 사용될 각 퀴즈의 답과 오답을 저장할 버튼을 선언 */
    Button btnAnswer1;
    Button btnAnswer2;
    Button btnAnswer3;
    Button btnAnswer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
//                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

//        KeyguardManager km = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
//        KeyguardLock keyLock = km.newKeyguardLock(Context.KEYGUARD_SERVICE);
//
//        keyLock.disableKeyguard();    // 기본 잠금화면 없애기
//        keyLock.reenableKeyguard();

        setContentView(R.layout.lock);


        /** 단어와 답, 오답의 초기화 */
        tvWord = (TextView)findViewById(R.id.tvWord);
        btnAnswer1 = (Button)findViewById(R.id.btnAnswer1);
        btnAnswer2 = (Button)findViewById(R.id.btnAnswer2);
        btnAnswer3 = (Button)findViewById(R.id.btnAnswer3);
        btnAnswer4 = (Button)findViewById(R.id.btnAnswer4);

//        btnAnswer1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                if(btnAnswer1.getText().equals(??)) {
////                    Toast.makeText(getApplicationContext(), "정답입니다.", Toast.LENGTH_SHORT).show();
////                    // TODO 종료
////                } else {
////                    Toast.makeText(getApplicationContext(), "오답입니다. 다시 시도해보세요.", Toast.LENGTH_SHORT).show();
////                }
//            }
//        });


    }
}
