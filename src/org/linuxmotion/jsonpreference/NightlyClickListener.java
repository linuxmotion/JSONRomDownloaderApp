package org.linuxmotion.jsonpreference;

import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.preference.Preference.OnPreferenceClickListener;
import android.view.View;
import android.view.View.OnClickListener;


public class NightlyClickListener   implements OnClickListener, OnPreferenceClickListener {
	
    private int position;
    private onNightlyClickListener mOnNightlyClickListener ;
 
        // Pass in the callback (this'll be the activity) and the row position
    public NightlyClickListener(View v, int pos) {
        position = pos;
    }
 
        public NightlyClickListener(PreferenceScreen screen, int pos) {

            position = pos;
        	
		// TODO Auto-generated constructor stub
	}

	// The onClick method which has NO position information
    @Override
    public void onClick(View v) {
    	
    	mOnNightlyClickListener.OnNightlyClick(v, position);
    }
    @Override
	public boolean onPreferenceClick(Preference v) {
		// TODO Auto-generated method stub

    	mOnNightlyClickListener.OnNightlyPreferenceClick(position);
		return false;
	}



    public interface onNightlyClickListener {
    	
    	
    	public void OnNightlyClick(View v, int position);
    	public void OnNightlyPreferenceClick( int position);
        // Feel free to add other methods of use. OnCustomTouch for example :)
    }		

    
    public void setOnNightlyClickListener(onNightlyClickListener l) {
    	 //if (DBG) log("Setting the listners");
    	this.mOnNightlyClickListener = l;
    }

	
	


}
