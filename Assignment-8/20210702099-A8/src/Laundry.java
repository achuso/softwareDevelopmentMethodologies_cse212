/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-8
 ***************************/

public class Laundry extends Services {

	int clothingPieces;
	double laundryCost;
	
	Laundry(int reservationID, int clothingPieces, double laundryCost) {
		setReservationID(reservationID);
		setClothingPieces(clothingPieces);
		setLaundryCost(laundryCost);
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

