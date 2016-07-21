/*
	// numberOfNodes
	//insert
	//printInOrder
	//printPreOrder
	//iterativePrintPreOrder-commented
	//iterativePrintInOrder-commented
	//sumNodes
	//lowestCommonAncestor
	//invertTree


*/
import java.util.*;
public class Tree
{
	Node root;

	public Tree(int d)
	{
		root = new Node(d);
	}
	//--------------------------------------------------------------
	public int numberOfNodes()
	{
		return countNodes(root);
	}
	private int countNodes(Node r)
	{
		if(r == null)
			return 0;
		else
			return 1 + countNodes(r.left) + countNodes(r.right);
	}

	//--------------------------------------------------------------
	public void insert(int d)
	{
		root = add(root,d);
	}

	private Node add(Node r, int d)
	{
		if(r == null)
			return new Node(d);
		else
		{
			if(d < r.data)
				r.left = add(r.left,d);
			else
				r.right = add(r.right,d);
		}
		return r;
	}
	//--------------------------------------------------------------
	//	http://quiz.geeksforgeeks.org/binary-search-tree-set-2-delete/
	//
	public void delete(int d)
	{
		root = del(root,d);
	}
	private Node del(Node r ,int d)
	{
		if(r == null)
			return r;

		if(d < r.data)
			r.left = del(r.left,d);
		else if (d > r.data)
			r.right = del(r.right,d);
		else
		{
			if(r.left == null)
				return r.right;
			else if(r.right == null)
				return r.left;

			r.data  = minValue(r.right);
			r.right = del(r.right,r.data); 

		}
		return r;
	} 
	private int minValue(Node r)
	{
		int min = r.data;
		while(r != null)
		{
			min = r.left.data;
			r   = r.left;
		}
		return min;
	}
	//--------------------------------------------------------------
	public void printInOrder()
	{
		this.printInOrder(root);
	}
	private void printInOrder(Node r)
	{
		if(r == null)
			return;
		else
		{
			printInOrder(r.left);
			System.out.println(r.data + " ");
			printInOrder(r.right);
		}
	}
	//---------------------------------------------------------------
	public void printPreOrder()
	{
		this.printPreOrder(root);
	}
	private void printPreOrder(Node r)
	{
		if(r == null)
			return;
		else
		{
			System.out.println(r.data + " ");
			printPreOrder(r.left);
			printPreOrder(r.right);
		}
	}
	//---------------------------------------------------------------
	public void iterativePrintPreOrder()
	{
		/* will conflic with stack class
       if(root == null)
            return;
        
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            Node t1 = stack.pop();
            
            System.out.println(t1.data+ " ");
            
            if(t1.right!= null)
            {
                stack.add(t1.right);
            }
            
            if(t1.left != null)
            {
                stack.add(t1.left);
            }
        }		
        */
	}
	//---------------------------------------------------------------
	public void iterativePrintInOrder()
	{
		/* will conflict with stack class
		if(root == null)
			return;

		Stack<Node> stack = new Stack<Node>();
		Node t1 = root;

		while(!stack.isEmpty() || t1 != null)
		{
			if(t1 != null)
			{
				stack.push(t1);
				t1 = t1.left;
			}else
			{
				Node t2 = stack.pop();
				System.out.println(t2.data);
				t1 = t2.right;
			}
		}
		*/
	}	
	//--------------------------------------------------------------
	public int sumNodes()
	{
		return nodeSum(root);
	}
	private int nodeSum(Node r)
	{
		if(r==null)
			return 0;
		else
			return r.data + nodeSum(r.left) + nodeSum(r.right);
	}
	//----------------------------------------------------------
	public Node lowestCommonAncestor(Node p , Node q)
	{
		return lca(root,p,q);
	}
	private Node lca(Node r , Node p , Node q)
	{
		if(r == null)
			return null;

		if(p.data > r.data && q.data > r.data)
		{
			return lca(r.right,p,q);
		}
		
		if (p.data < r.data && q.data < r.data)
		{
			r = lca(r.left,p,q);
		}
		return r;

	}
	//----------------------------------------------------------
	public Node invertTree(Node r)
	{
		if(r != null)
			invert(r);

		return r;
	}
	public void invert(Node r)
	{
		Node tmp = r.left;
		r.left  = r.right;
		r.right = tmp;

		if(r.left != null)
			invert(r.left);

		if(r.right != null)
			invert(r.right);
	}
	//-----------------------------------------------------------
	public static class Node 
	{
		int data;
		Node left,right;

		public Node(int d)
		{
			data = d;
		}

	}
}