import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertEquals;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;


public class UpdateTest extends BaseTest {
    private static final String RESOURCE = "/updateName";

    //El request hace lo mismo q poner given

    @Test
    public void UpdateFighter(){
        request
                //Al base + el recurso
                .put(String.format("%s", RESOURCE))
                .then()
                .statusCode(406)
                .body("message",equalTo("Name was not provided"));





    }




}
