package problem.techgig.tree;

public class Node
{
	int data;
	Node left, right;

	public Node(int data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	@Override
	public int hashCode()
	{
		return this.data;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Node o = (Node) obj;
		return this.data==o.data;
	}
	
	
}
