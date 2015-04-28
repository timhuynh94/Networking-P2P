import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.concurrent.atomic.AtomicBoolean;
/*
 * Zackary J, Caleb W, Tim H
 * This class acts as the super class to the sender and reciever subclasses
 * 
 * Class Variables:
 * 
 * Constructors 
 * DatagramSenderReciever(DatagramSocket in, SynchronizedPacketQueue queue, int packetSize) - only constructor, takes an queue, socket and the size of the packets coming in/out
 * 
 * Methods
 * action(DatagramSocket socket, SynchronizedPacketQueue queue) - overwritten
 * getPort() - 
 * isStopped() - 
 * run() - 
 * Thread startAsThread() - 
 * stop() - 
 * 
 * 
 */

public class DatagramSenderReciever implements Runnable
{
	private AtomicBoolean done;
	private DatagramSocket datagramSocket; //The socket that we are listening or sending on
	private int packetSize;
	private SynchronizedPacketQueue queue;	
	
	
	DatagramSenderReciever(DatagramSocket in, SynchronizedPacketQueue queue, int packetSize) throws SocketException
	{
		this.packetSize = packetSize;
		this.queue = queue;		
		this.datagramSocket = in;				
	}
	public void action(DatagramSocket socket, SynchronizedPacketQueue queue)
	{	
		//overwritten
	}
	public int getPort()
	{
		return datagramSocket.getPort();
	}
	public int getPacketSize()
	{
		return this.packetSize;
	}
	public boolean isStopped()
	{
		//Still need to implement
		return false;
	}
	public void run()
	{
		//need to do
	}
	public Thread startAsThread()
	{
		//need to do
		return new Thread();
	}
	public void stop()
	{
		//need to do
	}
	

}
