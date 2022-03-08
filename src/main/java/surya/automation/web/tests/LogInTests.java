package surya.automation.web.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import surya.automation.utils.Constants;
import surya.automation.utils.Enums;
import surya.automation.web.features.HomeFeatures;
import surya.automation.web.framework.AppConfig;
import surya.automation.web.features.LogInFeatures;
import surya.automation.web.framework.TestInit;

public class LogInTests extends TestInit {
	public static String userName, password;

	@BeforeClass
	public void setup() {
		userName = AppConfig.userName;
		password = AppConfig.password;	
	}
	
	@Test(priority = 0,description = "Login With invalid Credentials.", enabled = false)
	public void verifyUserShouldNotAbleToLogin() {
		LogInFeatures loginObj = new LogInFeatures();
		loginObj.loginPageModalHeaderText("Login");
		loginObj.loginApplication(userName, "invalidPassword");
	}
	
	@Test(priority = 1,description = "Login With Valid Credentials.", enabled = false)
	public void verifyUserShouldAbleToLogin() {
		LogInFeatures loginObj = new LogInFeatures();
		loginObj.loginPageModalHeaderText("Login");
		loginObj.loginApplication(userName, password);
	}

	@Test(priority = 1,description = "Login With Valid Credentials.")
	public void verifyUserShouldAbleToBookHotel() throws InterruptedException {
		LogInFeatures loginObj = new LogInFeatures();
		loginObj.loginPageModalHeaderText("Login");
		loginObj.loginApplication(userName, password);

		HomeFeatures homeObj = new HomeFeatures();
		homeObj.verifyBookingDetails(Enums.BookingType.Hotel.getBookingType(), String.valueOf(Enums.Status.pending),Constants.PENDINGINVOICEBANNERTEXT);
	}
	
}
