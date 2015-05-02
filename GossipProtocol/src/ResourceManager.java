import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;


public class ResourceManager extends Responder
{
	/*
	 * Zackary J, Caleb W, Tim H
	 * This class will be a subclass of the responder class
	 * 
	 * Class Variables:
	 * 
	 * Constructors 
	 * 
	 *  
	 * Methods
	 * 
	 */
	
	HashMap<ID, Resource> resourceDirectory;
	
	public ResourceManager()
	{
		
	}
	public void loadResourceFrom(File file)
	{
		//Enqueue a series of datagram packets into the outgoing queue?
		//thats what i am going to make it do and we will decide later
		UDPMessage udpMessage = null;
		FileInputStream fileInputStream = null;
	    byte[] fileBytes = new byte[(int) file.length()];
	    byte[] message = new byte[476];
	    
	    try
	    {
	       fileInputStream = new FileInputStream(file);
	       fileInputStream.read(fileBytes);
	       
	       //Idk a faster way to fill an array with another
	       int j = 0;
	       for(int i = 0; i < fileBytes.length; i++)
	       {
	    	   if(j < message.length)
	    	   {
		    	   message[j] = fileBytes[i];    		   
	    	   }
	    	   else
	    	   {
	    		   j = 0;
	    		   /*send off what we have
	    		    * We will need to call the super to get what we need:
	    		    * the two ids and the time to live of our message. Then we can probably give the responder (super)
	    		    * the udp message that it can get the packets it needs to enque, then listen for any pull requests for x time
	    		    */
	    		   udpMessage = new UDPMessage(id1,id2,ttl,message);
	    		   
	    	   }
	       }         
	         
	         fileInputStream.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	    

	}

}
