package stepdef.UI;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPage;

public class TC01_RegisterStepDefs {
    RegisterPage registerPage;
    Faker faker = new Faker();

    @Given("Launch browser")
    public void launchBrowser() {
    }

    @When("Navigate to url {string}")
    public void navigateToUrlHttpAutomationexerciseCom() {
    }

    @Then("Verify that home page is visible successfully")
    public void verifyThatHomePageIsVisibleSuccessfully() {
    }

    @Given("Click on Signup Login button")
    public void clickOnSignupLoginButton() {
    }

    @Then("Verify New User Signup! is visible")
    public void verifyNewUserSignupIsVisible() {
    }

    @And("Enter name and email address")
    public void enterNameAndEmailAddress() {
    }

    @And("Click Signup button")
    public void clickSignupButton() {
    }

    @Then("Verify that {string} is visible")
    public void verifyThatIsVisible(String arg0) {
    }

    @When("Fill details: {string}, {string}, {string}, {string}, {string}")
    public void fillDetails(String arg0, String arg1, String arg2, String arg3, String arg4) {
    }

    @And("Select checkbox Sign up for our newsletter!")
    public void selectCheckboxSignUpForOurNewsletter() {
    }

    @And("Select checkbox Receive special offers from our partners!")
    public void selectCheckboxReceiveSpecialOffersFromOurPartners() {
    }

    @When("Fill details: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void fillDetails(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9) {
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
