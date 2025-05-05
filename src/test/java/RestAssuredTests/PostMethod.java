package RestAssuredTests;

import Modals.Posts;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostMethod {

    /**
     * TYPE OF TEST CASE = TEST TO PASS
     * EXPECT RESULT = VALIDATE A NEW REGISTER
     */
    @Parameters({"URL"})
    @Test(priority = 0)
    public void postMethodOfPostsTest(String URL){
        Posts register = new Posts(101,10,"EPAM example","body example body example");
        var response = given()
                .body(register)
                .when()
                .post(URL+"posts/")
                .then()
                    .assertThat()
                    .statusCode(201);
        response.log().body();
    }

    /**
     * TYPE OF TEST CASE = TEST TO FAIL
     * EXPECT RESULT = VALIDATE A NEW REGISTER WHIT BIGGER DATA
     */
    @Parameters({"URL"})
    @Test(priority = 0)
    public void postMethodOfPostsBIGGERDATATest(String URL){
        Posts register = new Posts(1012332324,1023324234,"EPAM example EPAM example EPAM example EPAM example EPAM example","body example body example body example body example body example body example body example body example body example body example");
        var response = given()
                .body(register)
                .when()
                .post(URL+"posts/")
                .then()
                    .assertThat()
                    .statusCode(201);
        response.log().body();
    }
}
