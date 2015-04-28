import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/*
 * Zackary J, Caleb W, Tim H
 * This class will act as the receiver for the datagram packets, by listening on a port and enqueueing the datagrams
 * 
 * Class Variables:
 * 
 * Constructors 
 * DatagramReciever(DatagramSocket socket, IncomingPacketQueue queue, int packetSize) - only constructor, takes the socket
 * and recieves datagrams of size (packetSize) then puts them into the passed incoming queue
 * 
 * Methods
 * action(DatagramSocket socket, SynchronizedPacketQueue queue) - uses the passed socket parameter and receives packets that it enques in the passed queue
 * 
 */

public class DatagramReciever extends DatagramSenderReciever 
{
	
	
	public DatagramReciever(DatagramSocket socket, IncomingPacketQueue queue, int packetSize) throws SocketException
	{
		super(socket,queue,packetSize);
	}
	@Override
	public void action(DatagramSocket socket, SynchronizedPacketQueue queue)
	{
		DatagramPacket p = new DatagramPacket(new byte[super.getPacketSize()],super.getPacketSize());
		try 
		{		
			socket.receive(p);
			System.out.println("Datagram Recieved");
			queue.enQueue(p);			
		
		} catch (IOException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
		}
	}

}
