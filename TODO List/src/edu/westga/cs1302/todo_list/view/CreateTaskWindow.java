package edu.westga.cs1302.todo_list.view;
import java.net.URL;
import java.util.ResourceBundle;
import edu.westga.cs1302.todo_list.model.Task;
import edu.westga.cs1302.todo_list.model.TaskPriority;
import edu.westga.cs1302.todo_list.viewmodel.CreateTaskViewModel;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Codebehind for the CreateTaskWindow of the Application.
 * 
 * @author Jacob Baker
 * @version Fall 2023
 */
public class CreateTaskWindow {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button addSubTask;
    @FXML private Button addTask;
    @FXML private Button cancelTask;
    @FXML private TextArea description;
    @FXML private ComboBox<Integer> hours;
    @FXML private ComboBox<TaskPriority> priority;
    @FXML private ComboBox<Task> selectTask;
    @FXML private TextField title;
    
    private CreateTaskViewModel vm;

    /**The constructor of CreateTaskWindow
     * 
     */
    public CreateTaskWindow() {
    	this.vm = new CreateTaskViewModel();
    }
    
    @FXML
    void initialize() {
        this.assertInitially();
        this.bindingViewModel();
        this.addTask.setOnAction((event)-> {
			this.vm.addTask();
		});
		this.addSubTask.setOnAction((event)-> {
			this.vm.addSubTask();
		});
		this.cancelTask.setOnAction((event)-> {
			((Node) (event.getSource())).getScene().getWindow().hide();
		});
    }
    
    /**Asserts that the properties all have the proper assigned values
     * 
     */
    public void assertInitially() {
    	assert this.addSubTask != null : "fx:id=\"addSubTask\" was not injected: check your FXML file 'CreateTaskWindow.fxml'.";
        assert this.addTask != null : "fx:id=\"addTask\" was not injected: check your FXML file 'CreateTaskWindow.fxml'.";
        assert this.cancelTask != null : "fx:id=\"cancelTask\" was not injected: check your FXML file 'CreateTaskWindow.fxml'.";
        assert this.description != null : "fx:id=\"description\" was not injected: check your FXML file 'CreateTaskWindow.fxml'.";
        assert this.hours != null : "fx:id=\"hours\" was not injected: check your FXML file 'CreateTaskWindow.fxml'.";
        assert this.priority != null : "fx:id=\"priority\" was not injected: check your FXML file 'CreateTaskWindow.fxml'.";
        assert this.selectTask != null : "fx:id=\"selectTask\" was not injected: check your FXML file 'CreateTaskWindow.fxml'.";
        assert this.title != null : "fx:id=\"title\" was not injected: check your FXML file 'CreateTaskWindow.fxml'.";
    }
    
    /**Binds the view model with the view
     * 
     */
    public void bindingViewModel() {
    	//this.addTask.disableProperty().bind(this.title.textProperty().isEmpty());
    	
    	//this.addTask.disableProperty().set(true);
    	BooleanBinding disableAddTaskButton = Bindings.or(this.title.textProperty().isEmpty(), this.description.textProperty().isEmpty().or(this.hours.itemsProperty().isNull().or(this.priority.itemsProperty().isNull())));
		this.addTask.disableProperty().bind(disableAddTaskButton);
    	
		BooleanBinding disableAddSubTaskButton = Bindings.or(this.title.textProperty().isEmpty(), this.description.textProperty().isEmpty().or(this.hours.itemsProperty().isNull().or(this.priority.itemsProperty().isNull().or(this.selectTask.itemsProperty().isNull()))));
		this.addSubTask.disableProperty().bind(disableAddSubTaskButton);

    	this.hours.itemsProperty().bind(this.vm.getHoursList());
		this.hours.setValue(this.vm.getHoursList().getValue().get(0));
		this.selectTask.itemsProperty().bind(this.vm.getTaskList());
		//getSelectedTaskComboBox
		this.priority.itemsProperty().bind(this.vm.getPriorityList());
		this.priority.setValue(this.vm.getPriorityList().getValue().get(0));
		this.title.textProperty().bindBidirectional(this.vm.getTaskTitle());
		this.description.textProperty().bindBidirectional(this.vm.getTaskDescription());
		this.vm.getTaskHour().bind(this.hours.getSelectionModel().selectedItemProperty());
		this.vm.getTaskPriority().bind(this.priority.getSelectionModel().selectedItemProperty());
		this.vm.getSelectedTask().bind(this.selectTask.getSelectionModel().selectedItemProperty());
    }
}
