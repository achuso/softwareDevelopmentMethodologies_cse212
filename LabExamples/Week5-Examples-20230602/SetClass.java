package Sets;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetClass {
	
//	Interface Set defines a collection that does not contain
//	duplicates.

	public static void main(String[] args) {
		
		Set<Integer> set = new LinkedHashSet<Integer>();
		
		set.add(4);
		set.add(10);
		set.add(6);
		set.add(9);
		set.add(10);
		
		System.out.println(set);
		

	}

}
