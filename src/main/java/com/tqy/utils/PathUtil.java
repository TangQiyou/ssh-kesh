package com.tqy.utils;

public class PathUtil {
	
	synchronized static public String getRealPath(){
		return System.getProperty("user.dir");
	}

}
