package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Validation_Manager extends BasePage {

    @FindBy(xpath = "//button[text()=' Enable All ']")
    protected WebElement Enable_All;

    @FindBy(xpath = "//button[text()=' Run Enabled Tests ']")
    protected WebElement Run_Enabled_Tests;

    @FindBy(xpath = "//div[@class='lii-1 lii-shape']")
    protected WebElement Loadercheck;

    @FindBy(xpath = "(//div[@id=\"mainBody\"]//div[2]//h4[1])[1]")
    protected WebElement errorpopup;

        public Validation_Manager(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void Run_ValidationManager() throws IOException {
            click(driver, Enable_All);
            click(driver, Run_Enabled_Tests);
            waitForInvisibility(driver, Loadercheck);
        failIfErrorPopupAppears(driver,errorpopup);
    }
}