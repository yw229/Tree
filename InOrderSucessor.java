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
		 else // (e.parenet !=null && e.right == null ,)
		 {
			 next = e.parent ;
			/* while ( next !=null )
			 {
				 next = e.parent ;
				 e = next ;
				 if ( next.left ==e)
					 break ;
			 } */
                          next = e.parent ;
			if ( next.left ==null)
				next = next.parent ;



		 }
		 return next ;
		 
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
