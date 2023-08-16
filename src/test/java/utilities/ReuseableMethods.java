package utilities;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class ReuseableMethods {



    static Faker faker = new Faker();

    public static void wait(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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



    public static String kelimeUret(int limit) {
        String kelime = "";
        Random r = new Random();
        for (int i = 0; i < limit; i++) {
            char c = (char)(r.nextInt(26) + 'a');
            kelime += c;
        }
        return kelime;
    }
    public static String stringSayiUret(int baslangic, int bitis){

        String sayi =""+faker.instance().number().numberBetween(baslangic, bitis);

        return sayi;
    }

    public static Integer integerSayiUret(int baslangic, int bitis){

        Integer sayi =faker.instance().number().numberBetween(baslangic, bitis);

        return sayi;

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


    public static String lessonChange(int lessonId){
        String lesson ="";
        switch (lessonId) {
            case 1:
                lesson="Cypress";
            case 2:
                lesson="Java";
                break;

            case 3:
                lesson="JavaScript";
                break;

            case 4:
                lesson="Phyton";
                break;

        }

        return lesson;

    }



}
