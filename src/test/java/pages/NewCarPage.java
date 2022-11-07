package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewCarPage extends BasePage{

    public NewCarPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//ul[@class='o-XylGE  o-cpnuEd']/li/a/div[2]")
    protected List<WebElement> carTitles;

    @FindBy(xpath = "//div[text()='View More Brands']")
    protected WebElement viewMore;



    public void carTitles(){
        click(driver,viewMore);
        System.out.println("Total Car Brands: "+ carTitles.size());
        for(WebElement title : carTitles){
            System.out.println(title.getText());
        }
    }




}
