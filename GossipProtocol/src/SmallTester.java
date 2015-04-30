import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class SmallTester 
{	
	public static void main(String[] args) throws Exception 
	{
		String data;
		data = "/Library/user/file.txt\ntxt\nIm a file ima file ima file";
		Resource r = new Resource(ID.getZeroID(), data, '\n');
	}


}
