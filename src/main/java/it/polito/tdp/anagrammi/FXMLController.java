package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtCorretti"
    private TextArea txtCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtErrati"
    private TextArea txtErrati; // Value injected by FXMLLoader

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML
    void btnCalcola(ActionEvent event) {
    	txtErrati.clear();
    	txtCorretti.clear();
    	
    	String parola=txtParola.getText();
    	if(parola.length()<3)
    		txtCorretti.setText("Parola troppo corta!");
    	else {
    	model.anagramma(parola);
    	List<String> anagrammi= model.anagrammi;
		
		List<String> corretti=model.corretti(anagrammi);
		List<String> errati=model.errati(anagrammi);
		
		for(String s: corretti) {
			txtCorretti.appendText(s+"\n");
		}
		
		for(String ss: errati) {
			txtErrati.appendText(ss+"\n");
		}
    	}
		       		
    }

    @FXML
    void btnReset(ActionEvent event) {
    	txtErrati.clear();
    	txtCorretti.clear();
    	txtParola.clear();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";

    }

    public void setModel(Model model) {
        this.model=model;
    }
}
