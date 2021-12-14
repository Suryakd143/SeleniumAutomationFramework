package dh.assortment.automation.framework;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * This class implements the driver opening functionalities. Before initialize
 * driver class we have to set the path of the driver using System.setproperty
 * for different drivers. System.setProperty() is a java in-build method to set
 * any property and you can also get the same property throughout the project
 * using System.getProperty() method.
 * 
 * @author dh207483
 *
 */
public class DriverFactory {

	public static WebDriver driver;

	public static WebDriver getDriver() {

		String browserName = "chrome";
		if (driver == null) {
			if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			} else if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			} else if (browserName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			}
		}
		return driver;
	}

}
