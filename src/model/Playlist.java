package model;

public class Playlist {
	public String name;
	public int durationm;
	public int durations;
	private int mins;
	private int secs;
	public String genre;
	public Song[] songs;
	public boolean publicPlaylist;
	public boolean privatePlaylist;
	
	public static final int AMOUNTSONGS = 30;
	
	
	/**
	 * Description This is the constructor method of the PlayList class
	 * @param name The name of the playList
	 * @param mins The minutes of the playList
	 * @param secs The seconds of the playList
	 */
	public Playlist(String name, int mins, int secs) {
		this.name = name;
		this.mins = mins;
		this.secs = secs;
		songs = new Song[AMOUNTSONGS];
		genre = "unknown";
		durationm = mins;
		durations = secs;
		publicPlaylist = false;
		privatePlaylist = false;
	}
	/**
	 * Description This method gets the name of the playList
	 * @return String with The name of the playList
	 */
	
	public String getName() {
		return name;
	}
	/**
	 * Description This method sets the name of the playList
	 * @param name is the name of the playList
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Description This method gets the duration of the playlist
	 * @return is the duration of the playList
	 */
	
	public int getDurationm() {
		return durationm;
	}
	/**
	 * Description This method sets the duration of the playList
	 * @param durationm is The duration minutes of the playList
	 */
	
	public void setDurationm(int durationm) {
		int minsN = durationm;
		int minsT = minsN;	
		setMins(minsT);
		this.durationm = minsT;
	}
	/**
	 * Description This method gets the duration of the playlist
	 * @return int with the duration of the playList
	 */
	
	public int getDurations() {
		return durations;
	}
	/**
	 * Description This method sets the duration of the playList
	 * @param durations is the duration seconds of the playList
	 */
	
	public void setDurations(int durations) {
		int secsN = durations;
		int secsT = secsN;
		setSecs(secsT);
		
		this.durations = secsT;
	}
	/**
	 * Description This method gets the minutes of the playList 
	 * @return int with the minutes of the playList
	 */
	
	public int getMins() {
		return mins;
	}
	/**
	 * Description This method sets the minutes of the playList
	 * @param mins is the minutes of the playList
	 */
	
	public void setMins(int mins) {
		this.mins = mins;
	}
	/**
	 * Description This method gets the seconds of the playList
	 * @return int with the seconds of the playList
	 */
	
	public int getSecs() {
		return secs;
	}
	/**
	 * Description This method sets the seconds of the playList
	 * @param secs is the seconds of the playList
	 */
	public void setSecs(int secs) {
		this.secs = secs;
	}
	/**
	 * Description This method gets the genre of the playList
	 * @return String with the genre of the playList
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * Description This method sets the genre of the playList
	 */
	
	public void setGenre() {
		String sGenre = "";
		for (int i = 0; i < songs.length; i++) {
			if (songs[i] != null) {
				sGenre += songs[i].getGenre()+", ";
			}
		}
		genre = sGenre;
	}
	/**
	 * Description This method gets the songs of the playList
	 * @return The array of the songs
	 */
	public Song[] getSongs() {
		return songs;
	}
	/**
	 * Description This method sets the songs of the playList
	 * @param  songs is the array of the songs
	 */
	
	public void setSongs(Song[] songs) {
		this.songs = songs;
	}	
	/**
	 * Description This method is to know if it is a public PlayList or not
	 * @return boolean with true if is a public PlayList, false if not a public 
	 */

	public boolean isPublicPlayList() {
		return publicPlaylist;
	}
	/**
	 * Description This method is to know if it is a private PlayList or not
	 * @return boolean with true if is a private PlayList, false if not a private
	 */
	
	public boolean isPrivatePlayList() {
		return privatePlaylist;
	}
	/**
	 * Description This method adds the songs to the playList
	 * @param toAdd is the song to add
	 * @return boolean with true for yes added, false if not added song
	 */
	
	
	public boolean addSong(Song toAdd) {
		boolean added = false;
		
		for (int i = 0; i < songs.length && !added; i++) {
			if (songs[i] == null) {
				songs[i] = toAdd;
				added = true;
				setGenre();
				setDurationm(toAdd.getDurationm());
				setDurations(toAdd.getDurations());
				
			}
		}
		
		return added;
	}

	/**
	 * Description This method overwrites the class toString
	 * @return String with all playList information 
	 */
	
	public String toString() {
		return "**************  Playlist **************\n"+
				"\n**  Titulo: "+name+
				"\n**  Duracion: "+durationm+":"+durations+
				"\n**  Genero: "+genre.substring(0, genre.length()-2);
	}

}