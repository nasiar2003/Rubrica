package it.polito.rubrica;



import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.polito.tdp.rubrica.model.Model;
import it.polito.tdp.rubrica.model.Voce;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;

public class RubricaController {
	private Model model;
	private Map<String, String>countries;
	private List<Voce>voci= new ArrayList<>();
	
	  @FXML
	    private Label textStato;
	  
	  @FXML
	    private ComboBox<String> comboPrefisso;
	  
	  
	  @FXML
	    private Button btnCancella;
	  
	  @FXML
	    private Label labelPrefix;

	    


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Voce> comboNome;

   
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

    private boolean validateEmail(String email){
    	Pattern p = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    	Matcher m = p.matcher(email);

    	if (m.find())
    	   return true;
    	else 
    		return false;
    	
    }
    
    private boolean dataInputControl(){
    	this.textStato.setStyle("-fx-text-fill: red;");
    	String nome = this.textNome.getText().toLowerCase().trim();
    	String email= this.textEmail.getText().trim().toLowerCase();
    	String telefono=this.TextTelefono.getText().trim().toLowerCase();
    	
    	if(nome==null || nome.length()==0){
    		
    		this.textStato.setText("Inserire il nome \n");
    		return true;
    		
    		
    	}
    	else if(email==null || email.length()==0){
    
        		this.textStato.setText("Inserire L'Email \n");
        		return true;
        		
        	}
    	else if(this.validateEmail(email)==false){
        	
        		this.textStato.setText("Email non valido\n");
        		return true;
    	}
    	else if(telefono==null || telefono.length()==0){
    	
    		this.textStato.setText("Inserire il numero telefono \n");
    		return true;
    	}
    	
    	
    	else if(this.comboPrefisso.getValue()==null){
    		this.textStato.setText("Scegliere il suo paese \n");
    		return true;
    	
    	}
    	
    	else{
    		return false;
    	}
    
    
    }
    

       
    
    
    @FXML
    void doCerca(ActionEvent event) {
    	this.textEmail.clear();
    	//this.textEmail.clear();
    	this.TextTelefono.clear();
    	
    
    	Voce v=model.findVoceByNome(this.comboNome.getValue().getNome());
    	
    	
    		this.textStato.setStyle("-fx-text-fill: green;");
    		this.textStato.setText("Trovato\n");
    		//this.textResult.setStyle("-fx-text-fill: black;");
    		//da completare
    		this.textEmail.appendText(v.getEmail());
    		this.TextTelefono.appendText(v.getTelefono());
    		return;
    		
    		
    	

    }

    @FXML
    void doInsert(ActionEvent event) {
    	//this.textResult.clear();
    	int telefono;
    	boolean errore =dataInputControl();
    	
    	if(errore ==false){
    		try{
        		telefono =Integer.valueOf(this.TextTelefono.getText());
        		
        	}
        	catch(NumberFormatException nfe){
        		this.textStato.setStyle("-fx-text-fill: red;");
        		this.textStato.setText("Errore Inserire solo ciffre \n");
        		return ;
        	}
    	Voce v= new Voce(this.textNome.getText(), this.textEmail.getText(), 
    			String.valueOf(countries.get(this.comboPrefisso.getValue())+telefono));
    	
    	boolean insert=model.addVoce(v);
    	
    	if (insert){
    		this.textStato.setStyle("-fx-text-fill: green;");
    		this.textStato.setText("Inserito \n");
    	     voci.add(v);
    		Collections.sort(voci);
    		comboNome.getItems().clear();
    		this.comboNome.getItems().addAll(voci);
    		
    		return; 
    	}
    	else{
    		this.textStato.setStyle("-fx-text-fill: red;");
    		this.textStato.setText("Già presente \n");
    		return; 
    	}
    	}
    	else{
    		return;
    	}

    }
    
    
    
    
    @FXML
    void doCancella(ActionEvent event) {

    }

    @FXML
    void doChoosePrefix(ActionEvent event) {
    	this.TextTelefono.clear();
    	String prefix = this.comboPrefisso.getValue();
    	if(prefix!=null){
    		this.labelPrefix.setText(countries.get(prefix));
    	}

    }

    @FXML
    void initialize() {
        assert textStato != null : "fx:id=\"textStato\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert labelPrefix != null : "fx:id=\"labelPrefix\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert TextTelefono != null : "fx:id=\"TextTelefono\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert btnInsert != null : "fx:id=\"btnInsert\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert textEmail != null : "fx:id=\"textEmail\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert comboNome != null : "fx:id=\"comboNome\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert textNome != null : "fx:id=\"textNome\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert comboPrefisso != null : "fx:id=\"comboPrefisso\" was not injected: check your FXML file 'Rubrica.fxml'.";

    }
/**
 * permette di salvare l'elemento  {@link Model } creato dal {@link Main} cosi con questo metodo
 * creo tutto che ci servira all'avviamento del programma 
 * 
 * @param model proviene del {@link Main} e contiene tutta la logica algoritmitica del programma
 */
	public void setModel(Model model) {
		this.model=model;
		countries=model.getAllCountries();
	
		this.comboPrefisso.getItems().addAll(countries.keySet());
		
	}
}



