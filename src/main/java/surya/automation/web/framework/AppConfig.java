package surya.automation.web.framework;

import surya.automation.utils.ConfigManager;

/**
 * This class used to define all the application related configurations and
 * store in global variables. This class initialized once before test suite in
 * TestInit class.
 *
 * @author dh207483
 */
public class AppConfig {

    public static ConfigManager configReaderObj = new ConfigManager();

    // Following variables are related to automation framework
    public static String USER_PATH;
    public static String excelDataPath, driverPath;
    public static boolean isReportingEnabled;

    // Following variables are related to application.
    public static String userName, password;
    public static String appURL,apiBaseUrl;

    // Following variables are related to configuration type variables
    public static boolean isConfigured, isEnabled;

    public static void init() {

        // AUTOMATION VARIABLES
        userName = configReaderObj.getPropertyValue("userName");
        password = configReaderObj.getPropertyValue("password");
        appURL = configReaderObj.getPropertyValue("appURL");

        // APPLICATION VARIABLES
        USER_PATH = System.getProperty("user.dir");
        excelDataPath = configReaderObj.getPropertyValue("excelDataPath");
        driverPath = configReaderObj.getPropertyValue("driverPath");

        // API VARIABLES
        apiBaseUrl = configReaderObj.getPropertyValue("apiBaseUrl");

    }

}
