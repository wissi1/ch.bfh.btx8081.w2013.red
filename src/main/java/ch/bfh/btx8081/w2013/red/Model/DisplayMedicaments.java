package ch.bfh.btx8081.w2013.red.Model;

import java.util.ArrayList;
import java.util.Map;

import ch.bfh.btx8081.w2013.red.Database.Data;
import ch.bfh.btx8081.w2013.red.Database.Drug;

public class DisplayMedicaments {

	public static ArrayList<String> displayMedication()
	{
		ArrayList<String> medicaments = new ArrayList<String>();
		for(Map.Entry<String, Drug> medicament : Data.getDrugs().entrySet() )
		{
				medicaments.add(medicament.getKey());
		}
		return medicaments;
	}
	
	public static ArrayList<String> displayType()
	{
		ArrayList<String> types = new ArrayList<String>();
		for(Map.Entry<String, Drug> type : Data.getDrugs().entrySet() )
		{
				types.add(type.getValue().getTypes());	
		}
		return types;
	}
}
