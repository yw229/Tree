package Questions4;

import java.util.Stack;

public class PreOrderTraversal
{
    public TreeNode t ;
    public Stack<TreeNode> s ;
    public PreOrderTraversal(TreeNode t)
    {
        this.t = t ;
        s = new Stack<TreeNode>() ;
    }
    public void PreOrderNon()
    {
        TreeNode current = t;
        s.push(t) ;
        
        while( !s.isEmpty())
        {
        	
        current = s.pop() ;
        if(current!=null)
        {
        	System.out.print("" + current.data);
            //s.pop() ;
            s.push(current.right) ;
            s.push(current.left) ;
         }
        }
    }
    public static TreeNode createBST(int[]array, int low, int high)
    {
    	if(low>high) return null ;
		int mid = (low+high)/2 ;
		TreeNode n = new TreeNode(array[mid]) ;
		n.setLeft(createBST( array,low, mid-1) ) ;
		n.setRight(createBST(array,mid+1,high) );
		return n ;
    }
    public static void main(String[] args)
    {
    	int[] array = {2,3,4,5,6,7,8,9} ;
		//TreeNode t = addToTree(array, 0, array.length-1) ;
        TreeNode t = createBST(array,0,array.length -1) ;
        PreOrderTraversal pt= new PreOrderTraversal(t) ;
        pt.PreOrderNon() ;
        
    }
} 