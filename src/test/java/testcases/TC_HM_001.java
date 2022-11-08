package testcases;

import org.testng.annotations.Test;
import pages.HomePage;
import resources.Retry;

import java.io.IOException;

public class TC_HM_001 extends BaseTest {
    @Test()
    public void TC_HM_001() throws IOException {
        HomePage hp = new HomePage(driver);
        hp.verifyMenus();
        hp.navigateToSearch();
    }
}
