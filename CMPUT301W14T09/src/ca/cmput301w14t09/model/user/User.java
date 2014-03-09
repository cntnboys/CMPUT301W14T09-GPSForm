package ca.cmput301w14t09.model.user;

public class User {
	private Profile profile;
	private String userName;
	
	public User() {
		profile = new Profile(userName);
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
