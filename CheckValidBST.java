package Questions4;

import java.util.Random;

public class CheckValidBST {
	/*BST : left subtree of a node contains only key nodes with value less than the node
	 *  	right subtree of a node contains only key nodes with value greater than the node
	 *  	both left subtree and right subtree are BST 
	 *  
	 *  Solution :  keep track of the each traversed node value range and it's children
	 * 
	 * */
	public static boolean isValicBST(TreeNode t)
	{
		return check(t, Integer.MIN_VALUE , Integer.MAX_VALUE) ;
	}
	
	// to check node
	public static boolean check(TreeNode n, int small, int large)
	{
		if( n==null) return true ; // no value  return true 
		// if current node is within range(small, large)
		if( n.data>small && n.data<large)
		{
			boolean leftBST = check(n.left,small,n.data) ; // here for current left node only care about the large edge is current value
			boolean rightBST = check(n.right,n.data,large) ; // here for current right node care about the min edge is the current value ;
			// reccurance for each descendant 
			
			return leftBST&&rightBST ; // leftBST and rightBST are all BST 
		}
		return false ;
	}
	
	public static void main(String[] args)
    {
        Random ran = new Random() ;
        int array[] = new int[10] ;
        for (int i=0 ; i < array.length ; i++)
        {
            array[i] = ran.nextInt(10) ;
            System.out.print(" " + array[i]) ;
        }
        System.out.println() ;
        TreeNode t = TreeNode.createMinBST(array) ;
        System.out.println("is valid BST:" + isValicBST(t)) ;
    }

}
