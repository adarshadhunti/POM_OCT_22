package testcases;

import org.testng.annotations.Test;
import pages.*;
import resources.Retry;

public class TC_HM_002 extends BaseTest{


    @Test(retryAnalyzer = Retry.class)
    public void TC_HM_002(){

        HomePage hp = new HomePage(driver);
        hp.verifyMenus();
        hp.navigateToSearch();
        NewCarPage ncp = new NewCarPage(driver);
        ncp.carTitles();

    }
}
