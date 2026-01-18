// java
package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class Linkss {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(20, java.util.concurrent.TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links: " + links.size());
        List<LinkInfo> linkInfos = new ArrayList<>();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (WebElement link : links) {
            String href = link.getAttribute("href");
            String text = link.getText();
            String outer = "";
            try {
                outer = (String) js.executeScript("return arguments[0].outerHTML;", link);
            } catch (Exception ignored) {
            }
            linkInfos.add(new LinkInfo(href, text, outer));
        }
        for (LinkInfo li : linkInfos) {
            if (li.href == null || li.href.trim().isEmpty()) {
                System.out.println("Skipping link with no href. text: " + li.text + " html: " + li.outerHtml);
                continue;
            }
            try {
                driver.get(li.href);
                System.out.println("Valid link: " + li.href);
            } catch (Exception e) {
                System.out.println("Broken link: " + li.href + " (text: " + li.text + ")");
            }
        }
        driver.quit();
    }

    private static class LinkInfo {
        final String href;
        final String text;
        final String outerHtml;

        LinkInfo(String href, String text, String outerHtml) {
            this.href = href;
            this.text = text;
            this.outerHtml = outerHtml;
        }
    }
}