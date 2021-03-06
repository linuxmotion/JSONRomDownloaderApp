package com.t3hh4xx0r.external.addons.utils;

import java.io.File;

import android.content.Intent;
import android.os.Build;
import android.os.Environment;

public final class Constants {
	
	
	/**
	 *  Variable to turn debuging on across the app
	 */
	public static boolean FULL_DBG = true;
	/**
	 *  External storage mount point
	 *  @hide
	 * 
	 */
	private static File extStorageDirectory = Environment.getExternalStorageDirectory();
	
	/**
	 * Basic OMFGB downloads directory
	 */
    public static final String DOWNLOAD_DIR = extStorageDirectory + "/t3hh4xx0r/downloads/";
    
    /**
     * ClockWorkMod Recovery flash directory 
     */
    public static final String CWR_FLASH_DIR = "/sdcard/t3hh4xx0r/downloads/";
    
    /**
     * System app location
     */
    public static final String SYSTEM_APP = "/system/app/";
    
    /**
     * ClockWorkMod Recovery extended command directory
     */
    public static final String CWR_EXTENDED_CMD = "/cache/recovery/extendedcommand";
    
    /**
     *  Base URL for the manifest files for the addons, nightlies, and eventually the release roms.
     */
    public static final String BASE_SCRIPT_URL = "https://raw.github.com/OMFGB/OMFGBManifests/master/"; 
    

    /*
     *  The associated download has been completed
     * 
     */
	public static final int DOWNLOAD_COMPLETE = 1;
    
	
	/**
	 * 
	 * 
	 */
	
	public static String ADDONS = "addons.js"; 
    
    /**
     * The script ised for updating the app
     */
    private static String DEVICE_SCRIPT;




	public static void setDeviceScript(String deviceScript) {
		DEVICE_SCRIPT = deviceScript;
	}




	public static String getDeviceScript() {
		return DEVICE_SCRIPT;
	} 
    
	

}
