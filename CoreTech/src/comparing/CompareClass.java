package comparing;

import java.util.Comparator;

public class CompareClass implements Comparator<Country>
{

	@Override
	public int compare(Country o1, Country o2)
	{
		int a=0;
		
		if(o1.gold > o2.gold)
		{
			a=1;
		}
		else if(o1.gold < o2.gold)
			a=-1;
		else if(o1.gold == o2.gold)
		{
			if(o1.silver > o2.silver)
				a=1;
			else if(o1.silver < o2.silver)
				a=-1;
			else if(o1.silver == o2.silver)
			{
				if(o1.bronze > o2.bronze)
					a=1;
				else if(o1.bronze < o2.bronze)
					a=-1;
				else
					a=0;
			}
		}
			
		
		return a;
	}
	

}
