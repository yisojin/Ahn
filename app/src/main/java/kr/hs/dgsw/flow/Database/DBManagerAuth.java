package kr.hs.dgsw.flow.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by leesojin on 2018. 4. 2..
 */

public class DBManagerAuth extends SQLiteOpenHelper {

    public DBManagerAuth(Context context) {
        super(context, "flow.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("" +
                "CREATE TABLE user(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "token TEXT NOT NULL " +
                ");" +
                "");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String qur) {

        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("CREATE TABLE IF NOT EXISTS user(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "token TEXT NOT NULL " +
                ");" +
                "");

        db.execSQL(qur);
        db.close();
    }

    public void delete(String qur) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(qur);
        db.close();
    }

    public ArrayList<String> PrintData() {
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<String> list = new ArrayList<String>();

        Cursor cursor = db.rawQuery("select * from user", null);
        while (cursor.moveToNext()) {
            list.add(cursor.getString(1));
        }
        return list;
    }

    public String getLast() {

        SQLiteDatabase db = getWritableDatabase();

        String token = "";

        Cursor cursor = db.rawQuery("select * from user order by token asc limit 1", null);
        //order by token asc limit 1
        while (cursor.moveToNext()) {
            token = cursor.getString(1);
        }
        return token;

//        db.execSQL("CREATE TABLE IF NOT EXISTS user(" +
//                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                "token TEXT NOT NULL " +
//                ");" +"");
//        db.execSQL(sql);
//        db.close();
//        SELECT * FROM user ORDER BY token DESC limit 1;

    }
}
