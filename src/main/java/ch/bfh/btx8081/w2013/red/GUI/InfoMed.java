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
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ChameleonTheme;
import com.vaadin.ui.themes.Reindeer;

public class InfoMed extends VerticalLayout implements View, IState {
	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout upperVerticalLayout;
	private HorizontalLayout lowerHorizontalLayout;
	private MhcGuidDesign design;
	public InfoMed()
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
	private void editMainLayout()
	{		
		VerticalLayout midLayout = new VerticalLayout();
			midLayout.setHeight("300px");
			midLayout.setWidth("260px");
			
		VerticalLayout areaLayout = new VerticalLayout();
			areaLayout.setHeight("270px");
			areaLayout.setWidth("260px");
			
		
		HorizontalLayout tabLayout = new HorizontalLayout();
			tabLayout.setHeight("30px");
			tabLayout.setWidth("260px");
			
			midLayout.addComponent(areaLayout);
			midLayout.addComponent(tabLayout);
			midLayout.setComponentAlignment(tabLayout, Alignment.BOTTOM_CENTER);
			
		TextArea area = new TextArea("Indikation");
		area.setHeight("100%");
		area.setWidth("260px");
		
			areaLayout.addComponent(area);
			
		Button b1 = new Button("tab1");
		b1.setSizeFull();
		Button b2 = new Button("tab2");
		b2.setSizeFull();
		Button b3 = new Button("tab3");
		b3.setSizeFull();
		
		tabLayout.addComponent(b1);
		tabLayout.addComponent(b2);
		tabLayout.addComponent(b3);
		
		mainLayout.addComponent(midLayout, "top:90px;left:30px");
		
	}
	private void editUpperVerticalLayout()
	{
		design.setTitleLabel("Drug");
	}
	private void editLowerHorizontalLayout()
	{
		
		Button commentLink = new Button("comment ");
			commentLink.setStyleName(ChameleonTheme.BUTTON_LINK);
			commentLink.addClickListener(new Button.ClickListener() 
			{
	            public void buttonClick(ClickEvent event) {
	            	handleB1();
	            }
	        });
		
		Button returnButton = new Button("back");
        	returnButton.addClickListener(new Button.ClickListener() 
        	{
        		public void buttonClick(ClickEvent event) {
        			handleB2();
        		}
        	});
		
		
        	lowerHorizontalLayout.addComponent(commentLink);
            lowerHorizontalLayout.setComponentAlignment(commentLink, Alignment.MIDDLE_LEFT);
            lowerHorizontalLayout.addComponent(returnButton);
            lowerHorizontalLayout.setComponentAlignment(returnButton, Alignment.MIDDLE_RIGHT);
	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleB1() {
		NavigatorUI.navigateTo(NavigatorUI.COMMENTVIEW);
	}
	@Override
	public void handleB2() {
		NavigatorUI.navigateTo(NavigatorUI.SEARCHMEDVIEW);
	}
	@Override
	public void handleB3() {
		// TODO Auto-generated method stub
		
	}

}
