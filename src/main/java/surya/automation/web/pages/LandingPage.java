package surya.automation.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends PageInit {
	
	@FindBy(name = "email")
	private WebElement emailTextBox;
	
	@FindBy(name = "password")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//button[(@type='submit')]")
	private WebElement submitButton;

}
