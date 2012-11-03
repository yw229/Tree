package Questions2;
import Questions2.*;


public class DeleteFromMiddle {
	public static boolean deleteMiddle (LinkedListNode node)
	{
		if(node ==null || node.next ==null)
			return false; 
		LinkedListNode next = node.next ;
		node.data = next.data ;
		node.next = next.next ;
		return true ;
	}

	public static void main (String[] args)
	{
		LinkedListNode node = method.randomLinkedList(10, 0, 10) ;
		System.out.println(node.printForward()) ;
		if (deleteMiddle(node.next.next.next.next) == true)
			System.out.println( node.printForward() ) ;
			
		
	}
	
}
