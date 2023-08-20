package utilities;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.Pages;

public class CreateAccount {

    static Faker faker = new Faker();
   static Pages  pages =new Pages();

    public static void main(String[] args) {
        createNewAccount();
    }
    public static void createNewAccount() {


        //Launch browser
        Driver.getDriver();

    //Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

    //"Click on Signup Login button"
        pages.signUpLoginButton.click();
        ReuseableMethods.wait(2);

//"Enter name

        String name= faker.name().firstName();
        System.out.println("name = " + name);
        pages.nameTextBox.sendKeys(name);
        ReuseableMethods.wait(1);
        //Enter email address
        String email = faker.internet().emailAddress();
        System.out.println("email = " + email);
        pages.emailTextBox.sendKeys(email);
        ReuseableMethods.wait(1);
 //Click Signup button
        pages.signUpButton.click();
        ReuseableMethods.wait(2);

//select title
        String gender= ReuseableMethods.generateGender();
        if (gender.equals("Man")){
            pages.mrGenderRadioButton.click();
        } else {
            pages.mrsGenderRadioButton.click();}
        ReuseableMethods.wait(1);

        //Scroll down
        ReuseableMethods.scrollDownJS(200);

        //password
        pages.passwordTextBox.sendKeys(faker.internet().password());

        //day
        WebElement dayWE = pages.dayDDM;
        Select selectDay=new Select(dayWE);
        selectDay.selectByVisibleText(""+faker.instance().number().numberBetween(1, 31));//between 1 and 31 (first 0 and last 30)

        //month
        WebElement monthWE = pages.monthDDM;
        Select selectMoth=new Select(monthWE);
        selectMoth.selectByVisibleText(ReuseableMethods.generateMonth());

        //year
        WebElement yearWE= pages.yearDDM;
        Select selectYear=new Select(yearWE);
        selectYear.selectByVisibleText("2000");

        //Select checkbox Sign up for our newsletter!

        pages.newsLetterCheckBox.click();

        //Select checkbox Receive special offers from our partners!
        pages.receiveOffersCheckBox.click();

        // firstname
        pages.firstnameTextBox.sendKeys(faker.name().firstName());
        //lastname
        pages.lastnameTextBox.sendKeys(faker.name().lastName());
        //company
        pages.companyTextBox.sendKeys(faker.company().name());
        //address 1
        pages.adresse1TextBox.sendKeys(faker.address().fullAddress());
        //address 2
        pages.adresse2TextBox.sendKeys(faker.address().secondaryAddress());
        ReuseableMethods.wait(1);
        //Scroll down
        ReuseableMethods.scrollDownJS(500);
        //country
        WebElement countryWE= pages.countryDDM;
        Select selectCountry=new Select(countryWE);
        selectCountry.selectByVisibleText("India");
        //state
        pages.stateTextBox.sendKeys("Mumbai");
        //city
        pages.cityTextBox.sendKeys("Mumbai City");
        //zipCode
        pages.zipcodeTextBox.sendKeys(faker.address().zipCode());
        //mobileNumber
        pages.mobileNumberTextBox.sendKeys(faker.phoneNumber().cellPhone());

        ReuseableMethods.wait(1);
        //"Click Create Account button"
        pages.createAccountButton.click();
        ReuseableMethods.wait(1);

        Driver.closeDriver();

    }

}
