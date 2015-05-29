package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
	
	public ArrayList<User> readUsers(String path) throws IOException //Le todos os usuarios e retorna uma lista de usuarios
	{ 		
		ArrayList<User> list = new ArrayList<User>();
		String[] str;
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String line = buffRead.readLine(); 
		while(line != null)
		{
			User u = new User();
			str = line.split(","); //Separando cada campo pelo delimitador
			u.setName(str[0]); //Colocando cada campo em um User
			u.setRg(str[1]);
			u.setType(str[2]);
			list.add(u); //Adicionando user na lista
			line = buffRead.readLine(); //Lendo proximo registro
		}		
	buffRead.close();
	return list;
	}
	
public ArrayList<Book> readBooks(String path) throws IOException //Le todos os livros e joga na "List<Book> bookList"
	{ 	
		ArrayList<Book> list = new ArrayList<Book>();
		String[] str;
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String line = buffRead.readLine(); 
		while(line != null)
		{
			Book b = new Book();
			str = line.split(","); //Separando cada campo pelo delimitador
			b.setTitle(str[0]); //Colocando cada campo em um Book
			b.setAuthor(str[1]);
			b.setType(str[2]);
			list.add(b); //Adicionando book na lista
			line = buffRead.readLine(); //Lendo proximo livro
		}
	buffRead.close();
	return list;
	}
}