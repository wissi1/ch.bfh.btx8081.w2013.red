package ch.bfh.btx8081.w2013.red.GUI;


import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.server.ClassResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2013.red.Controller.IState;
import ch.bfh.btx8081.w2013.red.Controller.NavigatorUI;
import ch.bfh.btx8081.w2013.red.Database.Data;
import ch.bfh.btx8081.w2013.red.Database.User;
import ch.bfh.btx8081.w2013.red.Model.HashValueGenerator1;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
/**
 * 
 * The Login class creates a view in which a user can write his username
 * and hsi password in the textareas.  one of four main
 * views and navigate through the application. It also provides a login button to log in and to
 * navigate to the next view, in this case it would be the HOMEVIEW.
 * 
 * 
 * @author faton shabanaj
 * @email shabf2@bfh.ch
 * @version.nr V11.12.2013
 * 
 */
public class Login extends VerticalLayout implements View, IState {

	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private HorizontalLayout horizontalLayout_1;
	private VerticalLayout upperVerticalLayout;
	private Button HelpButton;
	protected Button homeButton;
	private VerticalLayout verticalLayout;
	private PasswordField passwordField;
	private TextField userField;
	private MhcGuidDesign design;
	
	/**
	 * Constructs a LOGINVIEW on the base of different parameters.
	 * 
	 * @param design
	 *            basic design of the view based on the class MhcGuidDesign
	 * 
	 * @param layout
	 *            basic layout of the view
	 * 
	 * @param mainLayout
	 *            main part of the layout
	 * 
	 * @param verticalLayout
	 *            upper part of the layout
	 * 
	 * @param horizontalLayout
	 *            lower part of the layout
	 * 
	 */
	
	public Login() 
	
	{
		design = new MhcGuidDesign(this);
		layout = design.getLayout();
		mainLayout = design.getMainLayout();
		horizontalLayout_1 = design.getLowerHorizontalLayout();
		upperVerticalLayout = design.getUpperVerticalLayout();
		buildHorizontalLayout_1();
		createLayout();
	}

	/**
	 * create a layout and add this new layout at the mainLayout. the title 
	 * of this layout will be defined.
	 */

	private void createLayout() {

		design.setTitleLabel("MHC-GUIDE");
		// verticalLayout_1
		verticalLayout = buildVerticalLayout_1();
		mainLayout.addComponent(verticalLayout, "top:60.0px;left:30.0px;");


	}
	/**
	 * overridden method of the interface view.
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Builds the verticallayout and defines the size.
	 * Edits the verticallayout by adding the application logo,
	 * textfield and a passwordfield.
	 */
	private VerticalLayout buildVerticalLayout_1() {
		// common part: create layout
		verticalLayout = new VerticalLayout();
		verticalLayout.setImmediate(false);
		verticalLayout.setWidth("260px");
		verticalLayout.setHeight("360px");
		verticalLayout.setMargin(false);

		// Logo which represents the mobile applicaton

		Embedded logo = new Embedded();
		logo.setImmediate(false);
		logo.setWidth("100%");
		logo.setHeight("160px");
		logo.setSource(new ThemeResource("Home.png"));
		logo.setType(1);
		logo.setMimeType("image/png");
		verticalLayout.addComponent(logo);

		// textField_1 for insert the Username

		userField = new TextField(" Username:");
		userField.setImmediate(true);
		userField.setRequired(true);
		userField.setWidth("80%");
		userField.setHeight("-1px");
		userField.setInputPrompt("Your username (eg. name@bfh.ch)");
	    userField.addValidator(new EmailValidator("Username must be an email address"));
	    userField.setInvalidAllowed(false);
		verticalLayout.addComponent(userField);
		verticalLayout.setComponentAlignment(userField, Alignment.BOTTOM_CENTER);

		// passwordField_1 for insert the Password
		passwordField = new PasswordField("Password: ");
		passwordField.setImmediate(false);
		passwordField.setWidth("80%");
		passwordField.setHeight("-1px");
		verticalLayout.addComponent(passwordField);
		verticalLayout.setComponentAlignment(passwordField, Alignment.MIDDLE_CENTER);
	
	    passwordField.setRequired(true);
	    passwordField.setValue("");
	    passwordField.setNullRepresentation("");
	
		return verticalLayout;
	}

	
	/**
	 * Builds the HorizontalLayout and defines the size.
	 * Edits the HorizontalLayout by adding a button to log in. 
	 * The button navitagets to the HOMEVIEW.
	 */
	private void buildHorizontalLayout_1() {
	
		homeButton = new Button("Login");
		homeButton.setImmediate(true);
		homeButton.setWidth("80px");
		homeButton.setHeight("-1px");
		horizontalLayout_1.addComponent(homeButton);
		horizontalLayout_1.setComponentAlignment(homeButton, Alignment.MIDDLE_LEFT);
		homeButton.addClickListener(new Button.ClickListener() 
    	{
    		private Component controllingFrame;

			public void buttonClick(ClickEvent event) {
    			
    		User user =	Data.getUsers().get(userField.getValue());
    		String password = HashValueGenerator1.getHash(passwordField.getValue());
    		if(password.equals(user.getPasswort()))
    		{
    			Data.setUser(user.getName());
    			handleB1();
    		}
    		else {
	            
					JOptionPane.showMessageDialog(controllingFrame,
	                        "Invalid password, please try again.",
	                        "Error Message",
	                        JOptionPane.ERROR_MESSAGE);
			}
    		}
    	});

	

	}
	/**
	 * overridden method which navigates to the HOMEVIEW using methods of
	 * the NavigatorUI class.
	 */

	@Override
	public void handleB1() {
		NavigatorUI.navigateTo(NavigatorUI.HOMEVIEW);
	}
	/**
	 *overridden method of the interface IState.
	 */

	@Override
	public void handleB2() {
		// TODO Auto-generated method stub
		
	}
	/**
	 *overridden method of the interface IState.
	 */
	@Override
	public void handleB3() {
		// TODO Auto-generated method stub
		
	}

	public void initUI(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}


