/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-6
 ***************************/

public class Laundry extends Services {

	int clothingPieces;
	double laundryCost;
	
	Laundry(int reservationID, int clothingPieces, double laundryCost) {
		this.reservationID = reservationID;
		this.clothingPieces = clothingPieces;
		this.laundryCost = laundryCost;
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
	// no setter for laundryCost because it is fixed at 20TL/item
	
}

