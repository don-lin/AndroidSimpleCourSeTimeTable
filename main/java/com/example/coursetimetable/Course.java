package com.example.coursetimetable;

public class Course {
	public int id;
	public String code;
	public String name;
	public int lecture;
	public int weekDay;
	public int startTime;
	public int endTime;
	public String location;
	public String comment;
	
	public String toString() {
		return "\'"+code+"\',\'"+name+"\',"+lecture+","+weekDay+","+startTime+","+endTime+",\'"+location+"\',\'"+comment+"\'";
	}
	
	public String insertSQL() {
		return "INSERT INTO course (module_code,name,l_p,day_of_week,start_time,end_time,location,comment) VALUES ("+toString()+")";
	}
}
