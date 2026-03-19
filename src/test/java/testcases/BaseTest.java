package testcases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver = null;

    @BeforeMethod
    public void setup() throws InterruptedException {
        String browser = System.getProperty("browser")!=null ? System.getProperty("browser") : BasePage.getvalue("browser");

        if (browser.contains("chrome")) {
           driver = new ChromeDriver();
        } else if (browser.contains("firefox")) {

            driver = new FirefoxDriver();
            Thread.sleep(300);
        }
        else if (browser.contains("InternetExplorerDriver")) {
              driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(BasePage.getvalue("url"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    /**
     * @author adarsh dv
     * @Date 2022-10-15
     */
    public String getScreenShotPath(String testMethodName, WebDriver driver) throws IOException {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String base64Screenshot ="data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.sss").format(new java.util.Date());
        String destinationFile = System.getProperty("user.dir") + "\\screenshots\\" + timeStamp + ".jpg";
        //String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testMethodName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }

    public String getScreenShotPath1(String testMethodName, WebDriver driver) throws IOException {
               String base64Screenshot ="data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        return base64Screenshot;
    }

}

