import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class SynchronizedPacketQueue extends SynchronizedLinkedListQueue 
{
	/*
	 * Zackary Jerabek
	 * This class is simply a linked list acting as a queue for holding objects, however all methods are synchronized
	 * Also it returns null if the queue is empty for peek and dequeue
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
	public synchronized DatagramPacket peek()
	{
		if(super.isEmpty())
		{
			return null;
		}
		else
		{
			return (DatagramPacket) super.peek();
		}
		
		
	}
	public synchronized DatagramPacket deQueue()
	{
		if(super.isEmpty())
		{
			return null;
		}
		else
		{
			return (DatagramPacket) super.deQueue();
		}		
		
	}
	public synchronized void enQueue(DatagramPacket packet)
	{
		super.enQueue(packet);
	}
	public synchronized void enQueue(SynchronizedPacketQueue queue)
	{
		super.enQueue(queue);
	}


}
