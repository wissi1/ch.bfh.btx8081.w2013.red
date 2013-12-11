package ch.bfh.btx8081.w2013.red.GUI;

import ch.bfh.btx8081.w2013.red.Controller.IState;
import ch.bfh.btx8081.w2013.red.Controller.NavigatorUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

/**
 * 
 * @author pzehnder
 *
 */

public class SearchDis extends VerticalLayout implements View, IState {
	
	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout upperVerticalLayout;
	private HorizontalLayout lowerHorizontalLayout;
	MhcGuidDesign design;
	
	public SearchDis()
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
		
		ComboBox comboBox_1 = new ComboBox("Disease");
		
		mainLayout.addComponent(comboBox_1, "top:120.0px;left:30.0px;");
		
		ComboBox comboBox_2 = new ComboBox("Symptom 1");
		
		mainLayout.addComponent(comboBox_2, "top:180.0px;left:30.0px;");
		
		ComboBox comboBox_3 = new ComboBox("Symptom 2");
		
		mainLayout.addComponent(comboBox_3, "top:240.0px;left:30.0px;");
		
		ComboBox comboBox_4 = new ComboBox("Symptom 3");
		
		mainLayout.addComponent(comboBox_4, "top:300.0px;left:30.0px;");
	
	}
	private void editUpperVerticalLayout()
	{
		design.setTitleLabel("Diseases");
	}
	
	private void editLowerHorizontalLayout()
	{
		
	
		Button backButton = new Button();
		backButton.setCaption("Search");
		backButton.setWidth("80px");
		backButton.addClickListener(new Button.ClickListener() 
    	{
    		public void buttonClick(ClickEvent event) {
    			handleB2();
    		}
    	});
		
		
		Button returnToMainButton = new Button();
		returnToMainButton.setCaption("Main");
		returnToMainButton.setWidth("80px");
		returnToMainButton.addClickListener(new Button.ClickListener() 
    	{
    		public void buttonClick(ClickEvent event) {
    			handleB1();
    		}
    	});
		
		
        lowerHorizontalLayout.addComponent(backButton);
        lowerHorizontalLayout.setComponentAlignment(backButton, Alignment.MIDDLE_LEFT);
        lowerHorizontalLayout.addComponent(returnToMainButton);
        lowerHorizontalLayout.setComponentAlignment(returnToMainButton, Alignment.MIDDLE_RIGHT);
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
		NavigatorUI.navigateTo(NavigatorUI.INFODISVIEW);
	}

	@Override
	public void handleB3() {
		// TODO Auto-generated method stub
		
	}

}