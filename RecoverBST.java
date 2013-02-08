package Questions4;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class RecoverBST {
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> result = InOrderTrav(root) ; // only two adjacent node is not increaing order 
        TreeNode t1 = null ; TreeNode t2 = null ;
        for(int i = 0 ; i < result.size()-1; i ++)
        {
            if(result.get(i).data > result.get(i+1).data)
              {
                t1 = result.get(i) ;
                break;
                }
        }
        for(int i = result.size()-1 ; i>0 ; i--)
        {
            if(result.get(i).data < result.get(i-1).data)
             {
                t2 = result.get(i) ;
                break ;
             }
        }
        int temp = t1.data ;
        t1.data = t2.data ;
        t2.data = temp ;
    }
    
    /*
     * In Order Traversal non-recursively 
     * current initlizaed to root , keep traversing left child push them into stack ,
     * stack to store from left traverse node till the node without the left -- left most child , set to current 
     * based on in order traversal, the first visit should be the left most , so pop the leftmost ,
     * current is set to its right child and repeat the process again.
     * 
     * the last traverse node must not have right child 
     *   
     * */
    public ArrayList<TreeNode> InOrderTrav(TreeNode t)
    {
        if(t==null) return null ;
        ArrayList<TreeNode> result = new ArrayList<TreeNode>() ;
        Stack<TreeNode> s= new Stack<TreeNode>() ;
        TreeNode current = t ;
        while(current!=null ||!s.isEmpty())
        {
            if(current!=null)
            {
                s.push(current) ; // push current to stack and traverse left node
                current = current.left ; // push left till the left leaf of tree
            }
            else
            { 
            current =s.pop() ; // pop the left most tree node 
            //System.out.print(" " + current.data) ;
            result.add(current) ;
                        
            current = current.right ;  // 
            }
            
        }
        return result ;
    }
}