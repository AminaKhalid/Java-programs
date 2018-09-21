
//My Stack implementation

public class StackArray<E> 
{

	public static final int CAPACITY=1000; // default array capacity
	private E[] data;
	private int a = -1;
	public StackArray( ) 
	{ 
		this(CAPACITY);  //constructs stack
	}
	public StackArray(int capacity)  //constructs stack with given capacity
	{
		data = (E[ ]) new Object[capacity];
	}
		
	/*
	 * Returns the number of elements in the stack.
	 */
	public int size()
	{
		return (a+1);
	}
	
	/*Tests whether the stack is empty.*/
	public boolean isEmpty()
	{
		return(a==-1);
	}
	
	/*Inserts an element at the top of the stack.*/
	public void push(E e) throws IllegalStateException
	{
		if(size()==data.length)throw new IllegalStateException("Stack is full");
		data[++a] = e;// increment t before storing new item
	}
	
	/*Returns but does not remove the element at the top of the stack.*/

	public E top()
	{
		if (isEmpty( )) return null;
		return data[a];
	}
	
	/*Removes and returns the top element from the stack.*/
	public E pop()
	{
		if (isEmpty( )) return null;
		E answer = data[a];
		data[a] = null; // dereference to help garbage collection
		a--;
		return answer;
	}
}

