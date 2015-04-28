


public class UIController {
	/*
	 * 	Caleb Wolfe
	 *	4/22/15 
	 *	
	 *	Variables:
	 *		
	 *		commandProcessor
	 *			This is a commandProcessor that will make and utilze commands
	 *
	 *		done
	 *			A boolean that will determine if a request is completed
	 *
	 *		IncomingPacketsFromPeerQueue
	 *			A queue that will be Pakets that will be recieved 
	 *
	 *		OutgoingPacketsFromPeerQueue
	 *			A queue of packets that will be recieved
	 *
	 *		peerAddress 
	 *			An InetSocketAdress that contains the peers information
	 *
	 *		receiveFromPeer 
	 *			A DatagramReciever that will process incoming packets
	 *
	 *		sendToPeer
	 *			A DatagramSenderReciever that will process outgoing packets
	 *
	 *	Constructor:
	 *		
	 *		UIController()
	 *
	 * 
	 */
	
		
	public UIController(int portNumber, int packetSize)
	{
		
		
	}
	
	public void start()
	{
		
	}
		
	
	
	abstract class UIControllerCommand extends Command{

	
		public UIControllerCommand(String commandName, String description) {
			super(commandName, description);
			// TODO Auto-generated constructor stub
		}
		
		public CommandProcessor getCommandProcessor()
		{
			return null;
		}
		
		public boolean getDoneFlag()
		{
				return false;
		}
		
		public void print(String message)
		{
			System.out.print(message);
		}
		
		public void println()
		{
			System.out.println();
		}
		
		public void println(String message)
		{
			System.out.println(message);
		}
		
		public void setDoneFlag(boolean flag)
		{
			
		}
		
		public void newRequestThread(Request request)
		{
			
		};


	}//Absract UIcommand
	
	private class CommandError extends UIControllerCommand
	{
		public CommandError(String commandName, String description) {
			super(commandName, description);
			// TODO Auto-generated constructor stub
		}

		

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void execute() {
			// TODO Auto-generated method stub
			this.print("Error this is not the correct input");
		}
	}
	
	private class CommandNone extends UIControllerCommand
	{

		public CommandNone(String commandName, String description) {
			super(commandName, description);
			// TODO Auto-generated constructor stub
		}

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void execute() {
			// TODO Auto-generated method stub
			this.print("Command does not exist");
		}
		
	}
	
	
	public class CommandHelp extends UIControllerCommand
	{

		public CommandHelp(String commandName, String description) {
			super(commandName, description);
			// TODO Auto-generated constructor stub
		}

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void execute() {
			// TODO Auto-generated method stub
			
		}
		
	}
}





