package library;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MenuController implements Initializable
{
	//Stage primaryStage = (Stage) ((Button)event.getSource()).getScene().getWindow();
	Library lb = new Library();

    @FXML
    private Button BtPrintBooks;

    @FXML
    private TextField TextNameUser;

    @FXML
    private TextField TextAuthorBook;

    @FXML
    private TextField TextTitleLoan;

    @FXML
    private TextField TextDateLoan;

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
    private Button BtAdvDay;
    
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
    	
    } 
    
    @FXML
    void onClickRegisterUser(ActionEvent event) throws Exception
    {
    	if(TextTypeUser.getText().equals("student") || TextTypeUser.getText().equals("teacher") || TextTypeUser.getText().equals("comunity"))
		{
    		lb.registerUser("Users.csv", TextNameUser.getText(), TextRgUser.getText(), TextTypeUser.getText());
    		ErrorUser.setVisible(false);
		}
    	else
    	 ErrorUser.setVisible(true);
	}
    
    @FXML
    void onClickRegisterBook(ActionEvent event) throws Exception
    {
    	lb.registerBook("Books.csv", TextTitleBook.getText(), TextAuthorBook.getText(), TextTypeBook.getText());
    }

    @FXML
    void onClickRegisterLoan(ActionEvent event) 
    {

    }
    
    @FXML
    void onClickShowUsers(ActionEvent event) 
    {
    	
    }
    
}