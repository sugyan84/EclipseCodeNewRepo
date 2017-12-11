package problem.UbonaOnline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class Solution
{

	public static int process(String s)
	{
		int retValue = 1;

		HashSet<Character> set = new HashSet<Character>();

		Set<StringBuffer> l = new HashSet<StringBuffer>();
		
		Set<StringBuffer> lRemoveList = new HashSet<StringBuffer>();

		int lastUnderScoreIndex = -1;

		for(int i = 0; i < s.length(); i++)
		{
			if(isVowel(s.charAt(i)))
			{
				set.add(s.charAt(i));
			}

			if(s.charAt(i) == '_')
			{
				if(l.size() == 0)
				{
					lastUnderScoreIndex = i;

					String permanentStr = s.substring(0, i);

					Iterator itr = set.iterator();

					while (itr.hasNext())
					{
						StringBuffer sb = new StringBuffer(permanentStr);

						sb.append(itr.next());

						l.add(sb);

					}
				}else
				/// ---

				if(l.size() > 0)
				{
					// elements there

					// lastUnderScoreIndex = i;

					String permanentStr2 = s.substring(lastUnderScoreIndex + 1, i); // ae

					Iterator itrList = l.iterator();

					while (itrList.hasNext())
					{
						// appending ae
						StringBuffer ss = (StringBuffer) itrList.next();

						ss.append(permanentStr2);

						// abua-ae
						

						Iterator itr3 = set.iterator();

						while (itr3.hasNext())
						{
							StringBuffer sb = new StringBuffer(ss);

							sb.append(itr3.next());

							l.add(sb);

						}
					}

				}
				
				
				
				lastUnderScoreIndex = i;
				set.clear();

			}
		}

		//l.removeAll(lRemoveList);
		
		retValue = l.size();
		
		if(retValue==0)
			retValue=1;
		
		return retValue;
	}

	public static boolean isVowel(char x)
	{
		boolean retValue = false;

		if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u')
		{
			retValue = true;
		}

		return retValue;

	}

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		// Write your code here
		for(int i = 0; i < T; i++)
		{
			String se = br.readLine().trim();
			
			int x = process(se);
			
			System.out.println(x);
		}

		
	}
}
