package testcases;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.UsedCarPage;

import java.io.File;
import java.io.FileInputStream;


public class TC_HM_003_parameterize_excel extends BaseTest {

    @Test(dataProvider = "getData")
    public void TC_HM_003_parameterize_excel(String city, String no_of_brands) {
        //String city = BasePage.generateCity();
        HomePage hp = new HomePage(driver);
        hp.navigateToUsedCar();
        hp.searchBasedOnCity(city);
        UsedCarPage ucp = new UsedCarPage(driver);
        ucp.enterYourCity(city);
        ucp.verifynoofbrands(no_of_brands);
    }

    @DataProvider
    public Object[][] getData() throws Exception {
        String Excelpath = BasePage.getvalue("Excelpath");
        File excelFile = new File(Excelpath);
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        //String Sheetname= "Sheet1";
        //XSSFSheet sheet = BasePage.excelutil("Sheet1");
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
        return data;
    }

}