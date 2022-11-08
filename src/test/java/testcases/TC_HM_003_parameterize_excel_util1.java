package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UsedCarPage;
import resources.ExcelUtil;
import resources.Retry;


public class TC_HM_003_parameterize_excel_util1 extends BaseTest {

    @Test
    public void TC_HM_003_parameterize_excel_util1(String city, String no_of_brands) {
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
        String Sheetname = "Sheet2";
        return ExcelUtil.Excelread(Sheetname);

    }
}