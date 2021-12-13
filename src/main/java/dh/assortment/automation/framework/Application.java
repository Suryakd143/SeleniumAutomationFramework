package dh.assortment.automation.framework;

public class Application {
	
	/*
	 * This method used to open the application.
	 */
	public static void launchApplication(){
		DriverFactory.getDriver().get(AppConfig.appURL);
	}

	/*
	 * This method is used to close the browser
	 */
	public static void closeApplication() {
		DriverFactory.getDriver().quit();	
	}

}
