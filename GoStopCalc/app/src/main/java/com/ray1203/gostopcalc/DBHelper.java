package com.ray1203.gostopcalc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=7;

    public DBHelper(Context context) {
        super(context, "datadb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String driverTable="create table gostop_data (score INTEGER,go INTEGER,pi INTEGER,ddi INTEGER,kkeut INTEGER,bomb INTEGER,gwang INTEGER,bi INTEGER,chung_dan INTEGER,hong_dan INTEGER,cho_dan INTEGER,pi_bak INTEGER,gwang_bak INTEGER,mung_bak INTEGER,godori INTEGER,mungtungguri INTEGER,nagari INTEGER,_ID INTEGER primary key autoincrement)";
        db.execSQL(driverTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//DB 버전이 변경될때 호출, 지금은 필요 X

    }
}
