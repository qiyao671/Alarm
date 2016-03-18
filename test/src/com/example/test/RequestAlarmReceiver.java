package com.example.test;

import java.sql.Date;

import com.example.test.R.id;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class RequestAlarmReceiver extends BroadcastReceiver {
	//test
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		intent.setClass(context, Alarm_run.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
		
//		Toast.makeText(context, "Warning!", Toast.LENGTH_LONG).show();
//		ObjectPool.alarmClock.startClock(intent.getIntExtra("_id", 999), new Date(System.currentTimeMillis() + 5 * 1000));
	}
}