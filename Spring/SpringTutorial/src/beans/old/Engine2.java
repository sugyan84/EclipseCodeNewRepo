package beans.old;

public class Engine2
{
	private String modelYear;

	public String getModelYear()
	{
		return modelYear;
	}

	public void setModelYear(String modelYear)
	{
		this.modelYear = modelYear;
	}

	@Override
	public String toString()
	{
		return this.getModelYear();
	}
	
	
	
	
}
