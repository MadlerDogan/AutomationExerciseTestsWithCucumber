package stepdef.UI;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.Pages;
import utilities.Driver;
import utilities.ReuseableMethods;

public class UIStepDefs {
   Pages pages;
    Faker faker = new Faker();





    @Given("Launch browser")
    public void launchBrowser() {

        Driver.getDriver();
    }

    @When("Navigate to url {string}")
    public void navigateToUrl(String url) {

        Driver.getDriver().get(url);
    }

    @Then("Verify that home page is visible successfully")
    public void verifyThatHomePageIsVisibleSuccessfully() {
        pages =new Pages();
    Assert.assertTrue(pages.homeIcon.isDisplayed());

    }

    @Given("Click on Signup Login button")
    public void clickOnSignupLoginButton() {
        pages =new Pages();
        pages.signUpLoginButton.click();
        ReuseableMethods.wait(2);
    }

    @Then("Verify New User Signup! is visible")
    public void verifyNewUserSignupIsVisible() {
        pages =new Pages();
    Assert.assertTrue(pages.newUserSignUpText.isDisplayed());

    }

    @And("Enter {string} and {string} address")
    public void enterAndAddress(String name, String email) {
        pages =new Pages();
       pages.nameTextBox.sendKeys(name);
       ReuseableMethods.wait(1);
       pages.emailTextBox.sendKeys(email);
     ReuseableMethods.wait(1);
    }

    @And("Click Signup button")
    public void clickSignupButton() {
        pages =new Pages();
        pages.signUpButton.click();
     ReuseableMethods.wait(2);
    }

    @Then("Verify that {string} is visible")
    public void verifyThatIsVisible(String text) {
     pages =new Pages();
     Assert.assertEquals(text, pages.enterAccountInfText.getText());
    }

 @When("Fill details: {string}, {string}, {string}, {string},{string}")
    public void fillDetails(String title, String password, String day, String month, String year) {
     pages =new Pages();

     if (title.equals("Man")){
     pages.mrGenderRadioButton.click();
     } else {
         pages.mrsGenderRadioButton.click();}
     ReuseableMethods.wait(1);

     //Scroll down
     ReuseableMethods.scrollDownJS(200);

     //password
     pages.passwordTextBox.sendKeys(password);

     //day
     WebElement dayWE = pages.dayDDM;
     Select selectDay=new Select(dayWE);
     selectDay.selectByVisibleText(day);

     //month
     WebElement monthWE = pages.monthDDM;
     Select selectMoth=new Select(monthWE);
     selectMoth.selectByVisibleText(month);

    //year
    WebElement yearWE= pages.yearDDM;
    Select selectYear=new Select(yearWE);
    selectYear.selectByVisibleText(year);

    }


    @And("Select checkbox Sign up for our newsletter!")
    public void selectCheckboxSignUpForOurNewsletter() {
     pages =new Pages();

     pages.newsLetterCheckBox.click();
    }

    @And("Select checkbox Receive special offers from our partners!")
    public void selectCheckboxReceiveSpecialOffersFromOurPartners() {
     pages =new Pages();

     pages.receiveOffersCheckBox.click();

    }

    @When("Fill details: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void fillDetails(String firstName, String lastName, String company, String address, String address2, String country, String state, String city, String zipCode, String mobileNumber) {
        pages =new Pages();
     //firstname
     pages.firstnameTextBox.sendKeys(firstName);
     //lastname
     pages.lastnameTextBox.sendKeys(lastName);
     //company
     pages.companyTextBox.sendKeys(company);
     //address 1
     pages.adresse1TextBox.sendKeys(address);
     //address 2
     pages.adresse2TextBox.sendKeys(address2);
     ReuseableMethods.wait(1);
        //Scroll down
        ReuseableMethods.scrollDownJS(500);
     //country
     WebElement countryWE= pages.countryDDM;
     Select selectCountry=new Select(countryWE);
     selectCountry.selectByVisibleText(country);
     //state
     pages.stateTextBox.sendKeys(state);
     //city
     pages.cityTextBox.sendKeys(city);
     //zipCode
     pages.zipcodeTextBox.sendKeys(zipCode);
     //mobileNumber
     pages.mobileNumberTextBox.sendKeys(mobileNumber);

        ReuseableMethods.wait(1);
    }

    @And("Click Create Account button")
    public void clickCreateAccountButton() {
        pages =new Pages();
        pages.createAccountButton.click();
        ReuseableMethods.wait(1);
    }

    @Then("After account created verify that {string} is visible")
    public void after_account_created_verify_that_is_visible(String text) {
        pages =new Pages();
        Assert.assertEquals(text, pages.accountCreatedText.getText());
    }

    @And("Click Continue button in Account Created Page")
    public void clickContinueButtonInAccountCreatedPage() {
        pages =new Pages();
        pages.continueButtonAfterCreated.click();
        ReuseableMethods.wait(1);
        //if there is a popup add, close add
        Driver.getDriver().get("https://automationexercise.com/account_created#google_vignette");
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.ESCAPE).build().perform();
        ReuseableMethods.wait(1);
        //click comtiue
        pages.continueButtonAfterCreated.click();

    }

    @Then("Verify that Logged in as username is visible")
    public void verifyThatLoggedInAsUsernameIsVisible() {
        pages =new Pages();
        Assert.assertTrue(pages.loggedInAsText.isDisplayed());
        ReuseableMethods.wait(1);
    }

    @And("Click Delete Account button")
    public void clickDeleteAccountButton() {
        pages =new Pages();
        pages.deleteAccountButton.click();

        ReuseableMethods.wait(1);

        //    if there is a popup add, close ad
        Driver.getDriver().get("https://automationexercise.com/delete_account#google_vignette");
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.ESCAPE).build().perform();
        ReuseableMethods.wait(1);
    }


    @Then("After account deleted verify that {string} is visible")
    public void after_account_deleted_verify_that_is_visible(String text) {
        pages =new Pages();
        Assert.assertEquals(text, pages.accountDeletedText.getText());
    }

    @And("click Continue button in Account Deleted Page")
    public void clickContinueButtonInAccountDeletedPage() {
        pages =new Pages();
        pages.continueButtonAfterDelete.click();
        ReuseableMethods.wait(1);
    }

    @And("close the page")
    public void closeThePage() {
        Driver.closeDriver();
    }

//TC02 Steps

    @Then("Verify Login to your account is visible")
    public void verifyLoginToYourAccountIsVisible() {
        pages =new Pages();
        Assert.assertTrue(pages.loginToYourAccountText.isDisplayed());
    }
    @And("Enter correct email address and password")
    public void enterCorrectEmailAddressAndPassword() {
        pages =new Pages();
        // Enter e-mail
        pages.emailAddressForLogin.sendKeys("Macupicu@gmail.com");
        //Enter password
        pages.passwordForLogin.sendKeys("password");
    }

    @And("Click login button")
    public void clickLoginButton() {

        pages =new Pages();
        pages.loginButton.click();
    }


    @And("Enter incorrect email address and password")
    public void enterIncorrectEmailAddressAndPassword() {
        pages =new Pages();
       // Enter e-mail
        pages.emailAddressForLogin.sendKeys("Macupicu@gmail.com");
        //Enter password
        pages.passwordForLogin.sendKeys("password");
        ReuseableMethods.wait(1);
    }

    @Then("Verify error your email or password is incorrect! is visible")
    public void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible() {

        pages =new Pages();
        Assert.assertTrue(pages.emailOrPasswortIsIncorrectText.isDisplayed());

    }

    @And("Click Logout button")
    public void clickLogoutButton() {
        pages =new Pages();
        pages.logoutButton.click();
        ReuseableMethods.wait(1);

    }

    @Then("Verify that user is navigated to login page")
    public void verifyThatUserIsNavigatedToLoginPage() {
        pages =new Pages();
        Assert.assertTrue(pages.loginPageIsVisible.isDisplayed());

    }
}
