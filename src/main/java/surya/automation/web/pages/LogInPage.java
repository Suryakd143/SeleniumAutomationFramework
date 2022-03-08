package surya.automation.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import surya.automation.web.framework.PageInit;


/**
 * This class contains all the page elements and methods for login page.
 * 
 * @author dh207483
 *
 */
public class LogInPage extends PageInit {

	@FindBy(name = "email")
	private WebElement emailTextBox;

	@FindBy(name = "password")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//button[(@type='submit')]")
	private WebElement submitButton;
	
	@FindBy(className = "modal-title")
	private WebElement modalHeader;

	/*
	 * This method enter the email ID on login page.
	 */
	public void enterEmail(String emailId) {
		enterText(emailTextBox, emailId, "Email");
	}

	/*
	 * This method enter password on login page.
	 */
	public void enterPassword(String password) {
		enterText(passwordTextBox, password, "Password");
	}

	/*
	 * This method click on the login button.
	 */
	public void clickOnLoginButton() {
		clickOnElement(submitButton, "Login Button");
	}
	
	/*
	 * This method get login page modal header text.
	 */
	public String getLogInPageModalHeaderText() {
		return getText(modalHeader);
		
	}
}
