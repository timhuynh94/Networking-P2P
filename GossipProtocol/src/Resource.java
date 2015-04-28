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
	
	String description;
	File location;
	String mimeType;
	ID resourceID;
	
	public Resource(String description, File location, String mimeType, ID resourceID)
	{
		//If data is just this all together then lets just pass it all this
		//Otherwise we could do something like make a method that does some of this automatically given a folder path
		//However the description has to be person made likely
		this.description = description;
		this.location = location;
		this.mimeType = mimeType;
		this.resourceID = resourceID;
		
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
		//likely going to be a check to see if key phrases or something similar is in the string
	}

}
