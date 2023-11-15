package edu.westga.cs1302.todo_list.view;

import java.net.URL;
import java.util.ResourceBundle;
import edu.westga.cs1302.todo_list.viewmodel.CreateTaskViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateTaskWindow {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button addSubTask;
    @FXML private Button addTask;
    @FXML private Button cancelTask;
    @FXML private TextArea description;
    @FXML private ComboBox<?> hours;
    @FXML private ComboBox<?> priority;
    @FXML private TextField title;
    
    private CreateTaskViewModel vm;

    public CreateTaskWindow() {
    	this.vm = new CreateTaskViewModel();
    }
    
    @FXML
    void initialize() {
        assert addSubTask != null : "fx:id=\"addSubTask\" was not injected: check your FXML file 'CreateTaskWindow.fxml'.";
        assert addTask != null : "fx:id=\"addTask\" was not injected: check your FXML file 'CreateTaskWindow.fxml'.";
        assert cancelTask != null : "fx:id=\"cancelTask\" was not injected: check your FXML file 'CreateTaskWindow.fxml'.";
        assert description != null : "fx:id=\"description\" was not injected: check your FXML file 'CreateTaskWindow.fxml'.";
        assert hours != null : "fx:id=\"hours\" was not injected: check your FXML file 'CreateTaskWindow.fxml'.";
        assert priority != null : "fx:id=\"priority\" was not injected: check your FXML file 'CreateTaskWindow.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'CreateTaskWindow.fxml'.";
    }
}
