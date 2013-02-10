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
public class ReconstructInPo {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer,Integer> inmap = new HashMap<Integer,Integer>() ;
        for(int i = 0 ; i < inorder.length; i++)
        {
            inmap.put(inorder[i],i) ;
        }
        return build(inmap,inorder,0,inorder.length-1,postorder,0,postorder.length-1) ;
    }
    public TreeNode build(HashMap<Integer,Integer> map, int[] inorder,int ins,int ine,
                          int[] postorder,int poss,int pose )
    {
        if(ins>ine || poss>pose)
        return null ;
        TreeNode root = new TreeNode(postorder[pose]) ;// last element in postorder is root 
        int i = map.get(postorder[pose]) ;
        root.left = build(map,inorder,ins,i-1,postorder,poss,poss+i-ins-1) ; // offset 
        root.right = build(map,inorder,i+1 ,ine,postorder,poss+i-ins,pose-1) ;
        return root ;
    }
}