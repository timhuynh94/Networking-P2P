import java.io.IOException;
import java.nio.ByteBuffer;

public class TimeToLive 
{
	/*
	 * Zackary J, Caleb W, Tim H
	 * This class will act as the sender that deques and sends our the datagram packets
	 * 
	 * Class Variables:
	 * private int timeToLive - the time remaining before the request is no longer being handled
	 * 
	 * Constructors 
	 * TimeToLive(int ttl) - sets int to the passed value
	 * TimeToLive(byte[] byteArray) - given the byte[] it extracts the int value
	 * 
	 * Methods
	 * static int getLengthInBytes() - returns the length of the time to live int value when it is in byte[] form
	 * int get() - returns the timetolive in int format
	 * void set(int ttl) - set the time to live useing a passed int value
	 * byte[] getBytes() - returns the timetolive represented in a byte[]
	 * String toString() - 
	 * 
	 */
	
	private int timeToLive;
		
	public TimeToLive(int ttl)
	{
		this.timeToLive = ttl;
		
	}
	public TimeToLive(byte[] byteArray)
	{
		this.timeToLive = java.nio.ByteBuffer.wrap(byteArray).getInt();
	}
	public static int getLengthInBytes()
	{
		//should only need four to represent an int
		return 4;
	}
	public int get()
	{
		return this.timeToLive;
	}
	public void set(int ttl)
	{
		this.timeToLive = ttl;
	}
	public byte[] getBytes() throws IOException
	{
		return ByteBuffer.allocate(TimeToLive.getLengthInBytes()).putInt(this.timeToLive).array();
	     
	}
	public String toString()
	{
		return (this.timeToLive + "");
	}

}
