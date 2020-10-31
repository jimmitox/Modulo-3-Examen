import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

public class BaseTest {
    public RequestSpecification request;






    //Para todos recibe el URL
    @BeforeClass
    @Parameters("baseUrl")
    public void SetupRestAssured(@Optional String baseUrl){
        if (baseUrl == null){
            baseUrl = "https://api-coffee-testing.herokuapp.com/v1/examen";
        }
        RestAssured.baseURI = baseUrl;

        System.out.println(String.format("Running on %s environment", baseUrl));
    }

    @BeforeMethod
    public void before(){
        request = RestAssured.given();
    }

}
