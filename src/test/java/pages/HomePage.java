package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage  extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//div[text()='NEW CARS']")
    protected WebElement nameCars;

    @FindBy(xpath = "//div[text()='USED CARS']")
    protected WebElement usedCars;

    @FindBy(xpath = "//div[text()='REVIEWS & NEWS']")
    protected WebElement reviewNews;

    @FindBy(xpath = "//button[text()='Search']")
    protected WebElement searchButton;

    @FindBy(xpath = "//ul[@class='o-XylGE  o-cpnuEd']/li/a/div[2]")
    protected List<WebElement> carTitles;

    @FindBy(xpath = "//div[text()='View More Brands']")
    protected WebElement viewMore;

    @FindBy(xpath = "//input[@placeholder='City, eg: Mumbai']")
    protected WebElement searchTextField;

    @FindBy(xpath = "//span[text()='New']")
    protected WebElement newButton;

    @FindBy(xpath = "//span[text()='Used']")
    protected WebElement usedButton;






    public void verifyMenus() {
        log1.info("Hello");
        log1.debug("Sample debug message");
        log1.info("Sample info message");
        log1.warn("Sample warn message");
        log1.error("Sample error message");
        log1.fatal("Sample fatal message");

        assertTitle(nameCars,"NEW CARS");
        assertTitle(usedCars,"USED CARS");
        assertTitle(reviewNews,"REVIEWS & NEWS");
    }

    public void navigateToSearch() {
        assertTitle(searchButton,"Search");
        searchButton.click();
    }

    public void carTitles(){
        viewMore.click();
        System.out.println("Total Car Titles: "+ carTitles.size());
        for(WebElement title : carTitles){
            System.out.println(title.getText());
        }
    }

    public void searchBasedOnCity(String city){
        searchTextField.sendKeys(city);
        sleep(2000);
        click(driver,searchButton);
    }

    public void navigateToUsedCar(){
        sleep(2000);
        click(driver,usedButton);

    }


}
