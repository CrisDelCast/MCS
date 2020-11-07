package model;

public class PublicPlayList extends Playlist{
	private int grade;
	private int quantityOfGrades;
	private int generalGrades;
	
	/**
	 * Description This is the constructor method of the PlayList class
	 * @param name is the name of the public playList
	 * @param mins is the minutes of the public playList
	 * @param secs is the seconds of the public playList
	 */
	public PublicPlayList(String name, int mins, int secs) {
		super(name, mins, secs);
		publicPlaylist = true;
	}
	/**
	 * Description This method gets the grade of the PublicPlayList
	 * @return grade of the PublicPlayList
	 */
	
	public int getGrade() {
		return grade;
	}
	/**
	 * Description This method sets the grade of the PublicPlayList
	 * @param grade is the grade of the PublicPlayList
	 */
	
	public void setGrade(int grade) {
		quantityOfGrades += 1;
		generalGrades += grade;
		this.grade = generalGrades/quantityOfGrades;
	}
	/**
	 * Description This method overrides the toString of this class
	 * @return String with the information of the PublicPlayList with the format of the superclass and adding the grades 
	 */
	public String toSting(){
		return super.toString()+
				"\n**  Calificacion: "+grade+
				"\n***************************************";
	}
	
}
