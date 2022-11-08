package testcases;

import org.testng.annotations.Test;
import pages.*;
import resources.Retry;

import java.io.IOException;

public class TC_HM_002 extends BaseTest{


    @Test()
    public void TC_HM_002() throws IOException {

        HomePage hp = new HomePage(driver);
        hp.verifyMenus();
        hp.navigateToSearch();
        NewCarPage ncp = new NewCarPage(driver);
        ncp.carTitles();

    }
}
