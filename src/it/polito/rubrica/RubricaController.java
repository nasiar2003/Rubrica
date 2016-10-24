package it.polito.rubrica;



import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.rubrica.model.Model;
import it.polito.tdp.rubrica.model.Voce;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RubricaController {
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea textResult;

    @FXML
    private TextField TextTelefono;

    @FXML
    private Button btnCerca;

    @FXML
    private Button btnInsert;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textNome;

    
    
    private void dataInputControl(){
    	String nome = this.textNome.getText().toLowerCase().trim();
    	String email= this.textEmail.getText().trim().toLowerCase();
    	String telefono=this.TextTelefono.getText().trim().toLowerCase();
    	if(this.textNome==null || this.textNome.getLength()==0){
    	this.textResult.setStyle("-fx-text-fill: red;");
    		this.textResult.appendText("Inserire il nome \n");
    		
    	}
    	 if(this.textEmail==null || this.textEmail.getLength()==0){
        	this.textResult.setStyle("-fx-text-fill: red;");
        		this.textResult.appendText("Inserire L'Email \n");
        		
        	}
    	 if(this.TextTelefono==null || this.TextTelefono.getLength()==0){
    	this.textResult.setStyle("-fx-text-fill: red;");
    		this.textResult.appendText("Inserire il numero telefono \n");
    	}
    	
    	return;
    
    }
    
    
    
    
    
    @FXML
    void doCerca(ActionEvent event) {
    	this.textResult.clear();
    	
    	if(this.textNome==null || this.textNome.getLength()==0){
        	this.textResult.setStyle("-fx-text-fill: red;");
        		this.textResult.appendText("Inserire il nome \n");
        		return;
        		
        	}
    	Voce v=model.findVoceByNome(this.textNome.getText());
    	
    	if(v !=null){
    		this.textResult.setStyle("-fx-text-fill: green;");
    		this.textResult.appendText("Trovato\n");
    		//this.textResult.setStyle("-fx-text-fill: black;");
    		this.textResult.appendText(v.getNome()+"\n"+v.getEmail()+"\n"+v.getTelefono());
    		return;
    		
    		
    	}
    	else{
    		
    		this.textResult.setStyle("-fx-text-fill: red;");
    		this.textResult.appendText(String.format("Non esiste un il nome %s nella rubrica", this.textNome.getText()));
    	}

    }

    @FXML
    void doInsert(ActionEvent event) {
    	this.textResult.clear();
    	this.dataInputControl();
    	
    	Voce v= new Voce(this.textNome.getText(), this.textEmail.getText(), this.TextTelefono.getText());
    	
    	boolean insert=model.addVoce(v);
    	
    	if (insert){
    		this.textResult.setStyle("-fx-text-fill: green;");
    		this.textResult.appendText("Inserito \n");
    		return; 
    	}
    	else{
    		this.textResult.setStyle("-fx-text-fill: red;");
    		this.textResult.appendText("Già presente \n");
    		return; 
    	}

    }

   

    @FXML
    void initialize() {
        assert textResult != null : "fx:id=\"textResult\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert TextTelefono != null : "fx:id=\"TextTelefono\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert btnInsert != null : "fx:id=\"btnInsert\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert textEmail != null : "fx:id=\"textEmail\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert textNome != null : "fx:id=\"textNome\" was not injected: check your FXML file 'Rubrica.fxml'.";

    }
/**
 * permette di salvare l'elemento  {@link Model } creato dal {@link Main} cosi con questo metodo
 * creo tutto che ci servira all'avviamento del programma 
 * 
 * @param model proviene del {@link Main} e contiene tutta la logica algoritmitica del programma
 */
	public void setModel(Model model) {
		this.model=model;
	}
}



