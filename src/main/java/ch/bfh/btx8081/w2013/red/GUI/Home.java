package ch.bfh.btx8081.w2013.red.GUI;

import ch.bfh.btx8081.w2013.red.Controller.IState;
import ch.bfh.btx8081.w2013.red.Controller.NavigatorUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.BaseTheme;

/**
 * 
 * 
 * 
 * The home class creates a view in which a user can select one of four main
 * views and navigate through the application. It provides a menu with four
 * selectable buttons. It also provides a logout buttons to log out and to
 * navigate back to the last view, in this case it would be the LOGINVIEW.
 * 
 * 
 * @author faton shabanaj
 * @email shabf2@bfh.ch
 * @version.nr V11.12.2013
 * 
 */
public class Home extends VerticalLayout implements View, IState {

	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private HorizontalLayout horizontalLayout_1;
	private Button medicationInfo;
	private Button disease;
	private Button apartmentSearch;
	private Button finances;

	private Button homeButton;
	private GridLayout gridLayout;
	private MhcGuidDesign design;
	private VerticalLayout upperVerticalLayout;

	/**
	 * Constructs a HOMEVIEW on the base of different parameters.
	 * 
	 * @param design
	 *            basic design of the view based on the class MhcGuidDesign
	 * 
	 * @param layout
	 *            basic layout of the view
	 * 
	 * @param mainLayout
	 *            main part of the layout
	 * 
	 * @param verticalLayout
	 *            upper part of the layout
	 * 
	 * @param horizontalLayout
	 *            lower part of the layout
	 * 
	 */

	public Home()

	{
		design = new MhcGuidDesign(this);
		layout = design.getLayout();
		mainLayout = design.getMainLayout();
		horizontalLayout_1 = design.getLowerHorizontalLayout();
		upperVerticalLayout = design.getUpperVerticalLayout();
		buildHorizontalLayout();
		createLayout();
	}

	/**
	 * create a layout and add this new layout at the mainLayout. 
	 * the title of this layout will be defined.
	 */
	private void createLayout() {
		design.setTitleLabel("Home");
		// verticalLayout_1
		gridLayout = buildVerticalLayout();
		mainLayout.addComponent(gridLayout, "top:120.0px;left:30.0px;");
	}

	/**
	 * overridden method of the interface view.
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * Builds the gridlayout and defines the size.
	 * Edits the gridlayout by adding four icons.
	 * to navigate to the different views (medicationInfo, disease,
	 * appartementSearch, finances).
	 */
	private GridLayout buildVerticalLayout() {
		gridLayout = new GridLayout(1, 4);
		gridLayout.setWidth("260px");
		gridLayout.setHeight("260px");

		medicationInfo = new Button("Medication info");
		medicationInfo.setIcon(new ThemeResource("Medication.png"));
		medicationInfo.setStyleName(BaseTheme.BUTTON_LINK);
		medicationInfo.setWidth("100%");
		medicationInfo.setHeight("100%");
		gridLayout.addComponent(medicationInfo);
		//gridLayout.setComponentAlignment(medicationInfo,
			//	Alignment.TOP_LEFT);
		medicationInfo.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				handleB1();
			}
		});

		disease = new Button("Diseases");
		disease.setIcon(new ThemeResource("Disease.png"));
		disease.setStyleName(BaseTheme.BUTTON_LINK);
		disease.setWidth("100%");
		disease.setHeight("100%");
		gridLayout.addComponent(disease);
		//gridLayout.setComponentAlignment(medicationInfo,
			//	Alignment.TOP_RIGHT);
		disease.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				handleB2();
			}
		});
		
		apartmentSearch = new Button("Apartment Search");
		apartmentSearch.setIcon(new ThemeResource("Apartment.png"));
		apartmentSearch.setStyleName(BaseTheme.BUTTON_LINK);
		apartmentSearch.setWidth("100%");
		apartmentSearch.setHeight("100%");
		apartmentSearch.setEnabled(false);
		gridLayout.addComponent(apartmentSearch);
		//gridLayout.setComponentAlignment(medicationInfo,
			//	Alignment.BOTTOM_LEFT);
	
		finances = new Button("Finances");
		finances.setIcon(new ThemeResource("Finances.png"));
		finances.setStyleName(BaseTheme.BUTTON_LINK);
		finances.setWidth("100%");
		finances.setHeight("100%");
		finances.setEnabled(false);
		gridLayout.addComponent(finances);
		//gridLayout.setComponentAlignment(medicationInfo,
			//	Alignment.BOTTOM_RIGHT);

		return gridLayout;
	}
	/**
	 * Builds the HorizontalLayout and defines the size.
	 * Edits the HorizontalLayout by adding a button to log out. 
	 * The button navitagets back to the LOGINVIEW.
	 */
	private void buildHorizontalLayout() {

		homeButton = new Button("Logout");
		homeButton.setWidth("80px");
		homeButton.setHeight("-1px");
		horizontalLayout_1.addComponent(homeButton);
		horizontalLayout_1.setComponentAlignment(homeButton,
				Alignment.MIDDLE_LEFT);
		homeButton.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				handleB3();
			}
		});
	}

	/**
	 * overridden method which navigates to the SEARCHMEDVIEW using methods of
	 * the NavigatorUI class.
	 */
	@Override
	public void handleB1() {
		NavigatorUI.navigateTo(NavigatorUI.SEARCHMEDVIEW);
	}

	/**
	 * overridden method which navigates to the SEARCHDISVIEW using methods of
	 * the NavigatorUI class.
	 */
	@Override
	public void handleB2() {
		NavigatorUI.navigateTo(NavigatorUI.SEARCHDISVIEW);
	}

	/**
	 * overridden method which navigates to the LOGINVIEW using methods of the
	 * NavigatorUI class.
	 */
	@Override
	public void handleB3() {
		NavigatorUI.navigateTo(NavigatorUI.LOGINVIEW);
	}

}
