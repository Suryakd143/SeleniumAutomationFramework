package dh.assortment.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import dh.assortment.automation.framework.PageInit;

public class LandingPage extends PageInit {
	
	@FindBy(name = "email")
	private WebElement emailTextBox;
	
	@FindBy(name = "password")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//button[(@type='submit')]")
	private WebElement submitButton;

}
