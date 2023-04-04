
public class Laundry extends Services {

	int clothingPieces;
	final double laundryCost = 20;
	
	Laundry(int customerID, int clothingPieces, double laundryCost) {
		this.customerID = customerID;
		this.clothingPieces = clothingPieces;
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

