package ch.bfh.btx8081.w2013.red.GUI;


import java.util.ArrayList;
import java.util.GregorianCalendar;

import ch.bfh.btx8081.w2013.red.Controller.IState;
import ch.bfh.btx8081.w2013.red.Controller.NavigatorUI;
import ch.bfh.btx8081.w2013.red.Database.Data;
import ch.bfh.btx8081.w2013.red.Database.Rating;
import ch.bfh.btx8081.w2013.red.Model.displayComment;

import com.vaadin.event.FieldEvents;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

/**
 * The comment class creates a view in which a user can read and write 
 * comments to a chosen theme. It provides a display panel to show the
 * existing comments, a TextArea to write a new comment and a button 
 * to commit the written comment. It also provides two buttons to 
 * navigate back to the last view or to the HOMEVIEW.
 * 
 * @author heebm2
 * @version V11.12.2013
 */

@SuppressWarnings("serial")
public class Comment extends VerticalLayout implements View, IState {
	
	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout upperVerticalLayout;
	private HorizontalLayout lowerHorizontalLayout;
	private VerticalLayout commentLayout = new VerticalLayout();
	MhcGuidDesign design;
	
	
	/**
	 * Constructs a COMMENTVIEW on the base of different parameters.
	 * 
	 * @param design
	 * 			basic design of the view based on the class MhcGuidDesign
	 *
	 * @param layout
	 * 			basic layout of the view
	 * 
	 * @param mainLayout
	 * 			main part of the layout
	 * 
	 * @param upperVerticalLayout
	 * 			upper part of the layout
	 * 
	 * @param lowerHorizontalLayout
	 * 			lower part of the layout
	 * 
	 */
	public Comment()
	{
		design = new MhcGuidDesign(this);
		this.layout = design.getLayout();
		this.mainLayout = design.getMainLayout();
		this.upperVerticalLayout = design.getUpperVerticalLayout();
		this.lowerHorizontalLayout = design.getLowerHorizontalLayout();
		editMainLayout();
		editUpperVerticalLayout();
		editLowerHorizontalLayout();
	}
	
	
	/**
	 * Edits the mainLayout by adding a TextArea for the user input, a button
	 * to commit the input and a panel to display existing comments.
	 */
	private void editMainLayout()
	{		
		commentLayout.setWidth("240px");
		final TextField title = new TextField("Yout Comment:");
        title.setValue("enter title");
        title.setWidth("260px");
        title.setHeight("25px");
        title.addFocusListener(new FieldEvents.FocusListener() {
			
			@Override
			public void focus(com.vaadin.event.FieldEvents.FocusEvent event) {
				// TODO Auto-generated method stub
				 title.setValue("");
			}
		});
        final TextArea textInputField = new TextArea();
		textInputField.setWidth("260px");
		textInputField.setHeight("70px");
		textInputField.setWordwrap(true);
		mainLayout.addComponent(title, "top:290.0px;left:30.0px");
		mainLayout.addComponent(textInputField, "top:315.0px;left:30.0px;");
		
		Button commitButton = new Button("Commit");
		commitButton.setWidth("260px");
		commitButton.addClickListener(new Button.ClickListener() 
    	{
    		public void buttonClick(ClickEvent event) {
    			  GregorianCalendar date = new GregorianCalendar();
    			  String id = "c" + date.getTimeInMillis();
    			  ch.bfh.btx8081.w2013.red.Database.Comment com =  new ch.bfh.btx8081.w2013.red.Database.Comment(id, Data.getReference(), textInputField.getValue(), Data.getUser(), title.getValue(), date, new ArrayList<Rating>());
                  Data.getComments().put(id, com);
                  CommentEntry commentEntry = new CommentEntry(com);
                  commentLayout.addComponent(commentEntry);
                  title.setValue("Enter Comment");
                  textInputField.setValue("");
                  Data.updateComment();
    		}
    	});
		
		mainLayout.addComponent(commitButton, "top:382.0px;left:30px;");
		
	
		Panel displayPanel = new Panel("Comments");
	
		displayPanel.setContent(commentLayout);
		displayPanel.setVisible(true);
		displayPanel.setWidth("260px");
		displayPanel.setHeight("210px");
		
		mainLayout.addComponent(displayPanel, "top:60.0px;left:30.0px;");	
	}
	
	/**
	 * Edits the upperVerticalLayout by setting the TitleLabel.
	 */
	private void editUpperVerticalLayout()
	{
		design.setTitleLabel("Comments");
	}
	
	/**
	 * Edits the lowerHorizontalLayout by adding a button to navigate back to
	 * the last view and a button to navigate to the HOMEVIEW.
	 */
	private void editLowerHorizontalLayout()
	{
		
	
		Button backButton = new Button();
		backButton.setCaption("Back");
		backButton.setWidth("80px");
		backButton.addClickListener(new Button.ClickListener() 
    	{
    		public void buttonClick(ClickEvent event) {
    			handleB1();
    		}
    	});
		
		
		Button returnToMainButton = new Button();
		returnToMainButton.setCaption("Main");
		returnToMainButton.setWidth("80px");
		returnToMainButton.addClickListener(new Button.ClickListener() 
    	{
    		public void buttonClick(ClickEvent event) {
    			handleB2();
    		}
    	});
		
		
        lowerHorizontalLayout.addComponent(backButton);
        lowerHorizontalLayout.setComponentAlignment(backButton, Alignment.MIDDLE_LEFT);
        lowerHorizontalLayout.addComponent(returnToMainButton);
        lowerHorizontalLayout.setComponentAlignment(returnToMainButton, Alignment.MIDDLE_RIGHT);
	}
	
	/**
	 * Not overridden method of the interface view.
	 */
	public void enter(ViewChangeEvent event) {
		commentLayout.removeAllComponents();
		Data.loadComments();
		for (int i = 0; i < displayComment.display().size(); i++)
		{
			design.setTitleLabel(Data.getReference());
			CommentEntry commentEntry = new CommentEntry(displayComment.display().get(i));
			commentLayout.addComponent(commentEntry);
		}
	}

	/**
	 * Navigates back the the last view using methods of the NavigatorUI class.
	 */
	public void handleB1() {
		NavigatorUI.navigateTo(NavigatorUI.getPreviousView());
	}

	/**
	 * Navigates back to the HOMEVIEW using methods of the NavigatorUI class.
	 */
	public void handleB2() {
		NavigatorUI.navigateTo(NavigatorUI.HOMEVIEW);
	}

	/**
	 * Not overridden method of the interface IState.
	 */
	public void handleB3() {	
	}

}
