import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class transferTest {
    private static String uri = "https://sandme.ru/";
    private static String USD = "d96d23be-30c9-4243-a9ab-e432e9a6f71d";
    private static String EUR = "95b22bb7-1bee-4bc5-9555-52689137eb49";
    private static String login = "0001@mailinator.com";
    private static String pwd = "qwerty123";
    private static String apiKey = "acea9d6d570540bb7d0e0f077182ffdc";

    @Test
    void shouldTransferMoneyUsingUsdCurrency() {

        given()
                .baseUri(uri)
                .header("X-Api-Key", apiKey)
                .contentType("application/x-www-form-urlencoded")
                .auth().preemptive().basic(login, pwd)
                .formParam("amount", "100")
                .formParam("amount_currency", USD)
                .formParam("from_account", "1234")
                .formParam("to_account", "5678")


                .when()
                .post("api/v2/exchange_transfers")
                .then().log().all().statusCode(200);


    }

}
