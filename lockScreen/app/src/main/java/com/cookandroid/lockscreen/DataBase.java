package com.cookandroid.lockscreen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
//import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DataBase extends Activity implements OnClickListener{
    private final static String DB_NAME = "word.db";
    private final static String DB_TABLE = "word";
    private final static int    DB_VERSION = 1;

    private EditText editText;
    private Button btn1;
    private Button btn2;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_test);
        editText = (EditText)findViewById(R.id.editText1);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);

        DBHelper dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    private static class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            db.execSQL("create table if not exists " + DB_TABLE + "(word text primary key, meaning text)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
            db.execSQL("drop table if exists " + DB_TABLE);
            onCreate(db);
        }
    }

    private static void showDialog(final Activity activity, String title, String text) {
        AlertDialog.Builder ad = new AlertDialog.Builder(activity);
        ad.setTitle(title);
        ad.setMessage(text);
        ad.setPositiveButton("ok", new DialogInterface.OnClickListener() {

            @SuppressLint("WrongConstant")
            public void onClick(DialogInterface dialog, int whichButton) {
                // TODO Auto-generated method stub
                activity.setRequestedOrientation(Activity.RESULT_OK);
            }
        });
        ad.create();
        ad.show();
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if(v == btn1) {

            try {
                String str = editText.getText().toString();
                writeDB(str);
                editText.setText("");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                showDialog(this,"저장","실패ㅋㅋ");
            }
        }else if(v == btn2) {
            String str;
            try {
                str = readDB();
                editText.setText(str);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                showDialog(this,"불러오기","실패ㅋㅋ");
            }

        }
    }

    private void writeDB(String str) {
    }

    private void writeDB(String word, String info) throws Exception {
        ContentValues values = new ContentValues();
        values.put("word",word);
        values.put("info", info);
        int colNum = db.update(DB_TABLE, values, null, null);
        if(colNum==0) db.insert(DB_TABLE, "", values);
    }

    private String readDB() throws Exception {
        Cursor c = db.query(DB_TABLE, new String[]{"word","info"}, "id='0'", null, null, null, null);
        if(c.getCount() == 0) throw new Exception();
        c.moveToFirst();
        String str = c.getString(1);
        c.close();
        return str;
    }
}
