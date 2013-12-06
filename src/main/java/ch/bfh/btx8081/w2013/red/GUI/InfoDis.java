package ch.bfh.btx8081.w2013.red.GUI;

import java.beans.DesignMode;

import ch.bfh.btx8081.w2013.red.Controller.NavigatorUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ChameleonTheme;
import com.vaadin.ui.themes.Reindeer;

public class InfoDis extends VerticalLayout implements View {
	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout upperVerticalLayout;
	private HorizontalLayout lowerHorizontalLayout;
	private MhcGuidDesign design;
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
			
		TextArea area = new TextArea("Krankheitsbild");
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
		design.setTitleLabel("Disease");
	}
	private void editLowerHorizontalLayout()
	{
		
		Button commentLink = new Button("comment");
			commentLink.setStyleName(ChameleonTheme.BUTTON_LINK);
			commentLink.addClickListener(new Button.ClickListener() 
			{
	            public void buttonClick(ClickEvent event) {
	            	//NavigatorUI.navigateTo(NavigatorUI.COMMENTVIEW);
	            }
	        });
		
		Button returnButton = new Button("back");
        	returnButton.addClickListener(new Button.ClickListener() 
        	{
        		public void buttonClick(ClickEvent event) {
        			//NavigatorUI.navigateTo(NavigatorUI.SEARCHDISVIEW);
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

}
