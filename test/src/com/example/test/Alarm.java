package com.example.test;

import java.util.Calendar;

public class Alarm {
	private int id;
	private Calendar time;
	private static int idFlag = 0;
	private boolean isRepeating = false;
	
	public Alarm(long milliseconds) {
		this.id = idFlag ++;
		this.time.setTimeInMillis(milliseconds);
	}
}
