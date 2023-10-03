package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.given;

public class ApiUtilities {


    public static String generateToken(){
        String body = "{ \"password\": \"485424698\", \"username\": \"Admin\" }";

        Response response = given()
                .body(body)
                .contentType(ContentType.JSON)
                .post("https://managementonschools.com/app/auth/login");

        return response.jsonPath().getString("token");
    }



        public static String convertDateFormat(String expectedDate) {
            try {
                // Expected format: dd.MM.yyyy
                SimpleDateFormat expectedFormat = new SimpleDateFormat("dd.MM.yyyy");

                // Actual format: yyyy-MM-dd
                SimpleDateFormat actualFormat = new SimpleDateFormat("yyyy-MM-dd");

                // Parse expectedDate to Date object
                Date date = expectedFormat.parse(expectedDate);

                // Format the parsed date to actual format
                return actualFormat.format(date);
            } catch (ParseException e) {
                // Handle parse exception if necessary
                e.printStackTrace();
                return null;
            }
        }


    }






