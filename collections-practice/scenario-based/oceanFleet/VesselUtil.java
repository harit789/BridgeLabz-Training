package oceanFleet;

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
	   vesselList.add(vessel);
	}
	
	public Vessel getVesselById(String vesselId) {
		for(Vessel vessel : vesselList) {
			if(vessel.getVesselId().equals(vesselId)) {
				return vessel;
			}
		}
		return null;
	}
	
	public List<Vessel> getHighPerformanceVessels(){
		double maxSpeed = 0;
		for(Vessel vessel : vesselList) {
			maxSpeed = Math.max(maxSpeed, vessel.getAverageSpeed());
		}
		
		List<Vessel> maxAvgList = new ArrayList<>();
		for(Vessel vessel : vesselList) {
			if(vessel.getAverageSpeed() >= maxSpeed) {
				maxAvgList.add(vessel);
			}
		}
		return maxAvgList;
	}
}
