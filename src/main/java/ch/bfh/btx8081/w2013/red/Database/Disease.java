package ch.bfh.btx8081.w2013.red.Database;

import java.util.ArrayList;

public class Disease {
	private String name;
	private String cause;
	private String treatment;
	private ArrayList<String> symptoms;
	private ArrayList<String> drugs;
	
	public Disease(String name, String cause, String treatment, ArrayList<String> drugs, ArrayList<String> symptoms)
	{
		 this.name = name;
		 this.cause = cause;
		 this.treatment = treatment;
		 this.drugs = drugs;
		 this.symptoms = symptoms;
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
	public ArrayList<String> getSymtoms()
	{
		return symptoms;
	}

}
