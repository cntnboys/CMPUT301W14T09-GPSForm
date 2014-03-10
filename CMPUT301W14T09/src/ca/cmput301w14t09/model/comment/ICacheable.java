package ca.cmput301w14t09.model.comment;

import android.app.Activity;

public interface ICacheable<T> {	
	void serialize(String userName, T object, Activity main);
	T load(String userName, String name, Activity main);
}
