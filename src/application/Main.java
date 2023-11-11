package application;
	
import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import model.entities.Option;
import model.services.WordsService;


public class Main extends Application {
	
	public static Scene mainScene;
	public static Integer level;
	public static Integer lesson;
	public static String kanjiPos;
	public static String kanji;
	public static String hiragana;
	public static List<Option> options;
	
	@Override
	public void start(Stage primaryStage) {
		level = 0;
		lesson = 0;
		kanjiPos = "";
		kanji = "";
		hiragana = "";
		options = WordsService.hiraganaOptions();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ResultView.fxml"));
			ScrollPane scrollPane = loader.load();
			mainScene = new Scene(scrollPane);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Kanji Study - Sou Matome");
			primaryStage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Scene getMainScene()
	{
		return mainScene;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
