package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

// Page Object for the application login screen.
public class LoginPage extends BasePage {

    // Username, password, and owner are read from config.properties.
    @FindBy(xpath = "//input[@placeholder='Username']")
    protected WebElement UsernameInputField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    protected WebElement passwordInputField;

    @FindBy(xpath = "//input[@placeholder='Owner']")
    protected WebElement OwnerField;

    @FindBy(xpath = "//button[text()=' Login ']")
    protected WebElement LoginButton;

    // Optional post-login confirmation popup.
    @FindBy(xpath = "//button[text()='OK']")
    protected WebElement Autoconfiguration;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Performs login using configured credentials and handles optional popup(s).
    public void login() throws IOException, InterruptedException {
        enterText(UsernameInputField, BasePage.getvalue("Username"));
        enterText(passwordInputField, BasePage.getvalue("Password"));
        enterText(OwnerField, BasePage.getvalue("Owner"));
        click(driver,LoginButton);

        // Popup may appear once or twice depending on environment state.
        try {
            click(driver, Autoconfiguration);
            click(driver, Autoconfiguration);
        }catch (Exception e){
            System.out.println("No Autoconfiguration popup");
        }

        // Small buffer to allow landing page modules to load after authentication.
        Thread.sleep(3000);
    }


}
