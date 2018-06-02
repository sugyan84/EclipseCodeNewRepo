package problem.techgig.tree;

public class Demo
{

	public static void main(String[] args)
	{
		MyTree t = new MyTree();
		
		t.addNode(50);
        t.addNode(30);
        t.addNode(20);
        t.addNode(40);
        t.addNode(70);
        t.addNode(60);
        t.addNode(80);
        
        t.addNode(15);
        t.addNode(37);
        t.addNode(89);
		
		t.printPreOrder();
		
		System.out.println();
		
		//t.printLevelOrder();
		
		System.out.println("\n"+t.getLeafNodesCount());

	}

}
