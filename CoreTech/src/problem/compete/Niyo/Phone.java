package problem.compete.Niyo;

public class Phone
{
	String OS;
	int RAM;
	int memorySize;
	int price;
	int rating;
	public Phone(String oS, int rAM, int memorySize, int price, int rating)
	{
		OS = oS;
		RAM = rAM;
		this.memorySize = memorySize;
		this.price = price;
		this.rating = rating;
	}
	public String getOS()
	{
		return OS;
	}
	public void setOS(String oS)
	{
		OS = oS;
	}
	public int getRAM()
	{
		return RAM;
	}
	public void setRAM(int rAM)
	{
		RAM = rAM;
	}
	public int getMemorySize()
	{
		return memorySize;
	}
	public void setMemorySize(int memorySize)
	{
		this.memorySize = memorySize;
	}
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public int getRating()
	{
		return rating;
	}
	public void setRating(int rating)
	{
		this.rating = rating;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((OS == null) ? 0 : OS.hashCode());
		result = prime * result + RAM;
		result = prime * result + memorySize;
		/*result = prime * result + price;
		result = prime * result + rating;*/
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj) return true;
		if(obj == null) return false;
		
		if(getClass() != obj.getClass()) return false;
		
		Phone other = (Phone) obj;
		
		if(OS == null)
		{
			if(other.OS != null) return false;
		}
		else if(!OS.equals(other.OS)) return false;
		
		if(RAM != other.RAM) return false;
		if(memorySize != other.memorySize) return false;
		if(price != other.price) return false;
		if(rating != other.rating) return false;
		return true;
	}
	@Override
	public String toString()
	{
		return this.OS+", "+this.memorySize+", "+this.RAM;
	}
	
	
}
