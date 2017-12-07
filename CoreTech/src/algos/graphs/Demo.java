package algos.graphs;

import java.util.Iterator;

public class Demo
{

	public static void main(String[] args)
	{
		Graph g = new Graph(8);
		
		g.setEdge(1, 2);
		g.setEdge(1, 4);
		g.setEdge(1, 7);
		g.setEdge(2, 5);
		g.setEdge(2, 6);
		g.setEdge(3, 6);
		g.setEdge(3, 8);
		g.setEdge(4, 6);
		g.setEdge(5, 7);



		
		Iterator itr = g.getEdge(1).iterator();
		
		/*while(itr.hasNext())
		{
			System.out.println(itr.next());
		}*/
		
		g.traverseBFS();

	}

}
