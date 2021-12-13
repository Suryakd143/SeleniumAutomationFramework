package dh.assortment.automation.framework;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageInit {
	protected static WebDriver driver;
	protected static WebDriverWait wait;

	/*
	 * In following constructor, initialized driver instance and Page elements using
	 * PageFactory.
	 */
	public PageInit() {
		driver = DriverFactory.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		PageFactory.initElements(driver, this);
	}

	/*
	 * Following method is used to enterText in any input field.
	 */
	protected void enterText(WebElement element, String textToEnter, String elementName) {
		element.sendKeys(textToEnter);
		System.out.println(String.format("Entered %s in %s textbox.", textToEnter, elementName));
	}

	/*
	 * Following method is used to click on any element.
	 */
	protected void clickOnElement(WebElement element, String elementName) {
		element.click();
		System.out.println(String.format("Click On %s.", elementName));
	}
	
	/*
	 * This method is used to return text of the element.
	 */
	protected String getText(WebElement element) {
		return element.getText();
	}
}
