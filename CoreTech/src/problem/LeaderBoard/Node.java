package problem.LeaderBoard;

public class Node implements Comparable
{
	int		score;
	int		rank;
	String	name;
	Node	next;
	Node	prev;

	public Node getNext()
	{
		return next;
	}

	public void setNext(Node next)
	{
		this.next = next;
	}

	public Node getPrev()
	{
		return prev;
	}

	public void setPrev(Node prev)
	{
		this.prev = prev;
	}

	public Node(int score)
	{
		this.score = score;
		this.next = null;
		// this.name = name;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public int getRank()
	{
		return rank;
	}

	public void setRank(int rank)
	{
		this.rank = rank;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public int compareTo(Object o)
	{
		Node n = (Node) o;

		if(this.score < n.score)
		{
			return -1;
		}
		else if(this.score > n.score)
		{
			return 1;
		}
		else
			return 0;
	}

}
