package problem.compete.GS;

public class Order
{
	int			orderId;
	long		timeStamp;
	String		symbol;
	OrderType	orderType;
	OrderSide	orderSide;
	float		price;
	int			quantity;
	OrderStatus	status;

	public Order(int orderId, long timeStamp, String symbol, OrderType orderType, OrderSide orderSide, float price,
			int quantity)
	{
		this.orderId = orderId;
		this.timeStamp = timeStamp;
		this.symbol = symbol;
		this.orderType = orderType;
		this.orderSide = orderSide;
		this.price = price;
		this.quantity = quantity;
		this.status = OrderStatus.NEW;
	}

	public int getOrderId()
	{
		return orderId;
	}

	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}

	public long getTimeStamp()
	{
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp)
	{
		this.timeStamp = timeStamp;
	}

	public String getSymbol()
	{
		return symbol;
	}

	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}

	public OrderType getOrderType()
	{
		return orderType;
	}

	public void setOrderType(OrderType orderType)
	{
		this.orderType = orderType;
	}

	public OrderSide getOrderSide()
	{
		return orderSide;
	}

	public void setOrderSide(OrderSide orderSide)
	{
		this.orderSide = orderSide;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public OrderStatus getStatus()
	{
		return status;
	}

	public void setStatus(OrderStatus status)
	{
		this.status = status;
	}

	@Override
	public boolean equals(Object obj)
	{
		boolean retVal = false;

		if(!(obj instanceof Order))
		{
			retVal = false;
		}

		Order otherOrder = (Order) obj;

		if(this.orderId == otherOrder.orderId)
		{
			retVal = true;
		}

		return retVal;
	}

	@Override
	public int hashCode()
	{
		int x = Integer.hashCode(this.orderId) + this.orderType.hashCode() + this.orderSide.hashCode();

		return x;
	}
	

	@Override
	public String toString()
	{
		
		return this.orderId+", "+this.symbol+", "+this.orderType+", "+this.orderSide+", "+this.quantity+", "+this.price;
	}

}
