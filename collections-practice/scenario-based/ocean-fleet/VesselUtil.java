package ocean_fleet;

import java.util.ArrayList;
import java.util.List;

public class VesselUtil {
	
	private List<Vessel> vesselList = new ArrayList<>();

	public List<Vessel> getVesselList() {
		return vesselList;
	}

	public void setVesselList(List<Vessel> vesselList) {
		this.vesselList = vesselList;
	}
	
	public void addVesselPerformance(Vessel vessel) {
		getVesselList().add(vessel);
	}

	public Vessel getVesselById(String vesselId) {
		for(int i=0;i<getVesselList().size();i++) {
			if(getVesselList().get(i).vesselId.equals(vesselId))return getVesselList().get(i);
		}
		return null;
	}
	
	public List<Vessel> getHighPerformanceVessel(){
		
		List<Vessel> hpv = new ArrayList<Vessel>();
		double max = Double.MIN_VALUE;
		
		for(int i=0;i<getVesselList().size();i++) {
			 if(getVesselList().get(i).averageSpeed>max)max=getVesselList().get(i).averageSpeed;
		}
		
		for(int i=0;i<getVesselList().size();i++) {
			if(getVesselList().get(i).averageSpeed==max)hpv.add(getVesselList().get(i));
		}
		return hpv;
		
	}
}
