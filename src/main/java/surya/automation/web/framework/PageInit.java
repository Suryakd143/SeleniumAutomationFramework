package surya.automation.web.framework;

import java.time.Duration;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

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
        PageFactory.initElements(driver, this);
    }

    /*
     * Following method is used to enterText in any input field.
     */
    protected void enterText(WebElement element, String textToEnter, String elementName) {
        try {
            element.sendKeys(textToEnter);
            System.out.println(String.format("Entered %s in %s textbox.", textToEnter, elementName));
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        } catch (ElementNotVisibleException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /*
     * Following method is used to click on any element.
     */
    protected void clickOnElement(WebElement element, String elementName) {
        try {
            element.click();
            System.out.println(String.format("Click On %s.", elementName));
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        } catch (ElementNotVisibleException ex) {
            System.out.println(ex.getMessage());
        }
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
        try {
            if (frameSelectionType instanceof String) driver.switchTo().frame((String) frameSelectionType);
            else if (frameSelectionType instanceof Integer) driver.switchTo().frame((Integer) frameSelectionType);
            else if (frameSelectionType instanceof WebElement) driver.switchTo().frame((WebElement) frameSelectionType);
        } catch (NoSuchFrameException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * This method accept parent window name and switch to the opened child window.
     *
     * @param mainWindow
     */
    protected void switchWindow(String mainWindow) {
        try {
            Set<String> childWindows = driver.getWindowHandles();
            for (String childWindow : childWindows) {
                if (!childWindow.equalsIgnoreCase(mainWindow)) {
                    driver.switchTo().window(childWindow);
                }
            }
        } catch (NoSuchWindowException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * This method switch to the alert present on the current window
     */
    protected void switchToAlert() {
        try {
            driver.switchTo().alert();
        } catch (NoAlertPresentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * This method is used to find an element using xpath and handle exception.
     *
     * @param xpathExpression
     * @return
     */
    protected WebElement findElementByXPath(String xpathExpression) {
        WebElement element = null;
        try {
            element = driver.findElement(By.xpath(xpathExpression));
        } catch (InvalidSelectorException ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }

    /**
     * This method is used to select a value from a dropdown.
     *
     * @param element
     * @param optionValue
     */
    protected void selectFromDropDown(WebElement element, String optionValue) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            try {
                Select dropdown = new Select(element);
                dropdown.selectByValue(optionValue);
            } catch (ElementNotSelectableException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (TimeoutException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * This method is used to perform any action using javascript.
     *
     * @param domElementIdentifier
     */
    protected void executeJavaScript(String domElementIdentifier) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(driver -> (JavascriptExecutor) driver).executeScript(domElementIdentifier);
        } catch (TimeoutException ex) {
            System.out.println(ex.getMessage());
        } catch (JavascriptException ex) {
            System.out.println(ex.getMessage());
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

    /**
     * This method used to wait explicitly for a web element.
     *
     * @param element
     * @param duration
     */
    protected void explicitWait(WebElement element, Duration duration) {
        try {
            Wait wait = new WebDriverWait(driver, duration);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * This method implement fluent wait which will wait for an element
     * for maximum time period and poll every given time interval
     *
     * @param xpath
     * @param totalTime
     * @param pollingTime
     * @return
     */
    protected WebElement fluentWait(String xpath, Duration totalTime, Duration pollingTime) {
        WebElement element = null;
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(totalTime)
                    .pollingEvery(pollingTime)
                    .ignoring(NoSuchElementException.class);
            element = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.xpath(xpath));
                }
            });
        } catch (TimeoutException ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }
}
