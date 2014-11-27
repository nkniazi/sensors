package pk.edu.ibasensorsprac;

import java.util.List;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class SensorSelectorFragment extends ListFragment {
	private static final String TAG="SensorSelectorFragment";
	private SensorDisplayFragment sensorDisplay;
	
	public void setSensorDisplay(SensorDisplayFragment sensorDisplay)
    {
        this.sensorDisplay = sensorDisplay;

        SensorManager sensorManager =
                (SensorManager) getActivity().getSystemService(
                        Activity.SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        this.setListAdapter(new SensorListAdapter(getActivity()
                .getApplicationContext(), android.R.layout.simple_list_item_1,
                sensors));
    }
	
	
	 protected void showSensorFragment(Sensor sensor) {
			sensorDisplay.displaySensor(sensor);
			android.support.v4.app.FragmentTransaction ft=getActivity().getSupportFragmentManager().beginTransaction();
			ft.hide(SensorSelectorFragment.this);
			ft.show(sensorDisplay);
			ft.addToBackStack("Showing sensor :"+sensor.getName());
			ft.commit();
			
			
			
			
		}
	 
	private class SensorListAdapter extends ArrayAdapter<Sensor>{

		public SensorListAdapter(Context context, int textViewresourceId,
				List<Sensor> sensors) {
			super(context,textViewresourceId, sensors);
			
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			final Sensor selectedSensor=getItem(position);
			if(convertView==null){
				convertView=LayoutInflater.from(getContext()).inflate(android.R.layout.simple_expandable_list_item_1,null);
				
			}
			convertView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					showSensorFragment(selectedSensor);
				}
			});
			return convertView;
		}

		
		
	
	}
	

}
