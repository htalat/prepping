public class Stack
{	
	Node root;

	public Stack(int d)
	{
		root = new Node(d);
	}
	
	public void push(int d)
	{
		if(root == null)
			root = new Node(d);
		else{
			Node newNode = new Node(d);
			newNode.next = root;
			root = newNode;
		}
	}

	public void pop()
	{
		if(root == null)
			return;
		else
		{
			root = root.next;
		}
	}
	public boolean isEmpty()
	{
		return root == null;
	}
	public void printAll()
	{
		if(root == null)
			{
				System.out.println("Stack is empty");
				return;
			}
		else
		{
			Node n = root;
			while(n!= null)
			{
				System.out.println(n.data);
				n = n.next;
			}
		}
	}
	public static class Node
	{
		int data;
		Node next;
		public Node(int d)
		{
			data = d;
		}
	}

}