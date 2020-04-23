package com.example.coursetimetable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ReadActivity extends Activity{
	public static Course courseShow;
	
	public void setText(String text,int id) {
		TextView tv=(TextView)findViewById(id);
		tv.setText(text);		
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.activity_course_detail);
		if(courseShow==null)
			return;
		
		setText(courseShow.name,R.id.name);
		setText(courseShow.code,R.id.code);
		setText(""+courseShow.lecture,R.id.lecture);
		setText(Week.toString(courseShow.weekDay),R.id.weekDay);
		setText(""+courseShow.startTime,R.id.stime);
		setText(""+courseShow.endTime,R.id.etime);
		setText(courseShow.location,R.id.location);
		setText(courseShow.comment,R.id.comment);
		
		Button back=(Button)findViewById(R.id.back);
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i=new Intent(ReadActivity.this,ListActivity.class);
				startActivity(i);
				finish();
			}
		});
	}
	
}
