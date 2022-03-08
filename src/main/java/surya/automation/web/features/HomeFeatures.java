package surya.automation.web.features;

import surya.automation.utils.Constants;
import surya.automation.web.pages.HomePage;
import surya.automation.web.pages.InvoicePage;

public class HomeFeatures {
    private HomePage homePageObj = new HomePage();
    private InvoicePage invoicePageObj = new InvoicePage();

    public void verifyBookingDetails(String bookingType, String statusType, String bannerText) throws InterruptedException {
        homePageObj.clickOnMyBookingsLeftMenu();
        homePageObj.clickOnViewVoucherButton(bookingType, statusType);
        invoicePageObj.switchToInvoicePage();
        invoicePageObj.verifyBannerText(bannerText);
    }
}
