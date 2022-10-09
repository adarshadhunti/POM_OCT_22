package pages;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.util.Locale;
import java.util.Properties;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public static void accept(WebDriver driver){
        Alert alert =   driver.switchTo().alert();
        System.out.println("Title" + alert.getText());
        alert.accept();
    }

    public static void dismiss(WebDriver driver){
        Alert alert =   driver.switchTo().alert();
        System.out.println("Title" + alert.getText());
        alert.dismiss();
    }

    public static void accept(WebDriver driver,String value){
        Alert alert =   driver.switchTo().alert();
        System.out.println("Title" + alert.getText());
        alert.sendKeys(value);
        alert.accept();
    }

    public static void waitForele(long timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void mouseHover(WebDriver driver, WebElement elementsByName){
        Actions actions = new Actions(driver);
        actions.moveToElement(elementsByName).build().perform();
    }

    public static void click(WebDriver driver, WebElement elementsByName){
        Actions actions = new Actions(driver);
        actions.click(elementsByName).build().perform();
    }

    public static void rightClick(WebDriver driver, WebElement element){
        Actions actions = new Actions(driver);
        actions.contextClick(element).build().perform();
    }

    public static void dragAndDrop(WebDriver driver, WebElement element1, WebElement element2){
        Actions action = new Actions(driver);
        action.dragAndDrop(element1, element2).build().perform();

    }

    public static void scrollIntoView(WebDriver driver, WebElement element1){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView();",element1);
        element1.click();

    }

    public static void selectBYindex( WebElement element, int index){
        Select sel = new Select(element);
        sel.selectByIndex(index);
    }


    public static void selectBYValue (WebElement element, String value){
        Select sel = new Select(element);
        sel.selectByValue(value);
    }

    public static void selectBYVisibleText(WebElement element, String value){
        Select sel = new Select(element);
        sel.selectByVisibleText(value);
    }

    public static void takeScreenshot(WebDriver driver){
        try {
            TakesScreenshot srcShot = (TakesScreenshot) driver;
            File screenshot = srcShot.getScreenshotAs(OutputType.FILE);
            File output = new File("./screenshot.png");
            FileUtils.copyFile(screenshot, output);
        }catch (Exception e) {}
    }

    public static String getvalue(String key){
        String value = null;
        try {
            String path = System.getProperty("user.dir")+ File.separator +"config.properties";
            FileInputStream fis = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(fis);
            value =  prop.getProperty(key);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void assertTitle(WebElement element, String expectedTitle){
      String actual =   element.getText();
      Assert.assertEquals(actual, expectedTitle,"Title not match!");
    }

    public static String generateCity(){
        Faker faker =   new Faker(new Locale("en-IND"));
        String city = faker.address().city();
        return city;
    }


}
