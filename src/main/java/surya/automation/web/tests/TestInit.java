package surya.automation.web.tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import surya.automation.framework.AppConfig;
import surya.automation.framework.Application;
import surya.automation.web.utils.ExcelManager;

public class TestInit {

	private static String excelDataPath = "\\test-data\\";

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() throws IOException {

		/*
		 * Load Application configurations before executing tests.
		 */
		AppConfig.init();
		System.out.println(AppConfig.USER_PATH + excelDataPath);
		Map<Integer, List<String>> excelTestData = ExcelManager
				.readExcel(AppConfig.USER_PATH.concat(excelDataPath + "ExcelData.xlsx"), "TestData");
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
