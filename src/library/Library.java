package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Library 
{	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
		
	public void registerUser(String name, String rg, String type) throws IOException
	{ 
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("Users.csv", true));
		buffWrite.append(name + "," + rg + "," + type + "\n");
		buffWrite.close();
	} 
	
	public void registerBook(String title, String author, String type) throws IOException
	{
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("Books.csv", true));
		buffWrite.append(title + "," + author + "," + type + "\n");
		buffWrite.close(); 
	}
	
	public void writeLoan(String name, String title, String returnDate) throws IOException
	{
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("Loans.csv", true));
		buffWrite.append(name + "," + title + "," + returnDate +"\n");
		buffWrite.close(); 
	}
	
	public ArrayList<User> readUsers() throws IOException //Le todos os usuarios e retorna uma lista de usuarios
	{ 		
		ArrayList<User> list = new ArrayList<User>();
		String[] str;
		BufferedReader buffRead = new BufferedReader(new FileReader("Users.csv"));
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
	
	public ArrayList<Book> readBooks() throws IOException //Le todos os livros e joga na "List<Book> bookList"
	{ 			
		ArrayList<Book> booksList = new ArrayList<Book>();
		String[] str;
		BufferedReader buffRead = new BufferedReader(new FileReader("Books.csv"));
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
	buffRead.close();
	return booksList;
	}
	
	public ArrayList<Loan> readLoans() throws IOException //Le todos os usuarios e retorna uma lista de usuarios
	{ 		
		ArrayList<Loan> list = new ArrayList<Loan>();
		String[] str;
		BufferedReader buffRead = new BufferedReader(new FileReader("Loans.csv"));
		String line = buffRead.readLine(); 
		while(line != null)
		{
				Loan l = new Loan();
				str = line.split(","); //Separando cada campo pelo delimitador
				l.setRg(str[0]); //Colocando cada campo em um User
				l.setTitle(str[1]);
				l.setReturnDate(str[2]);
				list.add(l); //Adicionando user na lista
				line = buffRead.readLine(); //Lendo proximo registro
		}
		
	buffRead.close();
	return list;
	}
	
	public ArrayList<Ban> readBans() throws IOException //Le todos os usuarios e retorna uma lista de usuarios
	{ 		
		ArrayList<Ban> list = new ArrayList<Ban>();
		String[] str;
		BufferedReader buffRead = new BufferedReader(new FileReader("Bans.csv"));
		String line = buffRead.readLine(); 
		while(line != null)
		{
				Ban b = new Ban();
				str = line.split(","); //Separando cada campo pelo delimitador
				b.setRg(str[0]); //Colocando cada campo em um User
				b.setBannedDate(str[1]);
				list.add(b); //Adicionando user na lista
				line = buffRead.readLine(); //Lendo proximo registro
		}
	buffRead.close();
	return list;
	}
	
	public void registerLoan(String rg, String title) throws IOException
	{
		ArrayList<User> usersList = this.readUsers();
    	ArrayList<Loan> loansList = this.readLoans();
    	ArrayList<Ban> bansList = this.readBans();
    	
    	Date aux = new Date(this.date.getYear(), this.date.getMonth(), this.date.getDate());
    	
    	List<User> filteredList = usersList.stream().filter(u->u.getRg().equals(rg))
    			.collect(Collectors.toList()); //filtrando usuario com o RG passado
    	User filteredUser = filteredList.get(0);
    	
    	long numberLoans = loansList.stream().filter(l->l.getRg().equals(rg)).collect(Collectors.counting()); //contando quantos emprestimos ja fez
    	
    	if(!bansList.stream().map(b->b.getRg()).anyMatch(b-> b.equals(rg)))
    	{ 
    		if(filteredUser.getType().equals("teacher"))
    		{
    			if(numberLoans < 6)
    			{
    				aux.setDate(this.date.getDate() + 60);
    				this.writeLoan(rg, title, this.formatter.format(aux));
    			}
    			else
    			{
    				// Tratar - Imprimir "Numero Maximo de Emprestimos permitidos(6)!!"
    				System.out.println("Numero Maximo de Emprestimos permitidos(6)!!");//TESTE
    			}
    		}
    		else if(filteredUser.getType().equals("student"))
    		{
    			if(numberLoans < 4)
    			{
    				aux.setDate(this.date.getDate() + 15);
    				this.writeLoan(rg, title, this.formatter.format(aux));
    			}
    			else
    			{
    				// Tratar - Imprimir "Numero Maximo de Emprestimos permitidos(4)!!"
    				System.out.println("Numero Maximo de Emprestimos permitidos(4)!!");//TESTE
    			}
    		}
    		else if(filteredUser.getType().equals("comunity"))
    		{
    			if(numberLoans < 2)
    			{
    				aux.setDate(this.date.getDate() + 15);
    				this.writeLoan(rg, title, this.formatter.format(aux));
    			}
    			else
    			{
    				// Tratar - Imprimir "Numero Maximo de Emprestimos permitidos(2)!!"
    				System.out.println("Numero Maximo de Emprestimos permitidos(2)!!");//TESTE
    			}
    		}
    	}
    	else
    	{
    		//Tratar quando o usuario está banido
    	}
	}
	
	public void removeLoan(String rg, String title) throws IOException
	{
			BufferedReader br = new BufferedReader(new FileReader("Loans.csv"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("tmp_Loans.csv"));
			String line;
			
			while((line = br.readLine()) != null)
			{
				if(!(line.contains(rg) && line.contains(title)))
				{
					bw.append(line + "\n");
				}
			}
			br.close();
			bw.close();
			File oldFile = new File("Loans.csv");
			File newFile = new File("tmp_Loans.csv");
			oldFile.delete();
			newFile.renameTo(oldFile);
	}
	
	public void unban() throws Exception //Verifica quais usuarios estao desbanidos na data atual e remove de Bans.csv
	{
		BufferedReader br = new BufferedReader(new FileReader("Bans.csv"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("tmp_Bans.csv"));
		String line;
		String[] splitLine;
		//ArrayList<Ban> bansList = this.readBans();
		//Date today = this.date;
		
		while((line = br.readLine()) != null)
		{
			splitLine = line.split(",");
			Date d = this.formatter.parse(splitLine[1]);
			if(!(this.date.equals(d) || this.date.after(d)))
			{
				bw.append(line + "\n");
			}
		}
		br.close();
		bw.close();
		File oldFile = new File("Bans.csv");
		File newFile = new File("tmp_Bans.csv");
		oldFile.delete();
		newFile.renameTo(oldFile);
	}
	
	public boolean bookIsRegistered(String title) throws IOException
	{
		ArrayList<Book> tmp_array = this.readBooks();
		if(tmp_array.stream().map(Book::getTitle).anyMatch(b->b.equals(title)))
			return true;
		return false;
	}
	
	public User searchUserByRg(String rg) throws IOException
	{
		List<User> usersList = readUsers();
		usersList = usersList.stream().filter(u->u.getRg().equals(rg)).collect(Collectors.toList());
		if(usersList.isEmpty())
			return null;
		return usersList.get(0);
	}
	
	public Book searchBookByTitle(String title) throws IOException
	{
		List<Book> booksList = readBooks();
		booksList = booksList.stream().filter(b->b.getTitle().equals(title)).collect(Collectors.toList());
		if(booksList.isEmpty())
			return null;
		return booksList.get(0);
	}
}