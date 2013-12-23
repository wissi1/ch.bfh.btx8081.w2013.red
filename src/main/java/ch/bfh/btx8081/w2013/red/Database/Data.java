package ch.bfh.btx8081.w2013.red.Database;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

public class Data {
	private static TreeMap<String, Comment> comments = new TreeMap<String, Comment>();
	private static TreeMap<String, Drug> drugs = new TreeMap<String, Drug>();
	private static TreeMap<String, Disease> diseases = new TreeMap<String, Disease>();
	private static TreeMap<String, User> users = new TreeMap<String, User>();
	
	public Data()
	{
		
	}
	public static void loadComments()
	{
		comments.put("c1", new Comment("1", "drug1", "text1", "owner1", "title1", new Date(), new ArrayList<Rating>()));
		comments.get("c1").addRating(Rating.POSITIVE, "oner2");
		comments.put("c2", new Comment("2", "disease2", "text2", "owner2", "title2", new Date(), new ArrayList<Rating>()));
		comments.get("c2").addRating(Rating.NEGAITIVE, "oner1");
	}
	public static void loadDrugs()
	{
		ArrayList<String> types = new ArrayList<String>();
		types.add("type1");
		types.add("type2");
		drugs.put("drug1", new Drug("drug1", "indication1", "effect1", "sideEffect1", types));
		drugs.put("drug2", new Drug("drug2", "indication2", "effect2", "sideEffect2", types));
	}
	public static void loadDiseases()
	{
		ArrayList<String> drugs = new ArrayList<String>();
		drugs.add("drug1");
		drugs.add("drug2");
		diseases.put("disease1", new Disease("disease1", "cause1", "treatment1", drugs));
		diseases.put("disease2", new Disease("disease2", "cause2", "treatment2", drugs));
	}
	public static void loadUsers()
	{
		users.put("owner1", new User("owner1", "passwort1"));
		users.put("owner2", new User("owner", "passwort2"));
	}
	public static TreeMap<String, Comment> getComments()
	{
		return comments;
	}
	public static TreeMap<String, Drug> getDrugs()
	{
		return drugs;
	}
	public static TreeMap<String, Disease> getDiseases()
	{
		return diseases;
	}
	public static TreeMap<String, User> getUsers()
	{
		return users;
	}
	
	

}
