package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LandingPage extends BasePage {

    // Form Input Fields
    @FindBy(xpath = "//h4[@class='window-title window-header type-warning']")
    protected WebElement ErrorPopup;
    @FindBy(xpath = "//button[@class='svy-btn svy-btn-primary ng-star-inserted']")
    protected WebElement ErrorPopupmenu;
    @FindBy(xpath = " //span[text()=' System Setup']")
    protected WebElement System_Setup;
    @FindBy(xpath = "(//span[text()=' Estimating'])[2]")
    protected WebElement Estimating;
    @FindBy(xpath = "//span[text()=' Validation Manager']")
    protected WebElement Validation_Manager;

    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void ValidationManager() throws IOException {
        try {
            waitForvisibilty(driver, ErrorPopup);
            click(driver, ErrorPopupmenu);
        } catch (Exception e) {
            System.out.println("No error popup");
        }
        click(driver, System_Setup);
        click(driver, Estimating);
        click(driver, Validation_Manager);
    }
}