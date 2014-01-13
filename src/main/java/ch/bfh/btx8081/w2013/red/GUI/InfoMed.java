package ch.bfh.btx8081.w2013.red.GUI;

import ch.bfh.btx8081.w2013.red.Controller.IState;
import ch.bfh.btx8081.w2013.red.Controller.NavigatorUI;
import ch.bfh.btx8081.w2013.red.Database.Data;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.BaseTheme;
import com.vaadin.ui.themes.ChameleonTheme;
import com.vaadin.ui.themes.Reindeer;

/**
 * The InfoMed class creates a view in which a user can read indication, effects 
 * and side effects of different medicines. It provides a display panel to show the existing documentation about the medicine,
 * providing three button to select each content. It also provides two buttons to 
 * navigate back to the last view or to the HOMEVIEW.
 * 
 * @author kalar1
 * @version V13.12.2013
 */

public class InfoMed extends VerticalLayout implements View, IState {
	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private HorizontalLayout lowerHorizontalLayout;
	private MhcGuidDesign design;
	TabSheet tabSheetMed = new TabSheet();

	/**
	 * Constructs a InfoMed View on the base of different parameters.
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
	
	public InfoMed()
	{
		design = new MhcGuidDesign(this);
		this.layout = design.getLayout();
		this.mainLayout = design.getMainLayout();
		design.getUpperVerticalLayout();
		this.lowerHorizontalLayout = design.getLowerHorizontalLayout();
		editMainLayout();
		editUpperVerticalLayout();
		editLowerHorizontalLayout();
	}
	
	/**
	 * Edits the mainLayout by adding a Tabsheet to display Indication, effect 
	 * and side effect. It also adds buttons to switch through each displays.
	 *
	 */
	
	private void editMainLayout()
	{		
		
		
		tabSheetMed.setWidth("260px");
		tabSheetMed.setHeight("300px");
		
		
		mainLayout.addComponent(tabSheetMed, "top:90px;left:30px");
	
		
		Button commentLink = new Button("comment");
		commentLink.setStyleName(ChameleonTheme.BUTTON_LINK);
			commentLink.addClickListener(new Button.ClickListener() 
			{
	            public void buttonClick(ClickEvent event) {
	            	handleB3();
	            }
	        });
		
		mainLayout.addComponent(commentLink, "top:395px;left:45px");
		
	}
	
	/**
	 * Edits the upperVerticalLayout by setting the TitleLabel.
	 */
	private void editUpperVerticalLayout()
	{
		
	}
	
	/**
	 * Edits the lowerHorizontalLayout by adding a button to navigate back to
	 * the last view and a button to navigate to the HOMEVIEW.
	 */
	
	private void editLowerHorizontalLayout()
	{
		
		Button backButton = new Button("Back");
		backButton.setIcon(new ThemeResource("Back.png"));
		backButton.setStyleName(BaseTheme.BUTTON_LINK);
		backButton.setWidth("80px");
			backButton.addClickListener(new Button.ClickListener() 
			{
	            public void buttonClick(ClickEvent event) {
	            	handleB2();
	            }
	        });
		
		Button mainButton = new Button("Home");
		mainButton.setIcon(new ThemeResource("Main.png"));
		mainButton.setStyleName(BaseTheme.BUTTON_LINK);
		mainButton.setWidth("80px");
        	mainButton.addClickListener(new Button.ClickListener() 
        	{
        		public void buttonClick(ClickEvent event) {
        			handleB1();
        		}
        	});
		
		
        	lowerHorizontalLayout.addComponent(backButton);
            lowerHorizontalLayout.setComponentAlignment(backButton, Alignment.MIDDLE_LEFT);
            lowerHorizontalLayout.addComponent(mainButton);
            lowerHorizontalLayout.setComponentAlignment(mainButton, Alignment.MIDDLE_RIGHT);
	}
	
	/**
	 * Not overridden method of the interface view.
	 */
	
	public void enter(ViewChangeEvent event) {
		design.setTitleLabel(Data.getReference());
		tabSheetMed.removeAllComponents();
		tabSheetMed.addTab(new Label((Data.getDrugs().get(Data.getReference())).getIndication()), "Indication");
		tabSheetMed.addTab(new Label((Data.getDrugs().get(Data.getReference())).getEffcet()), "Effect");
		tabSheetMed.addTab(new Label((Data.getDrugs().get(Data.getReference())).getSideEffect()), "Side Effect");
		
	}
	
	/**
	 * Navigates back to the HOMEVIEW using methods of the NavigatorUI class.
	 */
	
	public void handleB1() {
		NavigatorUI.navigateTo(NavigatorUI.HOMEVIEW);
	}
	
	/**
	 * Navigates to the SEARCHMEDVIEW using methods of the NavigatorUI class.
	 */
	
	public void handleB2() {
		NavigatorUI.navigateTo(NavigatorUI.SEARCHMEDVIEW);
	}
	
	/**
	 * Navigates to the COMMENTVIEW  using methods of the NavigatorUI class.
	 */
	
	public void handleB3() {
		NavigatorUI.navigateTo(NavigatorUI.COMMENTVIEW);
		
	}

}