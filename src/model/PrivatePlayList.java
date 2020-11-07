package model;

public class PrivatePlayList extends Playlist{
	
	private User uniqueUser;
	
	/**
	 * Description This is the constructor method of the PlayList class
	 * @param name is the name of the public playList
	 * @param mins is the minutes of the public playList
	 * @param secs is the seconds of the public playList
	 * @param uniqueUser is user playList 
	 */
	public PrivatePlayList(String name, int mins, int secs, User uniqueUser) {
		super(name, mins, secs);
		this.uniqueUser = uniqueUser;
		privatePlaylist = true;
	}
	/**
	 * Description This method gets the uniqueUser of the private PlayList
	 * @return uniqueUser of the private PlayList
	 */
	public User getUniqueUser() {
		return uniqueUser;
	}
	/**
	 * Description This method sets the uniqueUser of the private playList
	 * @param uniqueUser, the uniqueUser of the private PlayList
	 */
	public void setUniqueUser(User uniqueUser) {
		this.uniqueUser = uniqueUser;
	}
	
	 /**
	 * Description This method overrides the toString of this class
	 * @return String with the information of the PublicPlayList with the format of the superclass and adding the uniqueUser 
	 */
	public String toSting(){
		return super.toString()+
				"\n**  Usuario: "+uniqueUser.getUserName()+
				"\n***************************************";
	}

}
