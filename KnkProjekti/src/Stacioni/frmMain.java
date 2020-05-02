package Stacioni;


import java.sql.*;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.sun.media.jfxmediaimpl.platform.Platform;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class frmMain{
	
	
	private static TextField NisjaTxt = new TextField();
	private static TextField DestinacioniTxt = new TextField();
    private static TextField Emri=new TextField();
    private static TextField Komenti= new TextField();
	private static Text resultLabel;
	private static Button btnDergo = new Button("_Dergo");
	private static  Button Kerko = new Button("_Kerko");
	private static Stage mainstage = new Stage();
	private static Button Fshij = new Button("_Fshij");
	
	

	public static void Main(){
		
             frmMain obbj = new frmMain();

		   DbConnection.getConnection();
			Text shtotxt = new Text("Kerko udhetimin:");
			shtotxt.setFont(Font.font("Arial", FontWeight.LIGHT, 18));
		
			   MenuBar menuBar = new MenuBar();
		        // Krijo menute
		        Menu mainMenu = new Menu("Kryefaqja");
		        mainMenu.setStyle("-fx-background-color: #fcfae8" + 
		        		"; -fx-text-fill: black;");
		        
		        Menu Linjatmenu = new Menu("Linjat");
		        MenuItem shtoLinje = new MenuItem("Shto Linje");  
			     MenuItem shikoLinjat = new MenuItem("Shiko Linjat"); 
			     Linjatmenu.getItems().add(shtoLinje); 
			     Linjatmenu.getItems().add(shikoLinjat); 
			     
			     
			     shtoLinje.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
				 shtoLinje.setOnAction(e->{
					 
					 ShtoLinjenmenu.shtolinjenmenu();
					
					
				 });
			   
			     shikoLinjat.setAccelerator(new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN));
			     shikoLinjat.setOnAction(e->{
			       	 ShikoLinjat.showLinjattables();
				    	
			    	ShikoLinjat.Shikolinjat();
			    	 
			     });
			     
			      Menu Rezervonimenu = new Menu("Rezervoni");
			        
			        MenuItem reserveMenu = new MenuItem("Rezervo Bileten"); 
			        reserveMenu.setAccelerator(new KeyCodeCombination(KeyCode.B, KeyCombination.CONTROL_DOWN));
			        
			        Rezervonimenu.getItems().add(reserveMenu); 
			        reserveMenu.setOnAction(e->{
			        	
			        	RezervoB.Rezervomenu();
			        });
		        

		        Menu laMenu = new Menu("Gjuha");
		        Menu aboutMenu = new Menu("Ndihme");
		        MenuItem aboutHelpItem = new MenuItem("Rreth nesh"); 
		        aboutMenu.getItems().add(aboutHelpItem); 
		        
		        aboutHelpItem.setOnAction(e -> {
		        	
		        	About.about();
		        });
		        MenuItem manItem = new MenuItem("Manuali i perdorimit"); 
		        aboutMenu.getItems().add(manItem); 
		        
		       manItem.setOnAction(e -> {
		        	Help.help();
		        });
		        
		        


		      Image openIcon = new Image("1.png");
		      ImageView exitview = new ImageView(openIcon);
		      exitview.setFitWidth(15);
		      exitview.setFitHeight(15);
		        Menu logMenu = new Menu();
		        MenuItem exitMenuItem = new MenuItem("Dil"); 
		        logMenu.setGraphic(exitview);
			      logMenu.getItems().add(exitMenuItem); 
		        
		        exitMenuItem.setOnAction(e -> {
		        	System.exit(0);
		        });


		        
		        // Krijo MenuItems
		        MenuItem aItem = new MenuItem("Shqip");
		        MenuItem eItem = new MenuItem("Anglisht");
		        Image alIcon = new Image("ALFlag.png");
			      ImageView alview = new ImageView(alIcon);
			      alview.setFitWidth(20);
			     alview.setFitHeight(20);
			      aItem.setGraphic(alview);
			      Image eIcon = new Image("UKFlag.png");
			      ImageView eview = new ImageView(eIcon);
			      eview.setFitWidth(20);
			     eview.setFitHeight(20);
			      eItem.setGraphic(eview);
		        aItem.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
		        eItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
		  
		        // shtoj menuItems te Menute
		        laMenu.getItems().addAll(aItem, eItem);
		   
		        // Shtoje menute ne menubar
		        menuBar.getMenus().addAll(mainMenu, Linjatmenu,Rezervonimenu,laMenu, aboutMenu,logMenu);
		        BorderPane root = new BorderPane();
		        root.setTop(menuBar);
			
			
			
				
				
		        GridPane pane = new GridPane();
			    Button Kerko = new Button("Kerko");
			//    Kerko.setStyle("-fx-background-color: grey; -fx-text-fill: white;"); 
			     Image sIcon = new Image("Search.png");
			      ImageView sview = new ImageView(sIcon);
			      sview.setFitWidth(20);
			     sview.setFitHeight(20);
			      Kerko.setGraphic(sview);
			    pane.setPadding(new Insets(10, 10, 10, 10)); 
		     	pane.addRow(0, shtotxt);
				pane.addRow(1, new Label("Nisja: "), NisjaTxt);
				pane.addRow(2, new Label ("Destinacioni :"),DestinacioniTxt);
				pane.addRow(3, Kerko);
				pane.setHgap(0); 
				pane.setVgap(10); 
				pane.setAlignment(Pos.CENTER_LEFT);
				HBox box = new HBox();
				box.getChildren().addAll(Kerko) ;
				box.setMinHeight(15);
		        box.setAlignment(Pos.CENTER);
			    box.setPadding(new Insets(0, 0, 70, 0)); 
			
				Kerko.setOnAction(e->{
					obbj.Kerkoquery();
				});	


		        GridPane pane1 = new GridPane();
				Text txt1 = new Text("Komente,sygjerime,ankesa:");
			    txt1.setFont(Font.font("Arial", FontWeight.LIGHT, 11));
			    pane1.addRow(1,txt1);
				pane1.addRow(2,new Label("Emri:"), Emri);
				pane1.addRow(3,new Label("Komenti:"), Komenti);
				Komenti.setPrefWidth(300);
				pane1.setAlignment(Pos.CENTER_LEFT);
				pane1.setHgap(0); 
				pane1.setVgap(10); 
				
				btnDergo.setStyle("-fx-background-color: green; -fx-text-fill: white;"); 
				
				Button Fshij = new Button("Fshij");
				Fshij.setStyle("-fx-background-color: red; -fx-text-fill: white;"); 
				pane1.addRow(4,btnDergo);
				pane1.addRow(5,Fshij);	
			    pane1.setPadding(new Insets(10, 10, 10, 10)); 
				HBox box1 = new HBox(5);
				box1.getChildren().addAll(btnDergo) ;
				box1.getChildren().addAll(Fshij) ;
				box1.setMinHeight(15);
		        box1.setAlignment(Pos.CENTER);
		    	btnDergo.setOnAction(e->{
					obbj.ShtoKoment();
				});		
		        
				Fshij.setOnAction(e->{
					Komenti.clear();
				});				
				

				VBox vbox = new VBox();
				vbox.getChildren().addAll(root,pane , box, pane1, box1);
			//	vbox.setStyle("-fx-background-color:#FFD662; ");
				vbox.setAlignment(Pos.TOP_LEFT);
				Scene scene= new Scene(vbox,500,400); 

		 
				   if (scene.focusOwnerProperty().get() instanceof TextArea) {
				        TextArea focusedTextArea = (TextArea) scene.focusOwnerProperty().get();
				    }
		        mainstage.setScene(scene);
		        mainstage.setTitle("Stacioni i Autobuseve - Prishtine ");
		        mainstage.show();
	   }
	  
	

	 private  void Kerkoquery() { 
		 DbConnection.getConnection();
			try {
				
		   	String query = "SELECT * FROM Linjat WHERE Vendi_nisjes=? AND Destinacioni =? ";
			
				PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query);
				
				preparedStatement.setString(1, NisjaTxt.getText());
				preparedStatement.setString(2, DestinacioniTxt.getText());
				
				
				ResultSet result = preparedStatement.executeQuery();
				
				if(result.next()) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Menaxhimi i Linjave");
					alert.setHeaderText(null);
					alert.setContentText("Kerkimi perfundoi , shiko Linjat per me shume info");
					alert.showAndWait();
					
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Menaxhimi i Linjave");
					alert.setHeaderText(null);
					alert.setContentText(" Na vjen keq ,nuk ka te Linje");
					alert.showAndWait();
				}
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
		}
        
	 

private  void ShtoKoment() { 
	
	String query = "INSERT INTO Komentet(Kemri,Komenti) VALUES (?, ?)";
		try {
				
			PreparedStatement preparedStatement =  DbConnection.getConnection().prepareStatement(query);
			
			preparedStatement.setString(1, Emri.getText());
			preparedStatement.setString(2, Komenti.getText());
			
			
			if(preparedStatement.executeUpdate() > 0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Menaxhimi i Linjave");
				alert.setHeaderText(null);
				alert.setContentText("Ju faleminderit per Sygjerimin tuaj!");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Menaxhimi i Linjave");
				alert.setHeaderText(null);
				alert.setContentText("Diqka nuk eshte ne rregull!");
				alert.showAndWait();
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	



	    }
	    
