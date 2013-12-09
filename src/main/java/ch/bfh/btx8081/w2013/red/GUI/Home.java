package ch.bfh.btx8081.w2013.red.GUI;

import ch.bfh.btx8081.w2013.red.Controller.NavigatorUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
/**
 * 
 * @author faton shabanaj
 * @email shabf2@bfh.ch
 * @version.nr 1.2
 *
 */
public class Home extends VerticalLayout implements View {

	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private HorizontalLayout horizontalLayout_1;
	private Button MedicationInfo;
	private Button Disease;
	private Button ApartmentSearch;
	private Button Finances;
	
	private Button HelpButton;
	private Button HomeButton;
	private VerticalLayout verticalLayout_1;
	private MhcGuidDesign design;
	private VerticalLayout upperVerticalLayout;
	
	
	public Home()
	
	{
		design = new MhcGuidDesign(this);
		layout = design.getLayout();
		mainLayout = design.getMainLayout();
		horizontalLayout_1 = design.getLowerHorizontalLayout();
		upperVerticalLayout = design.getUpperVerticalLayout();
		buildHorizontalLayout_1();
		createLayout();
	}


	private void createLayout() {
		design.setTitleLabel("Home");
		// verticalLayout_1
		verticalLayout_1 = buildVerticalLayout_1();
		mainLayout.addComponent(verticalLayout_1, "top:120.0px;left:30.0px;");
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	
	}

	private VerticalLayout buildVerticalLayout_1() {
		// common part: create layout
		verticalLayout_1 = new VerticalLayout();
		verticalLayout_1.setWidth("260px");
		verticalLayout_1.setHeight("260px");
	
		// button_1 to which start the Event 'Login' and change the LoginView
		// with the'Home'-View.
		MedicationInfo = new Button("Medication info");
		MedicationInfo.setWidth("100%");
		MedicationInfo.setHeight("100%");
		verticalLayout_1.addComponent(MedicationInfo);
		verticalLayout_1.setComponentAlignment(MedicationInfo, Alignment.MIDDLE_CENTER);
		MedicationInfo.addClickListener(new Button.ClickListener() 
    	{
    		public void buttonClick(ClickEvent event) {
    			NavigatorUI.navigateTo(NavigatorUI.SEARCHMEDVIEW);
    		}
    	});
		
		Disease = new Button("Disease");
		Disease.setWidth("100%");
		Disease.setHeight("100%");
		verticalLayout_1.addComponent(Disease);
		verticalLayout_1.setComponentAlignment(MedicationInfo, Alignment.MIDDLE_CENTER);
		Disease.addClickListener(new Button.ClickListener() 
    	{
    		public void buttonClick(ClickEvent event) {
    			NavigatorUI.navigateTo(NavigatorUI.SEARCHDISVIEW);
    		}
    	});
		
		
		ApartmentSearch = new Button("Apartment search");
		ApartmentSearch.setWidth("100%");
		ApartmentSearch.setHeight("100%");
		verticalLayout_1.addComponent(ApartmentSearch);
		verticalLayout_1.setComponentAlignment(MedicationInfo, Alignment.MIDDLE_CENTER);
		
		Finances = new Button("Finances");
		Finances.setWidth("100%");
		Finances.setHeight("100%");
		verticalLayout_1.addComponent(Finances);
		verticalLayout_1.setComponentAlignment(MedicationInfo,Alignment.MIDDLE_CENTER);
				
		return verticalLayout_1;
	}

		private void buildHorizontalLayout_1() {
			// common part: create layout

			// HomeButton
			HomeButton = new Button("Logout");
			HomeButton.setWidth("80px");
			HomeButton.setHeight("-1px");
			horizontalLayout_1.addComponent(HomeButton);
			horizontalLayout_1.setComponentAlignment(HomeButton, Alignment.MIDDLE_LEFT);
			HomeButton.addClickListener(new Button.ClickListener() 
        	{
        		public void buttonClick(ClickEvent event) {
        			NavigatorUI.navigateTo(NavigatorUI.LOGINVIEW);
        		}
        	});

			

	}

}


