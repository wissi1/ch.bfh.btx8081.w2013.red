package ch.bfh.btx8081.w2013.red.GUI;

import ch.bfh.btx8081.w2013.red.Controller.NavigatorUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class Comment extends VerticalLayout implements View {
	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout upperVerticalLayout;
	private HorizontalLayout lowerHorizontalLayout;
	MhcGuidDesign design;
	public Comment()
	{
		design = new MhcGuidDesign(this);
		this.layout = design.getLayout();
		this.mainLayout = design.getMainLayout();
		this.upperVerticalLayout = design.getUpperVerticalLayout();
		this.lowerHorizontalLayout = design.getLowerHorizontalLayout();
	}
	private void createLayout()
	{
		layout.setMargin(true);
		layout.addComponent(new Label("Comment"));
		Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));             
            }
        });
        layout.addComponent(button);
	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
