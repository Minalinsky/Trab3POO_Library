package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Library 
{	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	
	public void registerUser(String path, String name, String rg, String type) throws IOException
	{ 
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));
		buffWrite.append(name + "," + rg + "," + type + "," + "false" + "\n");
		buffWrite.close();
	} 
	
	public void registerBook(String path, String title, String author, String type) throws IOException
	{
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));
		buffWrite.append(title + "," + author + "," + type + "\n");
		buffWrite.close(); 
	}
	
	public void registerLoan(String path, String name, String title, String returnDate) throws IOException
	{
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));
		buffWrite.append(name + "," + title + "," + returnDate + "," + "false" +"\n");
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
				u.setBanned(str[3]);
				list.add(u); //Adicionando user na lista
				line = buffRead.readLine(); //Lendo proximo registro
		}
		
	buffRead.close();
	return list;
	}
	
		//Ao chegar nesse ponto, temos um userList com todos os usuarios registrados
		//Usar readUsers() para obter a lista de usuarios do arquivo, e usar essa lista para imprimir 
		//		os nomes no "See All the Users" da interface
		
	
	public ArrayList<Book> readBooks(String path) throws IOException //Le todos os livros e joga na "List<Book> bookList"
	{ 			
		ArrayList<Book> booksList = new ArrayList<Book>();
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
				booksList.add(b); //Adicionando book na lista
				line = buffRead.readLine(); //Lendo proximo livro
		}
		//Ao chegar nesse ponto, temos um booksList com todos os livros registrados
		//Usar readBooks() para obter a lista de usuarios do arquivo, e usar essa lista para imprimir 
		//		os nomes no "See All the Users" da interface
		
	buffRead.close();
	return booksList;
	}
	
	public ArrayList<Loan> readLoans(String path) throws IOException //Le todos os usuarios e retorna uma lista de usuarios
	{ 		
		ArrayList<Loan> list = new ArrayList<Loan>();
		String[] str;
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String line = buffRead.readLine(); 
		while(line != null)
		{
				Loan l = new Loan();
				str = line.split(","); //Separando cada campo pelo delimitador
				l.setRg(str[0]); //Colocando cada campo em um User
				l.setTitle(str[1]);
				l.setReturnDate(str[2]);
				l.setOk(str[3]);
				list.add(l); //Adicionando user na lista
				line = buffRead.readLine(); //Lendo proximo registro
		}
		
	buffRead.close();
	return list;
	}
}