package dh.assortment.automation.framework;

/**
 * This class used to define all the application related configurations and
 * store in global variables. This class initialized once before test suite in
 * TestInit class.
 * 
 * @author dh207483
 *
 */
public class AppConfig {

	public static String userName, password;
	public static String appURL;
	public static boolean isConfigured, isEnabled;
	public static int defaultCount;

	public static void init() {
		userName = "user@phptravels.com";
		password = "demouser";
		appURL = "https://www.phptravels.net/login";
	}

}
