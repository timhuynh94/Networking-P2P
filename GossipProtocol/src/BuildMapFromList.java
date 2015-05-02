import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class BuildMapFromList 
{
	/*
	 * Zackary J, Caleb W, Tim H
	 * This class will be responsible for building the resources and the hashmap of resources
	 * from a text file
	 * 
	 * Class Variables:
	 * 
	 * Constructors 
	 *  
	 * Methods
	 * 
	 * 
	 * Notes
	 * 
	 */
	
	private char delimeter = ',';
	
	BuildMapFromList(String path)
	{
		File textFile = new File(path);
		String line = "";	
		
		try 
		{
			BufferedReader bufRead = new BufferedReader(new FileReader(textFile));
			
			line = bufRead.readLine();
			
			while(line != null)
			{	

				System.out.println(line);
				if(line != null && line.contains(""+delimeter))
				{
					new Resource(ID.idFactory(),line,delimeter);
				}
				
				line = bufRead.readLine();

			}
			
			bufRead.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	    
	    

	}

}
