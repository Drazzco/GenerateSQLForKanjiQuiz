package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.entities.Option;
import model.entities.Words;
import model.services.TextFile;
import model.services.WordsService;

public class ResultViewController implements Initializable {
	
	@FXML
	private TextField levelTF;
	@FXML
	private TextField lessonTF;
	@FXML
	private TextField kanjiTF;
	@FXML
	private TextField hiraganaTF;
	@FXML
	private TextField kanjiPosTF;
	@FXML
	private TextField engTF;
	@FXML
	private TextField ptTF;
	@FXML
	private Button nextBT;
	@FXML
	private Button finishBT;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		if(Main.level > 0)
		{
			levelTF.setText(String.valueOf(Main.level));
		}
		if(Main.lesson > 0)
		{
			lessonTF.setText(String.valueOf(Main.lesson));
		}
		if(!Main.kanjiPos.equals(""))
		{
			kanjiPosTF.setText(String.valueOf(Main.kanjiPos));
		}
		if(!Main.kanji.equals(""))
		{
			kanjiTF.setText(Main.kanji);
		}
		if(!Main.hiragana.equals(""))
		{
			hiraganaTF.setText(Main.hiragana);
		}
	}
	
	@FXML
	public void onNextBTAction()
	{
		setSQL(",");
		loadView("/gui/ResultView.fxml");
		Stage stage = (Stage) nextBT.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void onFinishBTAction()
	{
		setSQL(";");
		System.exit(0);
	}
	
	private void initializeNodes()
	{
		Constraints.setTextFieldInteger(levelTF);
		Constraints.setTextFieldInteger(lessonTF);
		Constraints.setTextFieldMaxLength(kanjiPosTF, 20);
		Constraints.setTextFieldMaxLength(kanjiTF, 20);
		Constraints.setTextFieldMaxLength(hiraganaTF, 20);
		Constraints.setTextFieldMaxLength(engTF, 80);
		Constraints.setTextFieldMaxLength(ptTF, 80);
	}
	
	private void setSQL(String fin)
	{
		String kan, hir, eng, pt, kanji;
		String kan1, kan2, kan3, kan4;
		String hir1, hir2, hir3, hir4;
		int pos, kAns, hAns, level, lesson, aux, index, next;
		Words word;
		char kanji1, kanji2;
		
		kanji = kanjiPosTF.getText();
		level = Integer.valueOf(levelTF.getText());
		lesson = Integer.valueOf(lessonTF.getText());
		kan = kanjiTF.getText();
		hir = hiraganaTF.getText();
		eng = engTF.getText();
		pt = ptTF.getText();
		kAns = WordsService.random();
		hAns = WordsService.random();
		pos = kan.indexOf(kanji);
		kanji1 = kan.charAt(pos);
		
		Main.level = level;
		Main.lesson = lesson;
		Main.kanjiPos = kanji;
		Main.hiragana = hir;
		Main.kanji = kan;
		
		kanji2 = WordsService.getNextKanji(kanji1, 1);
		kan1 = WordsService.replaceSubstring(kan, String.valueOf(kanji1), String.valueOf(kanji2));
		kanji2 = WordsService.getNextKanji(kanji1, 2);
		kan2 = WordsService.replaceSubstring(kan, String.valueOf(kanji1), String.valueOf(kanji2));
		kanji2 = WordsService.getPreviousKanji(kanji1, 1);
		kan3 = WordsService.replaceSubstring(kan, String.valueOf(kanji1), String.valueOf(kanji2));
		kanji2 = WordsService.getPreviousKanji(kanji1, 2);
		kan4 = WordsService.replaceSubstring(kan, String.valueOf(kanji1), String.valueOf(kanji2));
		
		switch(hAns)
		{
		case 1:
			kan1 = kan;
			break;
		case 2:
			kan2 = kan;
			break;
		case 3:
			kan3 = kan;
			break;
		default:
			kan4 = kan;
		}
		
		hir1 = "";
		hir2 = "";
		hir3 = "";
		hir4 = "";
		
		switch(kAns)
		{
		case 1:
			hir1 = hir;
			break;
		case 2:
			hir2 = hir;
			break;
		case 3:
			hir3 = hir;
			break;
		default:
			hir4 = hir;
		}
		
		aux = 1;
		
		while(aux < 5)
		{
			for(Option opt : Main.options)
			{
				index = hir.indexOf(opt.getHiragana());
				if(index > -1)
				{
					if(hir1.equals(""))
					{
						if(index > 0)
						{
							next = opt.getPos2().getNext();
							switch(next)
							{
							case 0:
								hir1 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos2().getOp1());
								opt.getPos2().setNext(1);
								break;
							case 1:
								hir1 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos2().getOp2());
								opt.getPos2().setNext(2);
								break;
							default:
								hir1 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos2().getOp3());
								opt.getPos2().setNext(0);
							}
						}
						else
						{
							next = opt.getPos1().getNext();
							switch(next)
							{
							case 0:
								hir1 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos1().getOp1());
								opt.getPos1().setNext(1);
								break;
							case 1:
								hir1 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos1().getOp2());
								opt.getPos1().setNext(2);
								break;
							default:
								hir1 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos1().getOp3());
								opt.getPos1().setNext(0);
							}
						}
						aux++;
					}
					else
					{
						if(hir2.equals(""))
						{
							if(index > 0)
							{
								next = opt.getPos2().getNext();
								switch(next)
								{
								case 0:
									hir2 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos2().getOp1());
									opt.getPos2().setNext(1);
									break;
								case 1:
									hir2 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos2().getOp2());
									opt.getPos2().setNext(2);
									break;
								default:
									hir2 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos2().getOp3());
									opt.getPos2().setNext(0);
								}
							}
							else
							{
								next = opt.getPos1().getNext();
								switch(next)
								{
								case 0:
									hir2 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos1().getOp1());
									opt.getPos1().setNext(1);
									break;
								case 1:
									hir2 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos1().getOp2());
									opt.getPos1().setNext(2);
									break;
								default:
									hir2 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos1().getOp3());
									opt.getPos1().setNext(0);
								}
							}
							aux++;
						}
						else
						{
							if(hir3.equals(""))
							{
								if(index > 0)
								{
									next = opt.getPos2().getNext();
									switch(next)
									{
									case 0:
										hir3 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos2().getOp1());
										opt.getPos2().setNext(1);
										break;
									case 1:
										hir3 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos2().getOp2());
										opt.getPos2().setNext(2);
										break;
									default:
										hir3 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos2().getOp3());
										opt.getPos2().setNext(0);
									}
								}
								else
								{
									next = opt.getPos1().getNext();
									switch(next)
									{
									case 0:
										hir3 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos1().getOp1());
										opt.getPos1().setNext(1);
										break;
									case 1:
										hir3 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos1().getOp2());
										opt.getPos1().setNext(2);
										break;
									default:
										hir3 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos1().getOp3());
										opt.getPos1().setNext(0);
									}
								}
								aux++;
							}
							else
							{
								if(aux < 4)
								{
									if(index > 0)
									{
										next = opt.getPos2().getNext();
										switch(next)
										{
										case 0:
											hir4 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos2().getOp1());
											opt.getPos2().setNext(1);
											break;
										case 1:
											hir4 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos2().getOp2());
											opt.getPos2().setNext(2);
											break;
										default:
											hir4 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos2().getOp3());
											opt.getPos2().setNext(0);
										}
									}
									else
									{
										next = opt.getPos1().getNext();
										switch(next)
										{
										case 0:
											hir4 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos1().getOp1());
											opt.getPos1().setNext(1);
											break;
										case 1:
											hir4 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos1().getOp2());
											opt.getPos1().setNext(2);
											break;
										default:
											hir4 = WordsService.replaceSubstring(hir, opt.getHiragana(), opt.getPos1().getOp3());
											opt.getPos1().setNext(0);
										}
									}
									aux++;
								}
								else
								{
									aux++;
									break;
								}
							}
						}
					}
				}
			}
		}
		word = new Words(level,lesson,kan,hir1,hir2,hir3,hir4,kAns,hir,kan1,kan2,kan3,kan4,hAns,eng,pt);
		try {
			TextFile.writeInsert(word, fin);
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error saving SQL File", e.getMessage(), AlertType.ERROR);
		}
	}
	
	private void loadView(String absoluteName) //Para nao ser interrompido durante mudanca de thread (synchronized)
	{
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			ScrollPane scrollPane = loader.load();
			Main.mainScene = new Scene(scrollPane);
			Stage primaryStage = new Stage();
			primaryStage.setScene(Main.mainScene);
			primaryStage.setTitle("Kanji Study - Sou Matome");
			primaryStage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
