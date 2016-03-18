package com.example.test;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Alarm_run extends Activity {
	Button bt_closeA,bt_wait,bt_closeV;
	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm_run);
		
		bt_closeA = (Button) findViewById(R.id.button1);
		bt_wait = (Button) findViewById(R.id.button2);
		intent = getIntent();
//		Toast.makeText(this, intent.getIntExtra("_id", 999) + "", Toast.LENGTH_SHORT).show();
		
		
		bt_closeA.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Alarm_run.this.finish();
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.MILLISECOND, 5 * ObjectPool.SECOND);
				ObjectPool.alarmClock.startRepeatingClock(intent.getIntExtra("id", 0), calendar, 5 * ObjectPool.SECOND);
			}
		});
		bt_wait.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int interval = intent.getIntExtra("interval", 10 * ObjectPool.SECOND);
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.MILLISECOND, interval);
				ObjectPool.alarmClock.startClock(intent.getIntExtra("id", 0), calendar);
				Alarm_run.this.finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alarm_run, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
