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

public class UsersListController extends MenuController implements Initializable 
{
	ArrayList<User> list = new ArrayList<User>();
	
	 @FXML
	    private TableColumn<User, String> columnType;

	    @FXML
	    private TableView<User> ListUsers;

	    @FXML
	    private TableColumn<User, String> columnRG;

	    @FXML
	    private TableColumn<User, String> columnName;
	
	@Override    
	public void initialize(URL url, ResourceBundle bundle) 
	{    
		try
		{
			list = lb.readUsers("Users.csv");
			
			columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
			columnRG.setCellValueFactory(new PropertyValueFactory<>("rg"));
			columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
			
	        ListUsers.setItems(FXCollections.observableArrayList(list));
	        
		}
		catch(IOException e)
		{
			System.out.println("Error when showing users! ");
		}
	}
}
