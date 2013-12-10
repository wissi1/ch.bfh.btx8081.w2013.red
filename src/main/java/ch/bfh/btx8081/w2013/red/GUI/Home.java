package ch.bfh.btx8081.w2013.red.GUI;

import ch.bfh.btx8081.w2013.red.Controller.IState;
import ch.bfh.btx8081.w2013.red.Controller.NavigatorUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
/**
 * 
 * @author faton shabanaj
 * @email shabf2@bfh.ch
 * @version.nr 1.2
 *
 */
public class Home extends VerticalLayout implements View, IState {

	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private HorizontalLayout horizontalLayout_1;
	private Button medicationInfo;
	private Button disease;
	private Button apartmentSearch;
	private Button finances;
	
	private Button homeButton;
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
		medicationInfo = new Button("Medication info");
		medicationInfo.setWidth("100%");
		medicationInfo.setHeight("100%");
		verticalLayout_1.addComponent(medicationInfo);
		verticalLayout_1.setComponentAlignment(medicationInfo, Alignment.MIDDLE_CENTER);
		medicationInfo.addClickListener(new Button.ClickListener() 
    	{
    		public void buttonClick(ClickEvent event) {
    			handleB1();
    		}
    	});
		
		disease = new Button("Disease");
		disease.setWidth("100%");
		disease.setHeight("100%");
		verticalLayout_1.addComponent(disease);
		verticalLayout_1.setComponentAlignment(medicationInfo, Alignment.MIDDLE_CENTER);
		disease.addClickListener(new Button.ClickListener() 
    	{
    		public void buttonClick(ClickEvent event) {
    			handleB2();
    		}
    	});
		
		
		apartmentSearch = new Button("Apartment search");
		apartmentSearch.setWidth("100%");
		apartmentSearch.setHeight("100%");
		verticalLayout_1.addComponent(apartmentSearch);
		verticalLayout_1.setComponentAlignment(medicationInfo, Alignment.MIDDLE_CENTER);
		
		finances = new Button("Finances");
		finances.setWidth("100%");
		finances.setHeight("100%");
		verticalLayout_1.addComponent(finances);
		verticalLayout_1.setComponentAlignment(medicationInfo,Alignment.MIDDLE_CENTER);
				
		return verticalLayout_1;
	}

		private void buildHorizontalLayout_1() {
			// common part: create layout

			// HomeButton
			homeButton = new Button("Logout");
			homeButton.setWidth("80px");
			homeButton.setHeight("-1px");
			horizontalLayout_1.addComponent(homeButton);
			horizontalLayout_1.setComponentAlignment(homeButton, Alignment.MIDDLE_LEFT);
			homeButton.addClickListener(new Button.ClickListener() 
        	{
        		public void buttonClick(ClickEvent event) {
        			handleB3();
        		}
        	});
	}
		@Override
		public void handleB1() {
			NavigatorUI.navigateTo(NavigatorUI.SEARCHMEDVIEW);
		}


		@Override
		public void handleB2() {
			NavigatorUI.navigateTo(NavigatorUI.SEARCHDISVIEW);
		}


		@Override
		public void handleB3() {
			NavigatorUI.navigateTo(NavigatorUI.LOGINVIEW);
		}

}


