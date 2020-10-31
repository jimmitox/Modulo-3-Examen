import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;


public class RandomTest extends BaseTest {


    private static final String RESOURCE = "/randomName";

    //Array of possible Fighters
   private String[] fighters = {"Edge","Jhon Cena", "Kane", "Undertaker", "La Roca", "Riquichi", "Triple H", "Stone Cold" , "Big Show", "Andre"};

    //Recorrer arreglo
    //  for (int x=0;x<fighters.length;x++){
    //        System.out.println(fighters[x]);
    //  }


    @Test
    public void Random_Name_Correct_Status_Test(){

       // request
        given().auth()
                .basic("testuser","testpass")
                .get(String.format("%s", RESOURCE))
                .then()
                .statusCode(200);
    }

    @Test
    public void Random_Name_Incorrect_Status_Test(){
        request
                .get(String.format("%s", RESOURCE))
                .then()
                .statusCode(401)
                .body("message",equalTo("Please login first"));

    }


    @Test
    public void FighterNameIsCorrect(){


        List<String> fighterL = new ArrayList<String>();
        fighterL.add("Edge");fighterL.add("Jhon Cena");fighterL.add("Kane");fighterL.add("Undertaker");fighterL.add("La Roca");
        fighterL.add("Riquichi");fighterL.add("Triple H");fighterL.add("Stone Cold");fighterL.add("Big Show");fighterL.add("Andre");

       // System.out.println("Los peliadores son" + fighterL);
        //Getting Name to Compare

     //  String name =

              given().auth()
                        .basic("testuser","testpass")
                        .get(String.format("%s", RESOURCE))
                        .then()
                            .statusCode(200)
                            .and()
                             .assertThat()
                             .body("name", anyOf(is(fighters[0]), is(fighters[1]),is(fighters[2]), is(fighters[3]), is(fighters[4]),
                                         is(fighters[5]), is(fighters[6]), is(fighters[7]) , is(fighters[8]), is(fighters[9])   ));

                /*
                .extract()
                       .response()
                        .path("name") */





     //   System.out.println(name);
      //  System.out.println(fighters[0]);

    }

/*
    @Test
    public void testExtract(){
        given().auth()
                .basic("testuser","testpass")
                .get(String.format("%s", RESOURCE))
                .then()
                .statusCode(200)
                .extract()
                .response()
                .path("name");
        String name =

                given().auth()
                .basic("testuser","testpass")
                .get(String.format("%s", RESOURCE))
                .then()
                .statusCode(200)
                .extract()
                .response()
                .path("name");

        System.out.println(name);
    }*/

    @Test
    public void submit_Same_Name(){

       //Capture current fighter to compare later
        String myCurrentFighter =

                given().auth()
                        .basic("testuser","testpass")
                        .get(String.format("%s", RESOURCE))
                        .then()
                        .statusCode(200)
                        .extract()
                        .response()
                        .path("name");
       System.out.println(myCurrentFighter);


        request
                //Sending current fighter on body
                .body("{\"name\":\""+myCurrentFighter+"\"}")
                .post("https://api-coffee-testing.herokuapp.com/v1/examen/sameName")
                .then()
                .statusCode(200)
                .body("name", anyOf(is(fighters[0]), is(fighters[1]),is(fighters[2]), is(fighters[3]), is(fighters[4]),
                        is(fighters[5]), is(fighters[6]), is(fighters[7]) , is(fighters[8]), is(fighters[9])   ));

                //or since we already have the current fighter after the post we use same variable

    }





}
