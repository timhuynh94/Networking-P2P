public class QueueUnderflowException extends RuntimeException{
	/*
	 * Zackary Jerabek
	 * This class extends Exception and acts as an indication that the queue is empty
	 *  
	 */
	public QueueUnderflowException(String message)
 	{
		super(message);
	}

}
