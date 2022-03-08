package surya.automation.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import surya.automation.web.framework.PageInit;

import java.util.List;

public class HomePage extends PageInit {
    @FindBy(xpath = "//*[@class='sidebar-menu list-items']//*[contains(text(),'Dashboard')]")
    private WebElement dashBoardLeftMenu;

    @FindBy(xpath = "//*[@class='sidebar-menu list-items']//*[contains(text(),'My Bookings')]")
    private WebElement myBookingsLeftMenu;

    @FindBy(xpath = "//*[@class='sidebar-menu list-items']//*[contains(text(),'Add Funds')]")
    private WebElement addFundsLeftMenu;

    @FindBy(xpath = "//*[@class='sidebar-menu list-items']//*[contains(text(),'My Profile')]")
    private WebElement myProfileLeftMenu;

    public void clickOnDashboardLeftMenu() {
        clickOnElement(dashBoardLeftMenu, "DashBoard Menu");
    }

    public void clickOnMyBookingsLeftMenu() {
        clickOnElement(myBookingsLeftMenu, "My Bookings Menu");
    }

    public void clickOnAddFundsLeftMenu() {
        clickOnElement(addFundsLeftMenu, "Add Funds Menu");
    }

    public void clickOnMyProfileLeftMenu() {
        clickOnElement(myProfileLeftMenu, "MyProfile Menu");
    }

    public void clickOnViewVoucherButton(String typeOfBooking, String status) {
        List<WebElement> voucherButton = driver.findElements(By.xpath("//i[contains(@class,'" + typeOfBooking + "')]/following::td[contains(text(),'" + status + "')]/following-sibling::td"));
        clickOnElement(voucherButton.get(0), "Voucher Button");
    }
}
