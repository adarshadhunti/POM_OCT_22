package testcases;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UsedCarPage;
import resources.Retry;
import resources.jdbcconection;

import java.sql.SQLException;
public class dbconnector extends BaseTest {
        @Test(dataProvider="getData3")
        public void TC_HM_003_parameterize_dbfetch_util(String city, String no_of_brands) {
            //String city = BasePage.generateCity();
            HomePage hp = new HomePage(driver);
            hp.navigateToUsedCar();
            hp.searchBasedOnCity(city);
            UsedCarPage ucp = new UsedCarPage(driver);
            ucp.enterYourCity(city);
            ucp.verifynoofbrands(no_of_brands);
        }

        @DataProvider
        public Object[][] getData3() throws SQLException, ClassNotFoundException {
            String tablename="cities";
            return jdbcconection.DBread(tablename);


        }


}
