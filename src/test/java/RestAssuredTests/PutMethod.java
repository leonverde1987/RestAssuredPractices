package RestAssuredTests;

import Modals.Posts;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutMethod {

    /**
     * TYPE OF TEST CASE = TEST TO PASS
     * EXPECT RESULT = VALIDATE PUT UPDATE OF ONE REGISTER
     */
    @Parameters({"URL"})
    @Test(priority = 2)
    public void putMethodOfPostTest(String URL){
        Posts register = new Posts(100,15,"EPAM example updated","example body updated example body updated");
        var response = given()
                .body(register)
                .when()
                .put(URL+"posts/"+register.getId())
                .then()
                    .assertThat()
                    .statusCode(200);
        response.log().body();
    }

    /**
     * TYPE OF TEST CASE = TEST TO FAIL *** BUG It doesn´t handle the exceptions
     * EXPECT RESULT = VALIDATE PUT UPDATE OF ONE REGISTER INVALID
     */
    @Parameters({"URL"})
    @Test(priority = 2)
    public void putMethodOfPostInvalidTest(String URL){
        Posts register = new Posts(45023982,15,"EPAM example updated","example body updated example body updated");
        var response = given()
                .body(register)
                .when()
                .put(URL+"posts/"+register.getId())
                .then()
                    .assertThat()
                    .statusCode(500);
        response.log().body();
    }

    /**
     * TYPE OF TEST CASE = TEST TO FAIL *** BUG It doesn´t handle the exceptions
     * EXPECT RESULT = VALIDATE PUT UPDATE WHIT BIGER DATA
     */
    @Parameters({"URL"})
    @Test(priority = 2)
    public void putMethodOfPostBigerDataTest(String URL){
        Posts register = new Posts(450243534,134534534,"EPAM example updated EPAM example updated EPAM example updated EPAM example updated","example body updated example body updated example body updated example body updated example body updated example body updated example body updated example body updated example body updated example body updated");
        var response = given()
                .body(register)
                .when()
                .put(URL+"posts/"+register.getId())
                .then()
                    .assertThat()
                    .statusCode(500);
        response.log().body();
    }
}
