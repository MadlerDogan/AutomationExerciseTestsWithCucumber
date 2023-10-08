package utilities;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojos.RegisterPojo;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class ReuseableMethods {

    public static  RegisterPojo registerPojo;

    static Faker faker = new Faker();

    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    public static String generateGender() {

        int num = faker.instance().number().numberBetween(0, 2);
        if(num==0){
            return "Mr";
        }
        else
        {
            return "Mrs";
        }
    }

    public static String generateMonth() {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        Random random = new Random();
        int randomIndex = random.nextInt(months.length);

        return  months[randomIndex];

    }



    public static String generateDateOfBirth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1); // 1 ay öncesini almak için

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(cal.getTime());
    }

    public static String guncelTarihiGetir() {
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(cal.getTime());
    }

    public static String birgunileriTarihiGetir() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, +1); // 1 GUN SONRASINI ALMAKİCİN

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(cal.getTime());
    }

    //istenilen uzunlukta bir şifre üret
    public static String generatePassword(int length) {
        Faker faker = new Faker();
        String password = faker.regexify("[A-Za-z0-9]{" + length + "}");
        return password;
    }


    // SCROLL TO ELEMENT WITH JS
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }



    public static String generateWord(int limit) {
        String word = "";
        Random r = new Random();
        for (int i = 0; i < limit; i++) {
            char c = (char)(r.nextInt(26) + 'a');
            word += c;
        }
        return word;
    }
    public static String generateStringNumber(int first, int end){

        String number =""+faker.instance().number().numberBetween(first, end);

        return number;
    }

    public static Integer generateIntegerNumber(int first, int end){

        Integer number =faker.instance().number().numberBetween(first, end);

        return number;

    }
    public static double generateBetweenZeroAndHundredDoubleRandomNumber() {
        Random random = new Random();
        double randomNumber = random.nextDouble() * 100; // 0 ile 100 arasında rastgele bir double sayı üretme
        randomNumber = Math.round(randomNumber * 100.0) / 100.0; // Noktadan sonra sadece 2 rakamı koruma
        return randomNumber;
    }

    public static String phoneNumberUret() {

     String phoneNumber=   faker.instance().number().numberBetween(300, 899)
                + "-" + faker.instance().number().numberBetween(100, 999)
                + "-" + faker.instance().number().numberBetween(1000, 9999);
        return phoneNumber;
    }
    public static String ssnUret() {

        String ssn=  faker.instance().number().numberBetween(100, 800)
                + "-" + faker.instance().number().numberBetween(10, 99)
                + "-" + faker.instance().number().numberBetween(1000, 9999);
        return ssn;
    }


    //Click Method
    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }

    public static WebElement waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void scrollDownJS(int pixsel){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, "+pixsel+")");
    }

    public static String getDay(String dateString) {
        return dateString.substring(0, 2);
    }

    public static String getMonth(String dateString) {
        return dateString.substring(3, 5);
    }

    public static String getYear(String dateString) {
        return dateString.substring(6, 10);
    }

    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
       int randomNumber = random.nextInt((max - min) + 1) + min; // Rastgele sayı üretme işlemi
        return randomNumber;
    }


    public static RegisterPojo generateRegister() {

        registerPojo = new RegisterPojo();
        registerPojo.setName(faker.name().username());
        registerPojo.setEmail(faker.internet().emailAddress());
        registerPojo.setPassword(faker.internet().password());
        registerPojo.setTitle(generateGender());
        registerPojo.setBirth_date(generateRandomNumber(1,28));
        registerPojo.setBirth_month(generateMonth());
        registerPojo.setBirth_year(generateRandomNumber(1900,2022));
        registerPojo.setFirstname(faker.name().firstName());
        registerPojo.setLastname(faker.name().lastName());
        registerPojo.setFirstname(faker.company().name());
        registerPojo.setAddress1(faker.address().streetName());
        registerPojo.setAddress2(faker.address().secondaryAddress());
        registerPojo.setCountry(selectRandomCountry());
        registerPojo.setZipcode(generateRandomNumber(1000,9999));
        registerPojo.setState(faker.address().state());
        registerPojo.setCity(faker.address().city());
        registerPojo.setMobile_number(generateRandomNumber(10000,99999)+generateRandomNumber(10000,99999));

        return registerPojo;
    }



    public static String selectRandomCountry() {
        String[] countryListArray = {
                "India",
                "United States",
                "Canada",
                "Australia",
                "Israel",
                "Singapore",
                };
        Random random = new Random();
        int randomIndex = random.nextInt(countryListArray.length);
        return countryListArray[randomIndex];
    }



}
