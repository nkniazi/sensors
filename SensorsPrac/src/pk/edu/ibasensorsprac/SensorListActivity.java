package pk.edu.ibasensorsprac;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class SensorListActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_main);
        SensorDisplayFragment sensorDisplay =
                (SensorDisplayFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.frag_sensor_view);
        SensorSelectorFragment sensorSelect =
                (SensorSelectorFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.frag_sensor_select);
        sensorSelect.setSensorDisplay(sensorDisplay);
    } 
}
