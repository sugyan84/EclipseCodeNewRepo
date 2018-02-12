package problem.compete.Niyo;

public class PriceRating
{
	int	price;
	int	rating;

	public PriceRating(int price, int rating)
	{
		this.price = price;
		this.rating = rating;
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
	public String toString()
	{
		// TODO Auto-generated method stub
		return this.price+", "+this.rating;
	}
}
