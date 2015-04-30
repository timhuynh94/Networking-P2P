import java.io.File;


public class Resource 
{
	/*
	 * Zackary J, Caleb W, Tim H
	 * This class will represent the file that is a resource of this peer
	 * 
	 * Class Variables:
	 * String description - the text description of this specific file
	 * File location - the File, comprised of the the path to it
	 * String mimeType - the type of file the file is formatted as
	 * ID resourceID - the unique identifier of the resource
	 * 
	 * Constructors 
	 * Resource(ID id, String data) - takes the id it is assigned, and the data that it holds
	 * 
	 * Methods
	 * 
	 */
	
	
	/*
	 * This is going to have to follow a pattern so this operates assuming:
	 * location
	 * mimetype
	 * description
	 */
	String description;
	File location;
	String mimeType;
	ID resourceID;
	
	public Resource(ID id, String data)
	{
		//????Assuming that return is the delimeter
		this(id,data,'\n');
	}
	public Resource(ID id, String data, char delimeter)
	{
		String locationString = "";
		String mimeString = "";
		String descriptionString = "";
		
		int fromHere = 0;
		int toHere = data.indexOf(delimeter);
		
		locationString = data.substring(fromHere,toHere);
		
		fromHere = toHere + 1;
		toHere = data.indexOf(delimeter, fromHere);		

		mimeString = data.substring(fromHere,toHere);
		
		fromHere = toHere + 1;
		
		descriptionString = data.substring(fromHere,data.length());
		
		this.resourceID = id;
		this.location = new File(locationString.trim());
		this.mimeType = mimeString.trim();
		this.description = descriptionString;

	}
	

	public String getDescription() 
	{
		return description;
	}

	public File getLocation() 
	{
		return location;
	}

	public String getMimeType() 
	{
		return mimeType;
	}

	public ID getResourceID() 
	{
		return resourceID;
	}
	public long getSizeInBytes()
	{
		//total size of the file
		return this.location.length();
	}
	public boolean matches(String searchString)
	{
		//Just checking if the deescription contatins it
		return description.contains(searchString);
	}

}
