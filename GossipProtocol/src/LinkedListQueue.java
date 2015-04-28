public class LinkedListQueue 
{
	/*
	 * Zackary Jerabek
	 * This class is a linked list acting as a queue for holding objects
	 * 
	 * Class Variables
	 * front - a Node that is the head of the linked list, it is the one that will be dequeued on call
	 * rear - the last node in the linked list, points to null
	 * 
	 * Constructors
	 * LinkedListQueue() - accepts no parameters, sets front and rear values to null
	 * 
	 * Methods
	 * removeAll() - sets front and rear values to null
	 * isEmpty() - returns boolean - if the front node is null
	 * peek() - returns the front nodes data
	 * deQueue() - returns the data and removes the node from the linked list
	 * enQueue(Object data) - adds a node with the passed data to the end of the linked list
	 * enQueue(LinkedListQueue queue) - takes a linked list queue and adds it to the end of the current queue
	 *  
	 */
	
	private Node front;
	private Node rear;


public LinkedListQueue()
{
	this.front = null;
	this.rear = null;
}
public void removeAll()
{
	this.front = null;
	this.rear = null;
}
public boolean isEmpty()
{
	return this.front == null;
}
public Object peek()
{
	return this.front.data;
}
public Object deQueue() throws QueueUnderflowException
{
	Object hold = this.front.data;
	this.front = this.front.next;
	
	return hold;
}
public void enQueue(Object data)
{
	if(data == null)
	{
        throw new IllegalArgumentException("Null value.");
	}
		Node hold = new Node(data,null);
		
		if(this.front == null)
		{
			this.front = hold;
		}
		
		if(this.rear != null)
		{
			this.rear.setNext(hold);
		}
		
		this.rear = hold;
	
	
}
public void enQueue(LinkedListQueue queue)
{
	if(queue == null || this.front == queue.front)
	{
        throw new IllegalArgumentException("Null value.");
	}
		this.rear.setNext(queue.front);
		this.rear = queue.rear;
		
		queue.removeAll();
			
}

	private class Node
	{
		private Object data;
		private Node next;
		
		public Node(Object data, Node next)
		{
			this.data = data;
			this.next = next;
		}
		public Object getData()
		{
			return this.data;
		}
		public Node getNext()
		{
			return this.next;
		}
		public void setNext(Node next)
		{
			this.next = next;
		}
	}


}