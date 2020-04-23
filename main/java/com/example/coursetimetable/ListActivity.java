package com.example.coursetimetable;

import java.util.LinkedList;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ListActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final DatabaseHelper dbh=new DatabaseHelper(getApplicationContext());

		SQLiteDatabase db=dbh.getWritableDatabase();
		final LinkedList<Course> list=dbh.getTable(db);
		String[] result=new String[list.size()];
		for(int i=0;i<list.size();i++) {
			result[i]=list.get(i).toString();
		}
		
		setContentView(R.layout.activity_course_list);
		ArrayAdapter<String> adapter= new ArrayAdapter<String>(
				ListActivity.this,android.R.layout.simple_list_item_1,result);
	
		ListView listView = (ListView)findViewById(R.id.courselist);
		listView.setAdapter(adapter);
			
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
					ReadActivity.courseShow=list.get(position);
					Intent i=new Intent(ListActivity.this,ReadActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		Button add=(Button)findViewById(R.id.add);
		add.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i=new Intent(ListActivity.this,AddActivity.class);
				startActivity(i);
				finish();
			}
		});
	}
}
