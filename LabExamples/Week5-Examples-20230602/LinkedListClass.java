package Lists;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;

public class LinkedListClass {

	public static void main(String[] args) {
		
		LinkedList<String> linkedList = new LinkedList<String>();
		
		// Adding integer objects to linkedlist
		linkedList.add("Hyacinth");
		linkedList.add("Rose");
		linkedList.add("Chamomile");
		
		// Inserting a string object at the tail
		linkedList.addLast("Tulip");
		
		// Inserting a string object at the first
		linkedList.addFirst("Poppy");
				
		// Inserting a string object at the specific position
		linkedList.add(1, "Carnation");
				
		// Obtaining a specific element in the linkedlist
		System.out.println("First: " + linkedList.getFirst());
		System.out.println("Last: " + linkedList.getLast());
		
		// Traversing the linkedlist through for loop
		for(int i=0; i<linkedList.size(); i++) {
			System.out.println("In for loop: " + linkedList.get(i)); 
		}
				
		// Traversing the linkedlist through iterator  
		Iterator<String> iterator = linkedList.iterator(); 
				
		while(iterator.hasNext()){  
			System.out.println("With iterator: " + iterator.next().toUpperCase());
			
		}  
		
		// Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive
		System.out.println("Sublist: " + linkedList.subList(2, 4));
		
		// Reaching the previous elements through listiterator 
		ListIterator<String> listIterator = linkedList.listIterator();
	
		System.out.println("Has previous?: " + listIterator.hasPrevious());
		listIterator.next();
		System.out.println("With listIterator, previous' index: " + listIterator.previousIndex());
		System.out.println("With listIterator, previous: " + listIterator.previous());
		listIterator.next();
		listIterator.next();
		System.out.println("With listIterator, previous' index: " + listIterator.previousIndex());
		System.out.println("With listIterator, previous: " + listIterator.previous());
		
		
		// After removing, there will be NoSuchElementException
		iterator.remove();
		//System.out.println("Iterator: " + iterator.next());
			
		
		// Cloning the linkedlist
		Object cloneLinkedList = linkedList.clone();
		// Casting
		cloneLinkedList = (LinkedList<String>) cloneLinkedList;
		// Checking if two linkedlists equal to each other
		System.out.println(cloneLinkedList.equals(linkedList));
				
		// Adding a linkedlist into the another linkedlist
		LinkedList<String> newLinkedList = new LinkedList<String>();
		newLinkedList.addAll(linkedList);
						
		// Checking if the linkedlist contains a specific element
		System.out.println(linkedList.contains("Chamomile"));
				
		// Deleting all linkedlist elements -not zero-
		linkedList.clear();
		System.out.println(linkedList.contains("Chamomile"));
		System.out.println(linkedList.contains(null));
		System.out.println(linkedList.size());
		
		
		// Is the list empty?
		List<String> newList = new LinkedList<String>();
		System.out.println("Is empty?: " + newList.isEmpty());
		
		newList.add("hello");
		newList.add("goodbye");
		
		// Returning the index of a specific element
		System.out.println("Index of: " + newList.indexOf("goodbye"));
		
		
	}

}
