package com.example.york_4_android_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "HogwartsMAD.db";

    //Homework table
    public static final String TABLE_NAME = "homework_table";
    //HomeworkImage table
    public static final String TABLE_NAME1 = "UploadHwImage";
    //HomeworkError table
    public static final String TABLE_NAME2 = "UploadError";
    //HomeworkError table
    public static final String TABLE_NAME3 = "time_table";

    //homework table columns
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "GRADE";
    public static final String COL_4 = "SUBJECT";

    //uploadHw table columns
    public static final String COL1 = "ID";
    public static final String COL2 = "TITLE";
    public static final String COL3 = "IMAGE";

    //UploadError table columns
    public static final String COLL1 = "ID";
    public static final String COLL2 = "ERROR";

    //timetable table columns
    public static final String COL_01 = "ID";
    public static final String COL_02 = "sub_name";
    public static final String COL_03 = "start_time";
    public static final String COL_04= "end_time";
    public static final String COL_05 = "venue";
    public static final String COL_06 = "lecture_name";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        // SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + " (ID TEXT PRIMARY KEY , NAME TEXT, GRADE INTEGER, SUBJECT TEXT)");
        db.execSQL("create table " + TABLE_NAME1 + " (ID TEXT PRIMARY KEY , TITLE TEXT, IMAGE BLOB NOT NULL )");
        db.execSQL("create table " + TABLE_NAME2 + " (ID TEXT PRIMARY KEY , ERROR TEXT )");
        db.execSQL("create table " + TABLE_NAME3 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , sub_name TEXT , start_time INT , end_time INT , venue TEXT , lecture_name TEXT)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        onCreate(db);
    }

    //---------------------------------------------------------------------------

    //insert student data
    public boolean insertData (String id, String name, String grade, String subject) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,grade);
        contentValues.put(COL_4,subject);
        long result = db.insert(TABLE_NAME,null, contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME, null);
        return res;
    }

    public boolean updateData (String id, String name, String grade, String subject) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,grade);
        contentValues.put(COL_4,subject);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[] { id });
        return true;
    }

    public Integer deleteData (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] { id });
    }

    //----------------------------------------------------------------------------

    //Insert UploadHwImage data
    public boolean insertDetails (String id, String title, ImageView image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL1,id);
        contentValues.put(COL2,title);
        contentValues.put(COL3, String.valueOf(image));
        long result = db.insert(TABLE_NAME1,null, contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getImageData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME1, null);
        return res;
    }

    public boolean updateImgData (String id, String title, ImageView image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,id);
        contentValues.put(COL2,title);
        contentValues.put(COL3, String.valueOf(image));
        db.update(TABLE_NAME1, contentValues, "ID = ?", new String[] { id });
        return true;
    }

    public Integer deleteImgData (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME1, "ID = ?", new String[] { id });
    }

    //----------------------------------------------------------------------------

    //Insert UploadError data
    public boolean insertErrorDetails (String id, String error) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLL1,id);
        contentValues.put(COLL2,error);
        long result = db.insert(TABLE_NAME2,null, contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }


    //----------------------------------------------------------------------------

    //Insert timetable data

    public boolean insertTimetableData (String sub_name , String start_time , String end_time , String venue , String lecture_name ) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues(  );
        contentValues.put ( COL_02 , sub_name );
        contentValues.put ( COL_03 , start_time );
        contentValues.put ( COL_04 , end_time );
        contentValues.put ( COL_05 , venue );
        contentValues.put ( COL_06 , lecture_name );


        long result = sqLiteDatabase.insert( TABLE_NAME3 , null ,contentValues );
        if ( result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllTimetableData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery( "select * from " +TABLE_NAME3, null );
        return res;
    }
    public boolean updateTimetableData (String sub_id , String sub_name , String start_time , String end_time , String venue , String lecture_name ) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues(  );
        contentValues.put ( COL_01 , sub_id );
        contentValues.put ( COL_02 , sub_name );
        contentValues.put ( COL_03 , start_time );
        contentValues.put ( COL_04 , end_time );
        contentValues.put ( COL_05 , venue );
        contentValues.put ( COL_06 , lecture_name );
        sqLiteDatabase.update ( TABLE_NAME3 , contentValues , " ID = ? ", new String[] { sub_id } );
        return true;
    }

    public Integer deleteTimetableData (String sub_id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete( TABLE_NAME3, "ID = ? " , new String[] { sub_id} );
    }

}
