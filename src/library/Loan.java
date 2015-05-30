package library;

public class Loan 
{
	private String rg;
	private String title;
	private String returnDate;
	private String ok;
	
	public String getReturnDate()
	{
		return returnDate;
	}
	public String getTitle()
	{
		return title;
	}
	
	public String getRg()
	{
		return rg;
	}
	
	public String getOk()
	{
		return ok;
	}
	
	public void setReturnDate(String n)
	{
		returnDate = n;
	}
	
	public void setRg(String r)
	{
		rg = r;
	}
	
	public void setTitle(String t)
	{
		title = t;
	}
	
	public void setOk(String o)
	{
		ok = o;
	}
}
