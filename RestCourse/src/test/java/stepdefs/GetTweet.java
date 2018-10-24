package stepdefs;

import cucumber.api.java.Before;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class GetTweet {
    String consumerKey = "r1SktL1rdaFe3jsF7uaC46uky";
    String cosumerSecret = "M3Y72JtfLgNruQMXJloFlXPIpd61QGV2rERgNe9ZmSMlPLyO62";
    String accesTokenSecret = "4923063747-u2L19lo0t5L5k6I5XLGlMGVN6cq2qzMWDsahCVR";
    String secretToken = "O28DGNswrwhdcLD9ehv97TJPMqHZ7OyMZxVpOjsmTbgCQ";


  @Test
    public void GetMyTweet(){
      RestAssured.baseURI = "https://api.twitter.com";
      RestAssured.basePath = "/1.1/statuses/user_timeline.json";

            given().
                    auth().
                    oauth(consumerKey, cosumerSecret, accesTokenSecret, secretToken).
             when().
                    get().
             then().assertThat().body("text",hasItem("REST Daniela"));

        }
    }

