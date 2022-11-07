package testcases;

import org.testng.annotations.*;
import pages.*;
import resources.Retry;


public class TC_HM_003_parameterize extends BaseTest {

    @Test(dataProvider = "getData",retryAnalyzer = Retry.class)
    public void TC_HM_003_parameterizer(String city) {
        //String city = BasePage.generateCity();
        HomePage hp = new HomePage(driver);
        hp.navigateToUsedCar();
        hp.searchBasedOnCity(city);
        UsedCarPage ucp = new UsedCarPage(driver);
        ucp.enterYourCity(city);
        ucp.verifynoofbrands();
    }

    @DataProvider
    public Object[][] getData() {
        // Row stands for how many different data types test should run
        //coloumn stands for how many values per each test

        // Array size is 2
        // 0,1
        Object[][] data = new Object[2][1];
        //0th row
        data[0][0] = "Bangalore";
        //1st row
        data[1][0] = "Mumbai";
        return data;
    }
}