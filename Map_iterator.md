## How to use iterator to traverse map
```java
import java.util.*;
import java.util.Map.Entry;

public class Test {
	public static void main(String[] args) {
		//HashMap 遍历是不按顺序排列
		Map map=new HashMap();
		map.put("m1", "");
		map.put("m2", "m22");
		map.put("m3", "m33");
		map.put("m4", "m44");
		Iterator iter=map.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry=(Entry) iter.next();
			String key=entry.getKey().toString();
			String value=entry.getValue().toString();
			System.out.println(key+"*"+value);
		}
```
