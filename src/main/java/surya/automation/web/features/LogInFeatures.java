package surya.automation.web.features;

import org.testng.Assert;

import surya.automation.web.pages.LogInPage;

/**
 * This feature class used to perform all LoginPage related features
 * 
 * @author dh207483
 *
 */
public class LogInFeatures {
	private LogInPage logInPageObj = new LogInPage();

	/*
	 * This method is used to login to the application using following details.
	 * 
	 * @param emailId
	 * @param password
	 */
	public void loginApplication(String emailId, String password) {
		logInPageObj.enterEmail(emailId);
		logInPageObj.enterPassword(password);
		logInPageObj.clickOnLoginButton();
	}

	/*
	 * This method used to validate login page modal header.
	 */
	public void loginPageModalHeaderText(String headerText) {
		String actualModalHeaderText = logInPageObj.getLogInPageModalHeaderText();
		Assert.assertEquals(actualModalHeaderText, headerText);
	}

	/**
	 * This method is used to reset the password.
	 */
	public void resetPassword() {

	}

}
