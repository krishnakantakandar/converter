package com.example.lenovo.anyconverter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="converter.db";
    public static final String TABLE_NAME="converter_table";
    public static final String COL_1="ID";
    public static final String COL_2="_FROM_";
    public static final String COL_3="_TO_";
    public static final String COL_4="VALUE_FROM";
    public static final String COL_5="VALUE_TO";


    public  DataBaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, _FROM_ TEXT , _TO_ TEXT ,VALUE_FROM INTEGER,VALUE_TO INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

    }
    public boolean insertData(String _FROM_,String _TO_,double val1,double val2)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,_FROM_);
        contentValues.put(COL_3,_TO_);
        contentValues.put(COL_4,val1);
        contentValues.put(COL_5,val2);
       long result=db.insert(TABLE_NAME,null,contentValues);
       db.close();
       if (result==-1){
           return false;
       }else {
           return true;
       }
    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res1=db.rawQuery("select * from "+TABLE_NAME,null);
        return res1;
    }

}
