package problem.compete.GS;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class MatchingEngine
{

	/*
	 * Complete the function below.
	 */
	static String[] processQueries(String[] queries)
	{
		List<String> retStrArray = new LinkedList<>();
		
		MatchEngine engine = new MatchEngine();

		// Write your code here.
		for(String str: queries)
		{
			char action = str.charAt(0);
			
			switch (action)
			{
			case 'N':	//New Order
				retStrArray.add(engine.addOrder(str));
				break;
						
			case 'A':	//Amend or update	
				retStrArray.add(engine.amendOrder(str));
				break;
				
			case 'X':	//Cancel	
				retStrArray.add(engine.cancelOrder(str));
				break;
				
			case 'M':	//Match	
				break;
				
			case 'Q':	//Query		
				break;

			default:
				break;
			}
		}
		
		String[] retVal = new String[retStrArray.size()];
		int i=0;
		for(String w: retStrArray)
		{
			retVal[i++] = w;
		}
		return retVal;
	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException
	{
		/*BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		
		if(bw == null)
		{
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}*/

		int queriesSize = Integer.parseInt(scan.nextLine().trim());

		String[] queries = new String[queriesSize];

		for (int queriesItr = 0; queriesItr < queriesSize; queriesItr++)
		{
			String queriesItem = scan.nextLine();
			queries[queriesItr] = queriesItem;

		}

		String[] response = processQueries(queries);

		/*for (int responseItr = 0; responseItr < response.length; responseItr++)
		{
			bw.write(response[responseItr]);

			if(responseItr != response.length - 1)
			{
				bw.write("\n");
			}
		}

		bw.newLine();

		bw.close();*/
		
		
		for(String p: response)
		{
			System.out.println(p);
		}
	}
}
