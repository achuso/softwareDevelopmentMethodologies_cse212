/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-10
 ***************************/

public class RoomTypeException extends Exception {

	RoomTypeException(String exceptionMsg) {
		super(exceptionMsg);
	}
	
	static void checkRoomType(String type) throws RoomTypeException {

		for(RoomTypes x: RoomTypes.values()) {
			if( x.getRoomType().compareToIgnoreCase(type) == 0)
				return;
		}
		throw new RoomTypeException("Room Type is not valid!");
	}
}
	

