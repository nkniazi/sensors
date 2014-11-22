package com.example.sensorrawaccelerometer1;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mXValueView;
	private TextView mYValueView;
	private TextView mZValueView;
	private SensorManager mSensorManager;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mXValueView=(TextView)findViewById(R.id.x_data);
        mYValueView=(TextView)findViewById(R.id.y_data);
        mZValueView=(TextView)findViewById(R.id.z_data);
        mSensorManager=(SensorManager)getSystemService(SEARCH_SERVICE);
        
        
    }
}
