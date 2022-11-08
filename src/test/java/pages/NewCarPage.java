package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;
import java.util.List;

public class NewCarPage extends BasePage {

    @FindBy(xpath = "//ul[@class='o-XylGE  o-cpnuEd']/li/a/div[2]")
    protected List<WebElement> carTitles;
    @FindBy(xpath = "//div[text()='View More Brands']")
    protected WebElement viewMore;

    public NewCarPage(WebDriver driver) {
        super(driver);
    }

    public void carTitles() throws IOException {
        click(driver, viewMore);
        System.out.println("Total Car Brands: " + carTitles.size());
        for (WebElement title : carTitles) {
            System.out.println(title.getText());
        }
    }
}
