package library;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Library 
{
	public void registerUser(String path, String name, String rg, String type) throws IOException
	{ 
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));
		buffWrite.append(name + "," + rg + "," + type + "\n");
		buffWrite.close();
	} 
	
	public void registerBook(String path, String title, String author, String type) throws IOException
	{
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));
		buffWrite.append(title + "," + author + "," + type + "\n");
		buffWrite.close(); 
	}
}
