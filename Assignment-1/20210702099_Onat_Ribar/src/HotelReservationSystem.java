

/************************************
		CSE 212 Section 3
		Student ID: 20210702099
		Name: Onat Ribar
 ***********************************/

public class HotelReservationSystem {
	
	private int standardRooms[][];
	private int maxAvailableRooms = 0;
	private int occupiedRooms = 0;
	
	
	public HotelReservationSystem(int x) {
		maxAvailableRooms = x;
		standardRooms = new int[maxAvailableRooms][3];

		 // [i][0] = reservation ID (starts from 1 AND account for index and id differences!!!)
		 // [i][1] = price per person
		 // [i][2] = person count
	}
	
	
	public void displayInfo() {
		if(occupiedRooms == 0)
			System.out.println("ERROR: No rooms reserved.");
		else
			for(int i = 0; i < occupiedRooms; i++)
				System.out.printf("Room #%d has %d people with a price total of $%d.\n",
						standardRooms[i][0], standardRooms[i][2], calculatePrice(i));
	}
	
	
	public int calculatePrice(int roomIndex) {
		return standardRooms[roomIndex][1] * standardRooms[roomIndex][2];
	}
	
	
	public void createStandardRoom(int pricePer, int personCount) {
		
		if(maxAvailableRooms == occupiedRooms)
			System.out.println("ERROR: No rooms available to reserve.");
		
		else {
			standardRooms[occupiedRooms][1] = pricePer;
			standardRooms[occupiedRooms][2] = personCount;
			standardRooms[occupiedRooms][0] = ++occupiedRooms;
			
			System.out.printf("Room #%d created!\n", occupiedRooms);
		}
		
	}
	
	
	public int roomsCreated() { return occupiedRooms; }
	
	
}
