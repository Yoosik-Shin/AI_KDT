package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Scene scene;
	
	@Override
	public void start(Stage stage) throws IOException {
		scene = new Scene(loadFXML("Main"));
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		
		
		// 맨위에 프로그램이름 및 아이콘 표시줄, 나중에 아이콘 적당히 집어넣을것.
//		Image icon = new Image("icon.png");
//		stage.getIcons().add(icon);
		stage.setTitle("Board");
//		stage.setResizable(false);
		stage.show();
		
//		stage.show();
	}
	
	public static void setRoot(String fxml) throws Exception {
		scene.setRoot(loadFXML(fxml));
	}
	public static void setRoot(Parent root) throws Exception {
		scene.setRoot(root);
		
	}
	
	public static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}
	
	public static void exit() {
		Stage stage = (Stage) scene.getWindow();
		stage.close();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
