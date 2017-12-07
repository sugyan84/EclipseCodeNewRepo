package dataStructure.Tree;

public class Node
{
	private Node parent;
	private Node left;
	private Node right;
	private int val;
	
	public Node(int v)
	{
		this.val=v;
	}
	
	
	public void addNode(Node e)
	{
		if(e.getValue() < this.getValue())
		{
			if(this.getLeftNode()!=null)
			this.getLeftNode().addNode(e);
			else
				this.setLeftNode(e);
		}
		else if(e.getValue() > this.getValue())
		{
			
		}
	}
	
	public int getValue()
	{
		return this.val;
	}
	
	public void setValue(int v)
	{
		this.val=v;
	}
	
	public Node getRightNode()
	{
		return this.right;
	}
	public void setRightNode(Node r)
	{
		this.right=r;
	}
	
	
	public Node getLeftNode()
	{
		return this.left;
	}
	
	public void setLeftNode(Node l)
	{
		this.left=l;
	}
	
	public Node getParent()
	{
		return this.parent;
	}
	
	public void setParent(Node p)
	{
		this.parent=p;
	}
}
