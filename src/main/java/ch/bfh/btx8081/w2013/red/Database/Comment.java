package ch.bfh.btx8081.w2013.red.Database;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Comment {
	private String id;
	private String reference;
	private String text;
	private String owner;
	private String title;
	private GregorianCalendar date;
	private ArrayList<Rating> ratings  = new ArrayList<Rating>();
	
	public Comment(String id, String reference, String text, String owner, String title, GregorianCalendar date, ArrayList<Rating> raitings)
	{
		this.id = id;
		this.reference = reference;
		this.text = text;
		this.owner = owner;
		this.title = title;
		this.date = date;
		this.ratings = raitings;	
	}
	
	public void addRating(boolean rate, String rateOwner)
	{
		ratings.add(new Rating(rate, rateOwner));
	}
	
	public String getId()
	{
		return id;
	}
	public String getReferene()
	{
		return reference;
	}
	public String getText()
	{
		return text;
	}
	public String getOwner()
	{
		return owner;
	}
	public String getTitle()
	{
		return title;
	}
	public GregorianCalendar getDate()
	{
		return date;
	}
	public ArrayList<Rating> getRatings()
	{
		return ratings;
	}

}
