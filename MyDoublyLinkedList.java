//implementation of my generic DoublyLinkedList

import java.util.Iterator;

public class DoublyLinkedList <E> implements Iterable<E>
{
	// instance variables of the DoublyLinkedList
	private Node<E> header; 
	private Node<E> trailer;
	//public Node<E> head;
	private static int size;

	private static class Node<E> {
		
		private E element; // reference to the element stored at this node
		private Node<E> prev; // reference to the previous node in the list
		private Node<E> next; // reference to the next node in the list
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

	// Constructs a new empty list
	public DoublyLinkedList() {
		header=new Node<>(null,null,null);
		trailer=new Node<>(null,header,null);
		//header.setNext(trailer);
	}

	//Returns the number of elements in the linked list.
	public int size() { return size; }
	
	//Tests if the linked list is empty
	public boolean isEmpty() { return size==0; }
	
	//Returns the first element of the list.
	public E first() {
		if(isEmpty()) return null;
		return header.getNext().getElement();
	}
	
	//Returns the last element of the list.
	public E last() {
		if(isEmpty()) return null;
		return trailer.getPrev().getElement();
	}

	//Adds element e to the linked list in between the given nodes
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}

	//Removes the given node from the list and returns element
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
		
		//Adds element e to the front of the list.
		public void addFirst(E e)
		{
			addBetween(e, header, header.getNext());
		}
		
		//Adds element e to the end of the list.
		public void addLast(E e)
		{
			addBetween(e, trailer.getPrev(), trailer);
		}
		
		//Removes and returns the first element of the list
		public E removeFirst()
		{
			if (isEmpty())	return null;
			return remove(header.getNext());
		}
		
		//Removes and returns the last element of the list
		public E removeLast()
		{
			if (isEmpty()) return null;
			return remove(trailer.getPrev());
		}
	
	public String toString() 
	{
		String s = "[";
		Node<E> v = header.getNext();
		while (v != trailer) 
		{
			s += v.getElement();
			v = v.getNext();
			if( v != trailer) 
				s += ",";
		}
		s += "]";
		return s;
	}
	
public static void main(String[] args) 
{

}
}