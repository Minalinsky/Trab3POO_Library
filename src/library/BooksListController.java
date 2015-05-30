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

public class BooksListController extends MenuController implements Initializable
{
	ArrayList<Book> list = new ArrayList<Book>();
	
    @FXML
    private TableColumn<Book, String> columnType;

    @FXML
    private TableView<Book> ListBooks;

    @FXML
    private TableColumn<Book, String> columnTitle;

    @FXML
    private TableColumn<Book, String> columnAuthor;

	    @Override    
		public void initialize(URL url, ResourceBundle bundle) 
		{    
	    	try
			{
				list = lb.readBooks("Books.csv");
				
				columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
				columnAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
				columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
				
		        ListBooks.setItems(FXCollections.observableArrayList(list));  
			}
			catch(IOException e)
			{
				System.out.println("Error when showing books! ");
			}
		}

}
