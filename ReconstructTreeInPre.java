package Questions4;

import java.util.HashMap;


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> imap = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < inorder.length ; i ++ )
            {
                imap.put(inorder[i],i);
            }
        return builT(imap,preorder,0,preorder.length-1,inorder,0,inorder.length-1) ; 
    }
    
    public TreeNode builT(HashMap<Integer,Integer> imap,int[] preorder,int pres,int prend,int[]inorder,int ins,int ined) 
        {
            if(pres>prend || ins>ined ) return null ;
            int rootv = preorder[pres] ; // the start of preorder array is always the root 
            int i = imap.get(rootv) ; 
            TreeNode root = new TreeNode(rootv) ; 
            int leftT = i - ins ;
            int rightT = ined -i ; 
            root.left = builT(imap,preorder,pres+1,pres+1 +leftT-1,inorder, ins,i-1 ) ;
            root.right = builT(imap,preorder, prend-rightT+1, prend,inorder,i+1,ined) ;
            return root ; 
        }
}  
   
