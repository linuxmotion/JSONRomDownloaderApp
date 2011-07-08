package org.linuxmotion.jsonpreference;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;



import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.preference.Preference.OnPreferenceClickListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class JSONPreferenceViewActivity extends PreferenceActivity {
	
	RelativeLayout mPreferenceContainer;
	private ListView mPreferenceListView;
	

	private ArrayList<NightlyObject> mNightlies = null;
	//private NightlyAdapter mAdapter;
	
	
	PreferenceScreen mRootPreference;
	Preference mRoot;
	private final String TAG = "JSON Preference Activity";
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        

        //mNightlies = new ArrayList<NightlyObject>();
       // mAdapter = new NightlyAdapter(this, R.layout.row, mNightlies);
        
        mPreferenceContainer = new RelativeLayout(this);
        mPreferenceContainer.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        
        
        mPreferenceListView = new ListView(this);
        mPreferenceListView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        mPreferenceListView.setId(android.R.id.list);
        //mPreferenceListView.setAdapter(mAdapter);
        
        
        mRootPreference = createPreferenceHierarchy();
        
        /*
        if(mNightlies != null && mNightlies.size() > 0){
        	Log.i(TAG, "Updating adapter");
        	//mAdapter.notifyDataSetChanged();
        	Log.i(TAG, "Number of nightlies" + mNightlies.size());
        	for(int i=0;i<mNightlies.size();i++)
            //mAdapter.add(mNightlies.get(i));
            
            Log.i(TAG, "The number of adapter views is: " + mAdapter.getCount());
        }
        */
        
        
        mRootPreference.bind(mPreferenceListView);
        Log.i(TAG, "mPreferenceListView: " + mPreferenceListView.getCount());
        
        mPreferenceContainer.addView(mPreferenceListView);
        
        
      setContentView(mPreferenceContainer);
      setPreferenceScreen(mRootPreference);
        
        
     
        
        
        
        
    }
    
    
    private PreferenceScreen createPreferenceHierarchy(){
    	
    	
    	// The root preference
    	PreferenceScreen PreferenceRoot = getNightlies();
    	
    	
    	
    	
    	
		return PreferenceRoot;
    	
    	
    	
    	
    }
    
    
 private PreferenceScreen getNightlies(){
    	

     PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(this);
    	try
        {

            mNightlies = new ArrayList<NightlyObject>();
    		
            String x = "";
            InputStream is;
            // Need to actually put our sript locatio here
            Log.d(TAG, "Begining json parsing");
            is = this.getResources().openRawResource(R.raw.jsonomfgb);
            
                
            byte [] buffer = new byte[is.available()];
            while (is.read(buffer) != -1);
            
            String jsontext = new String(buffer);
            JSONArray entries = new JSONArray(jsontext);

            Log.d(TAG, "Json parsing finished");

            x = "JSON parsed.\nThere are [" + entries.length() + "] entries.\n";

            int i;
            Log.i(TAG, "The number of entries is: " + entries.length());
            Log.d(TAG, "Starting preference resolver");
            
            for (i=0;i<entries.length();i++)
            {

                
            	NightlyObject n = new NightlyObject();
                JSONObject post = entries.getJSONObject(i);
                
                n.setDate(post.getString("date"));
                n.setBase(post.getString("base"));
                n.setDevice(post.getString("device"));
                n.setURL(post.getString("url"));
                n.setVersion(post.getString("version"));
                n.setZipName(post.getString("name"));
                n.setInstallable(post.getString("installable"));
                
                PreferenceScreen inscreen = getPreferenceManager().createPreferenceScreen(this);
                inscreen.setSummary(n.getVersion());
                inscreen.setTitle(n.getDate());
                screen.addPreference(inscreen);
              
                // Set the click listener for each preference
                OnNightlyPreferenceClickListener listner = new OnNightlyPreferenceClickListener(n, i, this);
                
                inscreen.setOnPreferenceClickListener(listner);
                
                
                mNightlies.add(n);
                

            }
            Log.d(TAG, x);
        }
        catch (Exception je)
        {

            Log.e(TAG, je.getMessage());
             je.printStackTrace();
        }
        
        

        return screen;
      }
 

 public class OnNightlyPreferenceClickListener implements OnPreferenceClickListener {
 	
 	private final String TAG = "OnNightlyPreferenceClick";
 	NightlyObject mNightly;
 	int mPosition;
 	Context mContext;
 	
 	OnNightlyPreferenceClickListener(NightlyObject o, int position, Context context){
 		
 		mNightly = o;
 		mPosition = position;
 		mContext = context;
 		
 		
 		
 	}
 	

 	@Override
 	public boolean onPreferenceClick(Preference v) {
 		

  		Log.d(TAG, v.getSummary().toString()  );
  		Log.d(TAG, v.getTitle().toString()  );
  		
  		Uri down = Uri.parse(mNightly.getURL());
  		
  		DownloadManager dman = (DownloadManager) mContext.getSystemService(mContext.DOWNLOAD_SERVICE);
  		
  		DownloadManager.Request req = new DownloadManager.Request(down);
  		req.setShowRunningNotification(true);
  		
  		dman.enqueue(req);
  		
 		// mNightly.get
 		// TODO Auto-generated method stub
 		return false;
 	}
 	
 	



 
 	
    
 }   
    
}