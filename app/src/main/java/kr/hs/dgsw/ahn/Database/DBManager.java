package kr.hs.dgsw.ahn.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by leesojin on 2018. 4. 2..
 */

public class DBManager extends SQLiteOpenHelper {


    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE register(id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, password TEXT, name TEXT, gender, TEXT, mobile TEXT, class_idx INTEGER,class_number INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String qur){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(qur);
        db.close();
    }
    public void delete(String qur){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(qur);
        db.close();
    }
    public ArrayList<String> PrintData(){
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<String> list = new ArrayList<String>();

        Cursor cursor = db.rawQuery("select * from register",null);
        while(cursor.moveToNext()){
            list.add(cursor.getString(1));
        }
        return list;
    }
}
