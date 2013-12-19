package ch.bfh.btx8081.w2013.red.Database;

import java.util.ArrayList;
import java.util.TreeMap;

public class Disease {
	private String name;
	private String cause;
	private String treatment;
	private ArrayList<String> drugs;
	
	public Disease(String name, String cause, String treatment, ArrayList<String> drugs)
	{
		 this.name = name;
		 this.cause = cause;
		 this.treatment = treatment;
		 this.drugs = drugs;
	}
	public String getName()
	{
		return name;
	}
	public String getCause()
	{
		return cause;
	}
	public String getTreatment()
	{
		return treatment;
	}
	public ArrayList<String> getDrugs()
	{
		return drugs;
	}

}
