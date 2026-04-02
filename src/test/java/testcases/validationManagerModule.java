package testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.LandingPage;
import pages.LoginPage;
import pages.Validation_Manager;
import resources.ChainTestListeners;
import resources.IListeners;

import java.io.IOException;
@Listeners({IListeners.class, ChainTestListeners.class})
public class validationManagerModule extends BaseTest {
@Test(
            testName = "Validation_Manager_Run",
            description = "Login and open Validation Manager from landing page menu",
            priority = 1
    )
    public void Validation_Manager_Run() throws IOException, InterruptedException {
        // ===== PHASE 1: AUTHENTICATION =====
        // Initialize LoginPage with WebDriver inherited from BaseTest.
        // WebDriver 'driver' is instance variable from BaseTest, set in @BeforeMethod.
        // PageFactory.initElements() in LoginPage constructor populates @FindBy fields.
        LoginPage loginPage = new LoginPage(driver);

        // Perform login: reads credentials from config.properties, fills form, clicks login.
        // This step validates:
        // - Login page loads correctly
        // - Credentials are properly configured in config.properties (Username, Password, Owner)
        // - Login button is responsive and clickable
        // - Post-login popup (if any) is handled gracefully
        // - Landing page modules load within 3-second buffer
        loginPage.login();

        // ===== PHASE 2: NAVIGATION TO VALIDATION MANAGER =====
        // Initialize LandingPage with same WebDriver instance.
        // LandingPage handles menu navigation after successful authentication.
        // Contains locators for System Setup, Estimating, and Validation Manager menu items.
        LandingPage landingPage = new LandingPage(driver);

        // Navigate through landing page menu hierarchy to reach Validation Manager.
        // This method:
        // - Checks for error popup: if found, test FAILS (popup indicates application error)
        // - Clicks System Setup menu option
        // - Clicks Estimating submenu option
        // - Clicks Validation Manager link
        // Uses BasePage.click() which auto-captures screenshots for tracing click sequence.
        // Each click is preceded by waitForvisibilty() with 300-second timeout.
        landingPage.ValidationManager();

        // ===== PHASE 3: VALIDATION MANAGER OPERATIONS =====
        // Initialize Validation_Manager page object to interact with its specific elements.
        // This page class encapsulates all Validation Manager UI locators and action methods.
        // Extends BasePage, so inherits common actions: click, waitForvisibilty, etc.
        Validation_Manager validation_managers = new Validation_Manager(driver);

        // Execute core Validation Manager functionality.
        // This method runs the primary business logic specific to Validation Manager module.
        // Typically includes:
        // - Form field interactions (fill, verify)
        // - Data entry and validation
        // - Verification/assertion operations
        // - Report generation or export
        // - Database updates or API calls
        validation_managers.Run_ValidationManager();

        // Test completes successfully if no exceptions are thrown.
        // WebDriver automatically closes in BaseTest.tearDown() @AfterMethod.
        // Test status (PASS) is recorded in ExtentReports with all screenshots and logs.
    }

}
