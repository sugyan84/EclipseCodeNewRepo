package dataStructure.Tree;

import java.util.Stack;

public class BinaryTree implements Tree
{

	private Node	root;

	public BinaryTree(Node root)
	{
		this.root = root;

	}

	public BinaryTree(int val)
	{
		this.root = new Node(val);
		this.root.setParent(null);
	}

	@Override
	public boolean addNode(int e)
	{
		boolean isAdded = false;

		Node currNode = this.root;
		Node temp = null;

		if(currNode == null)
		{
			currNode = new Node(e);
			this.root = currNode;
			isAdded = true;
			return isAdded;
		}

		while (!isAdded)
		{
			if(e > currNode.getValue())
			{
				// Move to rightNode
				if(currNode.getRightNode() != null)
				{
					temp = currNode;
					currNode = currNode.getRightNode();
					currNode.setParent(temp);
				}
				else
				{
					Node newNode = new Node(e);
					currNode.setRightNode(newNode);
					newNode.setParent(currNode);
					isAdded = true;
					return isAdded;
				}
			}
			else if(e < currNode.getValue())
			{
				// Move to leftNode
				if(currNode.getLeftNode() != null)
				{
					temp = currNode;
					currNode = currNode.getLeftNode();
					currNode.setParent(temp);
				}
				else
				{
					Node newNode = new Node(e);
					currNode.setLeftNode(newNode);
					newNode.setParent(currNode);
					isAdded = true;
					return isAdded;
				}
			}

		}

		return isAdded;
	}

	@Override
	public boolean removeNode(int e)
	{
		return false;
	}

	@Override
	public int getDepth(int n)
	{
		return 0;
	}

	@Override
	public int getSize(int u)
	{
		return 0;
	}

	@Override
	public int getHeight(int u)
	{
		return 0;
	}

	public void showTreeElements()
	{
		Stack s = new Stack();
		Node currNode = this.root;
		
		boolean isDone = false;

		while(!isDone)
		{
			while(currNode.getLeftNode()!=null)
			{
				s.push(currNode);
				currNode=currNode.getLeftNode();
			}
			
			System.out.print("["+currNode.getValue()+" ");
			
			
		}
	}
}
