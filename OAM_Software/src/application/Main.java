package application;
	
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.time.LocalDate;

import dao.factory.AbstractDAOFactory;
import dao.model.DAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Member;
import view.HomePageMapping;
import view.LoginMapping;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public static final int LOG_IN_ID = 0;
	public static final int HOME_PAGE_ID = 1;
	
	private Stage mainStage;
	private BorderPane mainContainer;
	
	@Override
	public void start(Stage primaryStage) {
		mainStage = primaryStage;
		mainStage.setTitle("Olympic Art Malaga");
		mainStage.setMaximized(true);
		
		initializeMainContainer();
		initializeLogin();
	}
	
	/**
	 * Initializes the main container of the software.
	 */
	private void initializeMainContainer() {
		
		FXMLLoader loader = new FXMLLoader();
		
		// We specify the relative path of the view to the loader
		loader.setLocation(Main.class.getResource("..\\view\\MainContainerView.fxml"));
		try {
			// The loading gives us the container
			mainContainer = (BorderPane) loader.load();
			
			// Set a primary scene with our container
			Scene scene = new Scene(mainContainer);
			
			// Set the style for the Software
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// We set the scene of our main stage
			mainStage.setScene(scene);
			
			// Displays the stage
			mainStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Initializes the login view
	 */
	private void initializeLogin() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("..\\view\\LoginView.fxml"));
		try {
			// Container loading
			BorderPane loginContainer = (BorderPane) loader.load();
			
			// We set it to the center of the main container
			mainContainer.setCenter(loginContainer);
			
			// Gets the controller
			LoginMapping controller = loader.getController();
			
			controller.setMainApp(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Initializes and displays the Home Page
	 */
	private void initializeHomePage() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("..\\view\\HomePageView.fxml"));
		try {
			// Container loading
			BorderPane homePageContainer = (BorderPane) loader.load();
			
			// We set it to the center of the main container
			mainContainer.setCenter(homePageContainer);
			
			// Gets the controller
			HomePageMapping controller = loader.getController();
			
			controller.setMainApp(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Set the content corresponding to the id.
	 * Used by the controllers.
	 * @param id : the id of the content to display
	 */
	public void setContent(int id){
		switch(id){
			case LOG_IN_ID:
				initializeLogin();
				break;
			case HOME_PAGE_ID:
				initializeHomePage();
				break;
		}
	}

	public static void main(String[] args) {
		launch(args);
		
		/* Temp testing code for Database access
		try {
		
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
		}*/
	}
}
