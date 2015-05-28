package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library 
{
	private ArrayList<User> usersList = new ArrayList<User>();
	private ArrayList<Book> booksList = new ArrayList<Book>();
	
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
	
	public void readUsers(String path) throws IOException //Le todos os usuarios e joga na "List<User> userList"
	{ 			
		String[] str;
		User u = new User();
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String line = buffRead.readLine(); 
		while(line != null)
		{
				str = line.split(","); //Separando cada campo pelo delimitador
				u.setName(str[0]); //Colocando cada campo em um User
				u.setRg(str[1]);
				u.setType(str[2]);
				usersList.add(u); //Adicionando user na lista
				line = buffRead.readLine(); //Lendo proximo registro
		}
		//Ao chegar nesse ponto, temos um userList com todos os usuarios registrados
		//Usar readUsers() para obter a lista de usuarios do arquivo, e usar essa lista para imprimir 
		//		os nomes no "See All the Users" da interface
		
	buffRead.close();
	}
	
	public void readBooks(String path) throws IOException //Le todos os livros e joga na "List<Book> bookList"
	{ 			
		String[] str;
		Book b = new Book();
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String line = buffRead.readLine(); 
		while(line != null)
		{
				str = line.split(","); //Separando cada campo pelo delimitador
				b.setTitle(str[0]); //Colocando cada campo em um Book
				b.setAuthor(str[1]);
				b.setType(str[2]);
				booksList.add(b); //Adicionando book na lista
				line = buffRead.readLine(); //Lendo proximo livro
		}
		//Ao chegar nesse ponto, temos um booksList com todos os livros registrados
		//Usar readBooks() para obter a lista de usuarios do arquivo, e usar essa lista para imprimir 
		//		os nomes no "See All the Users" da interface
		
	buffRead.close();
	}
}
