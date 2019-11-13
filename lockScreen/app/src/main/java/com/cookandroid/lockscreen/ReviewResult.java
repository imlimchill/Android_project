package com.cookandroid.lockscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ReviewResult extends Activity {

    Intent intent = getIntent();

//    int count[] = intent.getIntArrayExtra();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent2 = new Intent();
        startActivity(intent2);

    }
}
