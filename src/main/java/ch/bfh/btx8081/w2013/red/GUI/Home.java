package ch.bfh.btx8081.w2013.red.GUI;

import ch.bfh.btx8081.w2013.red.Controller.NavigatorUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class Home extends VerticalLayout implements View {
	final VerticalLayout layout;
	public Home()
	{
		this.layout = this;
		createLayout();
	}
	private void createLayout()
	{
		layout.setMargin(true);
		layout.addComponent(new Label("Home"));
		Button button = new Button("Go to Login");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("test"));
            }
        });
        layout.addComponent(button);
	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
