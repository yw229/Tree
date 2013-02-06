package Questions4;

import java.util.Random;

public class InOrderSucessor {
	public TreeNode t ;
	
	public InOrderSucessor (TreeNode t)
	{
		this.t = t ;
	}	
	public InOrderSucessor ()
	{
		//
		// case 1 : if current node right sub tree is not null or current node is root, then 
		// we only need to find the leftmost node of the right sub sttree
		// case 2 : if right sub tree is null, traverse it's ancestry till it reaches a node that is the left
		// child of a node, that node's parent is the next successor 
	}
	public TreeNode FindNextNode(TreeNode e)
	{
		 //this.t = t ;
		if (e !=null)
		{
		 TreeNode next ; 
		 if ( e.parent == null || e.right != null)
		 {
			 next = e.mostleft( e.right) ;
			 //return next ;
		 }
		 TreeNode p = e.parent ;
		 while(p!=null && e == p.right)
		 {
		 	p= p.parent ;
		 	e = p ;
		 }
		 return p ;
		 //reutrn next ;
		}
		 return null ;
	}
	
	public static void main (String[] args)
	{
		int ran = 10 ; 
		int[] array = new int[ran] ;
		Random r = new Random() ;
		System.out.println("The array is" ) ;
		
		for (int i= 0; i < array.length ; i ++)
		{
			array[i] = r.nextInt(10) ;
			System.out.print(" " + array[i]) ;
		}
		TreeNode tr = TreeNode.createMinBST(array) ;  
		InOrderSucessor inorder = new InOrderSucessor() ;
		TreeNode node = inorder.FindNextNode( tr) ;
		System.out.println() ;
		if (node != null) {
			System.out.println(tr.data + "->" + node.data);
		} else {
			System.out.println(node.data + "->" + null);
		}
		
	}

}
