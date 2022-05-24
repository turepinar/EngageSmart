package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HerokuAppPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class herokuappSteps {


    WebDriver driver = DriverHelper.getDriver();
    HerokuAppPage herokuAppPage = new HerokuAppPage(driver);

    @Given("the user navigates to herokuapp Webpage")
    public void the_user_navigates_to_herokuapp_webpage() {
        driver.navigate().to(ConfigReader.readProperty("herokuappUrl"));
    }

    @When("the user click on Add Element Button {int} times")
    public void the_user_click_on_add_element_button_times(int n) {
        herokuAppPage.adding(n);
    }

    @Then("the user validates the amount of element is {int}")
    public void the_user_validates_the_amount_of_element_is(int expectedNumberOfElement) {

        Assert.assertEquals(expectedNumberOfElement, herokuAppPage.actualNumberOfElements());
    }


}
