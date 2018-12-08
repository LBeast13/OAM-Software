package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			try {
			      Class.forName("org.postgresql.Driver");
			      System.out.println("Driver O.K.");

			      String url = "jdbc:postgresql://localhost:5432/Test";
			      String user = "postgres";
			      String passwd = "";

			      Connection conn = DriverManager.getConnection(url, user, passwd);
			      System.out.println("Connexion effective !");         
			      
			      //Création d'un objet Statement
			      Statement state = conn.createStatement();
			      //L'objet ResultSet contient le résultat de la requête SQL
			      ResultSet result = state.executeQuery("ALTER TABLE test_table ADD test_ajout INTEGER");
			      //On récupère les MetaData
			      ResultSetMetaData resultMeta = result.getMetaData();
			         
			      System.out.println("\n**********************************");
			      //On affiche le nom des colonnes
			      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
			        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
			         
			      System.out.println("\n**********************************");
			         
			      while(result.next()){         
			        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
			          System.out.print("\t" + result.getObject(i).toString() + "\t |");
			            
			        System.out.println("\n---------------------------------");

			      }

			      result.close();
			      state.close();
			      } catch (Exception e) {
			      e.printStackTrace();
			    }      
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
