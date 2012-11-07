package Questions4;

import java.util.Random;

public class CommonAncetor
{
    public static boolean isChild(TreeNode e, TreeNode r ) // find out if TreeNode e is the child(grandchild) of TreeNode root   
    {
        if (r != null && e == null) return true ;
        if (r == null) return false ;
        
        if (e.parent == r) return true ; 
        
        return ( isChild(e,r.left) || isChild(e,r.right)) ; // either left child or right child
    }
    public static TreeNode commonAncestor(TreeNode t, TreeNode a, TreeNode b)
    {
        if ( isChild(a,t.left)&& isChild(b,t.left)) // a b both on the left side of treenode t
           return commonAncestor(t.left ,a,b) ;
        if ( isChild(a,t.right) && isChild(b,t.right)) // a b both on the right side of treenode t
           return commonAncestor(t.right, a,b) ;
        // if both on the same side 
        return t ;
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
        TreeNode t = TreeNode.createMinBST(array) ;
        TreeNode a = t.left.right ;
        TreeNode b = t.left.left ;
        System.out.println(" TreeRoot" + t.data) ;
        System.out.println(" The first common of ancesotr of node a:" + a.data + "b:"+ b.data +
        		"Common"+commonAncestor(t,a,b).data) ;
    }
}