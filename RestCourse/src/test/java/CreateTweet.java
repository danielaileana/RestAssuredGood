import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class CreateTweet {

    @Test
    public void CreatePostTweet(){
        RestAssured.baseURI = "https://api.twitter.com";
        RestAssured.basePath = "/1.1/statuses/update.json";

        String consumerKey = "r1SktL1rdaFe3jsF7uaC46uky";
        String cosumerSecret = "M3Y72JtfLgNruQMXJloFlXPIpd61QGV2rERgNe9ZmSMlPLyO62";
        String accesTokenSecret = "4923063747-u2L19lo0t5L5k6I5XLGlMGVN6cq2qzMWDsahCVR";
        String secretToken = "O28DGNswrwhdcLD9ehv97TJPMqHZ7OyMZxVpOjsmTbgCQ";


        given().
                auth().
                oauth(consumerKey, cosumerSecret,accesTokenSecret, secretToken).
                contentType(ContentType.JSON).
                queryParam("status", "REST Daniela").
                log().all().
        when().
                post().
        then().
                log().
                all();
    }
}
