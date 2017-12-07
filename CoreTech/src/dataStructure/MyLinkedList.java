package dataStructure;

public class MyLinkedList
{

	public static void main(String[] args)
	{
		Node first=new Node(5);


		first.addNode(new Node(3));
		first.addNode(new Node(82));
		first.addNode(new Node(32));
		first.addNode(new Node(13));
		first.addNode(new Node(9));
		first.addNode(new Node(4));

		System.out.println("Total nodes now: "+first.getCount());

		System.out.println("elements are: ");



		Node currentNode=null;

		currentNode=first;


		while(true)
		{
			System.out.print(currentNode.getValue());

			if(currentNode.next!=null)
			{
				currentNode=currentNode.next;
				System.out.print(" -> ");
			}

			else
				break;
		}


		System.out.println("\n\nremoving...");
		first=Node.removeNode(first, 82);


		currentNode=null;

		currentNode=first;


		while(true)
		{
			System.out.print(currentNode.getValue());

			if(currentNode.next!=null)
			{
				currentNode=currentNode.next;
				System.out.print(" -> ");
			}

			else
				break;
		}

	}

}
