package ch.bfh.btx8081.w2013.red.Database;

import java.util.ArrayList;

public class Drug {
private String name;
private String indication;
private String effect;
private String sideEffect;
private ArrayList<String> types;

public Drug(String name, String indication, String effect, String sideEffect, ArrayList<String> types)
{
	this.name = name;
	this.indication = indication;
	this.effect = effect;
	this.sideEffect = sideEffect;
	this.types = types;
}
public String getName()
{
	return name;
}
public String getIndication()
{
	return indication;
}
public String getEffcet()
{
	return effect;
}
public String getSideEffect()
{
	return sideEffect;
}
public ArrayList<String> getTypes()
{
	return types;
}
}
