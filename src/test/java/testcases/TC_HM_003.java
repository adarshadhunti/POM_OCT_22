package testcases;

import org.testng.annotations.Test;
import pages.*;
import resources.Retry;

import java.io.IOException;


public class TC_HM_003 extends BaseTest {

    @Test()
    public void TC_HM_003() throws IOException {
        String city = BasePage.generateCity();
        HomePage hp = new HomePage(driver);
        hp.navigateToUsedCar();
        hp.searchBasedOnCity(city);
        UsedCarPage ucp = new UsedCarPage(driver);
        ucp.enterYourCity(city);
        ucp.verifynoofbrands();
    }
}
