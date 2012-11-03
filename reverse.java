package Questions2;

public class reverse {
	/*public static LinkedListNode rev(LinkedListNode n)
	{
		if (n ==null) return null;
		LinkedListNode prev = null;
		LinkedListNode next ;
		while (n !=null)
		{
			next = n.next ;
			n.next =prev  ;
			prev = n;
			n = next;
		}
		return prev ;
	}
	public static void main (String[] args)
	{
		LinkedListNode n = LinkedListNode.createLinkedListNode(10) ;
		System.out.println("LIST is " + n.printForward()) ;
		LinkedListNode newhead = rev(n);
		System.out.println("New reversed LIST is " + newhead.printForward()) ;
	} */
  //public LinkedListNode rl ;
    
    public  LinkedListNode reverseL (LinkedListNode n)
    {
        LinkedListNode prev = null ;
       // LinkedListNode next ;
        while (n!=null)
        {
        	 LinkedListNode next = n.next ;
             n.next = prev ;
             prev = n ;
             n = next;

     
         }
         return prev ;
    }
    
    public static void main (String[] args)
    {
        LinkedListNode n = LinkedListNode.createLinkedListNode(10) ;
        System.out.println("Before reverse the linklist is" + n.printForward()) ;
        reverse re= new reverse();
        LinkedListNode newl =re.reverseL(n) ;
        System.out.println("Before reverse the linklist is" + newl.printForward()) ;

    }

}
