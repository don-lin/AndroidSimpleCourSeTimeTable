package com.example.coursetimetable;

public class Week {
	private static final String[] table= {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
	public static int parseInt(String s) {
		int i=0;
		for(i=0;!table[i].equals(s);i++);
		return i+1;
	}
	public static String toString(int n) {
		return table[n-1];
	}
}
