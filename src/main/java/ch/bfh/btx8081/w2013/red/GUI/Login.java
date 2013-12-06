package ch.bfh.btx8081.w2013.red.GUI;

import ch.bfh.btx8081.w2013.red.Controller.NavigatorUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class Login extends VerticalLayout implements View {
	final VerticalLayout layout;
	public Login()
	{
		this.layout = this;
		createLayout();
	}
	private void createLayout()
	{
		layout.setMargin(true);
		layout.addComponent(new Label("Login"));
		Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
                NavigatorUI.navigateTo(NavigatorUI.HOMEVIEW);
                
            }
        });
        layout.addComponent(button);
	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
