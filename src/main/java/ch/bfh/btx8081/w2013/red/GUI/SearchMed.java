package ch.bfh.btx8081.w2013.red.GUI;

import ch.bfh.btx8081.w2013.red.Controller.IState;
import ch.bfh.btx8081.w2013.red.Controller.NavigatorUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ChameleonTheme;

public class SearchMed extends VerticalLayout implements View, IState {
	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout upperVerticalLayout;
	private HorizontalLayout lowerHorizontalLayout;
	private MhcGuidDesign design;
	public SearchMed()
	{
		design = new MhcGuidDesign(this);
		this.layout = design.getLayout();
		this.mainLayout = design.getMainLayout();
		this.upperVerticalLayout = design.getUpperVerticalLayout();
		this.lowerHorizontalLayout = design.getLowerHorizontalLayout();
		editLowerHorizontalLayout();
	}
	private void editLowerHorizontalLayout()
	{
		Button searchButton = new Button("serach");
		searchButton.addClickListener(new Button.ClickListener() 
		{
            public void buttonClick(ClickEvent event) {
            	handleB1();
            }
        });
		
		Button mainButton = new Button("main");
		mainButton.addClickListener(new Button.ClickListener() 
		{
            public void buttonClick(ClickEvent event) {
            	handleB2();
            }
        });
		
		lowerHorizontalLayout.addComponent(searchButton);
		lowerHorizontalLayout.setComponentAlignment(searchButton, Alignment.MIDDLE_LEFT);
		lowerHorizontalLayout.addComponent(mainButton);
		lowerHorizontalLayout.setComponentAlignment(mainButton, Alignment.MIDDLE_RIGHT);
	}
	@Override
	public void enter(ViewChangeEvent event) {
	
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleB1() {
		NavigatorUI.navigateTo(NavigatorUI.INFOMEDVIEW);
	}
	@Override
	public void handleB2() {
		NavigatorUI.navigateTo(NavigatorUI.HOMEVIEW);	
	}
	@Override
	public void handleB3() {
		// TODO Auto-generated method stub
		
	}

}
