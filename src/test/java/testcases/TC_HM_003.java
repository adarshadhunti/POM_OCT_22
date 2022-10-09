package testcases;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.NewCarPage;
import pages.UsedCarPage;

public class TC_HM_003 extends BaseTest{


    @Test
    public void TC_HM_003(){

        String city = BasePage.generateCity();
        HomePage hp = new HomePage(driver);
        hp.navigateToUsedCar();
        hp.searchBasedOnCity(city);
        UsedCarPage ucp = new UsedCarPage(driver);
        ucp.enterYourCity(city);


    }
}
