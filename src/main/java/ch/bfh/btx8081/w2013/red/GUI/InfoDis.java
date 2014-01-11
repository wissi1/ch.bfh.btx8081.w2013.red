package ch.bfh.btx8081.w2013.red.GUI;

import java.util.Map.Entry;

import ch.bfh.btx8081.w2013.red.Controller.IState;
import ch.bfh.btx8081.w2013.red.Controller.NavigatorUI;
import ch.bfh.btx8081.w2013.red.Database.Data;
import ch.bfh.btx8081.w2013.red.Database.Disease;
import ch.bfh.btx8081.w2013.red.Database.Drug;

import com.vaadin.client.ui.VTabsheet.Tab;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ChameleonTheme;
import com.vaadin.ui.themes.Reindeer;
/**
 * The InfoDis class creates a view in which a user can read symptoms, causes 
 * and treatments of different diseases. It provides a display panel to show the existing documentation about the medicine,
 * providing three button to select each content. It also provides two buttons to 
 * navigate back to the last view or to the HOMEVIEW.
 * 
 * @author wiss1
 * @version V13.12.2013
 */

public class InfoDis extends VerticalLayout implements View , IState {
	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout upperVerticalLayout;
	private HorizontalLayout lowerHorizontalLayout;
	private MhcGuidDesign design;
	private VerticalLayout symptomsLayout = new VerticalLayout();
	private VerticalLayout causeLayout = new VerticalLayout();
	private VerticalLayout treatmentLayout = new VerticalLayout();
	TabSheet tabSheetDis = new TabSheet();
	/**
	 * Constructs a InfoDis View on the base of different parameters.
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
	public InfoDis()
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
	 * Edits the mainLayout by adding a Tabsheet to display symptoms, causes 
	 * and treatments. It also adds buttons to switch through each displays.
	 *
	 */
	private void editMainLayout()
	{		
		tabSheetDis.setWidth("260px");
		tabSheetDis.setHeight("300px");
		tabSheetDis.addTab(symptomsLayout, "Symptoms");
		tabSheetDis.addTab(causeLayout, "Cause");
		tabSheetDis.addTab(treatmentLayout, "Treatment");
		mainLayout.addComponent(tabSheetDis, "top:90px;left:30px");
		
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
	 * Edits the upperVerticalLayout, does nothing.
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
		backButton.setWidth("80px");
			backButton.addClickListener(new Button.ClickListener() 
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
		symptomsLayout.removeAllComponents();
		for(String symp : Data.getDiseases().get(Data.getReference()).getSymtoms())
		{
			symptomsLayout.addComponent(new Label(symp));
		}
		causeLayout.removeAllComponents();
		causeLayout.addComponent(new Label((Data.getDiseases().get(Data.getReference())).getCause()));
		treatmentLayout.removeAllComponents();
		treatmentLayout.addComponent(new Label("Therapy:"));
		treatmentLayout.addComponent(new Label((" -" + Data.getDiseases().get(Data.getReference()).getTreatment())));
		treatmentLayout.addComponent(new Label("Medication:"));
		for(final String med : Data.getDiseases().get(Data.getReference()).getDrugs())
		{
			if(Data.getDrugs().containsKey(med))
			{
				Button medButton = new Button(" -" + med);
				medButton.setStyleName(Reindeer.BUTTON_LINK);
				medButton.addClickListener(new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						Data.setReference(med);
						NavigatorUI.navigateTo(NavigatorUI.INFOMEDVIEW);
					}
				});;
				treatmentLayout.addComponent(medButton);
			}
			else
			{
				treatmentLayout.addComponent(new Label(" -" + med));
			}
		}
			
	}

	/**
	 * Navigates back to the HOMEVIEW using methods of the NavigatorUI class.
	 */
	public void handleB1() {
		NavigatorUI.navigateTo(NavigatorUI.HOMEVIEW);
	}

	/**
	 * Navigates to the SEARCHDISVIEW using methods of the NavigatorUI class.
	 */
	
	public void handleB2() {
		NavigatorUI.navigateTo(NavigatorUI.SEARCHDISVIEW);
	}

	/**
	 * Navigates to the COMMENTVIEW using methods of the NavigatorUI class.
	 */
	public void handleB3() {
		NavigatorUI.navigateTo(NavigatorUI.COMMENTVIEW);
		
	}

}