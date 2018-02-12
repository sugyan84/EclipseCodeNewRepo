package problem.compete.GS;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MatchEngine
{
	Map<Integer, Order>		allOrders	= new HashMap<Integer, Order>();

	Map<String, Integer>	allSymbols	= new HashMap<String, Integer>();

	public String addOrder(String queryString)
	{
		String retVal = null;
		String[] strSplit = null;

		// N,2,0000002,XYZ,L,B,104.53,100
		try
		{
			strSplit = queryString.split(",");

			// <Order-ID>
			int OID = -1;

			if(Validators.isValidOID(strSplit[1]))
			{
				OID = Integer.parseInt(strSplit[1]);
				
				if(allOrders.containsKey(OID))
				{
					throw new Exception();
				}
			}
			else
				throw new Exception();

			
			
			
			
			// <TimeStamp>
			long timeStamp = 0L;

			if(Validators.isValidTimeStamp(strSplit[2]))
			{
				timeStamp = Integer.parseInt(strSplit[2]);
			}
			else
				throw new Exception();

			
			
			
			
			// <Symbol>
			String symbol = null;

			if(Validators.isValidSymbol(strSplit[3]))
			{
				symbol = strSplit[3];
			}
			else
				throw new Exception();

			
			
			
			// <OrderType>
			OrderType o = null;

			if(Validators.isValidOrderType(strSplit[4]))
			{
				char x = strSplit[4].charAt(0);

				switch (x)
				{
				case 'M':
					o = OrderType.MARKET;
					break;

				case 'L':
					o = OrderType.LIMIT;
					break;
				case 'I':
					o = OrderType.IOC;
					break;
				default:
					break;
				}
			}
			else
				throw new Exception();

			
			
			
			// <OrderSide>
			OrderSide side = null;

			if(Validators.isValidOrderSide(strSplit[5]))
			{
				char x = strSplit[5].charAt(0);

				switch (x)
				{
				case 'B':
					side = OrderSide.BUY;
					break;

				case 'S':
					side = OrderSide.SELL;
					break;
				
				default: throw new Exception();
				}
			}
			else
				throw new Exception();
			
			
			
			
			// <Price>
			float p = 0.0f;
			
			if(Validators.isValidPrice(strSplit[6]))
			{
				p = Float.parseFloat(strSplit[6]);
				
			}
			else
				throw new Exception();
			
			
			
			// <Quatity>
			int q = -1;
			
			if(Validators.isValidPrice(strSplit[7]))
			{
				q =Integer.parseInt(strSplit[7]);
				
			}
			else
				throw new Exception();
			
			
			Order newOrder = new Order(OID, timeStamp, symbol, o, side, p, q);
			
			allOrders.put(OID, newOrder);
			allSymbols.put(newOrder.getSymbol(), OID);
			
			retVal = strSplit[1]+" - Accept";
		}
		catch(Exception ex)
		{
			retVal = strSplit[1] + " - Reject - 303 - Invalid order details";

		}
		finally
		{

		}

		return retVal;
	}

	
	public String amendOrder(String queryString)
	{
		String retVal = null;
		
		String[] strSplit = null;
		Order existingOrder =null;
		
		if(Validators.validateAllDetails(queryString))
		{
			try
			{
				strSplit = queryString.split(",");

				// <Order-ID>
				int OID =  Integer.parseInt(strSplit[1]);				
				
				if(!allOrders.containsKey(OID)) 
					{
						retVal = strSplit[1]+" - AmendReject - 404 - Order does not exist";
						return retVal;
					}
				else
					{
						existingOrder =  allOrders.get(OID);
					}
				
				
				// <TimeStamp>
				long timeStamp = Integer.parseInt(strSplit[2]);
	
				existingOrder.setTimeStamp(timeStamp);
				
				
				// <Symbol>
				String symbol = strSplit[3];
				
				if(!existingOrder.getSymbol().equals(symbol)) throw new Exception();
				
				
				
				// <OrderType>
				OrderType o = null;

				char x = strSplit[4].charAt(0);

					switch (x)
					{
					case 'M':
						o = OrderType.MARKET;
						break;

					case 'L':
						o = OrderType.LIMIT;
						break;
					case 'I':
						o = OrderType.IOC;
						break;
					default:
						break;
					}
				
					if(existingOrder.getOrderType()!=o) throw new Exception();
				
				
				
				// <OrderSide>
				OrderSide side = null;

					char f = strSplit[5].charAt(0);

					switch (f)
					{
					case 'B':
						side = OrderSide.BUY;
						break;

					case 'S':
						side = OrderSide.SELL;
						break;
					
					default: throw new Exception();
					}
				
					if(existingOrder.getOrderSide()!=side) throw new Exception();
				
				
				
				// <Price>
				float p = Float.parseFloat(strSplit[6]);
				
				existingOrder.setPrice(p);
				
								
				
				// <Quatity>
				int q = Integer.parseInt(strSplit[7]);
				
				if(existingOrder.getQuantity()< q /*|| existingOrder.getQuantity()== q*/) throw new Exception();
				
				existingOrder.setQuantity(q);
				

				retVal = strSplit[1]+" - AmendAccept";
			}
			catch(Exception ex)
			{
				retVal = strSplit[1]+" - AmendReject - 101 - Invalid amendment details";

			}
		}
		
		
		return retVal;
	}


	public String cancelOrder(String queryString)
	{
		String retVal = null;
		String[] strSplit = null;
		
		try
		{
			if(Validators.validateAllDetails(queryString))
			{
				strSplit = queryString.split(",");
				
				int OID =  Integer.parseInt(strSplit[1]);
				
				if(allOrders.containsKey(OID))
				{
					allOrders.remove(OID);
					retVal = OID+" - CancelAccept";
					return retVal;
				}
			}
			else
			{
				throw new Exception();
			}
			
		}catch(Exception e)
		{
			retVal = strSplit[1]+" – CancelReject - 404 - Order does not exist";
		}
		
		return retVal;
	}

	
}
