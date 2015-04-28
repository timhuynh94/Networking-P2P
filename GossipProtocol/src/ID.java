import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class ID {
	
	/*
	 * Caleb Wolfe
	 * 
	 *	This class will generate the ID's for the packets for the gossip protocol
	 *
	 *	Class variables:
	 *		
	 *		idLengthinbytes: 
	 *				This is an int that will represent the length of the id 
	 *		
	 *		idQueue:
	 *				This is a Linkedlist queue that will store all of the ids to be used for future use
	 *
	 *		maxQueueLength:
	 *				This is an int that will represent that max number of ids that will be stored
	 *
	 *		queueLength:
	 *				This is an int that will represent the current length of the queue
	 *
	 *		secureRandom:
	 *				The is a SecureRandom type that will be used to generate the ids 
	 *
	 *		zeroId:
	 *				This is an ID type that will serve as ....... *verify later*
	 *
	 *		id:
	 *			This is a byte array, this will be the format of every id
	 *
	 *
	 *		Constructors:
	 *
	 *			ID()
	 *				This is a private constructor that will initialize most of the state
	 *		
	 *			ID(byte[] id)
	 *				This constructor will intialized the instance variable id to the passed value
	 *
	 *
	 *		Methods:
	 *			
	 *			public static ID idFactory()
	 *			 	This method returns an ID of the proper format 
	 *
	 *			private static ID createZeroId()
	 *				This is for varied sizes of id lengths
	 *			
	 *			public static void  generateID() 
	 *				This will create new IDs		
	 *			
	 *			public static int getIDLength()
	 *				This will return the length of an ID
	 *
	 * 			public static LinkedListQueue getQueue()
	 * 				This will return the queue of IDs
	 * 
	 * 			public static int getMaxQueueLength()
	 * 				This will return the max length of the queue
	 * 
	 * 			public static int getQueueLength()
	 * 				This will return the current length of the queue
	 * 
	 *  		public static ID getZeroID()
	 *				This will return an ID of all zeros 
	 *
	 *			public static setIDLength(int lengthInBytes)
	 *				This will set the length of an ID
	 *
	 *			public static setMaxQueueLength(int lenght)	
	 *				This will set the max length of the Queue
	 *
	 *			public byte[] getBytes()
	 *				returns a byte array of the id 
	 *			
	 *			public boolean equals(Object other)
	 *					This will verify if two objects values are equal
	 *
	 * 			public int hashCode()
	 *					This will return the hascode of an abjects
	 *
	 *			public String toString()
	 *					This will return a representation of an Object as hex values			
	 *					
	 *		
	 *
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	private static int idLengthinBytes;
	private static LinkedListQueue idQueue;
	private static int maxQueueLength;
	private static int queueLength;
	private static SecureRandom secureRandom;
	private static ID zeroID;
	private byte[] id;
	
	private ID ()
	{
		this.idQueue = new LinkedListQueue();
		this.secureRandom = new SecureRandom();
		this.maxQueueLength = 1000;
		
	}
	
	public ID (byte[] id)
	{
		this();
		if(id == null)
		{
			throw new IllegalArgumentException("Byte array is null");
		}
		this.id = id.clone();
		this.idLengthinBytes = this.id.length;
	 
		
	}

	public static ID idFactory()
	{
		byte[] array = new byte[idLengthinBytes];
		
		secureRandom.nextBytes(array);
		return new ID(array);
		
	}
	
	public static void generateID()
	{
		idQueue.enQueue(ID.idFactory());
		queueLength++;
	}
	
	
	private static ID createZeroID()
	{
	
		zeroID = new ID(new byte[idLengthinBytes]);
		return zeroID;
	}
	
	public static int getMaxQueueLength()
	{
		return maxQueueLength;
	}
	
	public static int getQueueLength()
	{
		return queueLength;
	}
	
	public static int getIdLength()
	{
		return idLengthinBytes;
	}
	
	public static void setIDlength(int lengthInBytes)
	{
		idLengthinBytes = lengthInBytes;
		idQueue.removeAll();
		createZeroID();
		queueLength = 0;
	}
	
	public static void setMaxQueueLength(int length)
	{
		maxQueueLength = length;
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
		if(!(other instanceof ID)){
			return false;
		}
		
		holder = (ID) other;
		return Arrays.equals(holder.getBytes(), this.getBytes());
	}
	
	public int hashCode()
	{
		return Arrays.hashCode(id);
	}
	
	public String toString()
	{
		
		return  id.toString();
	}
}
