package com.example.test;

import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;

public class Alarm_voice extends Activity {
	Calendar cal = Calendar.getInstance();
	private  TextToSpeech mSpeech;
	int minute, hour;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.onCreate(savedInstanceState);

		minute = cal.get(Calendar.MINUTE);
		hour = cal.get(Calendar.HOUR_OF_DAY);

		new AlertDialog.Builder(Alarm_voice.this).setTitle("当前时间").setMessage(hour + "：" + minute)
				.setPositiveButton("知道了", new OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						Alarm_voice.this.finish();
					}
				}).
				setNegativeButton("关闭报时", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						ObjectPool.alarmClock.stopClock(getIntent().getIntExtra("_id", 0));
						Alarm_voice.this.finish();
					}
				}).create().show();
		
		mSpeech  =   new  TextToSpeech( this ,  new  OnInitListener() {

            @Override
             public   void  onInit( int  status) {
                 //  TODO Auto-generated method stub 
                 if  (status  ==  TextToSpeech.SUCCESS) {
                     int  result  =  mSpeech.setLanguage(Locale.CHINESE);
                     if  (result  ==  TextToSpeech.LANG_MISSING_DATA
                             ||  result  ==  TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e( " lanageTag " ,  " not use " );
                    }  else  {
                        String utteranceId=this.hashCode() + "";
                        mSpeech.speak("当前的时间为" + hour + "点" + minute + "分", TextToSpeech.QUEUE_FLUSH, null, utteranceId);
                    }
                }
            }
        });
	}
}
