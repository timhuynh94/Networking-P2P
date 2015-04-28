
public class PortNumber 
{
	/*
	 * Zackary J, Caleb W, Tim H
	 * This class will act as the unique identifier that is used to identify the associated request 
	 * 
	 * Class Variables:
	 * private int portNumber - int that is the port number of the assoiated port
	 * 
	 * Constructors 
	 * PortNumber(int pN) - constructor that takes the int representation of the port number and assigns it to class variable 
	 * 
	 * Methods
	 * int get() - returns the int port number
	 * String toString() - 
	 * 
	 */
	private int portNumber;
	
	public PortNumber(int pN)
	{
		this.portNumber = pN;
		
	}
	public int get()
	{
		return portNumber;
	}
	public String toString()
	{
		return this.portNumber + "";
	}

}
