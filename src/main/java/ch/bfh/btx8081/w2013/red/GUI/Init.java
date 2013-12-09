package ch.bfh.btx8081.w2013.red.GUI;

import ch.bfh.btx8081.w2013.red.Controller.NavigatorUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class Init extends VerticalLayout implements View {

	@Override
	public void enter(ViewChangeEvent event) 
	{
		NavigatorUI.navigateTo(NavigatorUI.LOGINVIEW);
	}

}
