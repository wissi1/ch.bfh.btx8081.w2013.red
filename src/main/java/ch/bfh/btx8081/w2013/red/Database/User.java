package ch.bfh.btx8081.w2013.red.Database;

public class User {
	private String name;
	private String passwort;
	
	public User(String name, String passwort)
	{
		this.name = name;
		this.passwort = passwort;
	}

	public String getName()
	{
		return name;
	}
	
	public String getPasswort()
	{
		return passwort;
	}
}
