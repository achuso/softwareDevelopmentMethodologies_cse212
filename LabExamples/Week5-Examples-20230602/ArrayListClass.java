package Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListClass {

	public static void main(String[] args) {
		
//		Each primitive type has a corresponding type-wrapper class (in package java.lang),
//		--- Boolean, Byte, Character, Double, Float, Integer, Long and Short
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		//ArrayList<Integer> arrayList = new ArrayList<Integer>(10);
		 
		// Adding integer objects to arraylist
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		
		// Inserting an integer object at the specific position
		arrayList.add(2, 50);
		
		// Traversing the arraylist through for loop
		for(int i=0; i<arrayList.size(); i++) {
			System.out.println("In for loop: " + arrayList.get(i));
		}
		
		
		// Traversing the arraylist through iterator  
		Iterator<Integer> iterator = arrayList.iterator(); 
		
		while(iterator.hasNext()){  
			System.out.println("With iterator: " + iterator.next());  
		}  
		
		
		// Cloning the arraylist
		Object cloneArrayList = arrayList.clone();
		// Casting
		cloneArrayList = (ArrayList<Integer>) cloneArrayList;
		
		// Checking if two arraylists equal to each other
		System.out.println(cloneArrayList.equals(arrayList));
		
		// Adding an arraylist into the another arraylist
		ArrayList<Integer> newArrayList = new ArrayList<Integer>();
		newArrayList.addAll(arrayList);
		
		// Converting an arraylist to array
		Integer[] newArray = new Integer[arrayList.size()];
		arrayList.toArray(newArray);
		for(int i=0; i< newArray.length; i++) {
			System.out.println(newArray[i]);
		}
		
		// Sorting, reversing and shuffling the arraylist
		Collections.sort(arrayList);
		System.out.println("Sorted: " + arrayList);
		
		Collections.reverse(arrayList);
		System.out.println("Reversed: " + arrayList);
		
		Collections.shuffle(arrayList);
		System.out.println("Shuffled: " + arrayList);
		
		// Returning the maximum and minimum element
		System.out.println("Maximum: " + Collections.max(arrayList));
		System.out.println("Minimum: " + Collections.min(arrayList));
		
		// Checking whether arraylist and newarraylist have elements in common
		boolean disjoint = Collections.disjoint(arrayList, newArrayList);
		System.out.printf("arrayList and newArrayList %s elements in common\n",
				(disjoint ? "do not have" : "have"));
		
		// Checking if the arraylist contains a specific element
		System.out.println(arrayList.contains(3));
		
		// Deleting all arraylist elements -not zero-
		arrayList.clear();
		System.out.println(arrayList.contains(3));
		System.out.println(arrayList.contains(0));
		System.out.println(arrayList.size());
		
		
	}

}
