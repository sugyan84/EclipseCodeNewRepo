package algos.tree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class DemoTree
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		/*Integer[] arr =
		//{ 4, 84, 42, 39, 76, 9, 17, 53, 24 };
			//{12, 35, 87, 26, 9, 28, 7};
		{15, 9, 23, 3, 12, 17, 1, 4};

		String[] arrStr =
		{ "Sugyan", "Sahu", "Tapaswini", "Amit", "Swetha" };

		// ATree<String> myTree = new ATree<String>();
		ATree<Integer> myTree = new ATree<Integer>();

		for (Integer x : arr)
		{
			myTree.insertElement(new TreeNode<Integer>(x));
		}

		//System.out.println("\nSearch Result: "+myTree.searchElement(24));

		System.out.println("\nHeight: "+myTree.getHeight());
		
		System.out.println("\nDepth: "+myTree.getDepth());
		
		System.out.println("\nTree traversal:- \n");
		
		myTree.printLevelOrder();
		
		TreeNode<Integer> minimumNode = myTree.minNode(myTree.root);
		System.out.println("Min Node:"+minimumNode.getValue());
		
		
		TreeNode<Integer> maximumNode = myTree.maxNode(myTree.root);
		System.out.println("Max Node:"+maximumNode.getValue());
		
		System.out.println("Delete 24: "+myTree.deleteNode(new TreeNode<Integer>(9)));

		
		myTree.printLevelOrder();*/
		
		
		
		
		
		// Let's create Huge data and add to Tree and then compute.
		List<Integer> l = new ArrayList<Integer>();

		int noOfElements = 500000;
		int start = 1;

		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("kara.txt")));
		
		ATree<Integer> myNewTree = new ATree<Integer>();

		Random random = new Random();

		int r = 0;
		int div = 10000;

		boolean stat=false;
		int gotRandomElement =0;
		HashSet s = new HashSet();
		
		while (start <= noOfElements)
		{
			while(!stat)
			{
				gotRandomElement= random.nextInt(60004777);
				stat= s.add(Integer.valueOf(gotRandomElement));
			}
			
			stat=false;

			Integer I = new Integer(gotRandomElement);
			myNewTree.insertElement(new TreeNode<Integer>(I));

			r = start % div;

			if (r == 0)
				System.out.println("Still I'm working..."+start);
			//System.out.println(start);
			
			bw.write("Working... "+gotRandomElement);
			bw.newLine();
			
			start++;
			
			
		}

		System.out.println("Tree formed!");
		
		System.out.println("\nHeight: "+myNewTree.getHeight());
		
		System.out.println("\nTotal no. of elements in Tree: "+myNewTree.getSize());
		
		bw.close();
		
		System.out.println("Done... now searching for "+gotRandomElement);
		
		SearchResult sr= myNewTree.searchElement(gotRandomElement);
		
		System.out.println("Search result "+sr.isFound());

	}

}
