package Questions2;

public class reverseLinkedList {
	public static LinkedListNode reverse (LinkedListNode n)
	{
		/*
		LinkedListNode prev = null ;
		LinkedListNode next  ;
		 while (n != null)
		 {
			 next = n.next ;
			 n.next = prev ;
			 
			 prev = n ;
			 n = next ;
		 }
		 return prev ; */
		LinkedListNode prev = null ;
		LinkedListNode current = n ;
		while (n !=null)
		{
			//current = n.next ;
			n.next = prev ;
			prev = n ;
			
			current = current.next ;
			
		}
		return current;
	}
	
	public static void main (String[] args)
	{
		LinkedListNode n = method.randomLinkedList(10, 0, 10) ;
		System.out.println("The list is" + n.printForward()) ;
		LinkedListNode nl = reverse (n) ;
		System.out.println("New reversed list is" + nl.printForward()) ;
		
	}

}
