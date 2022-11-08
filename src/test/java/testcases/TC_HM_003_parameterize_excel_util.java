package testcases;

import org.testng.annotations.*;
import pages.*;
import resources.*;


public class TC_HM_003_parameterize_excel_util extends BaseTest {

    @Test(dataProvider = "getData")
    public void TC_HM_003_parameterize_excel_util(String city, String no_of_brands) {
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
        String Sheetname = "Sheet1";
        return ExcelUtil.Excelread(Sheetname);

    }
}