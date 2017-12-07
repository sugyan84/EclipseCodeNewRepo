package beans.old;

public class Car2
{
	public String	carName;
	public Engine2	engine;

	public Car2()
	{
		System.out.println("default Car2 constructor");
	}

	public Car2(String c)
	{
		System.out.println("carName Car2 constructor");
		this.carName = c;
	}

	public Car2(Engine2 e)
	{
		System.out.println("Engine Car2 constructor");
		this.engine = e;
	}

	public Car2(String c, Engine2 e)
	{
		System.out.println("carName, Engine Car2 constructor");
		this.carName = c;
		this.engine = e;
	}

	public String getCarName()
	{
		return carName;
	}

	public void setCarName(String carName)
	{
		this.carName = carName;
	}

	public Engine2 getEngine()
	{
		return engine;
	}

	public void setEngine(Engine2 engine)
	{
		this.engine = engine;
	}
	
	public void printCarDetails()
	{
		System.out.println("Car ["+this.getCarName()+" "+this.getEngine().toString()+"]");
	}

}
