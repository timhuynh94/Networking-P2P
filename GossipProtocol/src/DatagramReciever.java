import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;


public class DatagramReciever extends DatagramSenderReciever {

	
	/*
	 * Caleb Wolfe 
	 * 4/10/15
	 * 
	 * This class will process incoming packets and interpret the data
	 * 
	 * Method:
	 * 		public void action(DatagramSocket datagramSocket,SynchronizedLinkedListQueue queue)
	 * 			This will take the packets and build the file
	 * 
	 * 
	 */
	
	public DatagramReciever( InetSocketAddress inetSocketAddress, SynchronizedLinkedListQueue queue, int packetSize) throws SocketException 
	{
		// TODO Auto-generated constructor stub
		super(inetSocketAddress, queue, packetSize);
	}


	@Override
	public void action(DatagramSocket datagramSocket,SynchronizedLinkedListQueue queue) throws IOException
	{
		// TODO Auto-generated method stub
		while(!queue.isEmpty())
		{
			byte[] array = new byte[100];
			DatagramPacket datagram  = new  DatagramPacket(array, array.length);
			try {
				datagramSocket.receive(datagram);
				queue.enQueue(datagram);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}
		}
	}
}
