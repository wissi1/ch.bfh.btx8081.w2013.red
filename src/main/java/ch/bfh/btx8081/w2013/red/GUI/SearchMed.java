/**
 * 
 * @author sians1
 * 
 * */

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
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ChameleonTheme;

public class SearchMed extends VerticalLayout implements View, IState {
	
	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout upperVerticalLayout;
	private HorizontalLayout lowerHorizontalLayout;
	private ComboBox comboBox_MediName;
	private ComboBox comboBox_MediArt;
	private Label label_MediName;
	private Label label_MediArt;
	MhcGuidDesign design;
	
        public SearchMed()
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
        
        private void editUpperVerticalLayout()
    	{
    		design.setTitleLabel("Medication");
    	}
   
  //      
    	private void editMainLayout()
    	{		
    		label_MediName = new Label();
    		label_MediName.setValue("Medication / Active substance");
    		mainLayout.addComponent(label_MediName, "top:120.0px;left:30.0px;");
    		
    		comboBox_MediName = new ComboBox();
    		mainLayout.addComponent(comboBox_MediName, "top:140.0px;left:30.0px;");
    		
    		label_MediArt = new Label();
    		label_MediArt.setValue("Type of medication ");
    		mainLayout.addComponent(label_MediArt, "top:170.0px;left:30.0px;");
    		
    		comboBox_MediArt= new ComboBox();
    		mainLayout.addComponent(comboBox_MediArt, "top:190.0px;left:30.0px;");
    	
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