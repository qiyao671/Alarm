package com.example.test;

import java.security.PublicKey;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.R.integer;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmClock {

//	private boolean status = false;
	private Context context;
	private AlarmManager alarmManager;
	
	public AlarmClock(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
        alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
	}
	
	public void startClock(int id, Calendar calendar) {
		Intent intent;
		PendingIntent sender;
		intent = new Intent(context, RequestAlarmReceiver.class);
		intent.putExtra("_id", id);
        sender = PendingIntent.getBroadcast(context, id, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        intent.putExtra("time", calendar.getTimeInMillis());

        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
	}
	//interval hasn't be set
	public void startRepeatingClock(int id, Calendar calendar, int interval) {
		Intent intent;
		PendingIntent sender;
		intent = new Intent(context, RepeatingAlarmReceiver.class);
		intent.putExtra("_id", id);
		intent.putExtra("interval", interval);
        sender = PendingIntent.getBroadcast(context, id, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
	}
	
	public void stopClock(int id)
	{
		Intent intent;
		PendingIntent sender;
		intent = new Intent(context, RepeatingAlarmReceiver.class);
		intent.putExtra("_id", id);
        sender = PendingIntent.getBroadcast(context, id, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        
		alarmManager.cancel(sender);
	}
}
