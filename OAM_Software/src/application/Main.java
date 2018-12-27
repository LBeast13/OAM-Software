package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.time.LocalDate;

import dao.factory.AbstractDAOFactory;
import dao.model.DAO;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Member;
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

			
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DB_DAO_FACTORY);
			//On récupère un objet faisant le lien entre la base et nos objets 
			DAO<Member> eleveDao = adf.getMemberDAO();
			
			LocalDate date = LocalDate.of(1963, 1, 19);
			
			Member memb = new Member(3, 1, "Brigitte", "BETTE", date, "bibi@hotmail.com", "1 Avenida Paraiso", 0, "Arroyo de la miel", "Espagne", "645123785", "X45FA478", 1.63, 0, false, false, "musculation", null, null);
			
			//boolean test = eleveDao.create(memb);
			eleveDao.update(memb);
			//boolean test = eleveDao.delete(memb);
			
			//System.out.println(test);
			
			for(int i = 1; i < 3; i++){
				//On fait notre recherche
				Member m = eleveDao.find(i);
				System.out.println("\tELEVE N°" + m.getId().get() + " - NOM : " + m.getFamName().get() + " - PRENOM : " + m.getFirstName().get() + " - Naissance : " + m.getBorn().get());
			}    
			
			

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
