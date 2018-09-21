
//Implementation of My Singly Linked List
import java.util.Iterator;

class SinglyLinkedList implements Iterable<String> 
{
    
    private static final class Node 
    {
        private String element;
        private Node next;
        
        public Node(String element, Node next) 
        {
            this.element = element;
            this.next = next;
        }
        //basics
        String getElement() 
        {
            return element;
        }
        
        Node getNext() 
        {
            return next;
        }
        
        void setElement(String e) 
        {
            element = e;
        }
        
        void setNext(Node next) 
        {
            this.next = next;
        }
    }
    
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    
    public SinglyLinkedList() 
    {
  
    }
    
    public int size() 
    {
        return size;
    }
    
    public boolean isEmpty() 
    {
        return size == 0;
    }
    
    public String first() 
    {
        return head == null ? null : head.getElement();
    }
    
    public void addFirst(String e) 
    {
     
        // addFirst creates a new node
        // the next pointer of the new head will point to the old head
        head = new Node(e, head); 
        
        // if there is only 1 node, head == tail
        if(size == 0) 
        {
            tail = head;
        }
        
        size++; // increment the counter
    }
    
	 //toString() method:
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[ size(").append(size).append(")").append("\n");
        for(String s : this) {
            sb.append("=> ").append(s).append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
    public Iterator<String> iterator() 
    {
        return new ListIterator();
    }
    
    class ListIterator implements Iterator<String> 
    {
        Node curr;
        
        public ListIterator() 
        {
            // curr = head;
            curr = SinglyLinkedList.this.head; 
        }
        
        public boolean hasNext() 
        {
            return curr != null;
        }
        
        public String next() 
        {
            String res = curr.getElement();
            curr = curr.getNext();
            return res;
        }
    }
}