package stepdef.UI;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReuseableMethods;

public class TC01_RegisterStepDefs {
   RegisterPage registerPage;
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
        registerPage =new RegisterPage();
    Assert.assertTrue(registerPage.homeIcon.isDisplayed());

    }

    @Given("Click on Signup Login button")
    public void clickOnSignupLoginButton() {
        registerPage =new RegisterPage();
        registerPage.signUpLoginButton.click();
        ReuseableMethods.wait(2);
    }

    @Then("Verify New User Signup! is visible")
    public void verifyNewUserSignupIsVisible() {
        registerPage =new RegisterPage();
    Assert.assertTrue(registerPage.newUserSignUpText.isDisplayed());

    }

    @And("Enter {string} and {string} address")
    public void enterAndAddress(String name, String email) {
        registerPage =new RegisterPage();
       registerPage.nameTextBox.sendKeys(name);
       ReuseableMethods.wait(1);
       registerPage.emailTextBox.sendKeys(email);
     ReuseableMethods.wait(1);
    }

    @And("Click Signup button")
    public void clickSignupButton() {
        registerPage =new RegisterPage();
        registerPage.signUpButton.click();
     ReuseableMethods.wait(2);
    }

    @Then("Verify that {string} is visible")
    public void verifyThatIsVisible(String text) {
     registerPage =new RegisterPage();
     Assert.assertEquals(text,registerPage.enterAccountInfText.getText());
    }

 @When("Fill details: {string}, {string}, {string}, {string},{string}")
    public void fillDetails(String title, String password, String day, String month, String year) {
     registerPage =new RegisterPage();

     if (title.equals("Man")){
     registerPage.mrGenderRadioButton.click();
     } else {registerPage.mrsGenderRadioButton.click();}
     ReuseableMethods.wait(1);

     //Scroll down
     ReuseableMethods.scrollDownJS(200);

     //password
     registerPage.passwordTextBox.sendKeys(password);

     //day
     WebElement dayWE = registerPage.dayDDM;
     Select selectDay=new Select(dayWE);
     selectDay.selectByVisibleText(day);

     //month
     WebElement monthWE = registerPage.monthDDM;
     Select selectMoth=new Select(monthWE);
     selectMoth.selectByVisibleText(month);

    //year
    WebElement yearWE= registerPage.yearDDM;
    Select selectYear=new Select(yearWE);
    selectYear.selectByVisibleText(year);

    }


    @And("Select checkbox Sign up for our newsletter!")
    public void selectCheckboxSignUpForOurNewsletter() {
     registerPage =new RegisterPage();

     registerPage.newsLetterCheckBox.click();
    }

    @And("Select checkbox Receive special offers from our partners!")
    public void selectCheckboxReceiveSpecialOffersFromOurPartners() {
     registerPage =new RegisterPage();

     registerPage.receiveOffersCheckBox.click();

    }

    @When("Fill details: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void fillDetails(String firstName, String lastName, String company, String address, String address2, String country, String state, String city, String zipCode, String mobileNumber) {

     //firstname
     registerPage.firstnameTextBox.sendKeys(firstName);
     //lastname
     registerPage.lastnameTextBox.sendKeys(lastName);
     //company
     registerPage.companyTextBox.sendKeys(company);
     //address 1
     registerPage.adresse1TextBox.sendKeys(address);
     //address 2
     registerPage.adresse2TextBox.sendKeys(address2);
     ReuseableMethods.wait(1);
        //Scroll down
        ReuseableMethods.scrollDownJS(500);
     //country
     WebElement countryWE= registerPage.countryDDM;
     Select selectCountry=new Select(countryWE);
     selectCountry.selectByVisibleText(country);
     //state
     registerPage.stateTextBox.sendKeys(state);
     //city
     registerPage.cityTextBox.sendKeys(city);
     //zipCode
     registerPage.zipcodeTextBox.sendKeys(zipCode);
     //mobileNumber
     registerPage.mobileNumberTextBox.sendKeys(mobileNumber);


    }

    @And("Click Create Account button")
    public void clickCreateAccountButton() {
    }

    @And("Click Continue button in Account Created Page")
    public void clickContinueButtonInAccountCreatedPage() {
    }

    @And("if there is a popup add, close add")
    public void ifThereIsAPopupAddCloseAdd() {
    }

    @Then("Verify that Logged in as username is visible")
    public void verifyThatLoggedInAsUsernameIsVisible() {
    }

    @And("Click Delete Account button")
    public void clickDeleteAccountButton() {
    }

    @And("click Continue button in Account Deleted Page")
    public void clickContinueButtonInAccountDeletedPage() {
    }

    @And("close the page")
    public void closeThePage() {
    }


}
