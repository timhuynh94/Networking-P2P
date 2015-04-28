import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;


public class Tester 
{
	public static void main(String[] args) 
	{
		//Ip adress and port
		InetAddress ip = null;
		try 
		{
			ip = InetAddress.getByName("localhost");
			
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		int port = 12345;
		
		//Outgoing queue
		OutgoingPacketQueue outQueue = new OutgoingPacketQueue();
		//Incoming Queue
		IncomingPacketQueue inQueue = new IncomingPacketQueue();
		
		//Packets
		byte[] buf = new byte[5000];
		int length = 5000;
		for(int i = 0; i < 5; i++)
		{
			DatagramPacket packet = new DatagramPacket(buf, length);
			packet.setData(("Message"+i).getBytes());
			packet.setPort(port);
			packet.setAddress(ip);
			
			outQueue.enQueue(packet);
		}

		//Datagram Sender
		DatagramSocket sendSock = null;
		DatagramSender sender = null;
		try 
		{
			sendSock = new DatagramSocket(54321, ip);
			sender = new DatagramSender(sendSock, outQueue, length);
		
		
		
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		//Datagram reciever
		DatagramSocket recieveSock = null;
		DatagramReciever reciever = null;
		try 
		{
			recieveSock = new DatagramSocket(port, ip);
			reciever = new DatagramReciever(recieveSock, inQueue, length);		
		
		} catch (SocketException e) {
			System.out.println("Recieve Socket fail");
			e.printStackTrace();
		}
		
		//Send and Recieve
		for(int i = 0; i < 3;i++)
		{
			sender.action(sendSock, outQueue);
			reciever.action(recieveSock,inQueue);
		}
		
		
		System.out.println("Cycling messages: ");
		while(inQueue.peek() != null)
		{
			System.out.println("Printing: ");
			String message = new String(inQueue.deQueue().getData());
			System.out.println(message);
			
		}
		
		TimeToLive ttl = new TimeToLive(987654321);
		byte[] array = null;
		try {
			array = ttl.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(Arrays.toString(array));
		
		TimeToLive ttyl = new TimeToLive(array);
		int number = ttyl.get();
		System.out.println("Was this your number?: " + number);

	}

}
