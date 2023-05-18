/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-10
 ***************************/

public class Laundry extends Services {

	int clothingPieces;
	double laundryCost;
	
	Laundry(int clothingPieces, int reservationID) {
		this.setClothingPieces(clothingPieces);
		this.setReservationID(reservationID);
		this.setLaundryCost(20);
	}
	
	@Override
	String getServiceType() {
		return "Laundry";
	}
	
	@Override
	double calculateService() {
		return getClothingPieces() * getLaundryCost();
	}
	
	int getClothingPieces() {return this.clothingPieces;}
	void setClothingPieces(int clothingPieces) {this.clothingPieces = clothingPieces;}
	
	double getLaundryCost() {return this.laundryCost;}
	void setLaundryCost(double laundryCost) {this.laundryCost = laundryCost;}
	
}