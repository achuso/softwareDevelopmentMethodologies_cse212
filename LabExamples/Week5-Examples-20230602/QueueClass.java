package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueueClass {
	
	// FIFO - first in, first out

	public static void main(String[] args) {
		
		Queue<Double> queue = new LinkedList<Double>();
		
		queue.add(30.78);
		queue.add(13.17);
		queue.add(98.56);
		queue.add(54.12);
		
		System.out.println(queue);
		
		// Returning the head of the queue
		System.out.println(queue.element());
		
		// Returning and removing the head of the queue
		queue.poll();
		System.out.println(queue);
		
		//Collections.sort(queue);
		
		

	}

}
