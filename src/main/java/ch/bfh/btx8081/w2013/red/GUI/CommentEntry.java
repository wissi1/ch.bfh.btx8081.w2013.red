package ch.bfh.btx8081.w2013.red.GUI;

import ch.bfh.btx8081.w2013.red.Database.Comment;
import ch.bfh.btx8081.w2013.red.Database.Data;
import ch.bfh.btx8081.w2013.red.Database.Rating;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.Reindeer;
/**
 * The CommentEntry class creates a graphical form of a Comment from the database-
 * @author Ivan
 *
 */
public class CommentEntry extends VerticalLayout {
	private boolean hidden = false;
	private CommentEntry commentEntry;
	private Comment comment = null;
	private Label commentText = new Label();
	public CommentEntry(Comment comment)
	{
		super();
		this.comment = comment;
		createTitle();
		createText();
		createRateBar();
		commentEntry = this;
	}
	private void createTitle()
	{
		Label commentTitle = new Label(comment.getTitle() + " by: " + comment.getOwner());
		commentTitle.setWidth("220px");
		this.addComponent(commentTitle);
	}
	private void createText()
	{
		commentText = new Label(comment.getText());
		if(comment.getOwner().equals(Data.getUser()))
		{
			commentText.addStyleName("bluetextarea");
		}
		else
		{
			commentText.addStyleName("greentextarea");
		}
		commentText.setWidth("220px");
		this.addComponent(commentText);
	}
	private void createRateBar()
	{
		
		final HorizontalLayout rateLayout = new HorizontalLayout();
			rateLayout.setWidth("220px");
		
		final VerticalLayout gap20px = new VerticalLayout();
			gap20px.setHeight("20px");
		
			final Button pos = new Button();
			final Button neg = new Button();	
			
				pos.setIcon(new ThemeResource("pos.png"));
				pos.setStyleName(Reindeer.BUTTON_LINK);
				pos.addClickListener(new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						comment.addRating(Rating.POSITIVE, Data.getUser());
						commentEntry.removeComponent(gap20px);
						commentEntry.removeComponent(rateLayout);
						commentEntry.createRateBar();
					}
				});
				
				neg.setIcon(new ThemeResource("neg.png"));
				neg.setStyleName(Reindeer.BUTTON_LINK);
				neg.addClickListener(new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						comment.addRating(Rating.NEGAITIVE, Data.getUser());
						commentEntry.removeComponent(gap20px);
						commentEntry.removeComponent(rateLayout);
						commentEntry.createRateBar();
					}
				});
				
		
			final Button hide = new Button("hide");
				hide.setStyleName(Reindeer.BUTTON_LINK);
				hide.addClickListener(new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						if(hidden == false)
						{
							commentText.setVisible(false);
							hidden = true;
							hide.setCaption("show");
						}
						else
						{
							commentText.setVisible(true);
							hidden = false;
							hide.setCaption("hide");
						}
					}
				});
				
			Button delete = new Button();
				delete.setIcon(new ThemeResource("delete.png"));
				delete.setStyleName(Reindeer.BUTTON_LINK);
				delete.addClickListener(new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						Data.removeComment(comment.getId());
						
						commentEntry.removeAllComponents();
					}
				});
				
		buttonStatus(pos, neg, delete);
	
		rateLayout.addComponent(new Label("pos: " + countRates(Rating.POSITIVE) ));
		rateLayout.addComponent(pos);
		rateLayout.setComponentAlignment(pos, Alignment.MIDDLE_LEFT);
		rateLayout.addComponent(new Label("neg: " + countRates(Rating.NEGAITIVE) ));
		rateLayout.addComponent(neg);
		rateLayout.setComponentAlignment(neg, Alignment.MIDDLE_LEFT);
		rateLayout.addComponent(hide);
		rateLayout.setComponentAlignment(hide, Alignment.MIDDLE_RIGHT);
		rateLayout.addComponent(delete);
		rateLayout.setComponentAlignment(delete, Alignment.MIDDLE_RIGHT);
		
		this.addComponent(rateLayout);
		this.addComponent(gap20px);
	}
	private int countRates(boolean positive)
	{
		int pos = 0;
		int neg = 0;
		for(Rating rate: comment.getRatings())
		{
			if(rate.getRate() == true)
			{
				pos++;
			}
			else
			{
				neg++;
			}
		}
		if(positive == true)
		{
			return pos;
		}
		else
		{
			return neg;
		}
	}
	private void buttonStatus(Button pos, Button neg, Button delete)
	{
		if(comment.getOwner().equals(Data.getUser()))
		{
			pos.setEnabled(false);
			neg.setEnabled(false);
		}
		else{
			delete.setEnabled(false);
		}
		for(Rating rates : comment.getRatings())
		{
			if(rates.getRateOwner().equals(Data.getUser()))
			{
				pos.setEnabled(false);
				neg.setEnabled(false);
			}
		}
	}
}
