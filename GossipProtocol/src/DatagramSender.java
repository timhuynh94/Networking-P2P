import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;


public class DatagramSender  extends DatagramSenderReciever  {

	public DatagramSender(InetSocketAddress inetSocketAddress, SynchronizedLinkedListQueue queue, int packetSize) throws SocketException {
		// TODO Auto-generated constructor stub
		super(inetSocketAddress, queue, packetSize);
	}

	@Override
	public void action(DatagramSocket datagramSocket,
			SynchronizedLinkedListQueue queue) throws IOException {
		// TODO Auto-generated method stub
		
		datagramSocket.send((DatagramPacket) queue.deQueue());
		
	}

}
