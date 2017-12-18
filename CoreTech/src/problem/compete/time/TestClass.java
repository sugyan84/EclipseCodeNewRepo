package problem.compete.time;

import java.util.*;
import java.io.*;

class TestClass
{
	public static void main(String args[]) throws Exception
	{
		boolean[] arr = new boolean[1440];

		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = false;
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//Scanner s = new Scanner(System.in);

		int T = Integer.parseInt(br.readLine());

		boolean isNeeded = false;
		
		for(int i = 0; i < T; i++)
		{
			String[] strSplit = br.readLine().trim().split("-");

			String[] startTime = strSplit[0].split(":");
			String[] endTime = strSplit[1].split(":");

			int startTimeHH = Integer.parseInt(startTime[0]);
			//System.out.println(startTimeHH);

			int endTimeHH = Integer.parseInt(startTime[1]);

			
			int startENDTimeHH = Integer.parseInt(endTime[0]);

			int endENDTimeHH = Integer.parseInt(endTime[1]);

			// Start Mins
			int startMins = (startTimeHH * 60 + endTimeHH)-1;
			
			
			//End Mins
			int endMins = (startENDTimeHH * 60 + endENDTimeHH)-1;
			
			//System.out.println(startMins+"---"+endMins);
			
			for(int j=startMins; j<=endMins; j++)
			{
				if(arr[j]==true)
				{
					isNeeded = true;
					break;
				}else
				{
					arr[j] = true;
				}
			}	
		}
		
		if(isNeeded)
		{
			System.out.println("Will need a moderator!");
			//break;
		}
		else
		{
			System.out.println("Who needs a moderator?");
			//break;
		}

	}
}
