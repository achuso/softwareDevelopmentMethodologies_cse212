package Vectors;

import java.util.Stack;

public class StackClass {
	
	// LIFO - last in first out

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(5);
		stack.push(8);
		stack.push(3);
		
		System.out.println(stack);
		
		stack.remove(1);
		System.out.println(stack);
		
		// Returning the current capacity of the stack
		System.out.println("Capacity: " + stack.capacity());

		// Returning the element at the specific index
		System.out.printf("1. element of the stack: %d" , stack.elementAt(1));
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		System.out.println(stack);
		
		
		
		
	}

}
