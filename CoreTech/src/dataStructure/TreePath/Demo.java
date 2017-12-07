package dataStructure.TreePath;

public class Demo
{

	public static void main(String[] args)
	{
		//Adding elements to Nodes
		Node n = new Node("Sugyan");
		
		n.addChildNode("Sahu");
		n.addChildNode("Ramesh");
		
		n.addChildUnder("Ramesh", "Pradeep");
		
		
		n.showTree(n);

	}

}
