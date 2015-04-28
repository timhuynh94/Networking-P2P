import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/*
 * Zackary J, Caleb W, Tim H
 * This class will act as the sender that deques and sends our the datagram packets
 * 
 * Class Variables:
 * 
 * Constructors 
 * DatagramSender(DatagramSocket socket, OutgoingPacketQueue queue, int packetSize) - only constructor, takes an queue, socket and the size of the packets going out
 * 
 * Methods
 * action(DatagramSocket socket, SynchronizedPacketQueue queue) - uses the passed socket parameter and sends packets that it dequeues from the passed queue
 * 
 */
public class DatagramSender extends DatagramSenderReciever 
{
	
	
	public DatagramSender(DatagramSocket socket, OutgoingPacketQueue queue, int packetSize) throws SocketException
	{
		super(socket,queue,packetSize);
	}
	@Override
	public void action(DatagramSocket socket, SynchronizedPacketQueue queue)
	{		
		try 
		{		
			socket.send(queue.deQueue());
			System.out.println("Datagram Sent");		
		
		} catch (IOException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
		}
	}

}
