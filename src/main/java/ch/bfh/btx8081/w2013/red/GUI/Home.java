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
 * @author shabf2 allererste Version
 * Autor Faton hochgeladen von Ivan wegen gitHub conflict 
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
	private VerticalLayout verticalLayout_2;


	
	final GridLayout grid = new GridLayout(1, 3);

	

	public Home() {
		this.layout = this;
		createLayout();
	}

	private void createLayout() {

		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("320px");
		mainLayout.setHeight("480px");

		// top-level component properties
		setWidth("320px");
		setHeight("480px");

		// verticalLayout_1
		verticalLayout_1 = buildVerticalLayout_1();
		mainLayout.addComponent(verticalLayout_1, "top:60.0px;left:30.0px;");
		


		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		mainLayout.addComponent(horizontalLayout_1, "top:380.0px;left:0.0px;");

		layout.addComponent(mainLayout);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	
	}

	private VerticalLayout buildVerticalLayout_1() {
		// common part: create layout
		verticalLayout_1 = new VerticalLayout();
		verticalLayout_1.setImmediate(false);
		verticalLayout_1.setWidth("260px");
		verticalLayout_1.setHeight("360px");
		verticalLayout_1.setMargin(false);
	
		verticalLayout_2 = new VerticalLayout();
		verticalLayout_2.setImmediate(false);
		verticalLayout_2.setWidth("100%");
		verticalLayout_2.setHeight("200px");
		verticalLayout_2.setMargin(true);
		

		// button_1 to which start the Event 'Login' and change the LoginView
		// with the'Home'-View.
		MedikamentenInfo = new Button();
		MedikamentenInfo.setCaption("MEDIKAMENTENINFO");
		MedikamentenInfo.setImmediate(false);
		MedikamentenInfo.setWidth("100%");
		MedikamentenInfo.setHeight("-1px");
		verticalLayout_2.addComponent(MedikamentenInfo);
		verticalLayout_2.setComponentAlignment(MedikamentenInfo, new Alignment(20));
		
		Krankheitsbilder = new Button();
		Krankheitsbilder.setCaption("KRANKHEITSBILDER");
		Krankheitsbilder.setImmediate(false);
		Krankheitsbilder.setWidth("100%");
		Krankheitsbilder.setHeight("-1px");
		verticalLayout_2.addComponent(Krankheitsbilder);
		verticalLayout_2.setComponentAlignment(MedikamentenInfo, new Alignment(20));
		
		Wohnungssuche = new Button();
		Wohnungssuche.setCaption("WOHNUNGSSUCHE");
		Wohnungssuche.setImmediate(false);
		Wohnungssuche.setWidth("100%");
		Wohnungssuche.setHeight("-1px");
		verticalLayout_2.addComponent(Wohnungssuche);
		verticalLayout_2.setComponentAlignment(MedikamentenInfo, new Alignment(20));
		
		Finanzen = new Button();
		Finanzen.setCaption("FINANZEN");
		Finanzen.setImmediate(false);
		Finanzen.setWidth("100%");
		Finanzen.setHeight("-1px");
		verticalLayout_2.addComponent(Finanzen);
		verticalLayout_2.setComponentAlignment(MedikamentenInfo, new Alignment(20));
		
		
		verticalLayout_1.addComponent(verticalLayout_2 );
		
		return verticalLayout_1;
	}

	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("320px");
		horizontalLayout_1.setHeight("100px");
		horizontalLayout_1.setMargin(false);

		// HomeButton
		HomeButton = new Button();
		HomeButton.setCaption("Button");
		HomeButton.setImmediate(true);
		HomeButton.setWidth("-1px");
		HomeButton.setHeight("-1px");
		horizontalLayout_1.addComponent(HomeButton);
		horizontalLayout_1.setComponentAlignment(HomeButton, new Alignment(48));

		// HelpButton
		HelpButton = new Button();
		HelpButton.setCaption("Button");
		HelpButton.setImmediate(true);
		HelpButton.setDescription(" ? ");
		HelpButton.setWidth("-1px");
		HelpButton.setHeight("22px");
		horizontalLayout_1.addComponent(HelpButton);
		horizontalLayout_1.setComponentAlignment(HelpButton, new Alignment(48));

		return horizontalLayout_1;

	}

}

/*
 * layout.setMargin(true); layout.addComponent(new Label("Home")); Button button
 * = new Button("Go to Login"); button.addClickListener(new
 * Button.ClickListener() { public void buttonClick(ClickEvent event) {
 * layout.addComponent(new Label("test"));
 * NavigatorUI.getNavi().navigateTo(NavigatorUI.LOGINVIEW);
 */
