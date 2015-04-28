import java.io.*;
import java.util.*;

public class CommandProcessor
{	/*
	Caleb D. Wolfe
	May 4, 2014

	This class creates a Registry of commands that can be executed.

	 Class Variables:

	 		commandRegistry
				A Map that will store a Sting key and a command value
	Constructor:
		CommandProcessor()
			Intializes the Map to a HashTable.


	Methods:

		private void convertToKey
			Trims and convervts to lower case, a string, it will

		private Map<String, Command> getCommandRegistry()
			Returns the Command Registry

		public void register(Command command)
			puts a new command into the Command Registry.

		public Command[] getAllCommands()
			returns all the commands in the register as a Command array.

		public void runCommand(String commandAndParameters)
			Runs the given command name with the given paramenters.




		Modification History:
			May 3, 2014
				Original Creation
			May 4, 2014
				Added RunCommandMethod
	*/ 


		private Map<String, Command> commandRegistry;

		public CommandProcessor()
		{
			commandRegistry = new Hashtable<String, Command>();
		}

		private String convertToKey(String data)
		{
			int space;
			data = data.toLowerCase();
			data = data.trim();
			if(data.indexOf(" ")>0)
				{
					space = data.indexOf(" ");
					data = data.substring(0,space);
			
				}

			return data;
		}

		private Map<String, Command> getCommandRegistry(){return this.commandRegistry;}

	
		public void register(Command command)
		{
			this.getCommandRegistry().put(Command, Comman);
		}
		
		

	 	public Command[] getAllCommands()
	 	{

			Command[] commands;

			commands = new Command[getCommandRegistry().size()];
			commands = this.commandRegistry.values().toArray( new Command [this.commandRegistry.size()]);


			return commands;

		}//getAll

		public void runCommand(String commandAndParameters) throws IOException, UnrecognizedCommandException
		{
			String command;
			String parameters;
			int space;
			String cap="";

			command = convertToKey(commandAndParameters);

			parameters = null;


			
			if(cap.indexOf(" ")>0)
			{
				//removes the command from the inputed string

				space = cap.indexOf(command);
				parameters = cap.substring(space+command.length(), cap.length());

			}

			if(getCommandRegistry().get(command) == null )
			{
				throw new UnrecognizedCommandException();
			}
			else{ }
		}//runCommand





}//class