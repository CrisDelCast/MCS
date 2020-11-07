package model;

import java.util.Date;

public class MCS{
	private User[] users;
	private Song[] poolOfSongs;
	private Playlist[] playlists;
	
	public static final int SIZE_OF_USERS = 10;
	public static final int AMOUNT_OF_SONGS = 30;
	public static final int AMOUNT_OF_PLAYLISTS = 20;
	/**
	 *Description This is the constructor method of the MCS class
	 */

	public MCS(){
		users = new User[SIZE_OF_USERS];
		poolOfSongs = new Song[AMOUNT_OF_SONGS];
		playlists = new Playlist[AMOUNT_OF_PLAYLISTS];

	}
	/**
	 *Description this method looks for a user comparing between their names
	 *@param userName is the name of the user
	 *@return The user that found, if it does return null
	 */
	public User findUser(String userName) {
		User toFind = null;
		boolean found = false;
		
		for (int i = 0; i < users.length && !found; i++) {
			if (users[i] != null) {
				if (users[i].getUserName().equalsIgnoreCase(userName)) {
					toFind = users[i];
					found = true;
				}
			}
		}
		
		return toFind;
	}
	/**
	 * Description This method adds a new user to the app 
	 * @param userName is the user name of the user
	 * @param password It is the user's password
	 * @param ageUser It is the user's age
	 * @return message if the user added or the user cant be created
	 */

	public String addUser(String userName, String password, int ageUser) {
		String msg = "";
		
		if (!userName.contains(" ") && findUser(userName) == null) {
			msg = "No se puede agregar este usuario, la lista de usuarios esta llena";
			boolean added = false;
			User us = new User(userName, password, ageUser, Category.newbie);
			
			for (int i = 0; i < users.length && !added; i++) {
				if (users[i] == null) {
					users[i] = us;
					added = true;
					msg = "Usuario añadido correctamente";
				}
			}
		}else {
			msg = "No se puede añadir este usuario. \n este usuario ya se encuentra en uso o tiene espacios en el ";
		}
		
		return msg;
	}
	
	/** Description This method steps through the user array 
	 * and saves them to a variable to display
	 * @return String message with the information of the user
	 */
	public String showUsers() {
		String info = "";
		
		for (int i = 0; i < users.length; i++) {
			if(users[i] != null) {
				info += users[i]+"\n";
			}
		}
		
		if (info.equals("")) {
			info = "No hay usuarios en la lista.";
		}
		return info;
	}
	
	/**
	 * Description This method finds the song with the name of the artist and the title of the song
	 * @param title the title of the song
	 * @param artist the artist of the song
	 * @return The song found, if the song isnt found returns null
	 */
	public Song findSong(String title, String artist) {
		Song toFind = null;
		boolean found = false;
		
		for (int i = 0; i < poolOfSongs.length && !found; i++) {
			if (poolOfSongs[i] != null) {
				if (poolOfSongs[i].getTitle().equalsIgnoreCase(title) && poolOfSongs[i].getArtist().equalsIgnoreCase(artist)) {
					toFind = poolOfSongs[i];
					found = true;
				}
			}
		}
		
		return toFind;
	}

	/**
	 * Description This method adds a new song, first check that it is not added before
	 * @param userName is the userName of the contributor  
	 * @param title is the title of the song
	 * @param artist is the name of the artist of the song
	 * @param day is a song release day 
	 * @param month is a song release month
	 * @param year is a song release year
	 * @param mins is the duration of the song in minutes
	 * @param secs is the duration of the song in seconds
	 * @param genre is the genre of the song
	 * @return message that advises if the song was added or the song cant be added  
	 */
	public String addSong(String userName, String title, String artist, int day, int month, int year, int mins, int secs, Genre genre) {
		String msg = "No se puede añadir la cancion, esta ya se encuentra añadida";
		boolean added = false;
		
		if (findSong(title, artist) == null) {
			msg = "No se puee añadir el usuario, la lista de canciones se encuentra llena";
			
			for (int i = 0; i < poolOfSongs.length && !added; i++) {
				if (poolOfSongs[i] == null) {
					User contributor = findUser(userName);
					contributor.setContribution(contributor.getContribution()+1);
					Date date = new Date(day+"/"+month+"/"+year);
					poolOfSongs[i] = new Song(title, artist, date, mins, secs, genre);
					added = true;
					msg = "Cancion añadida";
				}
			}
		}
		
		return msg;
	}


	/**
	 * Description This method find a playList 
	 * @param name is the name of the playList
	 * @return playList found, if not found returns null
	 */
	public Playlist findPlaylist(String name) {
		Playlist toFind = null;
		boolean found = false;
		
		for (int i = 0; i < playlists.length && !found; i++) {
			if (playlists[i] != null) {
				if (playlists[i].getName().equalsIgnoreCase(name)) {
					toFind = playlists[i];
					found = true;
				}
			}
		}
		
		return toFind;
	}
	/**
	 * Description This method add a private playList
	 * @param name is the name of the playList
	 * @param mins is minutes of playList duration 
	 * @param secs is seconds of playList duration
	 * @param userName is userName of the contributor
	 * @return String with message that advises if it is added or not
	 */
	public String addPrivatePlaylist(String name, int mins, int secs, String userName) {
		String msg = "No es posible crear la playlist, el usuario no se encuentra";
		User unique = findUser(userName);
		
		if (unique != null) {
			boolean added = false;
			msg = "no es posible crear la playlist privada, la lista de playlist se encuentra llena ";
			
			if (findPlaylist(name) == null) {
				for (int i = 0; i < playlists.length && !added; i++) {
					if (playlists[i] == null) {
						PrivatePlayList toAdd = new PrivatePlayList(name, mins, secs, unique);
						playlists[i] = toAdd;
						added = true;
						msg = "playlist creada";
					}
				}
			}else {
				msg = "No es posible crear la playlist, el nombre ya esta en uso, utiliza uno diferente";
			}
		}
		
		return msg;
	}
	/**
	 * Description This method add a public playList
	 * @param name the name of the playList
	 * @param mins minutes of playList duration 
	 * @param secs seconds of playList duration
	 * @return String that inform if the playlist was created or not
	 */
	public String addPublicPlaylist(String name, int mins, int secs) {
		boolean added = false;
		String msg = "no es posible crear la playlist publica, la lista de playlist se encuentra llena";
		
		if (findPlaylist(name) == null) {
			for (int i = 0; i < playlists.length && !added; i++) {
				if (playlists[i] == null) {
					PublicPlayList toAdd = new PublicPlayList(name, mins, secs);
					playlists[i] = toAdd;
					added = true;
					msg = "playlist creada";
				}
			}
		}else {
			msg = "No es posible crear la playlist, el nombre ya esta en uso, utiliza uno diferente";
		}
		
		return msg;
	}
	/**
	 * Description This method adds grades to a public PlayList
	 * @param playlistName is the name of playlist that get a grade
	 * @param grade is the rating between 1 and 5
	 * @return String with message that advises if it is added or not
	 */
	public String addGradeToPublicPlaylist(String playlistName, int grade) {
		String msg = "Debes ingresar una calificacion entre 1 y 5";
		
		if (grade >= 1 && grade <= 5) {
			msg = "Error la playlist seleccionada no es publica o no existe";
			Playlist tGrade = findPlaylist(playlistName);
			if (tGrade != null && tGrade.isPublicPlayList()) {
				PublicPlayList graded = (PublicPlayList) tGrade;
				graded.setGrade(grade);
				msg = "Playlist calificada correctamente";
			}
		}
		
		return msg;
	}
	/**
	 * Description This method add a public playList
	 * @param name the name of the playList
	 * @param mins minutes of playList duration 
	 * @param secs seconds of playList duration
	 * @param userName contributor userName
	 * @param userName2 contributor userName2. if the user want can be empty 
	 * @param userName3 contributor userName3. is the user want can be empty 
	 * @param userName4 contributor userName4. if the user want can be empty 
	 * @param userName5 contributor userName5. if the user want can be empty 
	 * @return String with message that advises if it is added or not
	 */
	public String addRestrictedPlaylist(String name, int mins, int secs, String userName, String userName2, String userName3, String userName4, String userName5) {
		String msg = "La playlist no fue creada, los usuarios no fueron encontrados";
		User first = findUser(userName);
		User second = findUser(userName2);
		User third = findUser(userName3);
		User fourth = findUser(userName4);
		User fifth = findUser(userName5);
		User[] accesibles = {first, second, third, fourth, fifth};
		
		if (accesibles[0] != null || accesibles[1] != null || accesibles[2] != null || accesibles[3] != null || accesibles[4] != null) {
			boolean added = false;
			msg = "No se puede crear la playlist restringida, la lista de playlist esta llena";
			
			if (findPlaylist(name) == null) {
				for (int i = 0; i < playlists.length && !added; i++) {
					if (playlists[i] == null) {
						RestrictedPlayList toAdd = new RestrictedPlayList(name, mins, secs, accesibles);
						playlists[i] = toAdd;
						added = true;
						msg = "playlist creada";
					}
				}
			}else {
				msg = "No se pudo crear la playlist restringida, el nombre ya esta en uso.";
			}
		}
		
		return msg;
	}
	/**
	 * Description This method add a song to playList
	 * @param title is the title of the song
	 * @param artist is the artist of the song
	 * @param playlistName is the playList name to add
	 * @return String with message that advises if it is added or not
	 */
	public String addSongToPlaylist(String title, String artist, String playlistName) {
		String msg = "No se pudo agregar la cancion a la playlist, la playlist no se encuentra";
		Playlist selectedPlaylist = findPlaylist(playlistName);
		
		if (selectedPlaylist != null) {
			Song chosenSong = findSong(title, artist);
			msg = "No se pudo añadir la cancion a la playlist, la cancion no se encuentra registrada";
			
			if (chosenSong != null) {
				selectedPlaylist.addSong(chosenSong);
				msg = "Cancion agregada correctamente";
			}
		}
		
		return msg;
	}
	/**
	 * Description This method show information of the playList
	 * @return String with message with the playList information
	 */
	public String showPlaylists() {
		String info = "";
		
		for (int i = 0; i < playlists.length; i++) {
			if(playlists[i] != null) {
				if (playlists[i].isPublicPlayList()) {
					PublicPlayList tosho = (PublicPlayList) playlists[i];
					info += tosho.toSting()+"\n";
				}else if (playlists[i].isPrivatePlayList()) {
					PrivatePlayList tosho = (PrivatePlayList) playlists[i];
					info += tosho.toSting()+"\n";
				}else {
					RestrictedPlayList tosho = (RestrictedPlayList) playlists[i];
					info += tosho.toSting()+"\n";
				}
			}
		}
		
		if (info.equals("")) {
			info = "No existen playlists";
		}
		
		return info;
	}

	
	/**
	 * Description This method show the songs
	 * @return String with message the information of the songs
	 */
		public String showSongs() {
		String info = "";
		
		for (int i = 0; i < poolOfSongs.length; i++) {
			if(poolOfSongs[i] != null) {
				info += poolOfSongs[i]+"\n";
			}
		}
		
		if (info.equals("")) {
			info = "No hay canciones en la lista de canciones";
		}
		
		return info;
	}

	
}