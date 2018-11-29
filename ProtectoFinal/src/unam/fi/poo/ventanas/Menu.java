package unam.fi.poo.ventanas;

import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import unam.fi.poo.controles.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Menu extends Stage {
	private Boton salirBtn;
	private Etiqueta opcionElegidaLbl;
	private ListaDesplegable opcionElegidaListaD;
    private Boton empezarBtn;
    private Boton adminBtn;
    private String opcionElegida;
    
	
	public Menu(){ 

		GridPane  grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
				
		Texto encabezado1 = new Texto("Pizzer\u00EDa Mi Pizza");
		encabezado1.setFont(Font.font("Cambria Math", FontWeight.EXTRA_LIGHT,22));
		encabezado1.setTextAlignment(TextAlignment.CENTER);
		
		Texto encabezado2 = new Texto("Bienvenido!");
		encabezado2.setFont(Font.font("Arial", FontWeight.NORMAL,20));
		encabezado2.setTextAlignment(TextAlignment.CENTER);

		this.opcionElegidaLbl = new Etiqueta("Elija la opci\u00F3n requerida:");

		String numeros[] ={"Seleccionar","Reservar","Ordenar"};
		this.opcionElegidaListaD = new ListaDesplegable(Arrays.asList(numeros),new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				System.out.println(opcionElegidaListaD.getValue());
				if (opcionElegidaListaD.getValue().toString()=="Seleccionar"){
					empezarBtn.setDisable(true);
				}
				else{
					empezarBtn.setDisable(false);
				}


			}
			
		});
		
		this.salirBtn= new Boton("Salir", new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event){
				close();
			}
			
		});
		this.adminBtn= new Boton("Modo administrador", new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event){
				//new ModoAdmin();
				System.out.println("Aqui va el modo administrador, correcto?");
			}
			
		});
		this.empezarBtn= new Boton("Empecemos!", new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				opcionElegida=opcionElegidaListaD.getValue();
				if (opcionElegida=="Reservar"){
					System.out.println("Reservar");
				}
				if (opcionElegida=="Ordenar"){
					System.out.println("Ordenar");
				}
				new PanelPrincipal();
			}
		});
		empezarBtn.setDisable(true);
		grid.add(encabezado1, 0,0,2,1);
		grid.add(encabezado2, 0,1,2,1);
		grid.add(this.salirBtn,2,15);
		grid.add(this.empezarBtn,1,6);
		grid.add(this.opcionElegidaLbl,0,4);
		grid.add(crearCajaH(this.adminBtn,Pos.CENTER_LEFT,10),0,15);
		grid.add(crearCajaV(this.opcionElegidaListaD, Pos.CENTER_RIGHT,10),1,5);
		
		//creacion de la escena
		Scene sceneGrid = new Scene(grid, 550, 500);
		
		this.setTitle("PIZZER\u00CDA MI PIZZA");
		this.setScene(sceneGrid);
		this.initModality(Modality.NONE);
		this.show();  
			

	}

	private HBox crearCajaH(Node nodo, Pos posicion, double espacio){
		HBox hbox = null;
		if(nodo !=null && posicion !=null){
			hbox=new HBox(espacio);
			hbox.setAlignment(posicion);
			hbox.getChildren().add(nodo);
		}
		
		return hbox;
	}

	private VBox crearCajaV(Node nodo, Pos posicion, double espacio){
		VBox vbox = null;
		if(nodo !=null && posicion !=null){
			vbox=new VBox(espacio);
			vbox.setAlignment(posicion);
			vbox.getChildren().add(nodo);
		}
		
		return vbox;
	}
}
