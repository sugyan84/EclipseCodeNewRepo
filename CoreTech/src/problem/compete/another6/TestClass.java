package problem.compete.another6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class TestClass
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//Scanner s = new Scanner(System.in);

		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; i++)
		{
			Team.indexStatic =1;
			
			String[] split = br.readLine().split(" ");

			int n = Integer.parseInt(split[0]);

			String targetString = split[1];

			List<Team> l = new ArrayList<Team>(n);

			for(int j = 0; j < n; j++)
			{
				l.add(new Team(br.readLine().trim()));
			}

			// TargetStr
			char[] targetStrChar = targetString.toCharArray();
			HashMap<Character, Integer> mTarget = new HashMap();

			for(char x : targetStrChar)
			{
				if(mTarget.containsKey(x))
				{
					mTarget.put(x, mTarget.get(x) + 1);
				}
				else
				{
					mTarget.put(x, 1);
				}
			}

			// each team
			Iterator itr = l.iterator();

			while (itr.hasNext())
			{
				Team temp = (Team) itr.next();

				HashMap tempM = temp.m;

				Iterator itrM = tempM.entrySet().iterator();

				while (itrM.hasNext())
				{
					Map.Entry me = (Map.Entry) itrM.next();
					
					char key = (Character) me.getKey();
					int val = (Integer) me.getValue();
					
					if(mTarget.containsKey(key))
					{
						int calculatedScore = val * mTarget.get(key);
						
						temp.score = temp.score + calculatedScore;

					}
				}
			}
			
			Collections.sort(l);
			
			System.out.println(l.get(0).index);
			
			
			
			/*Iterator itr2 = l.iterator();

			while (itr2.hasNext())
			{
				Team temp = (Team) itr2.next();

				System.out.println(temp.str+" ---> "+temp.score);
				
				System.out.println("");
			}*/

		}

	}
}

class Team implements Comparable
{
	String						str;

	static int indexStatic =1;
	int							teamSize;

	int							score;
	
	int index=0;

	HashMap<Character, Integer>	m	= new HashMap();

	public Team(String str)
	{
		this.str = str;

		this.index = indexStatic;
		indexStatic++;
		this.teamSize = this.str.length();

		this.score = 0;

		char[] chr = str.toCharArray();

		for(char x : chr)
		{
			if(m.containsKey(x))
			{
				m.put(x, m.get(x) + 1);
			}
			else
			{
				m.put(x, 1);
			}
		}

	}

	@Override
	public int compareTo(Object paramT)
	{
		int retVal =0;
		
		Team t = (Team) paramT;
		
		if(this.score < t.score)
		{
			retVal = 1;
		}
		
		else if(this.score > t.score)
		{
			retVal = -1;
		}
		else if(this.score == t.score)
		{
			if(this.teamSize < t.teamSize)
			{
				retVal = -1;
			}
			
			else if(this.teamSize > t.teamSize)
			{
				retVal = 1;
			}else if(this.teamSize == t.teamSize)
			{
				//
				if(this.index < t.index)
				{
					retVal = -1;
				}
				
				else if(this.index > t.index)
				{
					retVal = 1;
				}else if(this.index == t.index)
				{
					retVal = 0;
				}
			}
		}
		
		return retVal;
	}
}