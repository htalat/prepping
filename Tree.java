public class Tree 
{	
	Node head;
	public Tree(int d)
	{
		head = new Node(d);
	}

	public void addNode(int d){
		head = insert(head,d);
	}
	private Node insert(Node root, int d)
	{
		if(root == null)
			return new Node(d);
		else
		{
			if(root.data < d)
				root.right = insert(root.right,d);
			else
				root.left = insert(root.left,d);

			return root;
		}
	}
	public void printInOrder(){
		inOrderPrint(head);
	}
	public void inOrderPrint(Node r)
	{
		if(r!= null){
			inOrderPrint(r.left);
			System.out.println(r.data + " ");
			inOrderPrint(r.right);
		}

	}
	public int countNode()
	{
		return nodeCount(head);
	}
	private int nodeCount(Node r)
	{
		if(r == null)
			return 0;
		else
			return 1 + nodeCount(r.left) + nodeCount(r.right);
	}
	public int sumNode()
	{
		return nodeSum(head);
	}
	private int nodeSum(Node r)
	{
		if(r == null)
			return 0;
		else
			return r.data + nodeSum(r.left) + nodeSum(r.right);
	}
	public static class Node
	{
		public int data;
		public Node left;
		public Node right;

		public Node(int d)
		{
			data = d;
			left =null;
			right = null;
		}
	}
}