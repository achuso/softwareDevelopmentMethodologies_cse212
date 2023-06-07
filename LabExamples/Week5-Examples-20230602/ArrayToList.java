package Lists;

import java.util.Arrays;
import java.util.List;

public class ArrayToList {

	public static void main(String[] args) {
		
		String sArray[] = new String[] {"1", "2", "3"};
		
		List<String> list = Arrays.asList(sArray);
		
		System.out.println(list);
		
		list.set(2, "arr_element");
		
		System.out.println(list);

	}

}
