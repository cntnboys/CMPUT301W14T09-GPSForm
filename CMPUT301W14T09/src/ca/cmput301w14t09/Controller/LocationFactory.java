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
		
		GeoLocation geo1 = new GeoLocation();
		geo1.setName("Quad");
		geo1.setLatitude(53.52653);
		geo1.setLongitude(-113.52557);
		objList.add(geo1);
		
		GeoLocation geo11 = new GeoLocation();
		geo11.setName("CAB");
		geo11.setLatitude(53.52659);
		geo11.setLongitude(-113.52469);
		objList.add(geo11);
		
		GeoLocation geo111 = new GeoLocation();
		geo111.setName("SUB");
		geo111.setLatitude(53.52537);
		geo111.setLongitude(-113.52731);
		objList.add(geo111);
		
		GeoLocation geo1111 = new GeoLocation();
		geo1111.setName("CSC");
		geo1111.setLatitude(53.52678 );
		geo1111.setLongitude(-113.52715);
		objList.add(geo1111);
		
		
	}

	public List<GeoLocation> getObjList() {
		return objList;
	}

	public void setObjList(List<GeoLocation> objList) {
		this.objList = objList;
	}
	
	
	
}


