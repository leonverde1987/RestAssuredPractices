package RestAssuredTests;

import Modals.Posts;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PatchMethod {

    /**
     * TYPE OF TEST CASE = TEST TO PASS
     * EXPECT RESULT = VALIDATE PATCH UPDATE OF ONE REGISTER
     */
    @Parameters({"URL"})
    @Test(priority = 2)//Assign priority to execution with TestNG
    public void patchMethodOfPostsTest(String URL){
        Posts register = new Posts(100,10,"EPAM example patch","example patch");//Create a Test data using the object Posts
        var response = given()
                .body(register)
                .when()
                .patch(URL+"posts/"+register.getId())
                .then()
                    .assertThat()
                    .statusCode(200)//Validate stats code
                    .body("userId", equalTo(register.getUserId()))// Validate userID value
                    .body("id", equalTo(register.getId()));// Validate id value
        response.log().body();//Save body response on the log
    }



    /**
     * TYPE OF TEST CASE = TEST TO FAIL
     * EXPECT RESULT = VALIDATE PATCH UPDATE OF ONE REGISTER INVALID
     */
    @Parameters({"URL"})
    @Test(priority = 2)//Assign priority to execution with TestNG
    public void patchMethodOfPostsInvalidTest(String URL){
        Posts register = new Posts(500,10,"EPAM example patch","example patch");//Create a Test data using the object Posts
        var response = given()
                .body(register)
                .when()
                .patch(URL+"posts/"+register.getId())
                .then()
                    .assertThat()
                        .statusCode(200)//Validate stats code
                        .body("userId", equalTo(null))// Validate userID value
                        .body("id", equalTo(null))// Validate id value
                        .body("title", equalTo(null))//Validate title value
                        .body("body", equalTo(null));//Validate Body value
        response.log().body();//Save body response on the log
    }

}
