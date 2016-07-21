public class LinkedList
{
	Node head;

	public LinkedList(int d)
	{
		head = new Node(d);
	}

	public void add(int d)
	{
		Node  n  = new Node(d);

		Node tmp = head;
		while(tmp.next != null)
			tmp = tmp.next;
		
		tmp.next = n;

	}

	public void printList()
	{
		Node t = head;
		while(t!=null)
		{
			System.out.print(t.data + " ");
			t = t.next;
		}	
		System.out.println();
	}

	 public Node reverseList(Node head)
	 {
        
        if(head == null || head.next == null)
            return head;
    
        Node a = head;
        Node b = head.next;
        
        head.next = null;
        
        
        while(a != null || b != null)
        {
            Node c = b.next;
            b.next = a;
            a = b;
            
            if(c!=null)
                b=c;
            else
                break;
        }
        return b;
    }


	public class Node
	{
		int data;
		Node next;

		Node(int d)
		{
			data = d;
			next = null;
		}
	}
}