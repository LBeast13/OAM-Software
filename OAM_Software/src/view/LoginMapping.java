package view;

import application.Main;
import javafx.fxml.FXML;

public class LoginMapping {
	
	// Object used as a reference of the Main Class
    private Main main;
    
    public LoginMapping(){}
    
    
    
    
    @FXML
    private void Login(){
    	main.setContent(main.HOME_PAGE_ID);
    }
    
    
    /**
     * Used in the initialization of the HMI in the Main Class
     * @param mainApp : the main instance of the software
     */
    public void setMainApp(Main mainApp) {
        this.main = mainApp;
    }

}
