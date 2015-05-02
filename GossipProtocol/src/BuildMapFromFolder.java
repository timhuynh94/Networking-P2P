import java.io.File;
import java.util.HashMap;


public class BuildMapFromFolder 
{
	/*
	 * Zackary J, Caleb W, Tim H
	 * This class will be responsible for building the resources and the hashmap of resources
	 * from a folder path
	 * 
	 * Class Variables:
	 * 
	 * Constructors 
	 *  
	 * Methods
	 * 
	 */
	String path;
	HashMap<ID,Resource> map;
	
	
	public BuildMapFromFolder(String path)
	{
		int count;
		this.path = path;
		String[] files;
		ID id;
		String mime;
		String desc = "No Description";
		
		File file = new File(path);
		count = file.list().length;
		files = new String[count];
		
		files = file.list();
		
		
		for(String thisFile : files)
		{
			id = ID.idFactory();
			map.put(id, new Resource(id, thisFile + thisFile.substring(thisFile.indexOf('.')) + desc));
		}		
		
	}
	public HashMap getMap()
	{
		return map;
	}
	
	
	
	
	
	
}
