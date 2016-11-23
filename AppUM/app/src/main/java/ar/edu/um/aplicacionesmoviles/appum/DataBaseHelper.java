package ar.edu.um.aplicacionesmoviles.appum;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Fer on 22/11/2016.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static  final int DATABASE_VERSION  = 1;
    private static  final String DATABASE_NAME = "contacts.db";
    private static  final String TABLE_NAME = "contacts";
    private static  final String COLUMN_ID = "id";
    private static  final String  COLUMN_NAME= "name";
    private static  final String COLUMN_PASSWORD= "password";
    private static  final String COLUMN_USERNAME= "username";
    SQLiteDatabase db;
    private static  final String TABLE_CREATE = "create table "+TABLE_NAME+" ("+COLUMN_ID+" integer primary key not null auto_increment , "+
    COLUMN_NAME+" text not null ,"+COLUMN_PASSWORD+" text not null,"+COLUMN_USERNAME+" text not null);";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        this.db = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }
}
