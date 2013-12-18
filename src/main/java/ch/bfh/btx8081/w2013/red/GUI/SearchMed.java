/**
 * The SearchMedi class creates a view in which a user can select Information
 * about Medication and navigate through the application. 
 * The Buttons "Search" navigate to class "InfoMed" and Buttons "Main" 
 * navigate to class "Home"
 * 
 * @author sians1
 * @version 16.12.2013
 * 
 * */

package ch.bfh.btx8081.w2013.red.GUI;

import ch.bfh.btx8081.w2013.red.Controller.IState;
import ch.bfh.btx8081.w2013.red.Controller.NavigatorUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ChameleonTheme;

@SuppressWarnings("serial")

public class SearchMed extends VerticalLayout implements View, IState {

	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout upperVerticalLayout;
	private HorizontalLayout lowerHorizontalLayout;
	private ComboBox comboBox_MediName;
	private ComboBox comboBox_MediArt;
	MhcGuidDesign design;

	/**
	 * Constructs a SearchMed on the base of different parameters.
	 *  @param design
	 *   basic design of the view based on the class MhcGuidDesign
	 * @param layout
	 *   basic layout of the view
	 * @param mainLayout
	 *  main part of the layout
	 * @param upperVerticalLayout
	 *  upper part of the layout
	 * @param lowerHorizontalLayout
	 *   lower part of the layout
	 */

	public SearchMed()
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
	 * Edits the upperVerticalLayout by setting the TitleLabel.
	 */

	private void editUpperVerticalLayout()
	{
		design.setTitleLabel("Medication");
	}

	/**
	 * Here are elements to select. Two combobox for Medication selection  of name (or active substance)
	 *  and of type
	 * 
	 * */     
	private void editMainLayout()
	{		

		comboBox_MediName = new ComboBox("Medication / Active substance");
		mainLayout.addComponent(comboBox_MediName, "top:120.0px;left:30.0px;");

		comboBox_MediArt= new ComboBox("Type of medication ");
		mainLayout.addComponent(comboBox_MediArt, "top:170.0px;left:30.0px;");

	}

	/**
	 * Edits the lowerHorizontalLayout by search a button to navigate to class 
	 * InfoMed and a button "Main" to navigate to the HOMEVIEW.
	 * 
	 * */

	private void editLowerHorizontalLayout()
	{
		Button searchButton = new Button("Search");
		searchButton.setWidth("80px");
		searchButton.addClickListener(new Button.ClickListener()
		{
			public void buttonClick(ClickEvent event) {
				handleB2();
			}
		});

		Button mainButton = new Button("Main");
		mainButton.setWidth("80px");
		mainButton.addClickListener(new Button.ClickListener()
		{
			public void buttonClick(ClickEvent event) {
				handleB1();
			}
		});

		lowerHorizontalLayout.addComponent(searchButton);
		lowerHorizontalLayout.setComponentAlignment(searchButton, Alignment.MIDDLE_LEFT);
		lowerHorizontalLayout.addComponent(mainButton);
		lowerHorizontalLayout.setComponentAlignment(mainButton, Alignment.MIDDLE_RIGHT);
	}

	/**
	 * Not overridden method of the interface view.
	 */
	public void enter(ViewChangeEvent event) {

	}

	/**
	 * Navigates back the the last view using methods of the NavigatorUI class.
	 */

	public void handleB1() {
		NavigatorUI.navigateTo(NavigatorUI.HOMEVIEW);
	}
	
	/**
	 *  Navigates back to the HOMEVIEW using methods of the NavigatorUI class.
	 */
	public void handleB2() {
		NavigatorUI.navigateTo(NavigatorUI.INFOMEDVIEW);        
	}

	/**
	 * Not overridden method of the interface IState.
	 */
	public void handleB3() {

	}

}