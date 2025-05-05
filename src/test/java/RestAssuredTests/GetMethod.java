package RestAssuredTests;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetMethod {
    //++++++++++++++++++++++++++++++++++
    //SCENARIO TEST TO PASS
    //+++++++++++++++++++++++++++++++++++

    /**
     * TYPE OF TEST CASE = TEST TO PASS
     * EXPECT RESULT = VALIDATE THE TOTAL SIZE OF THE POSTS AVAILABLE IN THE API
     */
    @Parameters({"URL"})
    @Test(priority = 1)//Assign priority to execution with TestNG
    public void getMethodAllPosts(String URL) {
        var response = given()
                .when().get(URL + "posts")
                .then()
                    .assertThat()
                        .statusCode(200)//Validate status code
                        .body("records.size()", equalTo(100));//Validate size records returned
        response.log().body();//Print Response body in the log.
    }

    /**
     * TYPE OF TEST CASE = TEST TO PASS
     * EXPECT RESULT = VALIDATE ONE SPECIFIC POSTS
     */
    @Parameters({"URL"})
    @Test(priority = 1)//Assign priority to execution with TestNG
    public void getMethodOnePostsTest(String URL) {
        var response = given()
                .when().get(URL + "posts/" + 100)
                .then()
                    .assertThat()
                        .statusCode(200)//Validate status code
                        .body("userId", equalTo(10))// Validate userID value
                        .body("id", equalTo(100))// Validate id value
                        .body("title", equalTo("at nam consequatur ea labore ea harum"))//Validate title value
                        .body("body", equalTo("cupiditate quo est a modi nesciunt soluta\nipsa voluptas error itaque dicta in\nautem qui minus magnam et distinctio eum\naccusamus ratione error aut"));//Validate Body value
        response.log().body();//Print Response body in the log.
    }

    /**
     * TYPE OF TEST CASE = TEST TO PASS
     * EXPECT RESULT = VALIDATE SIZE OF COMMENTS FOR A POSTS
     */
    @Parameters({"URL"})
    @Test(priority = 1)//Assign priority to execution with TestNG
    public void getMethodPathParameterCommentsTest(String URL) {
        var response = given()
                .when().get(URL + "posts/" + 100 + "/comments")
                .then()
                .assertThat()
                .statusCode(200)
                .body("records.size()", equalTo(5));
        response.log().body();//Print Response body in the log.
    }

    /**
     * TYPE OF TEST CASE = TEST TO PASS
     * EXPECT RESULT = VALIDATE SIZE OF COMMENTS FOR A POSTS BUT USING QUERY PARAMETER
     */
    @Parameters({"URL"})
    @Test(priority = 1)//Assign priority to execution with TestNG
    public void getMethodQueryParameterCommentsTest(String URL) {
        var response = given()
                .when().get(URL + "comments?postId="+100)
                .then()
                .assertThat()
                    .statusCode(200)//Validate status code of the application
                    .body("records.size()", equalTo(5));// Validate the record size to expected
        response.log().body();//Print Response body in the log.
    }


    //+++++++++++++++++++++++++++++++++
    //SCENARIOS TEST TO FAIL
    //+++++++++++++++++++++++++++++++++

    /**
     * TYPE OF TEST CASE = TEST TO FAIL
     * EXPECT RESULT = VALIDATE COMMENTS NOT AVAILABLE FOR A postId INVALID
     */
    @Parameters({"URL"})
    @Test(priority = 3)//Assign priority to execution with TestNG
    public void getMethodCommentsWithPostIDNotExist(String URL) {
        var response = given()
                .when().get(URL + "comments?postId="+401)
                .then()
                    .assertThat()
                        .statusCode(200)//Validate status code of the application
                        .body("records.size()", equalTo(0));// Validate the record size to expected
        response.log().body();//Print Response body in the log.
    }

    /**
     * TYPE OF TEST CASE = TEST TO FAIL
     * EXPECT RESULT = VALIDATE ONE INVALID POSTS AND RETURNED STATUS CODE 404
     */
    @Parameters({"URL"})
    @Test(priority = 1)//Assign priority to execution with TestNG
    public void getMethodOnePostsInvalidTest(String URL) {
        var response = given()
                .when().get(URL + "posts/" + 101)
                .then()
                .assertThat()
                .statusCode(404);//Validate status code

        response.log().body();//Print Response body in the log.
    }

    /**
     * TYPE OF TEST CASE = TEST TO FAIL **BUG It doesn't handle exception***
     * EXPECT RESULT = VALIDATE LIST OF THE POST RETURNED WHEN PATH ARE INCORRECT
     */
    @Parameters({"URL"})
    @Test(priority = 1)//Assign priority to execution with TestNG
    public void getMethodAllPostsURLIncorrectTest(String URL) {
        var response = given()
                .when().get(URL + "post")
                .then()
                .assertThat()
                .statusCode(404);//Validate status code
        response.log().body();//Print Response body in the log.
    }

    /**
     * TYPE OF TEST CASE = TEST TO FAIL
     * EXPECT RESULT = VALIDATE QUERY PARAMETER EMPTY
     */
    @Parameters({"URL"})
    @Test(priority = 1)//Assign priority to execution with TestNG
    public void getMethodQueryParameterCommentsEMPTYTest(String URL) {
        var response = given()
                .when().get(URL + "comments?postId=")
                .then()
                .assertThat()
                .statusCode(200)//Validate status code of the application
                .body("records.size()", equalTo(0));// Validate the record size to expected
        response.log().body();//Print Response body in the log.
    }
}