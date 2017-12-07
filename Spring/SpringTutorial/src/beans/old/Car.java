package beans.old;

public class Car
{
	public Engine e;
	
	String carName;
	
	public Car(){}
	
	public Car(Engine e)
	{
		this.e=e;
	}
	
	public Car(String c)
	{
		this.carName=c;
	}
	
	public Car(String c, Engine e)
	{
		this.e=e;
		this.carName=c;
	}

	public Engine getE()
	{
		return e;
	}

	public void setE(Engine e)
	{
		this.e = e;
	}

	public String getCarName()
	{
		return carName;
	}

	public void setCarName(String carName)
	{
		this.carName = carName;
	}

	@Override
	public String toString()
	{
		System.out.println("Car [" + "" + "getCarName()=" + getCarName() + "]");
		return "";
	}
	
	
}
