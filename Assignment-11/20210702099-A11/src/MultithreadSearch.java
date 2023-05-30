/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-11
 ***************************/

import java.util.ArrayList;

public class MultithreadSearch implements Runnable {
	
	private ArrayList<Calculable> calculableArray;
	private MainFrame frame;
	private String hotelName;
	private int startIndex;
	private int endIndex;
	
	MultithreadSearch(ArrayList<Calculable> calculableArray, MainFrame frame, String hotelName, int startIndex, int endIndex) {
		this.frame = frame;
		this.calculableArray = calculableArray;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.hotelName = hotelName;
	}
	
	@Override
	public void run() {
		synchronized (calculableArray) {
			for(int i = getStartIndex(); i <= getEndIndex(); i++) {
				// This is a bit messy, but it checks if the Service at a given iteration is a Reservation, and if its hotelName matches with the one inputted for search
				Calculable currentCalculable = (Calculable) getCalculableArray().get(i);
				if( currentCalculable instanceof Reservation && ((Reservation) currentCalculable).getHotelName().compareToIgnoreCase(this.getHotelName()) == 0 ) 
					getFrame().getTerminal().setText(getFrame().getTerminal().getText() + ((Reservation) getCalculableArray().get(i)).getReservationID() + " "  ); 	
			}
		}	
	}
	
	public int getStartIndex() 							{ return this.startIndex; }
	public int getEndIndex() 							{ return this.endIndex; }
	public String getHotelName() 						{ return this.hotelName; }
	public ArrayList<Calculable> getCalculableArray()	{ return this.calculableArray; }
	public MainFrame getFrame() 						{ return this.frame; }
}
