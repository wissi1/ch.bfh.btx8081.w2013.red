package ch.bfh.btx8081.w2013.red.Database;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

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
	private static String reference = "default";
	
	public Data()
	{
		
	}
	/**
	 * loadComents loads the comments from the database into the TreeMap comments.
	 */
	public static void loadComments()
	{
		comments = new TreeMap<String, Comment>();
		String id = null;
		String reference = null;
		String owner = null;
		String dateString = null;
		GregorianCalendar date = new GregorianCalendar();
		String title = null;
		String text = null;
		boolean rateValue = true;
		try {
			Document jdom = new SAXBuilder().build("XML/comments_data.xml");
			Element aComment = jdom.getRootElement();
			for(Element comment : aComment.getChildren())
			{
				ArrayList<Rating> rates = new ArrayList<Rating>();
				id = comment.getAttributeValue("id");
				reference = comment.getAttributeValue("reference");
				owner = comment.getAttributeValue("owner");
				dateString = comment.getAttributeValue("date");
				date.setTimeInMillis(Long.parseLong(dateString));
				for(Element commentData : comment.getChildren())
				{
					if(commentData.getName().equals("title"))
					{
						title = commentData.getValue();
					}
					if(commentData.getName().equals("text"))
					{
						text = commentData.getValue();
					}
					if(commentData.getName().equals("ratings"))
					{
						for(Element rating : commentData.getChildren())
						{
							if(rating.getAttribute("positive").getValue().equals("true"))
							{
								rateValue = true;
							}
							else
							{
								rateValue = false;
							}
							rates.add(new Rating(rateValue, rating.getAttributeValue("rateowner")));
						}
					}
					
				}
				comments.put(id, new Comment(id, reference, text, owner, title, date, rates));
			}
		}
		catch (Exception e) {
			System.out.println("no connection to medications data possible");
		}
	}
	/**
	 * loadDrugs loads the drugs from the database into the TreeMap drugs.
	 * @throws IOException 
	 * @throws JDOMException 
	 */
	public static void loadDrugs()
	{
		drugs = new TreeMap<String, Drug>();
		String name = null;
		String type = null;
		String indication = null;
		String effect = null;
		String sideeffect = null;
		
		try {
			Document jdom = new SAXBuilder().build("XML/medications_data.xml");
			Element medications = jdom.getRootElement();
			for(Element medication: medications.getChildren())
			{
				name = medication.getAttributeValue("name");
				for(Element mediData : medication.getChildren())
				{
					if(mediData.getName().equals("type"))
					{
						type = mediData.getValue();
					}
					if(mediData.getName().equals("indication"))
					{
						indication = mediData.getValue();
					}
					if(mediData.getName().equals("effect"))
					{
						effect = mediData.getValue();
					}
					if(mediData.getName().equals("sideffect"))
					{
						sideeffect = mediData.getValue();
					}
				}
				drugs.put(name, new Drug(name, indication, effect, sideeffect, type));
			}
		} catch (Exception e) {
			System.out.println("no connection to medications data possible");
		}
	}
	/**
	 * loadDiseases loads the disease from the database into the TreeMap diseases.
	 */
	public static void loadDiseases()
	{
		diseases = new TreeMap<String, Disease>();
		String name = null;
		ArrayList<String> symptoms = new ArrayList<String>();
		String cause = null;
		String therapy = null;
		ArrayList<String> medications = new ArrayList<String>();
		
		try {
			Document jdom = new SAXBuilder().build("XML/diseases_data.xml");
			Element disease = jdom.getRootElement();
			for(Element aDisease : disease.getChildren())
			{
				name = aDisease.getAttributeValue("name");
				for(Element diseaseData: aDisease.getChildren())
				{
					if(diseaseData.getName().equals("symptoms"))
					{
						for(Element symptom : diseaseData.getChildren())
						{
							symptoms.add(symptom.getValue());
						}
					}
					if(diseaseData.getName().equals("cause"))
					{
						cause = diseaseData.getValue();
					}
					if(diseaseData.getName().equals("treatment"))
					{
						for(Element treatment : diseaseData.getChildren())
						{
							if(treatment.getName().equals("therapy"))
							{
								therapy = treatment.getValue();
							}
							if(treatment.getName().equals("medications"))
							{
								for(Element medication : treatment.getChildren())
								{
									medications.add(medication.getValue());
								}
							}
						}
					}
				}
				diseases.put(name, new Disease(name, cause, therapy, medications, symptoms));
			}
		} catch (Exception e) {
			System.out.println("no connection to diseases data possible");
		}
	}
	/**
	 * loadUsers loads the users from the database into the TreeMap users;
	 */
	public static void loadUsers()
	{
		users.put("shabf2@bfh.ch", new User("shabf2@bfh.ch", "-903581630"));
		users.put("owner2", new User("owner", "passwort2"));
	}
	
	public static void updateComment()
	{
		try {
			XMLOutputter outputter = new XMLOutputter();
			Document jdom = new SAXBuilder().build("XML/comments_data.xml");
			Element commentRoot = jdom.getRootElement();
			System.out.println(commentRoot.getName());
			for(int i = 0; i < commentRoot.getChildren().size(); i++)
			{
				System.out.println(commentRoot.getChildren().get(i).getAttributeValue("id"));
				String key = commentRoot.getChildren().get(i).getAttributeValue("id").toString();
				if(!comments.containsKey(key))
				{
					commentRoot.getChildren().get(i).detach();
				}
				else
				{
					if(commentRoot.getChildren().get(i).getChild("ratings").getChildren().size() < comments.get(key).getRatings().size())
					{
						Element rate = new Element("rate");
							rate.setAttribute(new Attribute("positive", "" + comments.get(key).getRatings().get(comments.get(key).getRatings().size()-1).getRate()));
							rate.setAttribute(new Attribute("rateowner", "" + comments.get(key).getRatings().get(comments.get(key).getRatings().size()-1).getRateOwner()));
						commentRoot.getChildren().get(i).getChild("ratings").addContent(rate);
					}
				}
			}
			
			for(Entry<String, Comment> aComment: comments.entrySet())
			{
				boolean commentExists = false;
				for(Element comment : commentRoot.getChildren())
				{
					
					if(comment.getAttributeValue("id").equals(aComment.getValue().getId()))
					{
						commentExists = true;
					}
				}
				if(commentExists == false)
				{
					Element newComment = new Element("comment");
					
						newComment.setAttribute(new Attribute("id", aComment.getValue().getId()));
						newComment.setAttribute(new Attribute("reference", aComment.getValue().getReferene()));
						newComment.setAttribute(new Attribute("owner", aComment.getValue().getOwner()));
						newComment.setAttribute(new Attribute("date", "" + aComment.getValue().getDate().getTimeInMillis()));
					
					newComment.addContent(new Element("title").setText(aComment.getValue().getTitle()));
					newComment.addContent(new Element("text").setText(aComment.getValue().getText()));
					newComment.addContent(new Element("ratings"));
					
					commentRoot.addContent(newComment);
				}
			}
			
			outputter.setFormat(Format.getPrettyFormat());
			outputter.output(jdom, new FileWriter("XML/test.xml"));
			System.out.println("File Saved!");
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
