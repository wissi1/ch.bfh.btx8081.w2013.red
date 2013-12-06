package ch.bfh.btx8081.w2013.red.GUI;

import ch.bfh.btx8081.w2013.red.Controller.NavigatorUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ChameleonTheme;

public class Comment extends VerticalLayout implements View {
	
	
	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout upperVerticalLayout;
	private HorizontalLayout lowerHorizontalLayout;
	MhcGuidDesign design;
	
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
	
	private void editMainLayout()
	{		
		
		
		
		TextArea textInputField = new TextArea("Your Comment:");
		textInputField.setImmediate(false);
		textInputField.setWidth("260px");
		textInputField.setHeight("80px");
		textInputField.setWordwrap(true);
		mainLayout.addComponent(textInputField, "top:300.0px;left:30.0px;");
		
		Button commitButton = new Button("Commit");
		commitButton.setWidth("260px");
		
		mainLayout.addComponent(commitButton, "top:382.0px;left:30px;");
		
		// Evtl. Tabel brauchen um verschiedenen kommentare anzuzeigen
		Panel displayPanel = new Panel("Comments");
		displayPanel.setImmediate(false);
		displayPanel.setVisible(true);
		displayPanel.setWidth("260px");
		displayPanel.setHeight("220px");
		
		mainLayout.addComponent(displayPanel, "top:60.0px;left:30.0px;");
		
		
	}
	private void editUpperVerticalLayout()
	{
		design.setTitleLabel("Comment");
	}
	private void editLowerHorizontalLayout()
	{
		
	
		Button backButton = new Button();
		backButton.setCaption("Back");
		
		
		Button returnToMainButton = new Button();
		returnToMainButton.setCaption("Main");
		
		
        lowerHorizontalLayout.addComponent(backButton);
        lowerHorizontalLayout.setComponentAlignment(backButton, Alignment.MIDDLE_LEFT);
        lowerHorizontalLayout.addComponent(returnToMainButton);
        lowerHorizontalLayout.setComponentAlignment(returnToMainButton, Alignment.MIDDLE_RIGHT);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
