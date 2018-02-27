package com.datautil.bookstore;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectToMap {

	/*
	 * 将object转换为Map，不包含object继承属性
	 */
	public static Map<String, String> getFieldVlaue(Object obj) throws Exception {  
        Map<String, String> mapValue = new HashMap<String, String>();  
        Class<?> cls = obj.getClass();  
        Field[] fields = cls.getDeclaredFields();  
        for (Field field : fields) {  
            String name = field.getName();  
            String strGet = "get" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());  
            Method methodGet = cls.getDeclaredMethod(strGet);  
            Object object = methodGet.invoke(obj);  
            String value = object != null ? object.toString() : "";  
            mapValue.put(name, value);  
        }  
        return mapValue;  
    }  
	/*
	 * 将List<object>转换为List<Map>
	 */
	public static List<Map> getFieldVlaueList(List<?> objects)throws Exception{
		
		List<Map> mapList = new ArrayList<Map>();
		for(Object obj:objects){
			mapList.add(getFieldVlaue(obj));
		}
		
		return mapList;
	}
	

}