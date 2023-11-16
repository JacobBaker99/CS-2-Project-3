package edu.westga.cs1302.todo_list.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * Codebehind for the DetailWindow of the Application.
 * 
 * @author Jacob Baker
 * @version Fall 2023
 */
public class DetailWindow {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button close;

    @FXML
    private TextArea details;

    @FXML
    void initialize() {
        assert this.close != null : "fx:id=\"close\" was not injected: check your FXML file 'DetailWindow.fxml'.";
        assert this.details != null : "fx:id=\"details\" was not injected: check your FXML file 'DetailWindow.fxml'.";
    }
    
    /**Binds the ViewModel with the View
     * 
     */
    public void bindingDetailsWindow() {
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

//import javafx.beans.property.SimpleListProperty;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.ListView;
//import javafx.scene.control.TextArea;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//import java.io.IOException;
//import java.util.Comparator;
//import edu.westga.cs1302.todo_list.Main;
//import edu.westga.cs1302.todo_list.model.Task;
//import edu.westga.cs1302.todo_list.viewmodel.MainWindowViewModel;
//
///**
// * Codebehind for the MainWindow of the Application.
// * 
// * @author Jacob Baker
// * @version Fall 2023
// */
//public class DetailWindow {
//	@FXML private ListView<Task> taskListView;
//	@FXML private TextArea details;
//	@FXML private ComboBox<Comparator<Task>> taskOrder;
//	@FXML private Button createTask;
//
//	private MainWindowViewModel vm;
//
//	/**The constructor of MainWindow
//	 * 
//	 */
//	public DetailWindow() {
//		this.vm = new MainWindowViewModel();
//	}
//	
//	@FXML
//	void initialize() {
//		this.assertInitially();
//        this.bindingViewModel();
//        
//		this.taskListView.setOnMouseClicked((event)-> {
//			this.vm.setSelectedTask(this.taskListView.getSelectionModel().getSelectedItem());
//		});
//		this.createTask.setOnAction((event)-> {
//			try {
//				FXMLLoader loader = new FXMLLoader();
//				loader.setLocation(Main.class.getResource(Main.ADD_TASK_DIALOG));
//				loader.load();
//				Parent parent = loader.getRoot();
//				Scene scene = new Scene(parent);
//				Stage addTaskStage = new Stage();
//				addTaskStage.setTitle(Main.ADD_TASK_TITLE);
//				addTaskStage.setScene(scene);
//				addTaskStage.initModality(Modality.APPLICATION_MODAL);
//				CreateTaskWindow controller = (CreateTaskWindow) loader.getController();
//				if (controller.setTaskListCreateTask(this.taskListView.getItems())) {
//					addTaskStage.showAndWait();
//					this.vm.updateDisplay();
//				}
//			} catch (IOException e) {
//				Alert alert = new Alert(Alert.AlertType.ERROR);
//				alert.setContentText(e.getMessage());
//				alert.showAndWait();
//			}
//		});
//	}
//	
//	/**
//	 * Asserts that the properties all have the proper assigned values
//	 * 
//	 */
//	public void assertInitially() {
//		assert this.createTask != null
//				: "fx:id=\"createTask\" was not injected: check your FXML file 'MainWindow.fxml'.";
//		assert this.details != null : "fx:id=\"details\" was not injected: check your FXML file 'MainWindow.fxml'.";
//		assert this.taskListView != null
//				: "fx:id=\"taskListView\" was not injected: check your FXML file 'MainWindow.fxml'.";
//		assert this.taskOrder != null : "fx:id=\"taskOrder\" was not injected: check your FXML file 'MainWindow.fxml'.";
//		new SimpleListProperty<Task>();
//	}
//
//	/**Binds the view model with the view
//	 * 
//	 */
//	public void bindingViewModel() {
//		this.taskOrder.itemsProperty().bind(this.vm.getSortingComparatorList());
//		this.taskOrder.setValue(this.vm.getSortingComparatorList().getValue().get(0));
//		this.taskListView.itemsProperty().bindBidirectional(this.vm.getTaskList());
//		this.details.textProperty().bind(this.vm.getDeatails());
//		this.vm.getTaskSortingComparator().bind(this.taskOrder.getSelectionModel().selectedItemProperty());
//		this.vm.getSelectedTask().bind(this.taskListView.getSelectionModel().selectedItemProperty());
//	}		
//}
