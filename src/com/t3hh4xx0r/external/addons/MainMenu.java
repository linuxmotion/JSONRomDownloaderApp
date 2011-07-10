package com.t3hh4xx0r.external.addons;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.t3hh4xx0r.external.addons.utils.Constants;
import com.t3hh4xx0r.external.addons.utils.DeviceType;


public class MainMenu extends PreferenceActivity {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		determineDevice();
		
		addPreferencesFromResource(R.layout.main_menu);
  
		
		
		
	}
	
	

	private void determineDevice(){
		
		// We dont need to set the device script every time just once
		if(Constants.getDeviceScript() == null || !Constants.getDeviceScript().equals("")){
		
				if (DeviceType.deviceEquals(DeviceType.INCREDIBLE)) {
			    	Constants.setDeviceScript(DeviceType.INCREDIBLE_SCRIPT);
			        	
				}else  if (DeviceType.deviceEquals(DeviceType.ERIS)) {

			    	Constants.setDeviceScript(DeviceType.ERIS_SCRIPT);
			    	
				}else  if (DeviceType.deviceEquals(DeviceType.DROID)) {

			    	Constants.setDeviceScript(DeviceType.DROID_SCRIPT);
					
				}else  if (DeviceType.deviceEquals(DeviceType.EVO)) {

			    	Constants.setDeviceScript(DeviceType.EVO_SCRIPT);
			        	
				}else  if (DeviceType.deviceEquals(DeviceType.HERO)) {

			    	Constants.setDeviceScript(DeviceType.HERO_SCRIPT);
			        	
				}else  if (DeviceType.deviceEquals(DeviceType.THUNDERBOLT)) {

			    	Constants.setDeviceScript(DeviceType.THUNDERBOLT_SCRIPT);
			        	
				}
		}
		
	}
	
}


