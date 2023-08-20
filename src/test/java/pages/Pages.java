package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Pages {
    public Pages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//i[@class='fa fa-home']")
    public WebElement homeIcon;

    @FindBy(xpath = "//*[@class='fa fa-lock']")
    public WebElement signUpLoginButton;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElement newUserSignUpText;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement nameTextBox;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//button[contains(text(),'Signup')]")
    public WebElement signUpButton;

    @FindBy(xpath = "//*[text()='Enter Account Information']")
    public WebElement enterAccountInfText;

    @FindBy(xpath = "//input[@id='id_gender1']")
    public WebElement mrGenderRadioButton;

    @FindBy(xpath = "//input[@id='id_gender2']")
    public WebElement mrsGenderRadioButton;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//select[@id='days']")
    public WebElement dayDDM;

    @FindBy(xpath = "//select[@id='months']")
    public WebElement monthDDM;

    @FindBy(xpath = "//select[@id='years']")
    public WebElement yearDDM;

    @FindBy(xpath = "//input[@id='newsletter']")
    public WebElement newsLetterCheckBox;

    @FindBy(xpath = "//input[@id='optin']")
    public WebElement receiveOffersCheckBox;

    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement firstnameTextBox;

    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement lastnameTextBox;

    @FindBy(xpath = "//input[@id='company']")
    public WebElement companyTextBox;

    @FindBy(xpath = "//input[@id='address1']")
    public WebElement adresse1TextBox;

    @FindBy(xpath = "//input[@id='address2']")
    public WebElement adresse2TextBox;

    @FindBy(xpath = "//select[@id='country']")
    public WebElement countryDDM;

    @FindBy(xpath = "//input[@id='state']")
    public WebElement stateTextBox;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement cityTextBox;

    @FindBy(xpath = "//input[@id='zipcode']")
    public WebElement zipcodeTextBox;

    @FindBy(xpath = "//input[@id='mobile_number']")
    public WebElement mobileNumberTextBox;

    @FindBy(xpath = "//button[contains(text(),'Create Account')]")
    public WebElement createAccountButton;

    @FindBy(xpath = "//b[contains(text(),'Account Created!')]")
    public WebElement accountCreatedText;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    public WebElement continueButtonAfterCreated;

    @FindBy(xpath = "//a[contains(text(),' Logged in as ')]")
    public WebElement loggedInAsText;

    @FindBy(xpath = "//a[contains(text(),' Delete Account')]")
    public WebElement deleteAccountButton;

    @FindBy(xpath = "//b[contains(text(),'Account Deleted!')]")
    public WebElement accountDeletedText;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButtonAfterDelete;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement loginToYourAccountText;

    @FindBy(xpath = "//*[@type='email']")
    public WebElement emailAddressForLogin;

    @FindBy(xpath = "//*[@type='password']")
    public WebElement passwordForLogin;

    @FindBy(xpath = "(//*[@type='submit'])[1]")
    public WebElement loginButton;



}
