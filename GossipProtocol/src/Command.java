import java.io.*;

abstract public class Command implements Cloneable, Comparable
{
	private String caseSensitive;
	private String commandName;
	private String description;
	private String parameters;
	


	public Command(String commandName,String caseSensitive)
	{
		if(commandName == null)throw new IllegalArgumentException("STRING BITCH!!!!!!");
		this.commandName = commandName;

	}//constructor



	abstract public void execute();
	public Object clone()
	{
		return new Object();
	}
	
	public int compareTo()
	{
		return 10;
	}
	
	
	
	
	public String getCommandName()
	{
		return this.commandName;
	};
	public String getDestcription()
	{
		return this.description;
	};
	public String getParameter()
	{
		return " ";
	};
	public void getParameter(String delimeter){};
	public int hashCode()
	{
		return this.hashCode();
	}
	
	public void print(String message)
	{
		System.out.print(message);
	}
	
	public void println()
	{
		System.out.println();
	}
	
	public void setParameters(String parameters){}
	
	public String toString()
	{
		return this.toString();
	}
	public boolean hasParameters(){return true;}
}//class