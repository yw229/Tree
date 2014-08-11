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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> imap = new HashMap<Integer, Integer>() ;
        for (int i = 0 ; i < inorder.length ; i++)
        {
            imap.put(inorder[i],i) ;
        }
        return buildT(imap , inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    
    public TreeNode buildT(HashMap<Integer, Integer> imap,int[] inorder, int inst, int ined, int[] postorder,int posst, int postend)
        {
            if(inst>ined || posst >postend)
                    return null ;
                    
            int rootv = postorder[postend];
            TreeNode root = new TreeNode(rootv) ; 
            int i = imap.get(rootv) ; 
            int postleftT = i - inst ; // calculate total on left subtree based on InOrderTrave 
            int postrightT = ined - i ; // calculate total on right subtree based on InOrderTrave 
            root.left = buildT(imap,inorder,inst, i-1,postorder,posst,posst+postleftT-1  ) ;
            root.right = buildT(imap,inorder, i+1,ined,postorder,postend-1-postrightT +1 ,  postend-1 ) ;
            
            return root ; 
                    
        }
}
