package kr.hs.dgsw.flow.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by leesojin on 2018. 4. 2..
 */

public class DBManager extends SQLiteOpenHelper {


    public DBManager(Context context) {
        super(context, "flow.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("" +
                "CREATE TABLE register(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "email TEXT NOT NULL, " +
                "password TEXT NOT NULL, " +
                "name TEXT NOT NULL, " +
                "gender TEXT NOT NULL," +
                "mobile TEXT NOT NULL," +
                "class_idx INTEGER NOT NULL," +
                "class_number INTEGER NOT NULL" +
                ");" +
                "");

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String qur){

        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("CREATE TABLE IF NOT EXISTS register("+ "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "email TEXT NOT NULL, " +
                "password TEXT NOT NULL, " +
                "name TEXT NOT NULL, " +
                "gender TEXT NOT NULL," +
                "mobile TEXT NOT NULL," +
                "class_idx INTEGER NOT NULL," +
                "class_number INTEGER NOT NULL" +
                ");" +"");

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
