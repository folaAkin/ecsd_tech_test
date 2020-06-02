package uk.co.ecs.ecsd.tech.test;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;


@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomePage extends BasePage {
    static final long DRIVER_WAIT_TIME = 30;
    final By renderTestButton = cssSelector("[data-test-id='render-challenge']");
    final By arraysChallengeText = xpath("//h1[contains(text(),'Arrays Challenge')]");


    public void openTestHomePage() {
        SharedDriver.getWebDriver().get(Props.getProp("url"));
    }

    public void clickOnRenderTestButton() {
        waitForExpectedElement(renderTestButton, DRIVER_WAIT_TIME).click();
    }

    public void scrollUntilArraysChallengeIsDisplayed() throws InterruptedException {

        WebElement element = waitForExpectedElement(arraysChallengeText, DRIVER_WAIT_TIME);
        ((JavascriptExecutor) SharedDriver.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }

    public List<Integer> getArrays(int index) {
        List<Integer> elements = new ArrayList<>();
        By arrayElements = cssSelector("tr:nth-child(" + index + ")>[data-test-id]");
        List<WebElement> firstArrayElements = waitForExpectedElements(arrayElements, DRIVER_WAIT_TIME);
        for (WebElement firstArrayElement : firstArrayElements) {
            elements.add(Integer.parseInt(firstArrayElement.getText()));
        }

        return elements;

    }

    public int findElement(Integer[] arr, Integer size) {
        int right_sum = 0, left_sum = 0;

        // Computing right_sum
        for (int i = 1; i < size; i++)
            right_sum += arr[i];

        // Checking the point of partition
        // i.e. left_Sum == right_sum
        for (int i = 0, j = 1; j < size; i++, j++) {
            right_sum -= arr[j];

            //left_sum += arr[i];
            left_sum = left_sum + arr[i];

            if (left_sum == right_sum)
                return arr[i + 1];
        }

        return -1;
    }


}
