/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-9
 ***************************/

import java.util.Comparator;

public class CostComparator implements Comparator<Services> {
	
	public int compare(Services o1, Services o2) {

		double total = o1.getCost() - o2.getCost();
		
		// Return 1 if o1>o2, 0 if o1==o2, -1 if o1<o2
		return (total >= 0) ? ( (total == 0) ? 0 : 1) : -1;
	}
	
}
