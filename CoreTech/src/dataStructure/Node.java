package dataStructure;

public class Node
{
	int value;
	Node next=null;

	static int count=0;

	public void incrementCount()
	{
		count++;
	}

	Node(int v)
	{
		incrementCount();
		this.setValue(v);
	}

	public int getValue()
	{
		return value;
	}
	private void setValue(int value)
	{
		this.value = value;
	}
	public Node getNext()
	{
		return next;
	}
	private void setNext(Node next)
	{
		this.next = next;
	}

	public void addNode(Node n)
	{
		if(this.next!=null)
			this.next.addNode(n);
		else
			this.setNext(n);
	}

	public int getCount()
	{
		return count;
	}


	public static Node removeNode(Node head, int v)
	{
		Node currentNode=null;
		Node previousNode=null;

		previousNode=head;
		currentNode=head;

		while(true)
		{
			if(currentNode.next==null)
				break;

			if(currentNode.value!=v)
			{
				previousNode=currentNode;
				currentNode=currentNode.next;
			}
			else if (currentNode.value==v)
			{
				previousNode.next=currentNode.next;
				break;
			}
		}

		return head;
	}
}
