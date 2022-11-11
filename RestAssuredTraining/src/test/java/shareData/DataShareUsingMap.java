package shareData;

import java.util.LinkedHashMap;
import java.util.Map;

public class DataShareUsingMap {
	
	private DataShareUsingMap() {
		
	}
 private static Map<String, Object> datamap = new LinkedHashMap<String, Object>();

 public static void setValue(String key,Object value) {
	 datamap.put(key, value);	
 }
 
 public static Object getValue(String key) {
	return datamap.get(key);
 }
}
