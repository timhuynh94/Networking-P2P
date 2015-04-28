import java.net.DatagramPacket;


public class UDPMessage 
{

	/*
	 * Caleb Wolfe
	 * 4/21/15
	 * 
	 * This class will create the messages to be sent over UDP
	 * 
	 * Class Variables:
	 * 
	 * 		id1:
	 * 			This will be of the type ID and will serve as the request id
	 * 
	 * 		id2:
	 * 			This will be of the type ID and will serve as the repsonse id
	 * 
	 * 		timeToLive:
	 * 			This will be of type TimeToLive and will serve as the hop counter of a given time to live
	 * 	
	 * Constructors:
	 * 
	 * 
	 * 		public UDPMessage(ID id1, ID id2, TimeToLive timeToLive, String message)
	 * 			This constructor will build content of string type for listing responses and requests
	 * 
	 * 		public UDPMessage(ID id1, ID id2, TimeToLive timeToLive, byte[] message)
	 * 			This constructor will build content of byte array for sending desired content
	 * 
	 * 	Methods:
	 * 		
	 * 		public DatagramPacket getDatagramPacket()
	 * 			This will return a datagramPacket with an empty message
	 * 
	 * 		public DatagramPacket getDatagramPacket(String paylaod)
	 * 			This will return a datagramPacket with an string message
	 * 		
	 * 		public DatagramPacket getDatagramPacket(byte[] payload)
	 * 			This will return a datagramPacket with an byteArray message
	 * 
	 * 		public ID getId1()
	 * 			This will return id1
	 * 
	 *		public ID getId2()
	 * 			This will return id2
	 * 
	 * 		public TimeToLive getTimeToLive()
	 * 			This will return the timeToLive
	 * 
	 * 		public byte[] getMessage()
	 * 			this will return the message of the UDP packet
	 * 
	 * 		
	 * 
	 * 
	 */
	ID id1;
	ID id2;
	TimeToLive timeToLive;
	byte[] message;
	
	public UDPMessage(ID id1, ID id2, TimeToLive timeToLive, String message) 
	{
		// TODO Auto-generated constructor stub
		this.id1 = id1;
		this.id2 = id2;
		this.timeToLive = timeToLive;
		this.message = message.getBytes();
	}
	
	public UDPMessage(ID id1, ID id2, TimeToLive timeToLive, byte[] message) 
	{
		// TODO Auto-generated constructor stub
		this.id1 = id1;
		this.id2 = id2;
		this.timeToLive = timeToLive;
		this.message = message;
	}
	
	
	public DatagramPacket getDatagramPacket()
	{
		byte[] b = new byte[0];
		DatagramPacket dP = new DatagramPacket(b, b.length);
		
		return dP;
	}
	
	public DatagramPacket getDatagramPacket(String message)
	{
		byte[] b = message.getBytes();
		DatagramPacket dP = new DatagramPacket(b, b.length);
		
		return dP;
	}
	
	public DatagramPacket getDatagramPacket(byte[] array)
	{
		byte[] b = array;
		DatagramPacket dP = new DatagramPacket(b, b.length);
		
		return dP;
	}
	
	

}
