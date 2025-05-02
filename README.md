# RestAssuredExamples

#Execution Code

1.- Build the project before execute it.

2.- To execute in parallel ejecute the file testng_parallel.xml.

3.- To execute one by one ejecute the file testng_onebyone.xml.



#Architecture of Code

1.- Package Modals:

    A.- Comments.java: Object to contain data of comments.
    
    B.- Posts.java: Object to contain data of posts.
    
2.- Package RestAssuredPractices:

    A.- DeleteMethod: Contains test script of delete method.
    
    B.- GetMethod: Contains test script of get method.
    
    C.- PatchMethod: Contains test script of patch method.
    
    D.- PostMethod: Contains test script of post method.
    
    E.- PutMethod: Contains test script of put method.
    
3.- POM.xml File: File of admin libreries.

4.- testng_parallel.xml: File to execute test cases in parallel.

5.- testng_onebyone.xml: File to execute test cases one by one.
