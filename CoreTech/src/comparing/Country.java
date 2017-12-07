package comparing;

public class Country implements Comparable<Country>
{
	int		gold;
	int		silver;
	int		bronze;
	String	name;

	public Country(String n, int gold, int silver, int bronze)
	{
		this.name = n;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
	
	public Country(String n)
	{
		this.name = n;
	}

	public int getGold()
	{
		return gold;
	}

	public void setGold(int gold)
	{
		this.gold = gold;
	}

	public int getSilver()
	{
		return silver;
	}

	public void setSilver(int silver)
	{
		this.silver = silver;
	}

	public int getBronze()
	{
		return bronze;
	}

	public void setBronze(int bronze)
	{
		this.bronze = bronze;
	}

	@Override
	public String toString()
	{
		return this.name + " [" + gold + ", " + silver + ", " + bronze + "]";
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		Country o=(Country)obj;
		int a=this.name.compareToIgnoreCase(o.name);
		if(a==0)
			return true;
		else
			return false;
	}

	@Override
	public int compareTo(Country o)
	{
		
		int a=this.name.compareToIgnoreCase(o.name);
		
			return a;
	}

}
