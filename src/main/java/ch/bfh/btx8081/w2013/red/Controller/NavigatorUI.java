package ch.bfh.btx8081.w2013.red.Controller;


import javax.servlet.annotation.WebServlet;

import ch.bfh.btx8081.w2013.red.Database.Data;
import ch.bfh.btx8081.w2013.red.GUI.Comment;
import ch.bfh.btx8081.w2013.red.GUI.Home;
import ch.bfh.btx8081.w2013.red.GUI.InfoDis;
import ch.bfh.btx8081.w2013.red.GUI.InfoMed;
import ch.bfh.btx8081.w2013.red.GUI.Init;
import ch.bfh.btx8081.w2013.red.GUI.Login;
import ch.bfh.btx8081.w2013.red.GUI.SearchDis;
import ch.bfh.btx8081.w2013.red.GUI.SearchMed;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Theme("redtheme")
@SuppressWarnings("serial")
public class NavigatorUI extends UI
{
	public static final String HOMEVIEW = "home";
	public static final String LOGINVIEW = "login";
	public static final String COMMENTVIEW = "Comment";
	public static final String INFODISVIEW = "infoDis";
	public static final String INFOMEDVIEW = "infoMed";
	public static final String SEARCHDISVIEW = "searchDis";
	public static final String SEARCHMEDVIEW = "searchMed";
	private static Navigator navigator;
	private static String previousView;
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = NavigatorUI.class, widgetset = "ch.bfh.btx8081.w2013.red.GUI.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }
    @Override
    protected void init(VaadinRequest request) 
    {
    	Data.loadComments();
		Data.loadDiseases();
		Data.loadDrugs();
		Data.loadUsers();
    	navigator = new Navigator(this, this);
    	navigator.addView("", new Init());
        navigator.addView(LOGINVIEW, new Login());
        navigator.addView(HOMEVIEW, new Home());
        navigator.addView(COMMENTVIEW, new Comment());
        navigator.addView(INFODISVIEW, new InfoDis());
        navigator.addView(INFOMEDVIEW, new InfoMed());
        navigator.addView(SEARCHDISVIEW, new SearchDis());
        navigator.addView(SEARCHMEDVIEW, new SearchMed());
        
    }
    /**
     * 
     * @param view
     * 
     */
    public static void navigateTo(String view)
    {
    previousView = navigator.getState();
    navigator.navigateTo(view);
    }
    /**
     * 
     * @return
     */
    public static String getPreviousView()
    {
		return previousView;
    }
    

}
