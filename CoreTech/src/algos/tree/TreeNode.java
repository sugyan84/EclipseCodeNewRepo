package algos.tree;

public class TreeNode<T extends Comparable<T>>
{
	private TreeNode left;
	private TreeNode right;
	private TreeNode parent;
	private T value;
	boolean isLeafNode;
	public int count=1;
	private NodePosition positionFromParent;
	
	public enum NodePosition
	{
		LEFT, RIGHT, ROOT
	}
	
	public TreeNode()
	{
		this.left=null;
		this.right=null;
	}
	
	public TreeNode(T newNode)
	{
		this.left=null;
		this.right=null;
		this.value=newNode;
	}

	public TreeNode getLeft()
	{
		return left;
	}

	public void setLeft(TreeNode left)
	{
		this.left = left;
	}

	public TreeNode getRight()
	{
		return right;
	}

	public void setRight(TreeNode right)
	{
		this.right = right;
	}

	public T getValue()
	{
		return value;
	}

	public void setValue(T value)
	{
		this.value = value;
	}

	public boolean isLeafNode()
	{
		boolean answer=true;
		if(this.getLeft()==null && this.getRight()==null)
			answer=true;
		else
			answer=false;
		return answer;
	}

	public void setLeafNode(boolean isLeafNode)
	{
		this.isLeafNode = isLeafNode;
	}

	
	public TreeNode getParent()
	{
		return parent;
	}

	
	public void setParent(TreeNode parent)
	{
		this.parent = parent;
	}

	
	public int getCount()
	{
		return count;
	}

	
	public void setCount(int count)
	{
		this.count = count;
	}

	
	public boolean equals(TreeNode<T> obj) 
	{
        return (this.getValue() == obj.getValue());
    }
	
	public NodePosition getPositionFromParent()
	{
		return positionFromParent;
	}

	public void setPositionFromParent(NodePosition positionFromParent)
	{
		this.positionFromParent = positionFromParent;
	}
	
}
