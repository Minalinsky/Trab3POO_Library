package library;

public class Ban
{
	private String rg;
	private String bannedDate;
	
	public String getRg() {
		return rg;
	}
	
	public String getDate() {
		return bannedDate;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public void setBannedDate(String date) {
		this.bannedDate = date;
	}
}
