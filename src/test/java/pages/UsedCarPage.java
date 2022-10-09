package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UsedCarPage extends BasePage{

    public UsedCarPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@placeholder='Type your city']")
    protected WebElement typeYourCity;

    @FindBy(xpath = "//ul[@id='ui-id-2']/li[1]")
    protected WebElement cityElement;



    public void enterYourCity(String city) {
        try {
            typeYourCity.sendKeys(city);
            click(driver,cityElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
