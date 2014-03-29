package ca.cmput301w14t09.Controller;

import java.util.ArrayList;

import ca.cmput301w14t09.Model.Comment;
import ca.cmput301w14t09.Model.GeoLocation;
import ca.cmput301w14t09.elasticSearch.ElasticSearchOperations;

public class SortingController {
	
	public void sortCommentsByDefaultGeoLocation(){
		LocationController lc = new LocationController();
		
		
		lc.getGeoLocation();

		
	}
	
	public void sortComments(GeoLocation geo){
		
		ArrayList<Comment> topComments = null;
		try {
			topComments = ElasticSearchOperations.pullThreads();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
