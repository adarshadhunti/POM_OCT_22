package testcases;

import org.testng.annotations.Test;
import pages.HomePage;
import org.apache.log4j.Logger;

public class TC_HM_001 extends BaseTest {
    //Logger logger = Logger.getLogger(TC_HM_001.class);

    @Test
    public void TC_HM_001() {
        HomePage hp = new HomePage(driver);
        hp.verifyMenus();
        hp.navigateToSearch();
    }
}
