package library;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BooksListController implements Initializable
{
	
	@FXML
    private TableColumn<Book, String> columnAuthor;

    @FXML
    private TableColumn<Book, String> columnTitle;

    @FXML
    private TableView<Book> ListBooks;

    @FXML
    private TableColumn<Book, String> columnType;

	    @Override    
		public void initialize(URL url, ResourceBundle bundle) 
		{    
			
		}

}
