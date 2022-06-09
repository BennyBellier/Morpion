package com.morpion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.morpion.Set.Symbole;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;
	private static SecondaryController sc;

	@Override
	public void start(Stage stage) throws IOException {

		scene = new Scene(loadFXML("secondary"), 640, 480);
		stage.setTitle("Morpion");
		stage.setScene(scene);
		stage.show();
		Set s = new Set();
		if (sc != null)
			sc.setSet(s);
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		Parent parent = fxmlLoader.load();
		sc = (SecondaryController) fxmlLoader.getController();
		return parent;
	}

	public static void main(String[] args) {
		launch();
	}

}