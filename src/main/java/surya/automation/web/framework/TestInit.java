package surya.automation.web.framework;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import surya.automation.utils.ExcelManager;

public class TestInit {
    /*
     * Load Application configurations before executing tests.
     */
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws IOException {
        AppConfig.init();
        Map<Integer, List<String>> excelTestData = ExcelManager
                .readExcel(AppConfig.USER_PATH.concat(AppConfig.excelDataPath + "ExcelData.xlsx"), "TestData");
    }

    @BeforeClass(alwaysRun = true)
    /*
     * Launch application before each testClass
     */
    public void beforeClass() {
        launchApplication();
    }

    @AfterClass(alwaysRun = true)
    /*
     * Quite application after each testClass
     */
    public void afterClass() {
        closeApplication();
    }


    /*
     * This method used to open the application.
     */
    public static void launchApplication() {
        DriverFactory.getDriver().get(AppConfig.appURL);
    }

    /*
     * This method is used to close the browser
     */
    public static void closeApplication() {
        DriverFactory.getDriver().quit();
    }

}
