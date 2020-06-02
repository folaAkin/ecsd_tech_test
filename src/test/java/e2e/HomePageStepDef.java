package e2e;

import cucumber.api.java.en.*;
import uk.co.ecs.ecsd.tech.test.HomePage;
import java.util.List;


public class HomePageStepDef {
    private final HomePage homePage;
    private List<Integer> array;

    public HomePageStepDef(HomePage homePage) {
        this.homePage = homePage;
    }


        @Given("^I am on ecsd home page$")
        public void iAmOnEcsdHomePage() {
        homePage.openTestHomePage();
        }

        @When("^I clicked on the render challenger button$")
        public void iClickedOnTheRenderChallengerButton() {
        homePage.clickOnRenderTestButton();
        }

        @And("^I scroll the page until Arrays Challenge is visible$")
        public void iScrollThePageUntilArraysChallengeIsVisible() throws InterruptedException {
        homePage.scrollUntilArraysChallengeIsDisplayed();
        }

    @And("^I get the index of the element that equals the sum of arrays on the left and on  the right$")
    public void iGetTheIndexOfTheElementThatEqualsTheSumOfArraysOnTheLeftAndOnTheRight() {
        Integer[] elementsArray = new Integer[array.size()];
        Integer[]  arraysElements = array.toArray(elementsArray);
        int element = homePage.findElement(arraysElements,arraysElements.length);
        System.out.printf("Element is %d%n", element);
    }

    @And("^get the array at role (.*)$")
    public void getTheEachOfTheRowNumberOfTheArrays(String indexOfArray) {
        array = homePage.getArrays(Integer.parseInt(indexOfArray));
    }
}
