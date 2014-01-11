package ch.bfh.btx8081.w2013.red.Model;

import java.util.ArrayList;
import java.util.Map;

import ch.bfh.btx8081.w2013.red.Database.Disease;
import ch.bfh.btx8081.w2013.red.Database.Data;

public class DisplayDiseases {

	public static ArrayList<String> displayDiseases()
	{
		ArrayList<String> diseases = new ArrayList<String>();
		for(Map.Entry<String, Disease> disease : Data.getDiseases().entrySet() )
		{
				diseases.add(disease.getKey());
		}
		return diseases;
	}
	
	public static ArrayList<String> displaySymptoms()
	{
		ArrayList<String> symptoms = new ArrayList<String>();
		for(Map.Entry<String, Disease> symptom : Data.getDiseases().entrySet() )
		{
				symptoms.addAll(symptom.getValue().getSymtoms());
		}
		return symptoms;
	}
}
