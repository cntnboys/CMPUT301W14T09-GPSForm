package ca.cmput301w14t09.Controller;

import java.util.ArrayList;
import java.util.List;

import ca.cmput301w14t09.Model.GeoLocation;

public class LocationFactory {
	
	List<GeoLocation> objList = new ArrayList<GeoLocation>();
	
	public void buildlocations(){
		
		GeoLocation geo = new GeoLocation();
		geo.setName("ETLC");
		geo.setLatitude(53.52743);
		geo.setLongitude(-113.52893);
		objList.add(geo);
		
	}

	public List<GeoLocation> getObjList() {
		return objList;
	}

	public void setObjList(List<GeoLocation> objList) {
		this.objList = objList;
	}
	
	
	
}


