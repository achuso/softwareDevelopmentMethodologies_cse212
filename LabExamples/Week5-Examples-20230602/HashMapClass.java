package Maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class HashMapClass {
	
//	(key, value)
//	(name -> Alice)
//	(name -> Bob)

	public static void main(String[] args) {
		
		HashMap<Integer, String> hMap = new HashMap<Integer, String>();
		
		hMap.put(1, "One");
		hMap.put(2, "Two");
		hMap.put(3, "Three");
		
		System.out.println(hMap.keySet());
		System.out.println(hMap.values());
		
		Collection<String> c = hMap.values();
		Iterator<String> iterator = c.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}

}
