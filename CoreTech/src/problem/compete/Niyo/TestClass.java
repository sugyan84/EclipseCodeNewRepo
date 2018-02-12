package problem.compete.Niyo;

import java.util.*;
import java.io.*;


class TestClass 
{
	static Map<String, List<PriceRating>> shop = new HashMap<>();
	
    public static void main(String args[] ) throws Exception 
    {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

        //Scanner s = new Scanner(System.in);
        
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++)
        {
        	 String str =  br.readLine().trim();
        	
        	 String[] strSplit = str.split(" ");
        	 
        	String OSRead = strSplit[0];
        	int RAMRead = Integer.parseInt(strSplit[1]);
        	int MRead = Integer.parseInt(strSplit[2]);
        	int PriceRead = Integer.parseInt(strSplit[3]);
        	int ratingRead = Integer.parseInt(strSplit[4]);
        	
        	//Phone p = new Phone(OSRead, RAMRead, MRead, PriceRead, ratingRead);
        	
        	String key = OSRead+RAMRead+MRead;
        	
        	PriceRating pr = new PriceRating(PriceRead, ratingRead);
        	
        	if(shop.containsKey(key))
        	{
        		List fetchedList = shop.get(key);
        		fetchedList.add(pr);
        		shop.put(key, fetchedList);
        	}
        	else
        	{
        		List newList = new LinkedList();
        		newList.add(pr);
        		shop.put(key, newList);
        	}
        }
        
        //System.out.println("Total phones is shop: "+shop.size());
       
        int Q = Integer.parseInt(br.readLine());
        
        for(int j=0; j<Q; j++)
        {
        	String str2 =  br.readLine();
        	//System.out.println(str2);
       	 String[] strSplit2 = str2.split(" ");
       	 
        	
        	String OSReadQuery = strSplit2[0];
        	int RAMReadQuery = Integer.parseInt(strSplit2[1]);
        	int MReadQuery = Integer.parseInt(strSplit2[2]);
        	int PriceReadQuery = Integer.parseInt(strSplit2[3]);
        	        	
        	//Phone pQuery = new Phone(OSReadQuery, RAMReadQuery, MReadQuery, PriceReadQuery, -1);
        	
        	String key = OSReadQuery+RAMReadQuery+MReadQuery;
        	
        	
        	
        	if(shop.containsKey(key)) 
        	{
        		//System.out.println("contains.");
        		
        		List fetchedQueryList2 = shop.get(key);
        		
        		Collections.sort(fetchedQueryList2, new MyComparatorRate());
        		
        		PriceRating ans = (PriceRating) fetchedQueryList2.get(0);
        		
        		System.out.println(ans.rating);
        		
        	}
        	else
        	{
        		System.out.println(-1);
        	}
        }

    }
}


class MyComparatorRate implements Comparator<PriceRating>
{

	@Override
	public int compare(PriceRating one, PriceRating two)
	{
		Integer oneR = one.getRating();
		Integer twoR = two.getRating();
		
		return (twoR.compareTo(oneR));
	}
	
}

