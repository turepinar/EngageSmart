package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

import java.util.List;

public class HerokuAppPage {

    public HerokuAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@Onclick='addElement()']")
    private WebElement addElement;

    @FindBy(className = "added-manually")
    private List<WebElement> elementDelete;



    public void adding(int n) {
        for (int i = 0; i <n; i++) {
            addElement.click();
        }
    }

    public int actualNumberOfElements(){
        return elementDelete.size();
    }



}
