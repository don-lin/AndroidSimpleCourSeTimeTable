package com.example.coursetimetable;

import java.util.LinkedList;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddActivity extends Activity {

	public String getEditString(int editTextId) {
		EditText et= (EditText)findViewById(editTextId);
		String result=et.getText().toString();
		et.setText(null);
		return result;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_course);
		Button save=(Button)findViewById(R.id.save);
		final DatabaseHelper dbh=new DatabaseHelper(getApplicationContext());
		
		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String code=getEditString(R.id.code);
				String name = getEditString(R.id.name);
				String lecture=getEditString(R.id.lecture);
				int day=Week.parseInt(((TextView)findViewById(R.id.weekDay)).getText().toString());
				String startTime=getEditString(R.id.stime);
				String endTime=getEditString(R.id.etime);
				String location=getEditString(R.id.location);
				String comment=getEditString(R.id.comment);
				
				Course course=new Course();
				course.code=code;
				course.name=name;
				course.lecture=lecture.equals("practical")?0:1;
				course.weekDay=day;
				course.startTime=TimeFactory.parseInt(startTime);
				course.endTime=TimeFactory.parseInt(endTime);
				course.location=location;
				course.comment=comment;
				
				SQLiteDatabase db=dbh.getWritableDatabase();
				dbh.insert(db, course);
				
				LinkedList<Course> list=dbh.getTable(db);
				String result="";
				while(!list.isEmpty()) {
					result+=list.remove().toString();
				}
				
				TextView display=(TextView)findViewById(R.id.display);
				display.setText(result);
				
				Intent i=new Intent(AddActivity.this,ListActivity.class);
				startActivity(i);
				finish();
			}			
		});
		

		Button addWeekDay=(Button)findViewById(R.id.addWeekDay);
		addWeekDay.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				TextView weekDay=(TextView)findViewById(R.id.weekDay);
				int day=Week.parseInt(weekDay.getText().toString());
				day=(day%7)+1;
				weekDay.setText(Week.toString(day));
				
			}
		});
		
		Button minusWeekDay=(Button)findViewById(R.id.minusWeekDay);
		minusWeekDay.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				TextView weekDay=(TextView)findViewById(R.id.weekDay);
				int day=Week.parseInt(weekDay.getText().toString());
				day=((day+5)%7)+1;
				weekDay.setText(Week.toString(day));
			}
		});
	}
}
