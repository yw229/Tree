package Questions4;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// similar with sorted array to BST O(nlogn)
// traverse till mid node, recursively build left tree and right tree
public class convertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null) return null ;
        int N = total(head) ;
        return sort(head, N) ;
    }
    public int total(ListNode head)
    {
        int N = 0 ; 
        ListNode temp = head ;
        while(temp!=null)
        {
            ++N ;
            temp = temp.next ;
        }
        return N ;
    }
    
    public TreeNode sort(ListNode head,int N)
    {
       // int N = total(head) ;
       if(N==0 || head==null) return null ;
        int mid = N/2 ;
        ListNode midnode = head ;
        for(int i=0; i < mid ; i++)
        {
            midnode = midnode.next ;
        }
        TreeNode root = new TreeNode(midnode.val) ;
        root.left = sort(head,mid) ;
        root.right = sort(midnode.next,N-1-mid) ;
        return root ;
    }
}