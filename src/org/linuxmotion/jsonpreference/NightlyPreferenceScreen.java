package org.linuxmotion.jsonpreference;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.util.AttributeSet;
import android.widget.TextView;

public class NightlyPreferenceScreen extends Preference {
	
	private TextView mDate;
	private TextView mCompiledOn;
	private TextView mBaseVersion;
	
	private Context mContext;
	
	private NightlyObject mNightly;
	
	public NightlyPreferenceScreen(Context context, NightlyObject nightly) {
		this(context, null, 0);
		
		mNightly = nightly;
		mContext = context;
		
		this.setLayoutResource(R.layout.nightly_preference_view);
		this.setSelectable(true);
		initUI(nightly);
	
	}
	
	public NightlyPreferenceScreen(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	
	private void initUI(NightlyObject nightliy){
		
		mDate = new TextView(mContext);
		mCompiledOn = new TextView(mContext);
		mBaseVersion = new TextView(mContext);
		
		mDate.setText(nightliy.getDate());
		mCompiledOn.setText(nightliy.getDate());
		mBaseVersion.setText( nightliy.getVersion());
		
		 
	
	}
	
	
	

}
