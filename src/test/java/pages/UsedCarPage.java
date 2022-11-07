package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.List;

public class UsedCarPage extends BasePage {

    public UsedCarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Type your city']")
    protected WebElement typeYourCity;

    @FindBy(xpath = "//ul[@id='ui-id-2']/li[1]")
    protected WebElement cityElement;

    @FindBy(xpath = "//li[@class='us-sprite makeLi']")
    protected List<WebElement> noofcarbrands;

    @FindBy(xpath = "//img[@title='CarWale']']")
    protected WebElement homePageLink;

    public void enterYourCity(String city) {
        try {
            typeYourCity.sendKeys(city);
            click(driver, cityElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifynoofbrands() {
        int actualnoofcarbrands = noofcarbrands.size();
        int expectednoofcarbrands = 46;
        Assert.assertEquals(actualnoofcarbrands, expectednoofcarbrands, "Not matching");
    }
    public void verifynoofbrands(String expectednoofcarbrands) {
        int actualnoofcarbrands = noofcarbrands.size();
        Assert.assertEquals(actualnoofcarbrands, Integer.parseInt(expectednoofcarbrands), "Not matching");
    }
    public void movetohomepage() {
        try {
           click(driver, homePageLink);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
