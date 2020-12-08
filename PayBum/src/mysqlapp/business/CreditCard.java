package mysqlapp.business;

public class CreditCard  {

	private int id;
	private int number;
	private int cvv;
	private int month;
	private int year;
	
	public CreditCard() {}
	
	public CreditCard(int id, int number, int cvv, int month, int year)
	{
		this.id = id;
		this.number = number;
		this.cvv = cvv;
		this.month = month;
		this.year = year;
	}
	
	public CreditCard(int number, int cvv, int month, int year)
	{	
		this.number = number;
		this.cvv = cvv;
		this.month = month;
		this.year = year;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public void setNumber(int number)
	{
		this.number = number;
	}
	
	public int getCvv()
	{
		return cvv;
	}
	
	public void setCvv(int cvv)
	{
		this.cvv = cvv;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public void setMonth(int month)
	{
		this.month = month;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	
	
}
