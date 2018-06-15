package kr.hs.dgsw.flow.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by leesojin on 2018. 6. 12..
 */

public class DBManagerApplication extends SQLiteOpenHelper {
    public DBManagerApplication(Context context) {
        super(context, "flow.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("" +
                "CREATE TABLE application(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "kind TEXT NOT NULL, " +
                "start_time DATETIME NOT NULL, "+
                "end_time DATETIME NOT NULL,"+
                "reason TEXT NOT NULL"+
                ");" +
                "");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    public void insert(String qur){
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("" +
                "CREATE TABLE application(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "kind TEXT NOT NULL, " +
                "start_time DATETIME NOT NULL, "+
                "end_time DATETIME NOT NULL,"+
                "reason TEXT NOT NULL"+
                ");" +
                "");

        db.execSQL(qur);
        db.close();
    }
}
