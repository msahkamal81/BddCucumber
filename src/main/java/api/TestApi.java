package api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import javax.swing.*;

import java.sql.SQLOutput;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class TestApi {


    /*
    There are following public apis
#	Route	        Method  Type	                    Full route	                                Description	Details
1	/employee	    GET	    JSON	http://dummy.restapiexample.com/api/v1/employees	    Get all employee data Details
2	/employee/{id}	GET	    JSON	http://dummy.restapiexample.com/api/v1/employee/{id}	Get a single employee data Details
3	/create	        POST	JSON	http://dummy.restapiexample.com/api/v1/create	        Create new record in database Details
4	/update/{id}	PUT	    JSON	http://dummy.restapiexample.com/api/v1/update/{id}	    Update an employee record Details
5	/delete/{id}	DELETE	JSON	http://dummy.restapiexample.com/api/v1/update/{id}	    Delete an employee record Details
*/


    private String BaseURI = RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
    private String employees = "employees";
    private String employeeWithID = "employee/";
    private String create = "create/";
    private String update = "update/";


    @Test
    public void testGetAllEmployee(){
        Response response = given().when().get(employees).then().extract().response();
        JsonPath x = new JsonPath(response.asString());
        System.out.println("employee_name is : " + x.get("employee_name").toString());
        System.out.println("Response : " + response.asString());
        System.out.println("Status Code : " + response.getStatusCode());
    }

    @Test
    public void testGetSpecificEmployee(){
        Response response = given().when().get(employeeWithID + 71406).then().extract().response();
        JsonPath x = new JsonPath(response.asString());
        System.out.println("Response is : " + response.asString());
        System.out.println("Response : " + response.asString());
        System.out.println("Status Code : " + response.getStatusCode());
    }






}
