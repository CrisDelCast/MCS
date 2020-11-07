package model;

import java.util.Date;

public class Song {
	private String title;
	private String artist;
	private Date date;
	private int durationm;
	private int durations;
	private int mins;
	private int secs;
	private Genre genre;
	
public Song(String title, String artist, Date date, int mins, int secs, Genre genre) {
		this.title = title;
		this.artist = artist;
		this.date = date;
		this.mins = mins;
		this.secs = secs;
		setDurationm(mins);
		setDurations(secs);
		this.genre = genre;
	}
	
	/**

	 * Description This method gets song title
	 * @return String with title of the song
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Description This method sets song title
	 * @param title song title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Description This method gets song artist
	 * @return String with the artist of the song
	 */
	public String getArtist() {
		return artist;
	}
	
	/**
	 * Description This method sets song artist
	 * @param artist song artist 
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	/**
	 * Description This method gets song date
	 * @return date of the song
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Description This method sets song date
	 * @param date song date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/*
	 * Description This method gets song duration
	 * @return duration of the song
	 */
	
	public int getDurations() {
		return durations;
	}
	
	/*
	 * Description This method sets song duration
	 * @param mins, song minutes
	 * @param secs, song seconds
	 */
	public void setDurations(int secs) {
		int secsT = secs;
		setMins(secsT);
		
		
		this.durations = secsT;
	}
	
	/*
	 * Description This method gets song duration
	 * @return duration of the song
	 */
	
	public int getDurationm() {
		return durationm;
	}
	
	/*
	 * Description This method sets song duration
	 * @param mins, song minutes
	 * @param secs, song seconds
	 */
	public void setDurationm(int mins) {
		int minsT = mins;
		setMins(minsT);
		
		
		this.durationm = minsT;
	}	
	/**
	 * Description This method gets song minutes
	 * @return int with the minutes of the song
	 */
	public int getMins() {
		return mins;
	}

	public void setMins(int mins) {
		this.mins = mins;
	}
	
	/**
	 * Description This method gets song seconds
	 * @return int with seconds of the song
	 */
	public int getSecs() {
		return secs;
	}

	public void setSecs(int secs) {
		this.secs = secs;
	}
	
	/**
	 * Description This method gets song genre
	 * @return genre of the song
	 */
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	/**
	 * Description This method overwrites the class toString
	 * @return String with all user information 
	 */
	public String toString() {
		return "\n**************  Cancion **************"+
				"\n**  Titulo: "+title+
				"\n**  Artista: "+artist+
				"\n**  Duracion: "+durationm+":"+durations+
				"\n**  Genero: "+genre+ 
				"\n***********************************";
	}
}