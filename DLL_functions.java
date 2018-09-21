import java.util.Iterator;

//******My Doubly Linked List Implementation along with functions - SEE COMMENTS in MyDoublyLinkedList.java*******

public class DoublyLinkedList <E> implements Iterable<E>
{
	private Node<E> header;
	private Node<E> trailer;
	private static int size;

	private static class Node<E> {

		private E element;
		private Node<E> prev;
		private Node<E> next;
		//char data;

		public Node(E e, Node<E> p, Node<E> n) 
		{
			this.element=e;
			this.prev=p;
			this.next=n;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setNext(Node<E> n) {
			next=n;
		}

		public void setPrev(Node<E> p) {
			prev=p;
		}

	}

	public DoublyLinkedList() {
		header=new Node<>(null,null,null);
		trailer=new Node<>(null,header,null);
		//header.setNext(trailer);
	}

	public int size() { return size; }

	public boolean isEmpty() { return size==0; }

	public E first() {
		if(isEmpty()) return null;
		return header.getNext().getElement();
	}

	public E last() {
		if(isEmpty()) return null;
		return trailer.getPrev().getElement();
	}

	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}

	private E remove( Node<E> node) {
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext(); 
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}   

	public Iterator<E> iterator() {

		return new ListIterator();
	}

	private class ListIterator implements Iterator<E> 
	{
		Node<E> curr;

		public ListIterator() {
			//curr=DoublyLinkedList.this.header;
			curr = header;
		}

		public boolean hasNext() {
			//return curr == curr.getNext();
			if(curr.getNext() != null)
				return true;
			return false;
		}

		public E next() {
			E res = (E) curr.getElement();
			curr = curr.getNext();
			return res;
		}
	}

	public void addFirst(E e)
	{
		addBetween(e, header, header.getNext());
	}

	public void addLast(E e)
	{
		addBetween(e, trailer.getPrev(), trailer);
	}

	public E removeFirst()
	{
		if (isEmpty())	return null;
		return remove(header.getNext());
	}

	public E removeLast()
	{
		if (isEmpty()) return null;
		return remove(trailer.getPrev());
	}

	//QUESTION 5
	public boolean isPalindrome()
	{
		//if size is greater than 2, set the next node from the beginning to first and previous node from end to last
		if(size >= 2)
		{
			Node<E> first = header.next;
			Node<E> last = trailer.prev;

			//loop through the first an last elements
			for(int i=0;i<size/2;i++)
			{
				//if the first element is not equal to the last element, return false
				if(first.getElement()!=last.getElement())
				{
					return false;
				}
				first = first.next;
				last = last.prev;
			}
		}

		return true;

	}

	//Palindrome Tester
	public static void testPalindrome()
	{
		String[] data = {"a", "m", "a", "n", "a", "p", "l", "a", "n", "a", "c", "a", "n", "a", "l", "p", "a", "n", "a", "m", "a"};
		DoublyLinkedList<String> ll = new DoublyLinkedList<String>();

		for(String s : data)
		{
			ll.addLast(s);
		}
		
		System.out.println("isPalindrome(): "+ll.isPalindrome());
	}


	//QUESTION 7
	public Node<E> getKth(int k)
	{
		//if size is greater than or equal to next node
		if(size>=k+1)
		{
			//set temp to be the next node
			Node<E> temp = header.next;
			//loop through 
			for(int i=0; i<k; i++)
			{
				//next node is now temp
				temp = temp.next;
			}

			//return temp
			return temp;
		}
		return null;
	}

	//QUESTION 8
	public void reverse() {
		Node<E> curr = header;
		Node<E> pre = null;
		Node<E> incoming = null;

		while(curr!= null) {
			incoming = curr.next;   //store incoming element
			curr.next = pre;        //swap nodes
			pre = curr;             //increment previous
			curr = incoming;        //increment current
		}

		header = pre; // previous is the latest item
	}


	public static void reverse_test()
	{

		String [] data = {"one" ,"two" ,"three" ,"four", "five", "six"};
		Reverse<String> ll = new Reverse<String>();

		for (String s : data)
		{
			ll.addLast(s);
			//System.out.println("test" + s);
		}
		Iterator<String> iter = ll.iterator();
		//System.out.println("before reverse: " + ll);
		//System.out.println(iter.hasNext());


		System.out.println("Before Reverse:");
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		ll.reverse();

		iter.next();
		System.out.println("\nAfter Reverse:");
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

	//QUESTION 9
	public Node findMinimum()
	{
		if(size>0)
		{
			Node curr = header.next;
			Node minimum = curr;

			//assign value from minimum element to min_no
			Integer min_no = (Integer) minimum.getElement();
			while(curr!=trailer)
			{
				curr = curr.next;
				Integer e = (Integer) curr.getElement();
				if(e!=null)
				{
					//if comparison of element in comparison to min_no is less than 0
					if(e.compareTo(min_no)<0)
					{
						//value in curr is assigned to minimum, value in e is assigned to min_no
						minimum = curr;
						min_no = e;
					}
				}
			}

			return minimum;
		}
		return null;
	}


	//QUESTION 9
	public Node<E> popMin()
	{
		if(size>1)
		{
			//create new nodes with assignments
			Node<E> min_no = this.findMinimum();
			Node<E> node_1 = min_no.prev;
			Node<E> node_2 = min_no.next;
			
			//set Nodes
			node_1.setNext(node_2);
			node_2.setPrev(node_1);
			min_no.setNext(null);

			min_no.setPrev(null);
			size--;
			return min_no;
		}

		//assign value in next node to pos
		Node pos = header.next;
		header.setNext(null);
		trailer.setPrev(null);
		size--;
		return pos;

	}

	public static void main(String[] args) 
	{
		testPalindrome();
		reverse_test();
	}
}