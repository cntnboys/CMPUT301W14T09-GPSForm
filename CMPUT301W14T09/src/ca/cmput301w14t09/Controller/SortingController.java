package ca.cmput301w14t09.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import ca.cmput301w14t09.Model.Comment;
import ca.cmput301w14t09.Model.GeoLocation;
import ca.cmput301w14t09.elasticSearch.ElasticSearchOperations;

public class SortingController {
	
	public void sortCommentsByGeoLocation(){
		LocationController lc = new LocationController();
		ArrayList<Comment> newList = null;
		newList = sortComments(lc.getGeoLocation());
		
	}
	
	public ArrayList<Comment> sortComments(GeoLocation geo){
		final HashMap<Double, Comment> myHashMap = new HashMap<Double, Comment>();
		double comRank = 0;
		double lon = geo.getLongitude();
		double lat = geo.getLatitude();
		ArrayList<Comment> topComments = null;
		ArrayList<Comment> sortedComments = null;
		
		try {
			topComments = ElasticSearchOperations.pullThreads();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i=0; i< topComments.size(); i++){
			Comment tComment = topComments.get(i);
			GeoLocation geo1 = tComment.getGeoLocation();
			double tlon = geo1.getLongitude();
			double tlat = geo1.getLatitude();
			comRank = Math.abs(Math.abs(tlon) - Math.abs(lon)) + Math.abs(Math.abs(tlat)-Math.abs(lat));
			myHashMap.put(comRank, tComment);
		}
		
		//http://www.mkyong.com/java/how-to-sort-a-map-in-java/
		Map<Double, Comment> treeMap = new TreeMap<Double, Comment>(myHashMap);
		for (Map.Entry entry : treeMap.entrySet()){
			sortedComments.add((Comment) entry.getValue());
		}
		return sortedComments;
	}

}
