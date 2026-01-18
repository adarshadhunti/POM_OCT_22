package javaoops;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class program5 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("http://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> ele=driver.findElements(By.tagName("a"));
        List<String> urls= new ArrayList<>();
        for (WebElement links: ele)
        {
            urls.add(links.getAttribute("href"));
        }
        for (String urrll:urls)
            try {
                driver.get(urrll.toString());
                System.out.println(urrll +"is valid url");
            } catch (Exception e) {
                System.out.println(urrll +"is invalid valid url");
            }

    }
}
