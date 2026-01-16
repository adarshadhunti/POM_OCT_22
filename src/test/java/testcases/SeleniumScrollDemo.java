package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumScrollDemo {

    @Test
    public void testScrollToElement() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.flipkart.com/"); // Replace with a long URL
driver.manage().timeouts().implicitlyWait(2000, java.util.concurrent.TimeUnit.MILLISECONDS);
        // 1. Cast the driver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 2. Find an element near the bottom of the page
        // You would replace this with a real locator for your specific page
      //  WebElement footerLink = driver.findElement(By.linkText("Privacy Policy"));

        // 3. Execute the scroll script to bring the element into view
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Optional: Add a short pause to visually confirm the scroll happened
        Thread.sleep(5000);

        driver.quit();
    }
}