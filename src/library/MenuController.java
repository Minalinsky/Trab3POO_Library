package library;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuController implements Initializable
{
	static Library lb = new Library();

    @FXML
    private Text LblDate;
	
    @FXML
    private Button BtPrintBooks;

    @FXML
    private TextField TextNameUser;

    @FXML
    private TextField TextAuthorBook;

    @FXML
    private TextField TextTitleLoan;

    @FXML
    private Button BtRegisterUser;

    @FXML
    private Button BtRegisterLoan;

    @FXML
    private Button BtPrintLoans;

    @FXML
    private Button BtPrintUsers;

    @FXML
    private TextField TextRgUser;

    @FXML
    private TextField TextNameLoan;

    @FXML
    private TextField TextTitleBook;

    @FXML
    private Button BtRegisterBook;
    
    @FXML
    private TextField TextTypeUser;
    
    @FXML
    private TextField TextTypeBook;
    
    @FXML
    private TextField TextTypeLoan;
    
    @FXML
    private Label ErrorUser;
    
    @FXML
    private Label ErrorBooks;
    
    @FXML
    private Label ErrorLoan;
    
    @Override    
    public void initialize(URL url, ResourceBundle bundle)
    {            
    	LblDate.setText(lb.formatter.format(lb.date)); //Colocando Data Atual digitada na primeira tela no canto direito da segunda tela
    	//Ao abrir MenuController, remove de Ban.csv todos os usuarios que nao estao mais banidos (pela data atual)
    	try{
    		lb.unban();
    	}
    	catch(Exception e) 
    	{
    		System.out.println("Erro ao tirar a suspensão de usuários");
    	}
    } 
    
    @FXML
    void onClickRegisterUser(ActionEvent event) throws Exception
    {
    	ErrorBooks.setVisible(false);
    	ErrorLoan.setVisible(false);
    	
    	if(!(TextTypeUser.getText().trim().equals("")) && !(TextNameUser.getText().trim().equals("")) && !(TextRgUser.getText().trim().equals("")))
    	{	
    		if(TextTypeUser.getText().equals("student") || TextTypeUser.getText().equals("teacher") || TextTypeUser.getText().equals("comunity"))
    		{
    			lb.registerUser(TextNameUser.getText(), TextRgUser.getText(), TextTypeUser.getText());
    			ErrorUser.setText("Registro inserido com sucesso!");
    			ErrorUser.setVisible(true);
    		}
    		else
    		{	
    			ErrorUser.setText("O tipo não existe!");
    			ErrorUser.setVisible(true);
    		}
    	}
    	else
    	{
    		ErrorUser.setText("Há campos em branco!");
			ErrorUser.setVisible(true);
    	}
	}
    
    @FXML
    void onClickRegisterBook(ActionEvent event) throws Exception
    {	
    	ErrorUser.setVisible(false);
    	ErrorLoan.setVisible(false);
    	
    	final String title = TextTitleBook.getText();
    	final String author = TextAuthorBook.getText();
    	final String type = TextTypeBook.getText();
    	if(!(TextTitleBook.getText().trim().equals("")) && !(TextAuthorBook.getText().trim().equals("")) && !(TextTypeBook.getText().trim().equals("")))
    	{
    		if(!lb.bookIsRegistered(title)) //Verificando se o livro ja esta cadastrado na biblioteca
    		{
    			if(type.equals("Text") || type.equals("General") || type.equals("text") || type.equals("general")) //Comparando tipo do livro (texto ou geral)
    			{
    				lb.registerBook(title, author, type);
    				ErrorBooks.setText("Registro inserido com sucesso!");
    				ErrorBooks.setVisible(true);
    			}
    			else
    			{
    				ErrorBooks.setText("O tipo não existe!");
    				ErrorBooks.setVisible(true);
    			}
    		}
    		else
    		{
    			ErrorBooks.setText("Este livro ja está cadastrado!");
				ErrorBooks.setVisible(true);
    		}
    	}
    	else
    	{
    		ErrorBooks.setText("Há campos em branco!");
			ErrorBooks.setVisible(true);
    	}
    }
    
    @SuppressWarnings("deprecation")
	@FXML
    void onClickRegisterLoan(ActionEvent event) throws Exception
    {
    	ErrorUser.setVisible(false);
    	ErrorBooks.setVisible(false);
    	
    	int situation;
    	final String rg = TextNameLoan.getText();
    	final String title = TextTitleLoan.getText();
    	final String type = TextTypeLoan.getText();
    	User auxUser;
    	Book auxBook;
    	
    	if(!(TextNameLoan.getText().trim().equals("")) && !(TextTitleLoan.getText().trim().equals("")) && !(TextTypeLoan.getText().trim().equals("")))	
    	{	
    		if(type.equals("Loan") || type.equals("loan")) //Se o tipo for emprestimo
    		{    		
    			if(lb.bookIsRegistered(title)) //Verifica se o livro esta cadastrado no sistema
    			{
    				auxUser = lb.searchUserByRg(rg); //retorna o usuario com o rg passado
    				auxBook = lb.searchBookByTitle(title);
    				
    				if(auxUser == null) //Se nenhum usuario for retornado
    				{
    					ErrorLoan.setText("Usuario nao consta no sistema");
    					ErrorLoan.setVisible(true);
    				}	
    				else
    				{
    					if((auxUser.getType().equals("Comunity") || auxUser.getType().equals("comunity")) && //Se o usuario for comunity
    							(auxBook.getType().equals("text") || auxBook.getType().equals("Text"))) //e o livro a ser retirado for Texto
    					{
    						ErrorLoan.setText("Nao pode retirar esse tipo de livro!");
        					ErrorLoan.setVisible(true);
    					}	
    					else 
    					{
    						situation = lb.registerLoan(rg, title);
    						if(situation == 0)
    						{
    							ErrorLoan.setText("Registro inserido com sucesso!");
            					ErrorLoan.setVisible(true);	
    						
    						}
    						if(situation == 1)
    						{
    							ErrorLoan.setText("Numero Maximo de Emprestimos permitidos!");
            					ErrorLoan.setVisible(true);	
    						}
    						if(situation == 2)
    						{
    							ErrorLoan.setText("Usuario esta banido!");
            					ErrorLoan.setVisible(true);	

    						}
    					}
    				}	
    			}	
    			else
    			{
    				ErrorLoan.setText("Não existe o livro solicitado!");
					ErrorLoan.setVisible(true);
    			}
    		}
    		else if(type.equals("Devolution") || type.equals("devolution"))
    		{
    			ArrayList<Loan> loansList = lb.readLoans(); //Lista de todos os emprestimos feitos
    			
    			List<Loan> filteredLoansList = loansList.stream().filter(l->l.getRg().equals(rg)).filter(l->l.getTitle()
    					.equals(title)).collect(Collectors.toList()); //Filtra todos os emprestimos ainda nao devolvidos feitos pelo RG passado,
        																				//com o livro de titulo passado
    			if(filteredLoansList.isEmpty())
    			{
    				ErrorLoan.setText("Nao ha nenhum livro a ser devolvido pelo usuário!");
					ErrorLoan.setVisible(true);
    			}
    			else 
    			{
    				Date today = new Date(lb.date.getYear(), lb.date.getMonth(), lb.date.getDate()); //Data atual
    				Date returnDate = new Date();
    				Loan loan = filteredLoansList.get(0);
    				returnDate = lb.formatter.parse(loan.getReturnDate()); //Data maxima de devolucao
    				
    				if(returnDate.equals(today) || returnDate.after(today)) //Se a entrega nao tiver atrasada
    				{
    					lb.removeLoan(rg, title);
    					ErrorLoan.setText("Registro removido com sucesso!");
    					ErrorLoan.setVisible(true);
    				}
    				else
    				{
    					long diff = today.getTime() - returnDate.getTime();
       					int counter = (int) (diff / (1000 * 60 * 60 * 24));
    				
    					//Calculando até que dia está banido
    					Date aux = new Date(lb.date.getYear(), lb.date.getMonth(), lb.date.getDate());
    					aux.setDate(aux.getDate() + counter);
    					//Escrevendo ban em Ban.csv
    					BufferedWriter bw = new BufferedWriter(new FileWriter("Bans.csv", true));
    					bw.append(rg + "," + lb.formatter.format(aux) + "\n"); //Escreve o RG e a data até quando esta banido em Ban.csv
    					bw.close();
    					lb.removeLoan(rg, title);
    					ErrorLoan.setText("O usuário foi banido por " + counter + " dia(s)!");
    					ErrorLoan.setVisible(true);
    				}
    			}
    		}
    		else
    		{
    			ErrorLoan.setText("Tipo de acao incompatível!");
    			ErrorLoan.setVisible(true);
    		}
    	}
    	else
    	{
    		ErrorLoan.setText("Há campos em branco!");
			ErrorLoan.setVisible(true);
    	}
    }
    
    @FXML
    void onClickShowUsers(ActionEvent event) throws Exception
    {
    	Stage primaryStage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("UsersList.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    @FXML
    void onClickShowBooks(ActionEvent event) throws Exception
    {
    	Stage primaryStage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("BooksList.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
    }    
    
    @FXML
    void onClickShowLoans(ActionEvent event) throws Exception
    {
    	Stage primaryStage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("LoansList.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
    }
}