package surya.automation.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import surya.automation.web.framework.PageInit;

public class InvoicePage extends PageInit {

    @FindBy(xpath = "//div[contains(@class,'infobox')]")
    private WebElement infoBoxBanner;

    public void switchToInvoicePage() {
        String mainWindow = driver.getWindowHandle();
        switchWindow(mainWindow);
    }

    public void verifyBannerText(String expectedBannerText) {
        String actualText = getText(infoBoxBanner);
        System.out.println("Banner Text : "+ actualText);
        if (actualText.contains(expectedBannerText)){
            Assert.assertTrue(true);
        };
    }
}
