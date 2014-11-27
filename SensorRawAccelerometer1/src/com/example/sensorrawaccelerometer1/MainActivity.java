package com.example.sensorrawaccelerometer1;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

	private static final int UPDATE_THRESHOLD = 500;
	private TextView mXValueView;
	private TextView mYValueView;
	private TextView mZValueView;
	private SensorManager mSensorManager;
	private Sensor mAccelrometer;
	private long mLastUpdate;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mXValueView=(TextView)findViewById(R.id.x_value_view);
        mYValueView=(TextView)findViewById(R.id.y_value_view);
        mZValueView=(TextView)findViewById(R.id.z_value_view);
        mSensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelrometer=mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        
        
        
    }

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		mSensorManager.registerListener(this,mAccelrometer, SensorManager.SENSOR_DELAY_UI );
		mLastUpdate=System.currentTimeMillis();
	}

	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		
		mSensorManager.unregisterListener(this);
		super.onPause();
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
			
			long actualTime=System.currentTimeMillis();
			if(actualTime - mLastUpdate >UPDATE_THRESHOLD){
				mLastUpdate=actualTime;
				float x=event.values[0],y=event.values[1],z=event.values[2];
				mXValueView.setText(String.valueOf(x));
				mYValueView.setText(String.valueOf(y));
				mZValueView.setText(String.valueOf(x));
				
				
			}
		}
		
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}



}
