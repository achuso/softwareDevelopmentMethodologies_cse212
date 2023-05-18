/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-10
 ***************************/


import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

	public static void main(String[] args) throws RoomTypeException {
	
		List<Calculable> CalculableArray = new ArrayList<Calculable>();
		
		MainFrame mainframe = new MainFrame();
		
		// FILE -> Exit
		mainframe.getExitOption().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// NEW -> Reservation
		// JMenuItem listener for adding Reservation
		mainframe.getReservationMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String reservationCity;
				String hotelName;
				String reservationMonth;
				int reservationStart_int, reservationEnd_int;
				
				reservationCity = JOptionPane.showInputDialog(mainframe, "Enter City:");
				if(reservationCity == null) return; // if clicked on cancel
				
				hotelName = JOptionPane.showInputDialog(mainframe, "Enter Hotel Name:");
				if(hotelName == null) return; // if clicked on cancel
				
				reservationMonth = JOptionPane.showInputDialog(mainframe, "Enter Reservation Month:");
				if(reservationMonth == null) return; // if clicked on cancel

				try {

					String reservationStart_str = JOptionPane.showInputDialog(mainframe, "Reservation Start:");
					if(reservationStart_str == null) return; // if clicked on cancel
					reservationStart_int = Integer.parseInt(reservationStart_str);
					
					String reservationEnd_str = JOptionPane.showInputDialog(mainframe, "Reservation End:");
					if(reservationEnd_str == null) return; // if clicked on cancel
					reservationEnd_int = Integer.parseInt(reservationEnd_str);
				} 
				catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(mainframe, "Dates for the reservation must be numeric values.", "Reservation Creation Failed", JOptionPane.ERROR_MESSAGE);
					return; // Send them back to the main menu if parseInt() throws an exception. It could be made into a loop like in Assignment-9 but it feels better this way, in my opinion.
				}
				
				CalculableArray.add(new Reservation(reservationCity, hotelName, reservationMonth, reservationStart_int, reservationEnd_int));
			}
		});
		
		// NEW -> Services
		// JMenuItem listener for adding Services
		mainframe.getServicesMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int serviceType_int;
				int clothes_int;
				int days_int;
				int serviceID_int;
				String serviceID_str;

				try {
					String serviceType_str = JOptionPane.showInputDialog(mainframe, "Please select one of the extra services from below:\n1. Laundry Service\n2. Spa Service");
					if(serviceType_str == null) return; // if clicked on cancel
					serviceType_int = Integer.parseInt(serviceType_str);	
					
					switch(serviceType_int) {
					case 1: // Laundry
						serviceID_str = JOptionPane.showInputDialog(mainframe, "Type the ID to credit this service:");
						if(serviceID_str == null) return; // if clicked on cancel
						serviceID_int = Integer.parseInt(serviceID_str);
						
						String clothes_str = JOptionPane.showInputDialog(mainframe, "Number of clothing articles:");
						if(clothes_str == null) return; // if clicked on cancel
						clothes_int = Integer.parseInt(clothes_str);
					
						CalculableArray.add(new Laundry(clothes_int, serviceID_int));
						break;
						
					case 2: // Spa
						serviceID_str = JOptionPane.showInputDialog(mainframe, "Type the ID to credit this service:");
						if(serviceID_str == null) return; // if clicked on cancel
						serviceID_int = Integer.parseInt(serviceID_str);
						
						String days_str = JOptionPane.showInputDialog(mainframe, "How many days?");
						if(days_str == null) return; // if clicked on cancel
						days_int = Integer.parseInt(days_str);
						
						CalculableArray.add(new Spa(days_int, serviceID_int));
						break;
						
					default: // Number out of range (1,2)
						JOptionPane.showMessageDialog(mainframe, "Invalid service type.", "Service Creation Failed", JOptionPane.ERROR_MESSAGE);
						break;
						
					}
				}
				catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(mainframe, "Inputted value must be a numeral.", "Service Creation Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// HELP -> CONTENTS
		mainframe.getContentsMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainframe, "Lorem ipsum dolor sit amet, consectetur adipiscing elit,sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n"
														+ "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n"
														+ "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.\n"
														+ "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." , "Contents", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		// HELP -> ABOUT
		mainframe.getAboutMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainframe, "Lorem ipsum dolor sit amet, consectetur adipiscing elit,sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n"
														+ "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n"
														+ "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.\n"
														+ "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." , "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		// Button listener for "Display Reservations"
		mainframe.getDisplayReservations().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe.setTerminalText(""); // reset the text box
				for(Calculable x: CalculableArray) {
					if(x instanceof Reservation) {
						Reservation tempRes = ((Reservation)x);
						mainframe.getTerminal().setText(mainframe.getTerminal().getText()
								+ "Reservation ID #" + tempRes.getReservationID() + "\nReservation at " + tempRes.getHotelName() + " starts on " 
								+ tempRes.getReservationMonth() + " " +  tempRes.getReservationStart() + " and ends on " + tempRes.getReservationMonth() 
								+ " " + tempRes.getReservationEnd() + "\n");
					}
				}		
			}
		});
		
		// Button listener for "Display Extra Services"
		mainframe.getDisplayServices().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe.setTerminalText(""); // reset the text box
				for(Calculable x: CalculableArray) {
					if(x instanceof Laundry) {
						Laundry tempLaundry = ((Laundry) x);
						mainframe.getTerminal().setText(mainframe.getTerminal().getText() 
								+ "Reservation ID #" + tempLaundry.getReservationID() + " has " + tempLaundry.getClothingPieces() + " pieces assigned for Laundry Service.\n");
					}
					else if(x instanceof Spa) {
						Spa tempSpa = ((Spa) x);
						mainframe.getTerminal().setText(mainframe.getTerminal().getText() 
								+ "Reservation ID #" + tempSpa.getReservationID() + " has " + tempSpa.getDays() + " days of SPA services.\n");
					}
				}
			}
		});
		
		// Button listener for "Display Reservations for City"
		mainframe.getDisplayResForCity().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				mainframe.setTerminalText(""); // reset the text box
				String cityName = JOptionPane.showInputDialog(mainframe, "Type City Name:");
				mainframe.getTerminal().setText("Reservations for " + cityName + ":\n");
				Boolean resInCity = false;
				
				for(Calculable x: CalculableArray) {
					if(x instanceof Reservation && ((Reservation) x).getCityName().compareToIgnoreCase(cityName) == 0 ) {
						Reservation tempResX = ((Reservation) x);
						mainframe.getTerminal().setText(mainframe.getTerminal().getText()
								+ "Reservation ID #" + tempResX.getReservationID() + "\n"
								+ "Reservation at " + tempResX.getHotelName() + " starts on " 
								+ tempResX.getReservationMonth() + " " +  tempResX.getReservationStart() + " and ends on " 
								+ tempResX.getReservationMonth() + " " + tempResX.getReservationEnd() + "\n");
						resInCity = true;
					}
				}
				
				if(!resInCity)
					mainframe.getTerminal().setText(mainframe.getTerminal().getText() + "No reservations have been made for this city." );		
			}	
		});
		
		
		

		
		
		


	}
}
