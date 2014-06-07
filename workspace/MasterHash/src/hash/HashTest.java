package hash;

import java.util.Random;

public class HashTest 
{
	public static void main(String[] args)
	{
		HashTable<String, String> table = new HashTable<String, String>();
		
		for(int i =0; i<100000; i++)
		{
			table.put(randomString(), randomString());
		}
		
		System.out.println(table.getNumCollisions());
		System.out.println(table.getNumResizes());
	}
	
	public static String randomString()
	{
	   Random r = new Random(); // perhaps make it a class variable so you don't make a new one every time
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < 10; i++) {
	        char c = (char)(r.nextInt((int)(Character.MAX_VALUE)));
	        sb.append(c);
	    }
		return sb.toString();
	}
}
