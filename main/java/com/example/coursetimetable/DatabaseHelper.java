package com.example.coursetimetable;

import java.util.LinkedList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

     private static final String name = "mycourses";

     private static final int version = 1;
     public DatabaseHelper(Context context) {  
            super(context, name, null, version);  
     }    
    @Override  
    public void onCreate(SQLiteDatabase db) {
          db.execSQL("CREATE TABLE IF NOT EXISTS course( id INTEGER , module_code CHAR(50) , name CHAR(50), l_p INTEGER, day_of_week INTEGER, start_time INTEGER, end_time INTEGER,location CHAR(50),comment CHAR(300));");       
     }   
    @Override   
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     }
    public LinkedList<Course> getTable(SQLiteDatabase db){
    	LinkedList<Course> myCourseList=new LinkedList<Course>();
    	Cursor cursor = db.rawQuery("SELECT * FROM course;",null);
    	while(cursor.moveToNext()) {
    		Course course=new Course();
    		course.code=cursor.getString(1);
    		course.name=cursor.getString(2);
    		course.lecture=cursor.getInt(3);
    		course.weekDay=cursor.getInt(4);
    		course.startTime=cursor.getInt(5);
    		course.endTime=cursor.getInt(6);
    		course.location=cursor.getString(7);
    		course.comment=cursor.getString(8);
    		myCourseList.add(course);
    	}
    	return myCourseList;
    }
    public void insert(SQLiteDatabase db,Course course) {
    	db.execSQL(course.insertSQL());
    }
}