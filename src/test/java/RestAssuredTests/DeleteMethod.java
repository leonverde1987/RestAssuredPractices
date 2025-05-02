package RestAssuredTests;

import Modals.Posts;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteMethod {
    String endpoint = "https://jsonplaceholder.typicode.com/posts/";


    /**
     * TYPE OF TEST CASE = TEST TO PASS
     * EXPECT RESULT = VALIDATE DELETE A REGISTER
     */
    @Test(priority = 3)
    public void deleteMethodOfPostsTest(){
        Posts register = new Posts(101,0,"","");
        var response = given()
                .body(register)
                .when()
                .delete(endpoint+register.getId())
                .then().statusCode(200);
        response.log().body();
    }

    /**
     * TYPE OF TEST CASE = TEST TO FAIL
     * EXPECT RESULT = VALIDATE DELETE A REGISTER
     */
    @Test(priority = 3)
    public void deleteMethodOfPostsInvalidTest(){
        Posts register = new Posts(500,0,"","");
        var response = given()
                .body(register)
                .when()
                .delete(endpoint+register.getId())
                .then().statusCode(200);
        response.log().body();
    }

}
