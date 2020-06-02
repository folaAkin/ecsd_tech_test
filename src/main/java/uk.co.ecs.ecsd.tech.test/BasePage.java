package uk.co.ecs.ecsd.tech.test;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static uk.co.ecs.ecsd.tech.test.SharedDriver.getWebDriver;

public class BasePage {
    private static final long DRIVER_WAIT_TIME = 10;
    protected WebDriverWait wait;
    protected WebDriver webDriver;

    protected BasePage() {
        this.webDriver = getWebDriver();
        if (webDriver == null) {
            System.out.println("driver is null");
        } else {
            System.out.println("the driver is not null");
        }
        this.wait = new WebDriverWait(webDriver, DRIVER_WAIT_TIME);
    }

    public WebElement waitForExpectedElement(final By by, long waitTimeInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(getWebDriver(), waitTimeInSeconds);
            return wait.until(visibilityOfElementLocated(by));
        } catch (NoSuchElementException | TimeoutException e) {
            e.getMessage();
            return null;
        }
    }

    public List<WebElement> waitForExpectedElements(final By by, long waitTimeInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(getWebDriver(), waitTimeInSeconds);
            return wait.until(visibilityOfAllElementsLocatedBy(by));
        } catch (NoSuchElementException | TimeoutException e) {
            e.getMessage();
            return null;
        }
    }

}
