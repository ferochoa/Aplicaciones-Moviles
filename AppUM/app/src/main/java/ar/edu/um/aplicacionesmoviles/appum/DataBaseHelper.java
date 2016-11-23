package ar.edu.um.aplicacionesmoviles.appum;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    private static  final String TABLE_CREATE = "create table "+TABLE_NAME+" ("+COLUMN_ID+" integer primary key not null , "+
    COLUMN_NAME+" text not null ,"+COLUMN_PASSWORD+" text not null,"+COLUMN_USERNAME+" text not null);";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        this.db = db;

    }

    public  void insertContact(Contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_PASSWORD, c.getPassword());
        values.put(COLUMN_USERNAME, c.getUsername());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public String searchPass(String username)
    {
        db = getReadableDatabase();
        String query = "select username, pass from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do
            {
               a= cursor.getString(0);
                if(a.equals(username))
                {
                    b = cursor.getString(1);
                    break;
                }

            }
            while(cursor.moveToNext());
        }
        return  b;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }
}
