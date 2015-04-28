
public class TimeToLive {

	int timeToLive;
	byte[] byteArray;
	
	public TimeToLive(int timeToLive) {
		// TODO Auto-generated constructor stub
	}
	
	public TimeToLive(byte[] byteArray) {
		// TODO Auto-generated constructor stub
	}
	
	public static int getLengthInBytes(){
		return 10;
	}
	
	public int get()
	{
		return this.timeToLive;
	}
	
	public void set(int timeToLive)
	{
		this.timeToLive = timeToLive;
	}
	
	public byte[] getBytes()
	{
		return new byte[this.get()];
	}
	
	public String toString()
	{
		return this.toString();
	}
}
