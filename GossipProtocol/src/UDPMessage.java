import java.io.IOException;
import java.net.DatagramPacket;


public class UDPMessage 
{
	private ID id1;
	private ID id2;
	private TimeToLive timeToLive;
	private byte[] message;
	private int messageLength = 476;
	
	public UDPMessage(ID id1, ID id2, TimeToLive ttl, String message) throws Exception
	{
		this(id1, id2, ttl, message.getBytes());
	}
	public UDPMessage(ID id1, ID id2, TimeToLive ttl, byte[] message) throws Exception
	{
		//need more checking
		
		this.id1 = id1;
		this.id2 = id2;
		this.timeToLive = ttl;
		if(message.length <= 476)
		{
			this.message = message;
		}
		else
		{
			throw new Exception();
		}
		
	}
	public UDPMessage(DatagramPacket packet)
	{
		byte[] id1Bytes = new byte[ID.getIDLength()];
		byte[] id2Bytes = new byte[ID.getIDLength()];
		byte[] ttlBytes = new byte[TimeToLive.getLengthInBytes()];
		byte[] message = new byte[this.messageLength];
		int j;//a counter used in loops
		
		//This is assuming that we have received a datagram packet that follows the UDP message protocol
		
		byte[] bytes = packet.getData();
		
		//The first ID first 16
		j = 0;
		for(int i = 0; i < ID.getIDLength();i++)
		{
			id1Bytes[j] = bytes[i];
			j++;
		}
		
		//The second ID second 16
		j = 0;
		for(int i = ID.getIDLength(); i < ((ID.getIDLength() * 2) - 1);i++)
		{
			id2Bytes[j] = bytes[i];		
			j++;
		}
		//The next 4 (33 - 36) bytes should be the time to live
		j = 0;
		for(int i = ((ID.getIDLength() * 2) - 1); i < (((ID.getIDLength() * 2) - 1) + TimeToLive.getLengthInBytes());i++)
		{
			ttlBytes[j] = bytes[i];
			j++;
		}
		
		//The last XX (37 - End) bytes should be the message itself
		j = 0;
		for(int i = (ID.getIDLength() * 2) + TimeToLive.getLengthInBytes(); i < this.messageLength + ((ID.getIDLength() * 2) + TimeToLive.getLengthInBytes()); i++)
		{
			message[j] = bytes[i];
			j++;
		}
		
		//Create instances and initialize
		this.id1 = new ID(id1Bytes);
		this.id2 = new ID(id2Bytes);
		this.timeToLive = new TimeToLive(ttlBytes);
		
	}
	public DatagramPacket getPacket() throws IOException
	{
		//Returns a packet with the message and length having been set
		//DatagramPacket dp = new DatagramPacket(message,message.length);//This would only contain the message
		DatagramPacket packet;
		byte[] id1Bytes = new byte[ID.getIDLength()];
		byte[] id2Bytes = new byte[ID.getIDLength()];
		byte[] ttlBytes = new byte[TimeToLive.getLengthInBytes()];
		byte[] full = new byte[(ID.getIDLength() * 2) + TimeToLive.getLengthInBytes() + this.messageLength];
		int j;
		
		id1Bytes = this.id1.getBytes();
		id2Bytes = this.id2.getBytes();
		ttlBytes = this.timeToLive.getBytes();
		
		j = 0;
		for(int i = 0; i < ID.getIDLength(); i++)
		{
			full[i] = id1Bytes[j];
			j++;
		}
		
		j = 0;
		for(int i = ID.getIDLength(); i < (ID.getIDLength() * 2); i++)
		{
			full[i] = id2Bytes[j];
			j++;
		}
		
		j = 0;
		for(int i = ID.getIDLength() * 2; i < (ID.getIDLength() * 2) + TimeToLive.getLengthInBytes(); i++)
		{
			full[i] = ttlBytes[j];
			j++;
		}

		j = 0;
		for(int i = (ID.getIDLength() * 2) + TimeToLive.getLengthInBytes(); i < this.messageLength + ((ID.getIDLength() * 2) + TimeToLive.getLengthInBytes()); i++)
		{
			full[i] = message[j];
			j++;
		}
		
		
		packet = new DatagramPacket(full, full.length);
		
		return packet;
	}
	public DatagramPacket getPacket(String payload)
	{
		//uses BUT DOES NOT SET THE INSTANCE VARIABLES TO the incoming payload
		//Assuming that payload means it is the whole intended datagram packet
		DatagramPacket dp = new DatagramPacket(payload.getBytes(),payload.getBytes().length);
		return dp;
	}
	public DatagramPacket getPacket(byte[] payload)
	{
		//uses BUT DOES NOT SET THE INSTANCE VARIABLES TO the incoming payload
		DatagramPacket dp = new DatagramPacket(payload,payload.length);
		return dp;
	}
	public ID getID1()
	{
		return this.id1;
	}
	public ID getID2()
	{
		return this.id2;
	}
	public TimeToLive getTimeToLive()
	{
		return this.timeToLive;
	}
	public byte[] getMessage()
	{
		return this.message.clone();
	}
	
	

}
