package library;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
	//Stage primaryStage = (Stage) ((Button)event.getSource()).getScene().getWindow();
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
    	catch(Exception e) {}
    } 
    
    @FXML
    void onClickRegisterUser(ActionEvent event) throws Exception
    {
    	if(TextTypeUser.getText().equals("student") || TextTypeUser.getText().equals("teacher") || TextTypeUser.getText().equals("comunity"))
		{
    		lb.registerUser(TextNameUser.getText(), TextRgUser.getText(), TextTypeUser.getText());
    		ErrorUser.setText("Registro inserido com sucesso!");
    		ErrorUser.setVisible(true);
		}
    	else
    	{	
    		ErrorUser.setText("Tipo inválido!");
    		ErrorUser.setVisible(true);
    	}
	}
    
    @FXML
    void onClickRegisterBook(ActionEvent event) throws Exception
    {	
    	final String title = TextTitleBook.getText();
    	final String author = TextAuthorBook.getText();
    	final String type = TextTypeBook.getText();
    	
    	if(!lb.bookIsRegistered(title)) //Verificando se o livro ja esta cadastrado na biblioteca
		{
    		if(type.equals("Text") || type.equals("General") || type.equals("text") || type.equals("general")) //Comparando tipo do livro (texto ou geral)
    		{
    			lb.registerBook(title, author, type);
    		}
    		else
    		{
    			//System.out.println("Tipo de livro incompativel!!");
    			//Tratar - Imprimir "Tipo de livro incompativel!!"
    		}
		}
    	else
    	{
    		//System.out.println("Este livro ja está cadastrado!!");
    		// Tratar - Imprimir mensagem "Este livro ja está cadastrado!!"
    	}
    }

    @SuppressWarnings("deprecation")
	@FXML
    void onClickRegisterLoan(ActionEvent event) throws Exception
    {
    	final String rg = TextNameLoan.getText();
    	final String title = TextTitleLoan.getText();
    	final String type = TextTypeLoan.getText();
    	User auxUser;
    	Book auxBook;
    	
    	if(type.equals("Loan") || type.equals("loan")) //Se o tipo for emprestimo
    	{
    		// Tratar - tratar quando digitar coisas invalidas nos campos
    		// Tratar um emprestimo por pessoa para cada titulo de livro
    		
    		if(lb.bookIsRegistered(title)) //Verifica se o livro esta cadastrado no sistema
    		{
    			auxUser = lb.searchUserByRg(rg); //retorna o usuario com o rg passado
    			auxBook = lb.searchBookByTitle(title);
    			if(auxUser == null) //Se nenhum usuario for retornado
    			{
    				//Tratar - Imprimir "Usuario nao consta no sistema"
    				System.out.println("Usuario nao consta no sistema");//TESTE
    			}
    			else
    			{
    				if((auxUser.getType().equals("Comunity") || auxUser.getType().equals("comunity")) && //Se o usuario for comunity
    						(auxBook.getType().equals("text") || auxBook.getType().equals("Text"))) //e o livro a ser retirado for Texto
    				{
    					//Tratar -Imprimir "Nao pode retirar esse tipo de livro!"
    					System.out.println("Nao pode retirar esse tipo de livro!");//TESTE
    				}
    				else lb.registerLoan(rg, title);
    			}
    		}
    		else
    		{
    			// Tratar - Imprimir "A biblioteca nao possui o livro solicitado!!"
    			System.out.println("A biblioteca nao possui o livro solicitado!!");//TESTE
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
    			//Tratar - Imprimir "Nao ha nenhum livro a ser devolvido por (fulano)!!"
    		}
    		else 
    		{
    			final Date today = new Date(lb.date.getYear(), lb.date.getMonth(), lb.date.getDate()); //Data atual
    			Date returnDate = new Date();
    			Loan loan = filteredLoansList.get(0);
    			returnDate = lb.formatter.parse(loan.getReturnDate()); //Data maxima de devolucao
    			
    			if(returnDate.equals(today) || returnDate.after(today)) //Se a entrega nao tiver atrasada
    			{
    				lb.removeLoan(rg, title);
    			}
    			else
    			{
    				//calculando quantos dias de ban em counter
    				int counter = 0;
    				int day = today.getDate();
    				
    				while(!today.equals(returnDate))
    				{
    					day--;
    					today.setDate(day);
    					counter++;
    				}
    				//Calculando até que dia está banido
    				Date aux = new Date(lb.date.getYear(), lb.date.getMonth(), lb.date.getDate());
    				aux.setDate(aux.getDate() + counter);
    				//Escrevendo ban em Ban.csv
    				BufferedWriter bw = new BufferedWriter(new FileWriter("Bans.csv", true));
    				bw.append(rg + "," + lb.formatter.format(aux) + "\n"); //Escreve o RG e a data até quando esta banido em Ban.csv
    				bw.close();
    				lb.removeLoan(rg, title);
    				//Tratar - Mostrar "usuario foi banido por 'COUNTER' dias!"
    			}
    		}
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
}