package com.t3hh4xx0r.external.addons.utils;

import android.os.Build;

public class DeviceType {
	
	
@SuppressWarnings("unused")
public
static boolean deviceEquals(String s){
		
		if(Build.MODEL.equals(s))
			return true;
		else 
			return false;
		
	
		
	}

public static String DEVICE_TYPE;


// Device name constatnts

/**
 * HTC Droid Incredible
 */
public static final String INCREDIBLE = "Incredible";
public static final String INCREDIBLE_SCRIPT = "inc.js";

public static final String ERIS = "Eris";
public static final String ERIS_SCRIPT = "desirec.js";


public static final String EVO = "Evo";
public static final String EVO_SCRIPT = "supersonic.js";

public static final String HERO = "Hero";
public static final String HERO_SCRIPT = "heroc.js";

public static final String THUNDERBOLT = "Thunderbolt" ;
public static final String THUNDERBOLT_SCRIPT = "mecha.js";

public static final String DROID = "Droid";
public static final String DROID_SCRIPT = "sholes.js";


}
