package com.example.test;

import java.util.Calendar;

import com.example.test.R.id;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Calendar cal = Calendar.getInstance();
	private Button bt_addAlarm = null;
	final int DIALOG_TIME = 0;
	Dialog dialog_add = null;
	int id = 0;	//for test
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ObjectPool.alarmClock = new AlarmClock(this);
        bt_addAlarm = (Button) findViewById(R.id.button1);
        Button bt_stop = (Button)findViewById(R.id.button2);
        bt_addAlarm.setOnClickListener(new OnClickListener() {			        	
        	@Override			
			public void onClick(View arg0) {
        		cal.setTimeInMillis(System.currentTimeMillis()); 
        		int hour = cal.get(Calendar.HOUR_OF_DAY);
        		int minute = cal.get(Calendar.MINUTE);
				// TODO Auto-generated method stub
				new TimePickerDialog(MainActivity.this,new OnTimeSetListener(){
					@Override
					public void onTimeSet(TimePicker arg0, int arg1, int arg2) {
						// TODO Auto-generated method stub
						cal.setTimeInMillis(System.currentTimeMillis());
						cal.set(Calendar.HOUR_OF_DAY, arg1);
						cal.set(Calendar.MINUTE, arg2);
						cal.set(Calendar.SECOND, 0);
						cal.set(Calendar.MILLISECOND, 0);
						
//						Toast.makeText(MainActivity.this, cal.getTimeInMillis() + "", Toast.LENGTH_LONG).show();
						ObjectPool.alarmClock.startClock(id, cal);
					}
				},hour,minute,true).show();
			}
		});
    }  
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
