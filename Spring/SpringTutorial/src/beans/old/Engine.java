package beans.old;

public class Engine
{
	String	modelno;

	public Engine()
	{
	}

	public Engine(String m)
	{
		this.modelno = m;
	}

	public String getModelno()
	{
		return modelno;
	}

	public void setModelno(String modelno)
	{
		this.modelno = modelno;
	}

	@Override
	public String toString()
	{
		String s = this.getModelno();

		if((s == null))
			System.out.println("Engine [modelno is unavailable]");
		else
			System.out.println("Engine [modelno=" + getModelno() + "]");
		return "";
	}

}
