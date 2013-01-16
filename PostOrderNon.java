package Questions4;

import java.util.Stack;

public class PostOrderNon
{
    public TreeNode t ;
    public Stack<TreeNode> s1 ;
    public Stack<TreeNode> s2 ;
    public PostOrderNon(TreeNode t)
    {
        this.t = t ; 
        s1 = new Stack<TreeNode>() ;
        s2 = new Stack<TreeNode>() ;
    }
    public void PostOrder()
    {
        s1.push(t) ;
        while(!s1.isEmpty())
        {
            TreeNode current = s1.pop();
            s2.push(current) ;
            if(current.left!=null)
                s1.push(current.left) ;
             if(current.right!=null)
                s1.push(current.right);


        }
        while(!s2.isEmpty())
        {
            System.out.print(" " + s2.pop().data) ;
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
        PostOrderNon pt= new PostOrderNon(t) ;
        pt.PostOrder() ;
        
    }
}
