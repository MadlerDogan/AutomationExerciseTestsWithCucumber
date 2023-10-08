package stepdef.API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;
import org.apache.hc.core5.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;
import pojos.RegisterPojo;

import java.util.HashMap;
import java.util.Map;

import static baseurl.AutomationExerciseBaseUrl.setUp;
import static baseurl.AutomationExerciseBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.util.HashMap;
import java.util.Map;
public class APIStepDefs {

    public static Response response;
    public static RegisterPojo expectedData;


    @Then("Request parameters : {string}, {string}, {string}, {string}, {string}, {string}, {string},{string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void requestParameters(String name, String email, String password, String title, String birth_date1, String birth_month, String birth_year1, String firstname, String lastname, String company, String address1,
                                  String address2, String country, String zipcode1, String state, String city, String mobile_number1) {

        setUp();
    int  birth_date = Integer.parseInt(birth_date1);
    int birth_year = Integer.parseInt(birth_year1);
    int zipcode = Integer.parseInt(zipcode1);
    int mobile_number = Integer.parseInt(mobile_number1);

        spec.pathParam("first","createAccount");

         expectedData= new RegisterPojo(
                name, email, password, title, birth_date, birth_month, birth_year, firstname, lastname, company, address1,
                address2, country, zipcode, state, city, mobile_number

        );


         response = given(spec)
                .contentType(String.valueOf(ContentType.APPLICATION_FORM_URLENCODED))
                .formParam("name", expectedData.getName())
                .formParam("email", expectedData.getEmail())
                .formParam("password", expectedData.getPassword())
                .formParam("title", expectedData.getTitle())
                .formParam("birth_date", expectedData.getBirth_date())
                .formParam("birth_month", expectedData.getBirth_month())
                .formParam("birth_year", expectedData.getBirth_year())
                .formParam("firstname", expectedData.getFirstname())
                .formParam("lastname", expectedData.getLastname())
                .formParam("company", expectedData.getCompany())
                .formParam("address1", expectedData.getAddress1())
                .formParam("address2", expectedData.getAddress2())
                .formParam("country", expectedData.getCountry())
                .formParam("zipcode", expectedData.getZipcode())
                .formParam("state", expectedData.getState())
                .formParam("city", expectedData.getCity())
                .formParam("mobile_number", expectedData.getMobile_number())
                .post("{first}");

     }





    @Given("Delete Request parameters : {string}, {string}")
    public void deleteRequestParameters(String email, String password) {
        setUp();
        spec.pathParam("first", "deleteAccount");


        response = given(spec)
                .contentType(String.valueOf(ContentType.APPLICATION_FORM_URLENCODED))
                .formParam("email",email)
                .formParam("password", password)
                .delete("{first}");
        response.prettyPrint();


    }

    @Then("Verify Response Code: {string}, Response Message as {string}")
    public void verifyResponseCodeResponseMessageAs(String response_code1, String response_message) {
        JsonPath jsonPath = response.body().jsonPath();
        int response_code = Integer.parseInt(response_code1);

        assertEquals(jsonPath.getInt("responseCode"),response_code);
        assertEquals(jsonPath.get("message"), response_message);
    }



    @Test
    public void test(){

    }
}
