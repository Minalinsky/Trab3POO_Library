package library;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LoansListController extends MenuController implements Initializable
{
	ArrayList<Loan> list = new ArrayList<Loan>();

    @FXML
    private TableColumn<Loan, String> columnReturnDate;

    @FXML
    private TableView<Loan> ListLoans;

    @FXML
    private TableColumn<Loan, String> columnRG;

    @FXML
    private TableColumn<Loan, String> columnTitle;
    
    @Override    
	public void initialize(URL url, ResourceBundle bundle) 
	{    
    	try
		{
			list = lb.readLoans();
			
			columnRG.setCellValueFactory(new PropertyValueFactory<>("rg"));
			columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
			columnReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
			
	        ListLoans.setItems(FXCollections.observableArrayList(list));  
		}
		catch(IOException e)
		{
			System.out.println("Error when showing books! ");
		}
	}

}