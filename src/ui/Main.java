package ui; 
import java.util.Scanner;
import model.MCS;
import model.Genre;
/**

 * this class have the obj that run in the class MCS y Genre
 */

public class Main{
	private MCS master;
	Scanner sc;

	public static void main(String[] args){
		Main menu = new Main();
	/**
	 * Description This method is a menu of the aplication
	 */
	}
	public Main(){
		System.out.println(Interface());
		sc = new Scanner(System.in);
		master = new MCS();
		boolean exit = false;
		do {
			showMenu();
			int option = sc.nextInt();
			sc.nextLine();
			
			switch (option) {
			case 1:
				createUser();
				break;
				
			case 2:
				showUsers();
				break;
				
			case 3:
				createSong();
				break;

			case 4:
				showSongs();
				break;

			case 5:
				createPlaylist();
				break;
				
			case 6:
				addSongToPlaylist();
				break;
				
			case 7:
				ratePlaylist();
				break;

			case 8:
				showPlaylist();
				break;

			case 9:
				
				System.out.println("#####################################################");
				System.out.println("========== Gracias por usar esta app =========");
				System.out.println("#####################################################");
				exit = true;
				
				break;

			default:
				System.out.println("Error, Selecciona una opcion valida");
				break;
			}
		} while (!exit);
	}
	/**
	 * Description This method is a menu of the principal options
	 */
	public void showMenu(){
		System.out.println("******************************************************");
		System.out.println("***** MCS - Bienvenido - Selecciona una opccion ******");
		System.out.println("opcion 1) Crear Usuario.");
		System.out.println("opcion 2) Mostrar Usuarios Registrados.");
		System.out.println("opcion 3) Crear y Compartir una nueva cancion.");
		System.out.println("opcion 4) Mostrar canciones del pool.");
		System.out.println("opcion 5) Crear Una playlist.");
		System.out.println("opcion 6) Agregar una cancion a una playlist.");
		System.out.println("opcion 7) Calificar una lista Publica.");
		System.out.println("opcion 8) Mosrar las playlist.");
		System.out.println("opcion 9) salir.");
		System.out.println("******************************************************");
	}
	/**
	 * Description This method is a visual of logo of the aplication
	 * @return String with the logo of app
	 */
	public String Interface(){
		return "(((((((((((((((((((((((((((((((((((((((((((((((((\r\n" + 
				"((((((((((((((((/((((((((((((((((((((((((((((((((\r\n" + 
				"(((/  .(((((((*  .((((((*        (((((/      /(((\r\n" + 
				"(((/   .((((((.  .(((((   ,((((((((((*  .((((((((\r\n" + 
				"(((/    /((((/   .((((/  ,(((((((((((.  /((((((((\r\n" + 
				"(((/     ((((*   .((((*  ,(((((((((((/   ((((((((\r\n" + 
				"(((/  *  *(((     ((((*  ,((((((((((((,  .(((((((\r\n" + 
				"(((/  /.  ((*     ((((*  *(((((((((((((,   ((((((\r\n" + 
				"(((/  //  ,(  .   ((((*  *((((((((((((((/   /((((\r\n" + 
				"(((/  *(*  ,  (   ((((*  *((((((((((((((((   /(((\r\n" + 
				"(((/  ,(/    ,(   /(((*  ,(((((((((((((((((   (((\r\n" + 
				"(((/  .((    ((   /((((  .(((((((((((((((((.  /((\r\n" + 
				"(((/  .((.  .((.  *((((,  *((((((((((((((((   /((\r\n" + 
				"(((/  .((((((((.  *(((((   *((((/,/(((((((/   (((\r\n" + 
				"(((/  .((((((((.  *((((((.        *((   .   .((((\r\n" + 
				"(((((((((((((((/*/((((((((((///(((((((////(((((((\r\n" + 
				"(((((((((((((((((((((((((((((((((((((((((((((((((\r\n" + 
				"               ./(###((///((###(*                \r\n" + 
				"           *#(,                   *((,           \r\n" + 
				"        ,#/                           ((         \r\n" + 
				"      .#*          .**/////*,.          ((       \r\n" + 
				"     *(.      .//////////////////*       *#      \r\n" + 
				"    .#,     *///////////////////////,     /(     \r\n" + 
				"    /(    *///////////////////////////    .#.    \r\n" + 
				"  ,/////,*/////////////////////////////,*////*.  \r\n" + 
				"  /////////////////////////*,...,/////////////,  \r\n" + 
				"  //////*,,,********,,.............,,,,,//////,  \r\n" + 
				"  //////*.........//*........//*.......,//////,  \r\n" + 
				"  //////*.........,,.........,,........,//////,  \r\n" + 
				"  //////*..............................,//////,  \r\n" + 
				"   *///*  ........,/.........**.......  .*///,   \r\n" + 
				"            .......,/*.....,/*.......            \r\n" + 
				"               ........,,,,.......               \r\n" + 
				"                    .........                    \r\n" + 
				"*************************************************\r\n";
	}
	
	/**
	 * Description This method recive the information to create a new user 
	 */
	public void createUser(){
		System.out.println("Ingresa el Nombre de Usuario : ");
		String nameUser = sc.nextLine();
		System.out.println("Ingresa una Contraseña: ");
		String password = sc.nextLine();
		System.out.println("Ingresa tu edad : ");
		int ageUser = sc.nextInt();
		sc.nextLine();

		System.out.println(master.addUser(nameUser,password,ageUser));

	}
	/**
	 * Description This method call the method that show the info of the users
	 */
	public void showUsers(){
		System.out.println(master.showUsers());
	}

	/**
	 * Description This method got all the information to create a song 
	 */
	public void createSong(){
		System.out.println("Ingresa el Nombre de Usuario del Contribuidor:");
		String userName = sc.nextLine();
		System.out.println("Ingresa el titulo de la cancion:");
		String title = sc.nextLine();
		System.out.println("Ingresa el Nombre del Artista de la cancion:");
		String artist = sc.nextLine();
		System.out.println("Ingresa el dia de lanzamiento de la cancion:");
		int day = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingresa el mes de lanzamiento de la cancion :");
		int month = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingresa el año de lanzamiento de la cancion:");
		int year = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingresa los minutos de duracion de la cancion");
		int mins = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingresa los segundos de duracion de la cancion");
		int secs = sc.nextInt();
		sc.nextLine();
		showGenres();
		int genreNum = sc.nextInt();
		sc.nextLine();
		Genre genre = Genre.unknown;
		switch (genreNum) {
		case 1:
			genre = Genre.Rock;
			break;
			
		case 2:
			genre = Genre.HipHop;
			break;
			
		case 3:
			genre = Genre.Clasica;
			break;
			
		case 4:
			genre = Genre.Reggae;
			break;
			
		case 5:
			genre = Genre.Salsa;
			break;
			
		case 6:
			genre = Genre.Metal;
			break;
			
		default:
			System.out.println("Error, Ingresa una Opcion valida");
			break;
		}
		if (!genre.equals(Genre.unknown)) {
			System.out.println(master.addSong(userName, title, artist, day, month, year, mins, secs, genre));
		}
	}
	/**
	 * Description This method is a menu of the options to select a gener of the songs
	 */
	public void showGenres() {
		System.out.println("Slecciona para la cancion uno de los siguientes generos :");
		System.out.println("opcion 1) Rock");
		System.out.println("opcion 2) HipHop");
		System.out.println("opcion 3) Clasica");
		System.out.println("opcion 4) Reggae");
		System.out.println("opcion 5) Salsa");
		System.out.println("opcion 6) Metal");;
	}
	/**
	 * Description this method is a menu to create a type of playlist 
	 */
	
	public void createPlaylist() {
		System.out.println("Selecciona que tipo de lista quieres crear:");
		System.out.println("opcion 1) Publica");
		System.out.println("opcion 2) Privada");
		System.out.println("opcion 3) Restringida");
		
		int type = sc.nextInt();
		sc.nextLine();
		
		switch (type) {
		case 1:
			createPublicPlaylist();
			break;
			
		case 2:
			createPrivatePlaylist();
			break;
			
		case 3:
			createRestrictedPlaylist();
			break;

		default:
			System.out.println("Error, selecciona una opcion valida");
			break;
		}
	}
	/**
	 * Description This method recive the name to create a public playlist
	 */
	public void createPublicPlaylist() {
		System.out.println("Ingresa el Nombre que le asignaras a la playlist");
		String name = sc.nextLine();
		System.out.println(master.addPublicPlaylist(name, 0, 0));
	}
	/**
	 * Description This method recive the name to create a private playlist
	*/
	
	public void createPrivatePlaylist() {
		System.out.println("Ingresa el Nombre que le asignaras a la playlist");
		String name = sc.nextLine();
		System.out.println("Ingresa el Unico Usuario que tendra acceso a esta playlist:");
		String userName = sc.nextLine();
		
		System.out.println(master.addPrivatePlaylist(name, 0, 0, userName));
	}
	/**
	 * Description This method recive the information to rate a public playlist
	 */
	public void ratePlaylist() {
		System.out.println("Ingresa el nombre de la playlist que deseas calificar:");
		String playlistName = sc.nextLine();
		System.out.println("Califica la playlist de 1 a 5, siendo 1 mala y 5 muy buena");
		int grade = sc.nextInt();
		sc.nextLine();
		
		System.out.println(master.addGradeToPublicPlaylist(playlistName, grade));
	}
	
	/**
	 * Description This method recive information to create a restricted playlist 
	 */
	
	public void createRestrictedPlaylist() {
		System.out.println("Ingresa el Nombre que le asignaras a la playlist");
		String name = sc.nextLine();
		System.out.println("*campo obligatorio* Ingresa el primer Nombre de usuario que podra acceder a la playlist: ");
		String userName = sc.nextLine();
		System.out.println("*campo no obligatorio* Ingresa el Segundo Nombre de usuario que podra acceder a la playlist:");
		String userName2 = sc.nextLine();
		System.out.println("*campo no obligatorio* Ingresa el tercer Nombre de usuario que podra acceder a la playlist:");
		String userName3 = sc.nextLine();
		System.out.println("*campo no obligatorio* Ingresa el cuarto Nombre de usuario que podra acceder a la playlist:");
		String userName4 = sc.nextLine();
		System.out.println("*campo no obligatorio* Ingresa el quinto Nombre de usuario que podra acceder a la playlist:");
		String userName5 = sc.nextLine();
		
		System.out.println(master.addRestrictedPlaylist(name, 0, 0, userName, userName2, userName3, userName4, userName5));
	}
	/**
	 * Description This method recive de information to add a song in a playlist
	 */
	public void addSongToPlaylist() {
		System.out.println("Ingresa el titulo de la cancion:");
		String title = sc.nextLine();
		System.out.println("Ingresa el nombre del artista de la cancion:");
		String artist = sc.nextLine();
		System.out.println("Ingresa el nombre de la playlist donde quieres agregar la cancion:");
		String playlistName = sc.nextLine();
		
		System.out.println(master.addSongToPlaylist(title, artist, playlistName));
	}
	/**
	 * Description This method call the method that show all the song in the pool of songs
	 */
	
	public void showSongs() {
		System.out.println(master.showSongs());
	}
	/**
	 * Description This method call the method that show the quantity of playlists that was created
	 */
	public void showPlaylist() {
		System.out.println(master.showPlaylists());
	}




}