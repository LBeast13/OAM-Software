package view;

import application.Main;

public class HomePageMapping {
	
	// Object used as a reference of the Main Class
    private Main main;
    
    public HomePageMapping(){}
    
    

    /**
     * Used in the initialization of the HMI in the Main Class
     * @param mainApp : the main instance of the software
     */
    public void setMainApp(Main mainApp) {
        this.main = mainApp;
    }

}
