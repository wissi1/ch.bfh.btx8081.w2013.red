package ch.bfh.btx8081.w2013.red.Database;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

/**
 * The Data class manages (load and update) all data from the database.
 * The Data class also contains the information about the loggd in user and ther reference
 * of the searched medication or disease
 *  * @author Ivan
 *
 */
public class Data {
	private static TreeMap<String, Comment> comments = new TreeMap<String, Comment>();
	private static TreeMap<String, Drug> drugs = new TreeMap<String, Drug>();
	private static TreeMap<String, Disease> diseases = new TreeMap<String, Disease>();
	private static TreeMap<String, User> users = new TreeMap<String, User>();
	private static String user = "default";
	private static  String reference = "derfault";
	
	public Data()
	{
		
	}
	/**
	 * loadComents loads the comments from the database into the TreeMap comments.
	 */
	public static void loadComments()
	{
		comments.put("c1", new Comment("c1", "drug1", "text1: Ein literaturwissenschaftlicher Kommentar (auch philologischer Kommentar, oder, in eindeutigem Zusammenhang, kurz Kommentar) ist die Sammlung von Anmerkungen zu einem literarischen Text, welche das Verständnis des Textes erleichtern beziehungsweise ermöglichen sollen.", "owner1", "title1", new Date(), new ArrayList<Rating>()));
		comments.get("c1").addRating(Rating.POSITIVE, "owner2");
		comments.put("c2", new Comment("c2", "drug1", "text2", "shabf2", "title2", new Date(), new ArrayList<Rating>()));
		comments.get("c2").addRating(Rating.NEGAITIVE, "oner1");
	}
	/**
	 * loadDrugs loads the drugs from the database into the TreeMap drugs.
	 */
	public static void loadDrugs()
	{
		ArrayList<String> types = new ArrayList<String>();
		types.add("type1");
		types.add("type2");
		drugs.put("drug1", new Drug("drug1", "indication1", "effect1", "sideEffect1", types));
		drugs.put("drug2", new Drug("drug2", "indication2", "effect2", "sideEffect2", types));
	}
	/**
	 * loadDiseases loads the disease from the database into the TreeMap diseases.
	 */
	public static void loadDiseases()
	{
		ArrayList<String> drugs = new ArrayList<String>();
		drugs.add("drug1");
		drugs.add("drug2");
		diseases.put("disease1", new Disease("disease1", "cause1", "treatment1", drugs));
		diseases.put("disease2", new Disease("disease2", "cause2", "treatment2", drugs));
	}
	/**
	 * loadUsers loads the users from the database into the TreeMap users;
	 */
	public static void loadUsers()
	{
		users.put("shabf2@bfh.ch", new User("shabf2@bfh.ch", "-903581630"));
		users.put("owner2", new User("owner", "passwort2"));
	}
	/**
	 * Retrurns the TreeMap comments
	 * @return comments
	 */
	public static TreeMap<String, Comment> getComments()
	{
		return comments;
	}
	/**
	 * Returns the TreeMap drugs
	 * @return drugs
	 */
	public static TreeMap<String, Drug> getDrugs()
	{
		return drugs;
	}
	/**
	 * returns the TreeMap diseases
	 * @return diseases
	 */
	public static TreeMap<String, Disease> getDiseases()
	{
		return diseases;
	}
	/**
	 * Returns the TreeMap users
	 * @return users
	 */
	public static TreeMap<String, User> getUsers()
	{
		return users;
	}
	/**
	 * Removes the comment whit the given ID from the Arraylist
	 * @param commentID
	 */
	public static void removeComment(String commentId)
	{
		comments.remove(commentId);
	}
	/**
	 * Sets the reference on the searchd element. (Bsp; aDisease)
	 * @param ref
	 */
	public static void setReference(String ref)
	{
		reference = ref;
	}
	/**
	 * Sets the user on the logged in user.
	 * @param aUser
	 */
	public static void setUser(String aUser)
	{
		user = aUser;
	}
	public static String getReference()
	{
		return reference;
	}
	public static String getUser()
	{
		return user;
	}
	
}