package library;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DateController implements Initializable
{	
	@FXML
	private Button DateButton;

	@FXML
	private Pane DatePane;

	@FXML
	private TextField DateText;

	@FXML
	private Label MsgError;
	    
	@Override    
	public void initialize(URL url, ResourceBundle bundle) 
	{            
	    	
	} 
	    
	    
	@FXML
	void LoadDate(ActionEvent event) throws Exception
	{
		if(DateText.getText().trim().equals(""))
		{
	  		MsgError.setVisible(true);
	   	}
   		else
   		{	
	   		//String date = DateText.getText();
	   		DatePane.setVisible(false);
	   		Stage primaryStage = new Stage();	
	   		Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
	   		Scene scene = new Scene(root);
    		primaryStage.setScene(scene);
    		primaryStage.show();
    	}	    		
    }
}
