package ch.bfh.btx8081.w2013.red.Model;

import java.util.ArrayList;
import java.util.Map;

import ch.bfh.btx8081.w2013.red.Database.Comment;
import ch.bfh.btx8081.w2013.red.Database.Data;
/**
 * The displayComment class seperates the comments from the database (comments.xml)
 * and returns a new arraylist with all comments that should be displayed.
 * @author Ivan
 *
 */
public class displayComment {
	
	/**
	 * The display methode returns all comments that should be displayed
	 * @return comments
	 */
	public static ArrayList<Comment> display()
	{
		ArrayList<Comment> comments = new ArrayList<Comment>();
		for(Map.Entry<String, Comment> comment : Data.getComments().entrySet() )
		{
			if(comment.getValue().getReferene().equals(Data.getReference()))
			{
				comments.add(comment.getValue());
			}
		}
		return comments;
	}

}
