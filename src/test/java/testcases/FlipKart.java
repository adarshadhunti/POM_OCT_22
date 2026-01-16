// java
package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class FlipKart {
    public static void main(String[] args) throws InterruptedException {
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(20, java.util.concurrent.TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//span[text()='Electronics']"))).build().perform();
        act.moveToElement(driver.findElement(By.xpath("//a[text()='Cameras & Accessories']"))).build().perform();
        driver.findElement(By.xpath("//a[text()='DSLR & Mirrorless']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(5000);
        List<WebElement> imgcount = driver.findElements(By.xpath("(//div[@class='jIjQ8S'])[3]//img"));
        System.out.println("Total Images: " + imgcount.size());
        driver.quit();
    }
}
