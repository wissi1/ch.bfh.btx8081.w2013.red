package ch.bfh.btx8081.w2013.red.GUI;

/**
 * import all required packages
 */
import java.awt.Component;
import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import ch.bfh.btx8081.w2013.red.Controller.IState;
import ch.bfh.btx8081.w2013.red.Controller.NavigatorUI;
import ch.bfh.btx8081.w2013.red.Database.Data;
import ch.bfh.btx8081.w2013.red.Database.Disease;
import ch.bfh.btx8081.w2013.red.Model.DisplayDiseases;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinPortlet.VaadinGateinRequest;
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
import com.vaadin.ui.themes.BaseTheme;

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
		
		ValueChangeListener symptomListener = new ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				if(comboBox_2.getValue() != null || comboBox_3.getValue() != null || comboBox_4.getValue() != null)
				{
					comboBox_1.removeAllItems();
						for(Entry<String, Disease> disease : Data.getDiseases().entrySet())
						{
							boolean cb2 = false;
							if(comboBox_2.getValue() == null)
							{
								cb2 = true;
							}
							boolean cb3 = false;
							if(comboBox_3.getValue() == null)
							{
								cb3 = true;
							}
							boolean cb4 = false;
							if(comboBox_4.getValue() == null)
							{
								cb4 = true;
							}
							for(int i = 0 ; i< disease.getValue().getSymtoms().size(); i++)
							{
								if(disease.getValue().getSymtoms().get(i).equals(comboBox_2.getValue()))
								{
									cb2 = true;
								}
								if(disease.getValue().getSymtoms().get(i).equals(comboBox_3.getValue()))
								{
									cb3 = true;
								}
								if(disease.getValue().getSymtoms().get(i).equals(comboBox_4.getValue()))
								{
									cb4 = true;
								}
							}
							
							if(cb2 == true && cb3 == true && cb4 == true)
							{
								System.out.println(cb2);
								System.out.println(cb3);
								System.out.println(cb4);
								comboBox_1.addItem(disease.getValue().getName());
							}
						}
					}
					else
					{
						ArrayList<String> disease = DisplayDiseases.displayDiseases();
						for(String diseases : disease)
						{
							comboBox_1.addItem(diseases);
						}
					}
				}	
		};
		
		comboBox_2.addValueChangeListener(symptomListener);
		comboBox_3.addValueChangeListener(symptomListener);
		comboBox_4.addValueChangeListener(symptomListener);
		
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
		backButton.setIcon(new ThemeResource("Search.png"));
		backButton.setStyleName(BaseTheme.BUTTON_LINK);
		backButton.setWidth("80px");
		backButton.addClickListener(new Button.ClickListener() 
    	{
    		public void buttonClick(ClickEvent event) {
    			
    			try
    			{
    			Data.setReference(comboBox_1.getValue().toString());
    			handleB2();
    			}
    			catch(Exception e)
    			{
    				Component controllingFrame = null;
					JOptionPane.showMessageDialog(controllingFrame,
	                        "Please select Disease.",
	                        "Error Message",
	                        JOptionPane.ERROR_MESSAGE);
    			}
    		}
    	});
		
		/**
		 * create "Main"-Button
		 */
		Button returnToMainButton = new Button();
		returnToMainButton.setCaption("Home");
		returnToMainButton.setIcon(new ThemeResource("Main.png"));
		returnToMainButton.setStyleName(BaseTheme.BUTTON_LINK);
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
		
		comboBox_1.setValue(null);
		comboBox_1.setInputPrompt("Select please");
		
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