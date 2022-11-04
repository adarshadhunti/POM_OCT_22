package pages;

import com.github.javafaker.Faker;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;

public class BasePage {
    public static Logger log1 = Logger.getLogger(BasePage.class.getName());
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        DOMConfigurator.configure("log4j.xml");
    }


    public static void accept(WebDriver driver){
        Alert alert =   driver.switchTo().alert();
        System.out.println("Title" + alert.getText());
        log1.info("switch to alert");
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

    public static Object[][] Excelread(String Sheetname) throws IOException {
        String Excelpath = BasePage.getvalue("Excelpath");
        File excelFile = new File(Excelpath);
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(Sheetname);
        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfColumns = sheet.getRow(0).getLastCellNum();
        String[][] data = new String[noOfRows - 1][noOfColumns];
        for (int i = 0; i < noOfRows - 1; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                DataFormatter df = new DataFormatter();
                data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
            }
        }
        workbook.close();
        fis.close();
        for (String[] dataArr : data) {
            log1.info(Arrays.toString(dataArr));
        }
        return data;
    }


}
