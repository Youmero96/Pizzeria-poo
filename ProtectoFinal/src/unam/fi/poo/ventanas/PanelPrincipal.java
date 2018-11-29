package unam.fi.poo.ventanas;

import java.util.Arrays;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import unam.fi.poo.controles.Boton;
import unam.fi.poo.controles.BotonSeleccion;
import unam.fi.poo.controles.CajaDeTexto;
import unam.fi.poo.controles.CajaSeleccion;
import unam.fi.poo.controles.Etiqueta;
import unam.fi.poo.controles.ListaDesplegable;
import unam.fi.poo.controles.Texto;
import javafx.scene.shape.*;
import java.awt.Color;
import javafx.scene.paint.*;
import java.util.Random;




public class PanelPrincipal extends Stage {

	private Etiqueta etiquetaLbl;
	private Etiqueta desdeLbl;
	private Etiqueta haciaLbl;
	private ArrayList<Rectangle> lista1;
	private ListaDesplegable desdeListaD;
	private ListaDesplegable haciaListaD;
	private Boton ingresarBtn;
	private Boton volverBtn;
	private BotonSeleccion moveOntoBtnSelec;
	private BotonSeleccion moveOverBtnSelec;
	private BotonSeleccion pileOntoBtnSelec;
	private BotonSeleccion pileOverBtnSelec;	
	private int cont=0;
	private int cont2=0;
	private int numObjetos=15;
	//private ArrayList<String> numeros[];
	
	
	public PanelPrincipal(){
		Texto encabezado = new Texto("Panel Principal");
		encabezado.setFont(Font.font("Tahoma", FontWeight.NORMAL,20));
		this.etiquetaLbl = new Etiqueta("Operaciones");
		this.desdeLbl = new Etiqueta("Desde:");
		ArrayList<String> numeros = new ArrayList<String>();
		numeros.add("Seleccionar");
		for (int i=0;i<numObjetos;i++){
			numeros.add(String.valueOf(i+1));
		}
		//String numeros[] ={"Seleccionar","4","5","6","7","8","9","10","11","12","13","14","15"};

		this.desdeListaD = new ListaDesplegable(numeros,new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				System.out.println(desdeListaD.getValue());
				if (desdeListaD.getValue().toString()=="Seleccionar" || haciaListaD.getValue().toString()
					=="Seleccionar"||desdeListaD.getValue().toString()== haciaListaD.getValue().toString())
				{
					ingresarBtn.setDisable(true);
				}
				else{
					ingresarBtn.setDisable(false);
				}
				}
			
		});
		this.haciaLbl = new Etiqueta("Hacia:");
		this.haciaListaD= new ListaDesplegable(numeros,new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event) {
				System.out.println(haciaListaD.getValue());
				if (desdeListaD.getValue().toString()=="Seleccionar" || haciaListaD.getValue().toString()
					=="Seleccionar"||desdeListaD.getValue().toString()== haciaListaD.getValue().toString())
				{
					ingresarBtn.setDisable(true);
				}
				else{
					ingresarBtn.setDisable(false);
				}
			}
		});		    
		GridPane  grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(12);
		grid.setGridLinesVisible(false);
		Scene sceneGrid = new Scene(grid,1300,500);
		Random aleatorio = new Random(System.currentTimeMillis());
		for (int i=0; i<numObjetos; i++){
			Rectangle r = new Rectangle();
			r.setX(50);
			r.setY(50);
			r.setWidth(40);
			r.setHeight(24);
			r.setArcWidth(10);
			r.setArcHeight(10);
			
			r.setFill(javafx.scene.paint.Color.rgb(aleatorio.nextInt(255),aleatorio.nextInt(255),aleatorio.nextInt(255)));
			cont2=1+cont++;
			grid.add(r,cont2,15);

			Texto mensaje = new Texto("Caja: "+String.valueOf(i+1));
			grid.add(mensaje,cont2,16);

			//grid.add(numCaja,cont++,6);
		}	

		this.setTitle("Examen de casa!");
		this.setScene(sceneGrid);

		ToggleGroup botonesSelModo = new ToggleGroup();


		this.moveOntoBtnSelec = new BotonSeleccion("Move Onto");
		this.moveOntoBtnSelec.setToggleGroup(botonesSelModo);
		this.moveOntoBtnSelec.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event) {
			if(moveOntoBtnSelec.isSelected()){
				System.out.println("Move Onto");
			}
		}
		});
				
		this.moveOverBtnSelec = new BotonSeleccion("Move Over");
		this.moveOverBtnSelec.setToggleGroup(botonesSelModo);
		this.moveOverBtnSelec.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event) {
			if(moveOverBtnSelec.isSelected()){
				System.out.println("Move Over");
			}
		}
		});		
			
		this.pileOntoBtnSelec = new BotonSeleccion("Pile Onto");
		this.pileOntoBtnSelec.setToggleGroup(botonesSelModo);
		this.pileOntoBtnSelec.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event) {
			if(pileOntoBtnSelec.isSelected()){
				System.out.println("Pile Onto");
			}
		}
		});		
		
		this.pileOverBtnSelec = new BotonSeleccion("Pile Over");
		this.pileOverBtnSelec.setToggleGroup(botonesSelModo);
		this.pileOverBtnSelec.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event) {
			if(pileOverBtnSelec.isSelected()){
				System.out.println("Pile Over");
			}
		}
		});				
		
		this.ingresarBtn= new Boton("Ingresar", new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				BotonSeleccion selectedRadioButton = (BotonSeleccion) botonesSelModo.getSelectedToggle();
				String OpcionElegida = selectedRadioButton.getText();
				Texto mensajeSalida = new Texto("La opci\u00f3n elegida es: "+ String.valueOf(OpcionElegida));
				grid.add(mensajeSalida,31,10);
				
				
			}
		});
		ingresarBtn.setDisable(true);

		this.volverBtn= new Boton("Volver", new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				close();
			}
		});

		this.initModality(Modality.APPLICATION_MODAL);
		this.show(); 

		grid.add(crearCajaH(encabezado, Pos.CENTER, 10),30,0,1,1);
		
		grid.add(crearCajaH(this.etiquetaLbl, Pos.TOP_RIGHT, 10),30,1);

		grid.add(crearCajaH(this.desdeLbl, Pos.CENTER,10),30,2,1,1);
		grid.add(this.desdeListaD,36,2);

		grid.add(crearCajaH(this.haciaLbl, Pos.CENTER,10),30,3,1,1);
		grid.add(this.haciaListaD,36,3);		

		//grid.add(crearCajaH(r, Pos.CENTER_LEFT,10),1,5);
		grid.add(moveOntoBtnSelec,31,4);
		grid.add(moveOverBtnSelec,31,5);
		grid.add(pileOntoBtnSelec,31,6);
		grid.add(pileOverBtnSelec,31,7);
		grid.add(volverBtn,31,8);
		grid.add(ingresarBtn,31,9);
			
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
