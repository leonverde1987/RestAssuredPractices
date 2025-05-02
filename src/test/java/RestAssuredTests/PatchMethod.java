package RestAssuredTests;

import Modals.Posts;
import org.apache.commons.lang3.ObjectUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PatchMethod {
    String endpoint = "https://jsonplaceholder.typicode.com/posts/";

    /**
     * TYPE OF TEST CASE = TEST TO PASS
     * EXPECT RESULT = VALIDATE PATCH UPDATE OF ONE REGISTER
     */
    @Test(priority = 2)//Assign priority to execution with TestNG
    public void patchMethodOfPostsTest(){
        Posts register = new Posts(100,10,"EPAM example patch","example patch");//Create a Test data using the object Posts
        var response = given()
                .body(register)
                .when()
                .patch(endpoint+register.getId())
                .then()
                    .assertThat()
                    .statusCode(200)//Validate stats code
                    .body("userId", equalTo(register.getUserId()))// Validate userID value
                    .body("id", equalTo(register.getId()))// Validate id value
                    .body("title", equalTo(register.getTitle()))//Validate title value
                    .body("body", equalTo(register.getBody()));//Validate Body value
        response.log().body();//Save body response on the log
    }



    /**
     * TYPE OF TEST CASE = TEST TO FAIL
     * EXPECT RESULT = VALIDATE PATCH UPDATE OF ONE REGISTER INVALID
     */
    @Test(priority = 2)//Assign priority to execution with TestNG
    public void patchMethodOfPostsInvalidTest(){
        Posts register = new Posts(500,10,"EPAM example patch","example patch");//Create a Test data using the object Posts
        var response = given()
                .body(register)
                .when()
                .patch(endpoint+register.getId())
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
