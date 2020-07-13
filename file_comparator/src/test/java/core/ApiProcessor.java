package core;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.net.ConnectException;

public class ApiProcessor {

    public JsonPath getApiProcessor(String url) throws ConnectException{
        RequestSpecification apiHeader = RestAssured.given().accept("application/json");
        JsonPath response = null;
        return apiHeader.when().get(url).then().extract().jsonPath();
    }
}
