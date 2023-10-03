package baseurl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class AutomationExerciseBaseUrl {


    public static RequestSpecification spec;



    public static void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://automationexercise.com/api")
                .setContentType(ContentType.JSON)
                .build();


    }
}
