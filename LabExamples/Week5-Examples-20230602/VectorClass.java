package Vectors;

import java.util.Vector;

public class VectorClass {

	public static void main(String[] args) {
		
		Vector<Integer> vector = new Vector<Integer>(5);
		
		System.out.println("Capacity: " + vector.capacity());
		
		for(int i=0; i<10; i++) {
			vector.add(i);
		}
		
		System.out.println(vector);

	}

}
