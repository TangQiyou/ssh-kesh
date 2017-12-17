package com.tqy.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回类
 * @author TQY 2017-12-17 23:02:44
 *
 */
public class Msg {
	//状态码:1：成功，2：失败  3：更新时的重名
	//private int code;
	
	/**
	 * 
	 * @return 一个map，里面包含了指定的code，msg
	 */
	public static Map<String, Object> success(){
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("code", 1);
		map.put("msg","处理成功！");
		return map;
	}
	
	/**
	 * 
	 * @return 一个map，里面包含了指定的code，msg
	 */
	public static Map<String, Object> fail(){
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("code", 2);
		map.put("msg","处理失败！");
		return map;
	}
	
	/**
	 * 
	 * @param map 需要添加新内容的map
	 * @param key 新添加内容的键
	 * @param value 新添加内容的值
	 * @return 一个map，包含添加前的内容后添加后的内容
	 */
	public static Map<String, Object> add(Map<String, Object> map, String key, Object value){
		Map<String, Object> extend = new HashMap<String, Object>();
		extend.put(key, value);
		map.put("extend", extend);
		return map;
	}
	
}
