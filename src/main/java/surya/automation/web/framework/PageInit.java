package surya.automation.web.framework;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import surya.automation.web.framework.DriverFactory;

public class PageInit {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    /*
     * In following constructor, initialized driver instance and Page elements using
     * PageFactory.
     */
    public PageInit() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        PageFactory.initElements(driver, this);
    }

    /*
     * Following method is used to enterText in any input field.
     */
    protected void enterText(WebElement element, String textToEnter, String elementName) {
        element.sendKeys(textToEnter);
        System.out.println(String.format("Entered %s in %s textbox.", textToEnter, elementName));
    }

    /*
     * Following method is used to click on any element.
     */
    protected void clickOnElement(WebElement element, String elementName) {
        element.click();
        System.out.println(String.format("Click On %s.", elementName));
    }

    /*
     * This method is used to return text of the element.
     */
    protected String getText(WebElement element) {
        return element.getText();
    }

    /**
     * This method is used to switch Frame using following parameters.
     * (a) FrameName
     * (b) FrameId
     * (c) FrameElement
     *
     * @param frameSelectionType
     */
    protected void switchFrame(Object frameSelectionType) {
        if (frameSelectionType instanceof String) driver.switchTo().frame((String) frameSelectionType);
        else if (frameSelectionType instanceof Integer) driver.switchTo().frame((Integer) frameSelectionType);
        else if (frameSelectionType instanceof WebElement) driver.switchTo().frame((WebElement) frameSelectionType);
    }

    /**
     * This method accept parent window name and switch to the opened child window.
     *
     * @param mainWindow
     */
    protected void switchWindow(String mainWindow) {
        Set<String> childWindows = driver.getWindowHandles();
        for (String childWindow : childWindows) {
            if (!childWindow.equalsIgnoreCase(mainWindow)) {
                driver.switchTo().window(childWindow);
            }
        }
    }

    /**
     * This method is used to drag an element to another location using Actions class.
     * Using Actions class we can perform following actions.
     * <p>
     * MOUSE ACTIONS:
     * (a) Mouse left click : click(element), doubleClick(element)
     * (b) Mouse right click : contextClick(element)
     * (c) Mouse Hover : moveToElement(element);
     * (d) Drag & Drop : dragAndDrop(source, target);
     * <p>
     * KEYBOARD ACTIONS:
     * (a) Type in TextBox : sendKeys(element,"abcd");
     * (b) Key Down : keyDown(Keys.CONTROL);
     * (c) Key Up : keyUp(Keys.CONTROL)
     * <p>
     * NOTES:
     * build() : Create chain of actions
     * perform() : Execute all the actions
     *
     * @param sourceElement
     * @param targetElement
     */
    protected void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement, targetElement).perform();
    }

}
