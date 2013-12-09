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
	private Button MedikamentenInfo;
	private Button Krankheitsbilder;
	private Button Wohnungssuche;
	private Button Finanzen;
	
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
		MedikamentenInfo = new Button("MEDIKAMENTENINFO");
		MedikamentenInfo.setWidth("100%");
		MedikamentenInfo.setHeight("100%");
		verticalLayout_1.addComponent(MedikamentenInfo);
		verticalLayout_1.setComponentAlignment(MedikamentenInfo, Alignment.MIDDLE_CENTER);
		MedikamentenInfo.addClickListener(new Button.ClickListener() 
    	{
    		public void buttonClick(ClickEvent event) {
    			NavigatorUI.navigateTo(NavigatorUI.SEARCHMEDVIEW);
    		}
    	});
		
		Krankheitsbilder = new Button("KRANKHEITSBILDER");
		Krankheitsbilder.setWidth("100%");
		Krankheitsbilder.setHeight("100%");
		verticalLayout_1.addComponent(Krankheitsbilder);
		verticalLayout_1.setComponentAlignment(MedikamentenInfo, Alignment.MIDDLE_CENTER);
		Krankheitsbilder.addClickListener(new Button.ClickListener() 
    	{
    		public void buttonClick(ClickEvent event) {
    			NavigatorUI.navigateTo(NavigatorUI.SEARCHDISVIEW);
    		}
    	});
		
		
		Wohnungssuche = new Button("WOHNUNGSSUCHE");
		Wohnungssuche.setWidth("100%");
		Wohnungssuche.setHeight("100%");
		verticalLayout_1.addComponent(Wohnungssuche);
		verticalLayout_1.setComponentAlignment(MedikamentenInfo, Alignment.MIDDLE_CENTER);
		
		Finanzen = new Button("FINANZEN");
		Finanzen.setWidth("100%");
		Finanzen.setHeight("100%");
		verticalLayout_1.addComponent(Finanzen);
		verticalLayout_1.setComponentAlignment(MedikamentenInfo,Alignment.MIDDLE_CENTER);
				
		return verticalLayout_1;
	}

		private void buildHorizontalLayout_1() {
			// common part: create layout

			// HomeButton
			HomeButton = new Button("Logout");
			HomeButton.setWidth("-1px");
			HomeButton.setHeight("-1px");
			horizontalLayout_1.addComponent(HomeButton);
			horizontalLayout_1.setComponentAlignment(HomeButton, Alignment.MIDDLE_LEFT);
			HomeButton.addClickListener(new Button.ClickListener() 
        	{
        		public void buttonClick(ClickEvent event) {
        			NavigatorUI.navigateTo(NavigatorUI.LOGINVIEW);
        		}
        	});

			// HelpButton
			HelpButton = new Button("   ?   ");
			HelpButton.setDescription(" Help-Mode ");
			HelpButton.setWidth("-1px");
			HelpButton.setHeight("22px");
			horizontalLayout_1.addComponent(HelpButton);
			horizontalLayout_1.setComponentAlignment(HelpButton, Alignment.MIDDLE_RIGHT);


	}

}


