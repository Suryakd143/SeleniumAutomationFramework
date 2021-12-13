package dh.assortment.automation.tests.ordering;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dh.assortment.automation.features.LogIn;
import dh.assortment.automation.framework.AppConfig;
import dh.assortment.automation.framework.TestInit;

public class LogInTests extends TestInit{
	public static String userName, password; 

	@BeforeClass
	public void setup() {
		userName = AppConfig.userName;
		password = AppConfig.password;	
	}
	
	@Test(priority = 0,description = "Login With invalid Credentials.")
	public void verifyUserShouldNotAbleToLogin() {
		LogIn loginObj = new LogIn();
		loginObj.loginPageModalHeaderText("Login");
		loginObj.loginApplication(userName, "invalidPassword");
	}
	
	@Test(priority = 1,description = "Login With Valid Credentials.")
	public void verifyUserShouldAbleToLogin() {
		LogIn loginObj = new LogIn();
		loginObj.loginPageModalHeaderText("Login");
		loginObj.loginApplication(userName, password);
	}
	
}
