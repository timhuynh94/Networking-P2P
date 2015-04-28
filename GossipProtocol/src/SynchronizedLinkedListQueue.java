
public class SynchronizedLinkedListQueue extends LinkedListQueue 
{
	/*
	 * Zackary Jerabek
	 * This class is simply a linked list acting as a queue for holding objects, however all methods are synchronized
	 * 
	 * Class Variables

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
	
	public SynchronizedLinkedListQueue()
	{
		super();
	}
	public synchronized void removeAll()
	{
		super.removeAll();
	}
	public synchronized boolean isEmpty()
	{
		return super.isEmpty();
	}
	public synchronized Object peek()
	{
		return super.peek();
	}
	public synchronized Object deQueue()
	{
		return super.deQueue();
	}
	public synchronized void enQueue(Object data)
	{
		super.enQueue(data);
	}
	public synchronized void enQueue(LinkedListQueue queue)
	{
		super.enQueue(queue);
	}
}
