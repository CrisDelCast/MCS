package model;

public class User {
	private String userName;
	private String password;
	private int age;
	private Category category;
	private int contribution;
	
	
	/**
	 * Description This is the constructor method of the User class
	 * @param userName is the name of user
	 * @param password is the kay of the user
	 * @param age is the age of the user
	 * @param category is the category of the user
	 */
	public User(String userName, String password, int age, Category category) {
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.category = category;
	}
	
	/**
	 * Description This method gets userName 
	 * @return Sring usernName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Description This method sets userName
	 * @param userName, userName of the user
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Description This method gets password 
	 * @return String with password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Description This method sets password
	 * @param password password of the user
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Description This method gets age 
	 * @return int with the age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Description This method sets age
	 * @param age age of the user
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Description This method gets category 
	 * @return category
	 */
	public Category getCategory() {
		return category;
	}
	
	/**
	 * Description This method sets category
	 * @param category category of the user
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	
	/**
	 * Description This method gets contribution
	 * @return int with the amount of contributions
	 */
	public int getContribution() {
		return contribution;
	}
	
	/**
	 * Description This method sets userName
	 * @param contribution amount of contributions
	 */
	public void setContribution(int contribution) {
		this.contribution = contribution;
		updateCategory();
	}
	
	/**
	 * Description This methods update the category of the user
	 */
	public void updateCategory() {
		switch (contribution) {
		case 3:
			category = Category.littleContributor;
			break;
			
		case 10:
			category = Category.mildContributor;
			break;
			
		case 30:
			category = Category.starContributor;
		}
	}
	
	/**
	 * Description This method overwrites the class toString
	 * @return All user information 
	 */
	public String toString() {
		return "*************  Usuario **************"+
				"\n**  Nombre de Usuario: "+userName+
				"\n**  Edad: "+age+
				"\n**  Categoria: "+category+
				"\n***********************************";

	}
}
