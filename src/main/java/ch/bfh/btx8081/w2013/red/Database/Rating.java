package ch.bfh.btx8081.w2013.red.Database;

public class Rating {
	public final static boolean POSITIVE = true;
	public final static boolean NEGAITIVE = false;
	private boolean rate;
	private String rateOwner;
	
	public Rating(boolean rate, String rateOwner)
	{
		this.rate = rate;
		this.rateOwner = rateOwner;
	}
	public boolean getRate()
	{
		return rate;
	}
	public String getRateOwner()
	{
		return rateOwner;
	}
}
