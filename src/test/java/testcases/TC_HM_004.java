package testcases;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.NewCarPage;
import pages.Registration;
import java.io.IOException;

/**
 * TC_HM_004 - New Cars Page Navigation and Display Verification Test
 *
 * Tests navigation to New Cars page and validates car listings display.
 * Includes end-to-end user registration flow.
 *
 * @author Adarsh DV
 * @date March 2026
 */
public class TC_HM_004 extends BaseTest {

    /**
     * Test method to verify New Cars page navigation and registration flow
     * @throws IOException if screenshot capture fails
     */
    @Test(testName = "newCarsPageNavigation", groups = {"sanity", "smoke"})
    public void verifyNewCarsPageNavigation() throws IOException {

        // Initialize HomePage and navigate to New Cars page
        HomePage hp = new HomePage(driver);
        hp.clickNewCarsMenu();

        // Verify New Cars page content
        NewCarPage ncp = new NewCarPage(driver);
        ncp.verifyPageTitle();
        ncp.verifyCarListingsDisplayed();

        // Test user registration flow
        Registration reg = new Registration(driver);
        reg.verifyPageLoaded();

        // Fill registration form
        reg.fillEmailField("testuser" + BasePage.geteid() + "@example.com");
        reg.fillPasswordField("SecurePass123!");
        reg.fillConfirmPasswordField("SecurePass123!");
        reg.fillFullNameField("Test User");
        reg.fillPhoneField("9876543210");

        // Submit registration
        reg.checkTermsAndConditions();
        reg.submitRegistrationForm();
        reg.verifySuccessMessage();

    } // End of verifyNewCarsPageNavigation test method

} // End of TC_HM_004 test class
