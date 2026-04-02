package pages;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import resources.IListeners;
import testcases.BaseTest;
import java.io.*;
import java.time.Duration;
import java.util.*;
import java.util.logging.Logger;


public class BasePage {
    public static Logger log1 = Logger.getLogger(BasePage.class.getName());
    public static int timeout = 3000;
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
           }

    public static void accept(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        System.out.println("Title" + alert.getText());
        log1.info("switch to alert");
        alert.accept();
    }

    public static void dismiss(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        System.out.println("Title" + alert.getText());
        alert.dismiss();
    }

    public static void accept(WebDriver driver, String value) {
        Alert alert = driver.switchTo().alert();
        System.out.println("Title" + alert.getText());
        alert.sendKeys(value);
        alert.accept();
    }

    public static void waitForele() {
        try {
            long timeout = 150;
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static void enterText(WebElement usernameInputField, String username) {
        usernameInputField.clear();
        usernameInputField.sendKeys(username);
    }
    public static void waitForvisibilty(WebDriver driver, WebElement element) {
        log1.info("Waiting for the element" + element.getText());
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(300));
       wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void mouseHover(WebDriver driver, WebElement elementsByName) {
        waitForvisibilty(driver, elementsByName);
        Actions actions = new Actions(driver);
        actions.moveToElement(elementsByName).build().perform();
    }

    public static void click(WebDriver driver, WebElement element) throws IOException {
        waitForvisibilty(driver, element);
        BaseTest br = new BaseTest();
        String screenShotPath = br.getScreenShotPath("click", driver);
        log1.info(screenShotPath);
        Object currentTest = IListeners.getCurrentTest();
        ChainTestListener.log("Step Description");

        if (currentTest != null) {
            try {
                currentTest.getClass().getMethod("addScreenCaptureFromPath", String.class)
                        .invoke(currentTest, screenShotPath);
            } catch (Exception ignored) {
            }
            try {
                currentTest.getClass().getMethod("addScreenCaptureFromBase64String", String.class)
                        .invoke(currentTest, br.getScreenShotPath1("click", driver));
            } catch (Exception ignored) {
            }
        }
        Actions actions = new Actions(driver);
        actions.click(element).build().perform();
    }
    public static void waitForInvisibility(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    static void failIfErrorPopupAppears(WebDriver driver, WebElement ErrorPopup) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(30));
            shortWait.until(ExpectedConditions.visibilityOf(ErrorPopup));

            String popupMessage = ErrorPopup.getText();
            Assert.fail("Error popup appeared. Failing test. Popup text: " + popupMessage);
        } catch (TimeoutException ignored) {
            // Popup did not appear within short timeout -> continue test
        }
    }
    public static void rightClick(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        waitForvisibilty(driver, element);
        actions.contextClick(element).build().perform();
    }

    public static void dragAndDrop(WebDriver driver, WebElement element1, WebElement element2) {
        Actions action = new Actions(driver);
        waitForvisibilty(driver, element1);
        waitForvisibilty(driver, element2);
        action.dragAndDrop(element1, element2).build().perform();

    }

    public static void scrollIntoView(WebDriver driver, WebElement element1) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element1);
        waitForvisibilty(driver, element1);
        element1.click();
    }

    public static void selectBYindex(WebDriver driver, WebElement element, int index) {
        waitForvisibilty(driver, element);
        Select sel = new Select(element);
        sel.selectByIndex(index);
    }


    public static void selectBYValue(WebDriver driver, WebElement element, String value) {
        waitForvisibilty(driver, element);
        Select sel = new Select(element);
        sel.selectByValue(value);
    }

    public static void selectBYVisibleText(WebDriver driver, WebElement element, String value) {
        waitForvisibilty(driver, element);
        Select sel = new Select(element);
        sel.selectByVisibleText(value);
    }

    public static String getvalue(String key) {
        String value = null;
        try {
            String path = System.getProperty("user.dir") + File.separator + "config.properties";
            FileInputStream fis = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(fis);
            value = prop.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static String geteid() throws IOException
    {
        String path = System.getProperty("user.dir") + File.separator + "doc.properties";
        FileInputStream fis = new FileInputStream(path);
        Properties pr = new Properties();
        pr.load(fis);
        int eid=Integer.parseInt(pr.getProperty("doc"));
        int eid1=eid++;
        //System.out.println(pr.getProperty("doc")+1);
        pr.setProperty("doc", String.valueOf(eid));
        FileOutputStream fr = new FileOutputStream(path);
        pr.store(fr, "Properties");
        fr.close();
        return "7841976"+eid1;
     }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void assertTitle(WebElement element, String expectedTitle) {
        String actual = element.getText();
        Assert.assertEquals(actual, expectedTitle, "Title not match!");
    }

    public static String generateCity() {
        Faker faker = new Faker(new Locale("en-IND"));
        String city = faker.address().city();
        return city;
    }
}