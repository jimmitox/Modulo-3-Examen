import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.core.IsEqual.equalTo;


public class StatusTest extends BaseTest  {

    private static final String RESOURCE = "/status";

    @Test
    public void CorrectStatus_Code_Test(){
        request
                //Al base + el recurso
                .get(String.format("%s", RESOURCE))
                .then()
                    .statusCode(200);

    }

    @Test
    public void Correct_String_Test(){
        request
                //Al base + el recurso
                .get(String.format("%s", RESOURCE))
                .then()
                    .statusCode(200)
                    .body("status",equalTo("Listos para el examen"));
    }

    @Test
    public void Status_Wrong_Page_Test(){
        request
                .get("https://api-coffee-testing.herokuapp.com/v1/examen/status2")
                .then()
                .statusCode(404);


    }





}
