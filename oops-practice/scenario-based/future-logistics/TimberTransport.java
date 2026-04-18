package future_logistics;

public class TimberTransport extends GoodsTransport {
	
	private float timberLength;
	private float timberRadius;
	private String timberType;
	private float timberPrice;

	public TimberTransport(String transportId, String transportDate, int transportRating , float timberLength , float timberRadius , String TimberType , float timberPrice) {
		super(transportId, transportDate, transportRating);
		setTimberLength(timberLength);
		setTimberRadius(timberRadius);
		setTimberType(TimberType);
		setTimberPrice(timberPrice);
	}
	
	//setter method
	public void setTimberLength(float timberLength) {
		this.timberLength = timberLength;
	}
	
	public void setTimberRadius(float timberRadius) {
		this.timberRadius = timberRadius;
	}
	
	public void setTimberType(String timberType) {
		this.timberType = timberType;
	}
	
	public void setTimberPrice(float timberPrice) {
		this.timberPrice = timberPrice;
	}
	
	//getter methods
	public float getTimberLength() {
		return timberLength;
	}
	
	public float getTimberRadius() {
		return timberRadius;
	}
	
	public String getTimberType() {
		return timberType;
	}
	
	public float getTimberPrice() {
		return timberPrice;
	}

	@Override
	public String vehicleSelection() {
		double area = 2*3.147*getTimberRadius()*getTimberLength();
		if(area<250)return "Truck";
		else if(area>=250 && area <=400)return "Lorry";
		else return "MonsterLorry";
	}

	@Override
	public float calculateTotalCharge() {
		int vehiclePrice;
		double discountPercent;
		double volume;
		double Price;
		double TimberType;
		double Tax;
		double Discount;
		float totalCharge;
		
		//calculate vehicle price
		if(vehicleSelection().equalsIgnoreCase("Truck"))vehiclePrice=1000;
		else if(vehicleSelection().equalsIgnoreCase("Lorry")) vehiclePrice=1700;
		else vehiclePrice=3000;
		
		//calculate discount precentage
		if(transportRating==5)discountPercent=0.20;
		else if(transportRating==3 || transportRating==4)discountPercent=0.10;
		else discountPercent=0;
		
		volume=3.147*getTimberRadius()*getTimberRadius()*getTimberLength();
		
		if(timberType.equalsIgnoreCase("Premium")) TimberType=0.25;
		else TimberType=0.15;
		
		Price = volume*getTimberPrice()*TimberType;
		
		Tax=Price*0.3;
		
		Discount=Price*discountPercent;
		
		totalCharge = (float) (((Price)+vehiclePrice+Tax)-Discount);

		return totalCharge;
	}

}
