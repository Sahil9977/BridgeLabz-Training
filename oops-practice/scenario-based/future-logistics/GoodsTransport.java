package future_logistics;

public abstract class GoodsTransport {
	
	protected String transportId;
	protected String transportDate;
	protected int transportRating;
	
	public GoodsTransport(String transportId , String transportDate , int transportRating){
		setTransportId(transportId);
		setTransportDate(transportDate);
		setTransportRating(transportRating);
	}
	
	//setter methods
	public void setTransportId(String transportId) {
		this.transportId=transportId;
	}
	
	public void setTransportDate(String transportDate) {
		this.transportDate = transportDate;
	}
	
	public void setTransportRating(int transportRating) {
		this.transportRating = transportRating;
	}
	
	//getter methods
	public String getTransportId() {
		return transportId;
	}

	public String getTransportDate() {
		return transportDate;
	}
	
	public int getTransportRating() {
		return transportRating;
	}
	
	//abstract methods
	public abstract String vehicleSelection();
	
	public abstract float calculateTotalCharge();
	

}
