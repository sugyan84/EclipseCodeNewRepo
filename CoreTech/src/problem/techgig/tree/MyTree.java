package problem.techgig.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyTree
{
	Node root;

	public MyTree()
	{

	}

	public void addNode(int data)
	{
		Node currNode = this.root;

		if (currNode == null)
		{
			this.root = new Node(data);
			return;
		}
		else
		{
			addNodeUtil(currNode, data);
		}
		
	}
	
	private void addNodeUtil(Node currNode, int data)
	{
		
		if(data < currNode.data)
		{
			//go left
			if(currNode.left!=null)
			{
				addNodeUtil(currNode.left, data);
			}
			else
			{
				Node newN = new Node(data);
				currNode.left = newN;
				return;
			}
		}
		else if(data > currNode.data)
		{
			//go right
			if(currNode.right!=null)
			{
				addNodeUtil(currNode.right, data);
			}
			else
			{
				Node newN = new Node(data);
				currNode.right = newN;
				return;
			}
		}
	}
	
	public void printPreOrder()
	{
		if(this.root!=null)
		printPreOrderUtil(this.root);
	}
	
	private void printPreOrderUtil(Node currNode)
	{
		if(currNode==null)
			return;
		
		printPreOrderUtil(currNode.left);
		
		printPreOrderUtil(currNode.right);	
		System.out.print(currNode.data+" ");
	}
	
	public void printLevelOrder()
	{
		Queue<Node> q = new LinkedList();
		
		q.add(this.root);
		q.add(new Node('#'));
		
		int levelCount = 0;
		boolean isFirst = false;
		
		while(!q.isEmpty())
		{
			Node now = q.poll();
			
			if(now.data=='#')
			{
				levelCount++;
				isFirst = true;

				if(q.peek()==null)
					break;
				else
					q.add(new Node('#'));
				continue;
			}
			
			
			if(isFirst || levelCount==0)
			System.out.print(now.data+" ");
			
			isFirst = false;
			
			if(now.left!=null)
				q.add(now.left);
			
			if(now.right!=null)
				q.add(now.right);
		}
		
		System.out.println("Levels: "+levelCount);
	}
	
	public int getLeafNodesCount()
	{
		int leafNodesCount = 0;
		
		Queue<Node> q = new LinkedList();
		
		q.add(this.root);
		q.add(new Node('#'));
		
		int levelCount = 0;
		boolean isFirst = false;
		
		while(!q.isEmpty())
		{
			Node now = q.poll();
			
			if(now.data=='#')
			{
				levelCount++;
				isFirst = true;

				if(q.peek()==null)
					break;
				else
					q.add(new Node('#'));
				continue;
			}
			
			if(now.left==null && now.right==null)
			{
				leafNodesCount++;
				System.out.print(now.data+" ");
			}			
			
			isFirst = false;
			
			if(now.left!=null)
				q.add(now.left);
			
			if(now.right!=null)
				q.add(now.right);
		}
		
		return leafNodesCount;
	
	}

	public void print_K_DistantNodesFromRoot(int k)
	{
		Stack<Node> stack = new Stack<Node>();
		
		HashSet<Node> visited = new HashSet();
		
		Node currNode = this.root;
		//stack.add(currNode);
		
		while(true)
		{
			visited.add(currNode);
			
			if(currNode.left!=null)
			{
				if(!visited.contains(currNode.left))
				{
					stack.add(currNode);
					currNode = currNode.left;
					continue;
				}
				
			}
			else if(currNode.right!=null)
			{

				stack.add(currNode);
				currNode = currNode.right;
				continue;			
			}
			else
			{
				currNode = stack.pop();
			}
		}
		
	}
}
