package edu.westga.cs1302.todo_list;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Starting point for the application
 * 
 * @author Jacob Baker
 * @version Fall 2023
 */
public class Main extends Application {
	private static final String WINDOW_TITLE = "TODO List";
	private static final String GUI_RESOURCE = "view/MainWindow.fxml";
	public static final String ADD_TASK_TITLE = "AddTask";
	public static final String ADD_TASK_DIALOG = "view/CreateTaskWindow.fxml";
	public static final String ADD_DETAIL_TITLE = "Details";
	public static final String ADD_DETAIL_DIALOG = "view/DetailWindow.fxml";

	/**
	 * JavaFX entry point.
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @throws IOException
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource(Main.GUI_RESOURCE));
		Scene scene = new Scene(parent);
		primaryStage.setTitle(WINDOW_TITLE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Primary Java entry point.
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @param args command line arguments
	 */

	public static void main(String[] args) {
		Main.launch(args);
	}

}
