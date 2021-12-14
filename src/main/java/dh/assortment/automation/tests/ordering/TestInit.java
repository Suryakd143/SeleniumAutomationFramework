package dh.assortment.automation.tests.ordering;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import dh.assortment.automation.framework.AppConfig;
import dh.assortment.automation.framework.Application;

public class TestInit {

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		/*
		 * Load Application configurations before executing tests.
		 */
		AppConfig.init();
	}

	@BeforeClass(alwaysRun = true)
	/*
	 * Launch application before each testClass
	 */
	public void beforeClass() {
		Application.launchApplication();
	}

	@AfterClass(alwaysRun = true)
	/*
	 * Quite application after each testClass
	 */
	public void afterClass() {
		Application.closeApplication();
	}

}
