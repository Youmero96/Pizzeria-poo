package unam.fi.poo.aplicacion;

import javafx.application.Application;
import javafx.stage.Stage;
import unam.fi.poo.ventanas.Menu;

public class Principal extends Application{
   
    public void start(Stage primaryStage) {
    	
    		new Menu();
     }
    
	public static void main(String[] args){
		launch(args);

	}
	
	
 }
