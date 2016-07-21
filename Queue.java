/*
	Queue
	+enqueue
	+dequeue
	+isEmpty
	+peek
	+printAll
	+Node
*/
public class Queue
{

	public Node head;

	public Queue(int d)
	{
		head = new Node(d);
	}

	public void enqueue(int d)
	{
		if(head == null)
			head = new Node(d);
		else
		{
			Node tmp = head;
			while(tmp.next != null)
			{ 
				tmp = tmp.next;
			}
			tmp.next = new Node(d);
		}
	}
	public void dequeue()
	{
		head = head.next;
	}
	public boolean isEmpty()
	{
		return head == null;
	}
	public int peek()
	{
		return head.data;
	}
	public void printAll()
	{
		if(head == null)
			return;
		else
		{
			Node tmp = head;
			while(tmp!=null)
			{
				System.out.println(tmp.data);
				tmp = tmp.next;
			}
		}
	}
	public class Node
	{
		int data;
		Node next;
		public Node(int d)
		{
			data = d;
			next = null;
		}

	}
}