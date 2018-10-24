import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdatePetType {

    @Test
    public void putPetType() {

        RestAssured.baseURI = "http://bhdtest.endava.com:8080/petclinic/api";
        RestAssured.basePath = "/pettypes/{petTypeId}";

        given().
                contentType(ContentType.JSON).
                pathParam("petTypeId", 129).
                body("{\"name\": \"animalTest234\"}").
                when().
                put("{petTypeId}").
                then().
                statusCode(HttpStatus.SC_NO_CONTENT);

    }
}
