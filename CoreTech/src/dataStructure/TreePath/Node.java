package dataStructure.TreePath;

import java.util.*;

public class Node
{
	String name;
	ArrayList<Node> childNodes=new ArrayList<Node>();
	
	public Node(String n)
	{
		this.name=n;
	}
	
	public Node()
	{
		
	}
	
	public void addChildNode(Node e)
	{
		this.childNodes.add(e);
	}
	
	public void addChildNode(String e)
	{
		Node f = new Node(e);
		this.childNodes.add(f);
	}
	
	
	public boolean addChildUnder(String parent, String s)
	{
		boolean status=false; //false means not added
		
		if(this.containsChildNodes())
		{
			Iterator itr = this.childNodes.iterator();
			int x= this.childNodes.size();
			
			System.out.println(x);
			
			while(itr.hasNext())
			{
				Node currentNode= (Node)itr.next();
				
				if(currentNode.name.equalsIgnoreCase(parent))
				{
					currentNode.addChildNode(s);
					status = true;
					return status;
				}
				else
				{
					if(currentNode.addChildUnder(parent, s))
					{
						status=true;
						return status;
					}
				}
			}
		}
		
		return status;
		
	}
	
	
	public void showTree(Node root)
	{
		System.out.println(root.name+"-> ");
		
		if(root.containsChildNodes())
		{
			Iterator itr = this.childNodes.iterator();
			
			while(itr.hasNext())
			{
				Node currNode = (Node)itr.next();
				System.out.println(currNode.name+", ");
				currNode.showTree(currNode);
			}
		}
		
		
	}
	public boolean containsChildNodes()
	{
		if(this.childNodes.size() > 0)
			return true;
		else return false;
	}
}
