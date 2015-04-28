import java.net.DatagramSocket;


public class Request implements Runnable {

	/*
	 * This class will be a run as a thread that will handle the the resource request
	 * 
	 * Variables:
	 * 		
	 * 		sender
	 * 			This is a DatagramSender that will send out the request
	 * 
	 *  	receiver
	 *  		This is a DatagramReciever that will receive the requests
	 *  	
	 *  	requestID
	 *  		This is an ID that will represent the ID of this class
	 *  
	 *  	responseID
	 *  		This is an ID that will represent the ID of this class
	 *  
	 *  	timeToLive
	 *  		This is a Time to live and will represent the hop count of a packet 
	 *  
	 *  	SynchrnizedPacketQueue InQueue
	 *  		This will be the incoming packet queue
	 *  	
	 *  	SynchrnizedPacketQueue OutQueue
	 *  		This will be the Outgoing packet queue
	 *  
	 *  	String fileLocation
	 *  		This will be a string that will determine where files will stored 
	 *  
	 *  
	 *  	boolean responseAccepted
	 *  		If a response for a request has been selected, other, non-data, repsonses will be rejected. 
	 *  
	 *   	boolean idMatch
	 *   		If a packet matched the ID of this class ID the flag is set to true, else false
	 *   
	 *     	*FileBuilder * fileBuilder
	 *     		This will construct the data that from the packet messages  
	 *  	
	 *  	boolean requestComplete
	 *  		Returns true if the file is completely constructed
	 *  
	 *  	
	 * 
	 * Constructors:
	 * 
	 * 		private Request()
	 * 			This will construct the ID and the FileBuilder
	 * 
	 * 		public Request(DatagramSocket datagramSocket, SynchrnizedPacketQueue InQueue, SynchrnizedPacketQueue OutQueue)
	 * 			This will construct a DatagramSocket, new DatagramSenders and Receivers, and reference the Synchronized Queues
	 * 
	 * Methods:
	 * 
	 * 		private listOptionsDialog()
	 * 				This will allow the user to view and select which of the options that are available 
	 * 			
	 * 		public void sendMessage()
	 * 			This will send out datagram Packets
	 * 
	 * 		public void receiveMessage()
	 * 			This will receive and build files from the datagramPackets
	 * 
	 * 		public boolean checkID(byte[] id)
	 * 			This will verify if request Id matches the ID this class created
	 * 
	 * 		public boolean isComplete()
	 * 			This will verify if the file is completed 
	 * 
	 * 
	 * 		
	 * 
	 * 
	 */
	
	private Request() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public Request(DatagramSocket datagramSocket, SynchronizedLinkedListQueue InQueue, SynchronizedLinkedListQueue OutQueue)
	{
		// TODO Auto-generated constructor stub
	}
	
	
	public void run()
	{
	
		
		
		
	};

}
