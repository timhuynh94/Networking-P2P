import java.security.SecureRandom;
import java.util.Arrays;

/*
 * Zackary J, Caleb W, Tim H
 * This class will act as the unique identifier that is used to identify the associated request 
 * 
 * Class Variables:
 * private byte[] id - the byte array that represents the id
 * private static int idLengthInBytes - the length of the id when it is in a byte array
 * private static LinkedListQueue idQueue - the queue that holds all the created ids
 * private static int maxQueueLength - the maximum number of ids put in the queue before they stop being produced
 * private static int queueLength - the current amount of ids in the queue
 * private static SecureRandom secureRandom - see java documentation
 * private static ID zeroID - an id in which the byte array is made entirely of zeroes
 * 
 * Constructors 
 * ID(byte[] byteArray) - the only constructor, it takes a byte array that it sets the id to
 *  
 * Methods
 * ID idFactory() - a static method that creates arrays of bytes using SecureRandom
 * ID createZeroID() - creates the zero id using the the number of bytes as the length
 * void generateID() - calls idFactory and enqueues the return
 * int getIDLength() - returns the id length
 * LinkedListQueue getQueue() - returns the queue
 * int getMaxQueueLength() - returns the maximum length the queue can be
 * ID getZeroID() - returns a clone of the zero id
 * void setIDLength(int lengthInBytes) - sets the length of the id, removes all from queue and creates new zero id
 * void setMaxQueueLength(int length) -  sets te maximum, removes all from the queue
 * byte[] getBytes() - returns the byte array of the id
 * boolean equals(Object other) - checks if the array of bytes is the same as the one it is compared to and returns boolean
 * int hashCode() - returns Arrays.hashcode of the byte array
 * String toString - 
 * 
 */

public class ID 
{
	private byte[] id;
	private static int idLengthInBytes = 16; //Default option chosen arbitrarily
	private static LinkedListQueue idQueue;
	private static int maxQueueLength;
	private static int queueLength;
	private static SecureRandom secureRandom;
	private static ID zeroID;	
	
	public ID()
	{		
		idQueue = new LinkedListQueue();
		secureRandom = new SecureRandom();
		maxQueueLength = 1000;
	}
	public ID(byte[] byteArray)
	{
		this();
		idLengthInBytes = byteArray.length;
		
	}
	public static ID idFactory()
	{
		ID create;
		byte[] array  = new byte[idLengthInBytes];
		
		secureRandom.nextBytes(array);
		
		create = new ID(array);
		
		return create;
	}
	private static ID createZeroID()
	{
		byte[] array  = new byte[idLengthInBytes];
		
		ID newID = new ID(array);
		
		return newID;
	}
	public static void generateID()
	{
		idQueue.enQueue(ID.idFactory());
		ID.queueLength++;
		
	}
	public static int getIDLength()
	{
		return idLengthInBytes;
	}
	private static LinkedListQueue getQueue()
	{
		return ID.idQueue;
	}
	public static int getMaxQueueLength()
	{
		return maxQueueLength;
	}
	public static int getQueueLength()
	{
		return queueLength;
	}
	public static ID getZeroID()
	{		
		return createZeroID();
	}
	public static void setIDLength(int lengthInBytes)
	{
		idLengthInBytes = lengthInBytes;
		idQueue.removeAll();
		queueLength = 0;		
		createZeroID();
	}
	public static void setMaxQueueLength(int length)
	{
		maxQueueLength =length;
		idQueue.removeAll();
		queueLength = 0;
	}
	public byte[] getBytes()
	{
		return this.id.clone();
	}
	public boolean equals(Object other)
	{
	    ID holder;
		
		if(other == null)
	    {
	    	return false;
	    }
	    if(!(other instanceof ID))
	    {
	    	return false;
	    }

	    holder = (ID) other;
	    
	    return Arrays.equals(this.getBytes(), holder.getBytes());
	 }
	public int hashCode()
	{
		return Arrays.hashCode(id);
	}
	public String toString()
	{
		return "Still need to do";
	}
}
