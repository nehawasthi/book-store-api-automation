package utils;
import io.cucumber.java.BeforeAll;
import static io.restassured.RestAssured.*;

public class BaseApiClass {

   @BeforeAll
    public static void setUp()
   {
       baseURI=ConfigLoader.get("base.url")+":"+ConfigLoader.get("base.port");
   }

}
