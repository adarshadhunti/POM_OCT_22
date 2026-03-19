package testcases;

import org.testng.annotations.Test;
import pages.HomePage;
import resources.Retry;

import java.io.IOException;

/**
 * TC_HM_001 - Homepage Menu Verification Test
 *
 * PURPOSE:
 * This test case validates the presence and correctness of navigation menu items
 * on the CarWale homepage. It serves as a critical sanity test to ensure the main
 * navigation structure is intact and functional before running more complex test scenarios.
 *
 * TEST FLOW:
 * 1. Initialize HomePage Page Object Model with the WebDriver instance
 * 2. Verify that all required menu items (NEW CARS, USED CARS, REVIEWS & NEWS) are present
 *    and display the correct text
 * 3. Navigate to the search functionality to confirm menu interactivity
 *
 * PRIORITY: CRITICAL (Sanity Test)
 * - Runs in default test suite (testng.xml)
 * - Part of smoke tests for CI/CD pipelines
 * - Should pass before proceeding with feature-specific tests
 *
 * DEPENDENCIES:
 * - HomePage.java: Contains locators for menu elements and verification methods
 * - BaseTest.java: Provides WebDriver initialization and setup/teardown
 *
 * @author Adarsh DV
 * @date March 2026
 * @version 1.0
 */
public class TC_HM_001 extends BaseTest {
    
    /**
     * Test Method: TC_HM_001
     *
     * DESCRIPTION:
     * Verifies that the CarWale homepage displays all expected navigation menu items
     * with correct text labels, and that the search navigation element is clickable.
     *
     * EXECUTION STEPS:
     * Step 1: Instantiate HomePage object
     *   - HomePage constructor initializes Page Object with WebDriver instance
     *   - All @FindBy annotated elements are populated via PageFactory.initElements()
     *   - BasePage initialization happens via super(driver) call for common utilities
     *
     * Step 2: Verify Menu Elements (hp.verifyMenus())
     *   - Validates element text for: "NEW CARS", "USED CARS", "REVIEWS & NEWS"
     *   - Uses BasePage.assertTitle() for consistent assertion style
     *   - Throws AssertionError if any menu label doesn't match expected text
     *   - Screenshots auto-captured during click operations for debugging
     *
     * Step 3: Navigate to Search (hp.navigateToSearch())
     *   - Locates and clicks the "Search" button on homepage
     *   - Confirms menu elements are interactive and responsive
     *   - Validates page navigation after clicking
     *   - Generates screenshot for audit trail
     *
     * EXPECTED RESULT:
     * ✓ All menu items visible with correct text
     * ✓ Search button is clickable and responsive
     * ✓ No exceptions thrown during execution
     * ✓ Screenshots captured at key interaction points
     * ✓ Test passes and logged as PASS in ExtentReports
     *
     * FAILURE HANDLING:
     * - On assertion failure: Test marked as FAIL, screenshot attached to report
     * - On element not found: StaleElementReferenceException, check XPath in HomePage.java
     * - On timeout: NoSuchElementException, increase implicit wait in BaseTest.setup()
     * - Listeners automatically capture failure screenshot via onTestFailure() event
     *
     * @throws IOException if screenshot capture fails
     */
    @Test(testName = "case1", groups = {"sanity"})
    public void TC_HM_001() throws IOException {
        
        // STEP 1: Instantiate HomePage Page Object Model with WebDriver from BaseTest
        // The 'driver' variable is inherited from BaseTest.setup() @BeforeMethod
        // HomePage constructor calls:
        //   - super(driver) to initialize BasePage utilities
        //   - PageFactory.initElements(driver, this) to populate @FindBy annotations
        HomePage hp = new HomePage(driver);
        
        // STEP 2: Verify Homepage Menu Elements
        // Calls verifyMenus() method from HomePage to validate:
        //   - "NEW CARS" menu item text matches expected value
        //   - "USED CARS" menu item text matches expected value
        //   - "REVIEWS & NEWS" menu item text matches expected value
        // Uses BasePage.assertTitle(element, expectedText) for consistent assertions
        // Screenshots auto-captured during element clicks for debugging failed tests
        hp.verifyMenus();
        
        // STEP 3: Navigate to Search Functionality
        // Clicks the Search button to:
        //   - Confirm menu elements are interactive and clickable
        //   - Validate navigation structure works correctly
        //   - Test page transition from homepage to search page
        // BasePage.click() method is used internally to:
        //   - Wait for element visibility (implicit wait 30s)
        //   - Take screenshot for audit trail (stored in screenshots/ folder)
        //   - Execute Actions.click() for cross-browser compatibility
        hp.navigateToSearch();
        
    } // End of TC_HM_001 test method
    
} // End of TC_HM_001 test class
