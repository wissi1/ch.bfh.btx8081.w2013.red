package ch.bfh.btx8081.w2013.red.GUI;

/**
 * import all required packages
 */
import java.util.ArrayList;

import ch.bfh.btx8081.w2013.red.Controller.IState;
import ch.bfh.btx8081.w2013.red.Controller.NavigatorUI;
import ch.bfh.btx8081.w2013.red.Database.Data;
import ch.bfh.btx8081.w2013.red.Model.DisplayDiseases;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

/**
 * The SearchDis class creates a view in which a user can search for diseases
 * and/or symptoms of diseases.
 * It provides a display panel with comboboxes to choose diseases or symptoms.
 * There are two buttons; one for searching and the other one to go back to the main menue. 
 * 
 * @author zehnp1
 * @version 12.12.2013
 */

public class SearchDis extends VerticalLayout implements View, IState {

	/**
	 * define variables
	 */
	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout upperVerticalLayout;
	private HorizontalLayout lowerHorizontalLayout;
	MhcGuidDesign design;
	ComboBox comboBox_1 = new ComboBox();
	ComboBox comboBox_2 = new ComboBox();
	ComboBox comboBox_3 = new ComboBox();
	ComboBox comboBox_4 = new ComboBox();
	
	/**
	 * Constructs a SearchDisView on the base of different parameters.
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
	
	
	public SearchDis()
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
	 * define main-layout (middle); create comboBoxes; add components to main-Layout
	 */
	

	/**
	 * Edits the mainLayout by adding ComboBoxes for the user to choose diseases
	 * or symptoms.
	 */
	private void editMainLayout()
	{		
		
		comboBox_1.setCaption("Disease");
		comboBox_1.setInputPrompt("Bitte Auswählen");
		
		ArrayList<String> disease = DisplayDiseases.displayDiseases();
		
		for(String diseases : disease)
		{
			comboBox_1.addItem(diseases);
		}
		
		comboBox_1.addValueChangeListener(new ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				if(comboBox_1.getValue() != null)
				{
					comboBox_2.setEnabled(false);
					comboBox_3.setEnabled(false);
					comboBox_4.setEnabled(false);
					
				}
				else if(comboBox_1.getValue() == null)
				{
					comboBox_2.setEnabled(true);
					comboBox_3.setEnabled(true);
					comboBox_4.setEnabled(true);
				}
			}
		});
		
		mainLayout.addComponent(comboBox_1, "top:120.0px;left:30.0px;");
		
		comboBox_2.setCaption("Symptom 1");
		
		mainLayout.addComponent(comboBox_2, "top:180.0px;left:30.0px;");
		
		comboBox_3.setCaption("Symptom 2");
		
		mainLayout.addComponent(comboBox_3, "top:240.0px;left:30.0px;");
		
		comboBox_4.setCaption("Symptom 3");
		
		mainLayout.addComponent(comboBox_4, "top:300.0px;left:30.0px;");
		
		ArrayList<String> symptom = DisplayDiseases.displaySymptoms();
		
		for(String symptoms : symptom)
		{
			comboBox_2.addItem(symptoms);
			comboBox_3.addItem(symptoms);
			comboBox_4.addItem(symptoms);
		}
	
	}
	
	/**
	 * define upperVerticalLayout; set title 
	 */
	
	private void editUpperVerticalLayout()
	{
		design.setTitleLabel("Diseases");
	}
	
	/**
	 * define lower-layout
	 */
	
	/**
	 * Define the LowerHorizontalLayout by adding a button to navigate back to
	 * the home view and a button to search for the chosen diseases or symptoms.
	 */
	private void editLowerHorizontalLayout()
	{
		
		/**
		 * create "Search"-Button
		 */
		Button backButton = new Button();
		backButton.setCaption("Search");
		backButton.setWidth("80px");
		backButton.addClickListener(new Button.ClickListener() 
    	{
    		public void buttonClick(ClickEvent event) {
    			Data.setReference(comboBox_1.getValue().toString());
    			handleB2();
    		}
    	});
		
		/**
		 * create "Main"-Button
		 */
		Button returnToMainButton = new Button();
		returnToMainButton.setCaption("Main");
		returnToMainButton.setWidth("80px");
		returnToMainButton.addClickListener(new Button.ClickListener() 
    	{
    		public void buttonClick(ClickEvent event) {
    			handleB1();
    		}
    	});
		
		
		/**
		 * Add and define buttons to LowerHorizontalLayout
		 */
        lowerHorizontalLayout.addComponent(backButton);
        lowerHorizontalLayout.setComponentAlignment(backButton, Alignment.MIDDLE_LEFT);
        lowerHorizontalLayout.addComponent(returnToMainButton);
        lowerHorizontalLayout.setComponentAlignment(returnToMainButton, Alignment.MIDDLE_RIGHT);
	}
	
	
	/**
	 * Not overridden method of the interface view.
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Navigates back to the home view after clicking the "main"-button
	 * using methods of the NavigatorUI class.
	 */
	@Override
	public void handleB1() {
		NavigatorUI.navigateTo(NavigatorUI.HOMEVIEW);
	}

	/**
	 * Navigates to the InfoDis view after clicking the "search"-Button
	 * using methods of the NavigatorUI class.
	 */
	@Override
	public void handleB2() {
		NavigatorUI.navigateTo(NavigatorUI.INFODISVIEW);
	}

	/**
	 * Not overridden method of the interface IState.
	 */
	@Override
	public void handleB3() {
		// TODO Auto-generated method stub
		
	}

}