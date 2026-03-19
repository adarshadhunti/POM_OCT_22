package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

/**
 * Registration Page Object Model
 * Encapsulates all elements and interactions for user registration (signup) page.
 * 
 * USAGE:
 * Registration reg = new Registration(driver);
 * reg.fillEmailField("user@example.com");
 * reg.fillPasswordField("SecurePass123!");
 * reg.fillConfirmPasswordField("SecurePass123!");
 * reg.fillFullNameField("John Doe");
 * reg.fillPhoneField("9876543210");
 * reg.checkTermsAndConditions();
 * reg.submitRegistrationForm();
 * reg.verifySuccessMessage();
 *
 * @author Adarsh DV
 * @date March 2026
 * @version 1.0
 */
public class Registration extends BasePage {

    // Form Input Fields
    @FindBy(xpath = "//input[@placeholder='Email']")
    protected WebElement emailInputField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    protected WebElement passwordInputField;

    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    protected WebElement confirmPasswordInputField;

    @FindBy(xpath = "//input[@placeholder='Full Name']")
    protected WebElement fullNameInputField;

    @FindBy(xpath = "//input[@placeholder='Phone Number']")
    protected WebElement phoneNumberInputField;

    // Form Checkboxes
    @FindBy(xpath = "//input[@type='checkbox'][following-sibling::label[contains(text(), 'Terms')]]")
    protected WebElement termsAndConditionsCheckbox;

    @FindBy(xpath = "//input[@type='checkbox'][following-sibling::label[contains(text(), 'Newsletter')]]")
    protected WebElement newsletterCheckbox;

    // Form Buttons
    @FindBy(xpath = "//button[contains(text(), 'Register')]")
    protected WebElement registerButton;

    @FindBy(xpath = "//button[contains(text(), 'Cancel')]")
    protected WebElement cancelButton;

    // Form Labels & Headings
    @FindBy(xpath = "//h1[contains(text(), 'Create Account')]")
    protected WebElement pageHeading;

    @FindBy(xpath = "//label[contains(text(), 'Email')]")
    protected WebElement emailLabel;

    // Form Error Messages
    @FindBy(xpath = "//span[contains(text(), 'Email already registered')]")
    protected WebElement emailAlreadyRegisteredError;

    @FindBy(xpath = "//span[contains(text(), 'Passwords do not match')]")
    protected WebElement passwordMismatchError;

    @FindBy(xpath = "//span[contains(text(), 'This field is required')]")
    protected WebElement requiredFieldError;

    // Form Success Message
    @FindBy(xpath = "//span[contains(text(), 'Registration successful')]")
    protected WebElement successMessage;

    /**
     * Constructor
     * @param driver WebDriver instance
     */
    public Registration(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Form Interaction Methods

    /**
     * Fill email field
     * @param email User email address
     */
    public void fillEmailField(String email) {
        emailInputField.clear();
        emailInputField.sendKeys(email);
        log1.info("Filled email field with: " + email);
    }

    /**
     * Fill password field
     * @param password User password
     */
    public void fillPasswordField(String password) {
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
        log1.info("Filled password field");
    }

    /**
     * Fill confirm password field
     * @param confirmPassword Confirm password value (must match password)
     */
    public void fillConfirmPasswordField(String confirmPassword) {
        confirmPasswordInputField.clear();
        confirmPasswordInputField.sendKeys(confirmPassword);
        log1.info("Filled confirm password field");
    }

    /**
     * Fill full name field
     * @param fullName User's full name
     */
    public void fillFullNameField(String fullName) {
        fullNameInputField.clear();
        fullNameInputField.sendKeys(fullName);
        log1.info("Filled full name field with: " + fullName);
    }

    /**
     * Fill phone number field
     * @param phoneNumber User's 10-digit phone number
     */
    public void fillPhoneField(String phoneNumber) {
        phoneNumberInputField.clear();
        phoneNumberInputField.sendKeys(phoneNumber);
        log1.info("Filled phone number field");
    }

    /**
     * Check Terms and Conditions checkbox (required)
     * @throws IOException if screenshot capture fails
     */
    public void checkTermsAndConditions() throws IOException {
        if (!termsAndConditionsCheckbox.isSelected()) {
            click(driver, termsAndConditionsCheckbox);
            log1.info("Checked Terms and Conditions checkbox");
        }
    }

    /**
     * Check Newsletter subscription checkbox (optional)
     * @throws IOException if screenshot capture fails
     */
    public void checkNewsletterSubscription() throws IOException {
        if (!newsletterCheckbox.isSelected()) {
            click(driver, newsletterCheckbox);
            log1.info("Checked Newsletter subscription checkbox");
        }
    }

    /**
     * Submit registration form
     * @throws IOException if screenshot capture fails
     */
    public void submitRegistrationForm() throws IOException {
        if (!termsAndConditionsCheckbox.isSelected()) {
            throw new IllegalStateException("Terms and Conditions must be checked before submitting");
        }
        click(driver, registerButton);
        log1.info("Submitted registration form");
    }

    /**
     * Cancel registration and return to previous page
     * @throws IOException if screenshot capture fails
     */
    public void cancelRegistration() throws IOException {
        click(driver, cancelButton);
        log1.info("Cancelled registration");
    }

    /**
     * Verify registration page is loaded correctly
     */
    public void verifyPageLoaded() {
        assertTitle(pageHeading, "Create Account");
        assertTitle(emailLabel, "Email");
        log1.info("Registration page verified");
    }

    /**
     * Verify registration success message is displayed
     */
    public void verifySuccessMessage() {
        assertTitle(successMessage, "Registration successful");
        log1.info("Registration success message verified");
    }

    /**
     * Verify email already registered error is shown
     */
    public void verifyEmailAlreadyRegisteredError() {
        assertTitle(emailAlreadyRegisteredError, "Email already registered");
        log1.info("Email already registered error verified");
    }

    /**
     * Verify password mismatch error is shown
     */
    public void verifyPasswordMismatchError() {
        assertTitle(passwordMismatchError, "Passwords do not match");
        log1.info("Password mismatch error verified");
    }

}

