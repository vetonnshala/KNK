package Stacioni;

import java.sql.*;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShikoLinjat {

	private static TextField LidTxt = new TextField();
	private static TextField Vendi_nisjestxt = new TextField();
	private static TextField Destinacionitxt = new TextField();
	private static TextField Oranisjestxt = new TextField();
	private static TextField Oraarritjestxt = new TextField();
	private static TextField Cmimitxt = new TextField();
	private static TextField EmriKompanistxt = new TextField();
	private static  TextField Verifikimitxt = new TextField();
	private static TableView LinjattablesTable = new TableView();
	
	private static Button updateBtn = new Button("Update");
	private static Button deleteBtn = new Button("Delete");
	private static Stage LinjatStage = new Stage();
	public static void Shikolinjat() {
		
		Text txtlinjat = new Text("Linjat e Autobuseve");
		txtlinjat.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		
		 
			GridPane boxpane1 = new GridPane();
			
      		boxpane1.addRow(0, new Label("ID: "), LidTxt);
			boxpane1.addRow(1, new Label("VendiNis: "), Vendi_nisjestxt);
			boxpane1.setAlignment(Pos.BOTTOM_LEFT);
			boxpane1.addRow(2, new Label("Desti: "), Destinacionitxt);
			boxpane1.addRow(3, new Label("OraN: "), Oranisjestxt);
			
			GridPane boxpane2 = new GridPane();
			boxpane2.setAlignment(Pos.BOTTOM_CENTER);
	     	boxpane2.addRow(1, new Label("OraA: "), Oraarritjestxt);
	    	boxpane2.addRow(2, new Label("Cmimi: "), Cmimitxt);
	    	boxpane2.addRow(3, new Label("EmriK: "), EmriKompanistxt);
	    	
	    	GridPane boxpane3 = new GridPane();
	    	boxpane2.setAlignment(Pos.BOTTOM_RIGHT);
	    	boxpane2.addRow(1, new Label("Verifikimi"), Verifikimitxt);
	    	boxpane2.addRow(2, new Label(""), deleteBtn);
	    	boxpane2.addRow(3, new Label(" "), updateBtn);
			
			boxpane2.setHgap(10);
			boxpane2.setVgap(10);
			boxpane3.setHgap(10);
			boxpane3.setVgap(10);
			boxpane1.setHgap(10);
			boxpane1.setVgap(10);
			deleteBtn.setOnAction(e->{
				deleteLinjen();
			});
			updateBtn.setOnAction(e->{
				//updateLinjat()
			});

			
			HBox downPane = new HBox(15);
		
			downPane.getChildren().addAll(boxpane1,boxpane2,boxpane3);
	
		TableColumn<String, Linjattable> Linjac = new TableColumn<>("ID");
		Linjac.setCellValueFactory(new PropertyValueFactory("Lid"));
		Linjac.setPrefWidth(20);
		
		TableColumn<String, Linjattable> Vendinisjesc = new TableColumn<>("VendiNisjes");
		 Vendinisjesc.setCellValueFactory(new PropertyValueFactory("Vendi_nisjes"));
		 Vendinisjesc.setPrefWidth(75);
		
		TableColumn<String, Linjattable> Destinacionic = new TableColumn<>("Destinacioni");
		 Destinacionic.setCellValueFactory(new PropertyValueFactory("Destinacioni"));
		 Destinacionic.setPrefWidth(75);
		
		TableColumn<String, Linjattable> Oranisjesc = new TableColumn<>("OraNisjes");
		Oranisjesc.setCellValueFactory(new PropertyValueFactory("Oranisjes"));
		Oranisjesc.setPrefWidth(70);
		
		TableColumn<String, Linjattable> OraArritjesc = new TableColumn<>("OraArritjes");
		OraArritjesc.setCellValueFactory(new PropertyValueFactory("OraArritjes"));
		OraArritjesc.setPrefWidth(70);
		
		TableColumn<String, Linjattable> Cmimic = new TableColumn<>("Cmimi");
		Cmimic.setCellValueFactory(new PropertyValueFactory("Cmimi"));
		Cmimic.setPrefWidth(55);
		
		TableColumn<String, Linjattable> EmriKompanisc= new TableColumn<>("EmriKompanis");
		EmriKompanisc.setCellValueFactory(new PropertyValueFactory("EmriKompanis"));
		EmriKompanisc.setPrefWidth(100);
		
		TableColumn<String, Linjattable> Verifikmic = new TableColumn<>("Verifikimi");
		Verifikmic.setCellValueFactory(new PropertyValueFactory("Verifikimi"));
		Verifikmic.setPrefWidth(70);
		
		LinjattablesTable.setRowFactory(tv -> {
            TableRow<Linjattable> row = new TableRow<>();
            
            row.setOnMouseClicked(event -> {
               LidTxt.setText( String.valueOf(row.getItem().getLid()));
               Vendi_nisjestxt.setText(row.getItem().getVendi_nisjes());
               Destinacionitxt.setText(row.getItem().getDestinacioni());
               Oranisjestxt.setText( String.valueOf(row.getItem().getOranisjes()));
               Oraarritjestxt.setText( String.valueOf(row.getItem().getOraArritjes()));
               Cmimitxt.setText( String.valueOf(row.getItem().getCmimi()));
               EmriKompanistxt.setText(row.getItem().getEmriKompanis());
               Verifikimitxt.setText( String.valueOf(row.getItem().getVerifikimi()));
               
            });
            
            return row ;
        });
		
		LinjattablesTable.getColumns().add(Linjac);
		LinjattablesTable.getColumns().add(Vendinisjesc);
		LinjattablesTable.getColumns().add(Destinacionic);
		LinjattablesTable.getColumns().add(Oranisjesc);
		LinjattablesTable.getColumns().add(	OraArritjesc);
		LinjattablesTable.getColumns().add(Cmimic);
		LinjattablesTable.getColumns().add(EmriKompanisc);
		LinjattablesTable.getColumns().add(Verifikmic);
	
		
		LinjattablesTable.setPrefWidth(250);
		LinjattablesTable.setPrefHeight(290);
		
		// Main Pane
		VBox mainPane = new VBox(10);
		
		mainPane.getChildren().addAll(txtlinjat,LinjattablesTable,downPane);
		mainPane.setPadding(new Insets(20,20,20,20));
		Scene scene = new Scene(mainPane,630,550);
		
		LinjatStage.setTitle("Linjat");
		LinjatStage.setScene(scene);
		showLinjattables();
		LinjatStage.show();
	}
	

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public static void showLinjattables() {
		List<Linjattable> Linjattables = Linjattable.getLinjattables();
		
		ObservableList<Linjattable> LinjattableList = FXCollections.observableArrayList();
		
		for(int i = 0; i < Linjattables.size(); i++) {
			LinjattableList.add(Linjattables.get(i));
		}
		
		LinjattablesTable.setItems(LinjattableList);
	}
	public static void deleteLinjen() {						
		if(Linjattable.deleteLinjattable(Integer.parseInt(LidTxt.getText()))) {
			showLinjattables();
			clearForm();
		}
	}
//	public void updateLinjat() {
//		if(Linjattable.updateLinjattable(Integer.parseInt(LidTxt.getText()), Vendi_nisjestxt.getText(), Destinacionitxt.getText(),
//				Oranisjestxt.getTime(),Oraarritjestxt.getText(),Integer.parseInt(Cmimitxt.getText()),
//				EmriKompanistxt.getText(),Verifikimitxt.getBoolean()	)) {
//			showLinjattables();
//			clearForm();
//		}
//	}
	public static void clearForm() {
		LidTxt.setText("");
		Vendi_nisjestxt.setText("");
		Destinacionitxt.setText("");
		Oranisjestxt.setText("");
		Oraarritjestxt.setText("");
		Cmimitxt.setText("");
		EmriKompanistxt.setText("");
		Verifikimitxt.setText("");
	}

	}


