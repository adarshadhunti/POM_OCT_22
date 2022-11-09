package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/**
 * @author Aravindanath
 * @Date 2022-10-09
 */
public class BaseTest {

    public WebDriver driver = null;

    @BeforeMethod
    public void setup() {
        String browser;

        if(System.getProperty("browser")!=null)
        {
            browser=System.getProperty("browser");
        }
        else {
            browser = BasePage.getvalue("browser");
        }
        if (browser.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browser.contains("InternetExplorerDriver")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        driver.get(BasePage.getvalue("url"));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    /**
     * @author adarsh dv
     * @Date 2022-10-15
     */
    public String getScreenShotPath(String testMethodName, WebDriver driver) throws IOException {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        String destinationFile = System.getProperty("user.dir") + "\\screenshots\\" + timeStamp + ".png";
        //String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testMethodName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }

    public static void zoomcorrction(WebDriver driver) {

    }
}

