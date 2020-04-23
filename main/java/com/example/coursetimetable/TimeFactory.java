package com.example.coursetimetable;

public class TimeFactory {
	public static int parseInt(String time) {
		String[] result=time.split(":");
		if(result.length<2)
			return 0;
		return Integer.parseInt(result[0])*100+Integer.parseInt(result[1]);
	}
}
