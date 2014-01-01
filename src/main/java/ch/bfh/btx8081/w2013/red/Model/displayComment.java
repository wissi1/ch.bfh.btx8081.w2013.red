package ch.bfh.btx8081.w2013.red.Model;

import java.util.ArrayList;
import java.util.Map;

import ch.bfh.btx8081.w2013.red.Database.Comment;
import ch.bfh.btx8081.w2013.red.Database.Data;

public class displayComment {
	
	
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
