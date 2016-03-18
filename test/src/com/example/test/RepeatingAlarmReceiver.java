package com.example.test;

import java.sql.Date;
import java.util.Calendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class RepeatingAlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		int interval = intent.getIntExtra("interval", 5 * ObjectPool.SECOND);
		calendar.add(Calendar.MILLISECOND, interval);
		ObjectPool.alarmClock.startRepeatingClock(intent.getIntExtra("_id", 999), calendar, interval);
		intent.setClass(context, Alarm_voice.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}

}
