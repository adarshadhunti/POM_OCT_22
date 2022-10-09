package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.BasePage;
import java.util.concurrent.TimeUnit;

/**
 * @author Aravindanath
 * @Date 2022-10-09
 */
public class BaseTest {

    protected WebDriver driver = null;

    @BeforeClass
    public void setup(){
        if(BasePage.getvalue("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }else if(BasePage.getvalue("browser").equalsIgnoreCase  ("firefox")){
             WebDriverManager.firefoxdriver().create();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(BasePage.getvalue("url"));
    }

    @AfterClass
    public  void tearDown() {
        BasePage.sleep(6000);
     //   driver.quit();
    }

}
