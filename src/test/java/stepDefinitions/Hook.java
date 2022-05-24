package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class Hook {

    WebDriver driver = DriverHelper.getDriver();

    @After
    public void quitMethod() {
       DriverHelper.tearDown();
    }
}
