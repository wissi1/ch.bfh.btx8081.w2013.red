package ch.bfh.btx8081.w2013.red.Model;

public class HashValueGenerator1 
{
	private static String password;
	public static String getHash(String aPassword)
	{
		password = aPassword;
		password = "" + password.hashCode();
		return password;
	}
}
