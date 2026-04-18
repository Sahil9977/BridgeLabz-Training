package future_logistics;

public class BrickTransport extends GoodsTransport{
	
	private float brickSize;
	private int brickQuantity;
	private float brickPrice;

	public BrickTransport(String transportId, String transportDate, int transportRating , float brickSize , int brickQuantity , float brickPrice ) {
		super(transportId, transportDate, transportRating);
		setBrickSize(brickSize);
		setBrickQuantity(brickQuantity);
		setBrickPrice(brickPrice);
	}
	
	//setter methods
	public void setBrickSize(float brickSize) {
		this.brickSize = brickSize;
	}
	
	public void setBrickQuantity(int brickQuantity) {
		this.brickQuantity = brickQuantity;
	}

	public void setBrickPrice(float brickPrice) {
		this.brickPrice = brickPrice;
	}
	
	//getter method
	public float getBrickSize() {
		return brickSize;
	}
	
	public int getBrickQuantity() {
		return brickQuantity;
	}
	
	public float getBrickPrice() {
		return brickPrice;
	}
	
	@Override
	public String vehicleSelection() {
		
		if(getBrickQuantity()<300)return "Truck";
		else if(getBrickQuantity()>=300 && getBrickQuantity()<=500) return "Lorry";
		else return "MonsterLorry";
	}

	@Override
	public float calculateTotalCharge() {
		
		int vehiclePrice;
		double discountPercent ;
		double Price=getBrickPrice()*getBrickQuantity();
		double Tax=Price*0.3;
		double Discount;
		float totalCharge;
		
		//select vehicle price
		if(vehicleSelection().equalsIgnoreCase("Truck")) vehiclePrice=1000;
		else if(vehicleSelection().equalsIgnoreCase("Lorry")) vehiclePrice=1700;
		else vehiclePrice=3000;
		
		//calculate discout percentage
		if(transportRating==5)discountPercent=0.20;
		else if(transportRating==3 || transportRating==4)discountPercent=0.10;
		else discountPercent=0;
		
		Discount = Price*discountPercent;
		
		totalCharge = (float)(((Price)+vehiclePrice+Tax)-Discount);
		
		return totalCharge;
	}

	
}
