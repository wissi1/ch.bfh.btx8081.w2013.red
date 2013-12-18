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
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ChameleonTheme;
/**
 * 
 * @author Ivan
 *
 */
public class InfoDis extends VerticalLayout implements View , IState {
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
		
		TabSheet tabSheetDis = new TabSheet();
		tabSheetDis.setWidth("260px");
		tabSheetDis.setHeight("300px");
		tabSheetDis.addTab(new Label("test"), "Symptoms");
		tabSheetDis.addTab(new Label("test1"), "Cause");
		tabSheetDis.addTab(new Label("test2"), "Treatment");
		
		
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
	
	private void editUpperVerticalLayout()
	{
		design.setTitleLabel("Disease");
	}
	
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
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleB1() {
		NavigatorUI.navigateTo(NavigatorUI.HOMEVIEW);
	}

	@Override
	public void handleB2() {
		NavigatorUI.navigateTo(NavigatorUI.SEARCHDISVIEW);
	}

	@Override
	public void handleB3() {
		NavigatorUI.navigateTo(NavigatorUI.COMMENTVIEW);
		
	}

}
