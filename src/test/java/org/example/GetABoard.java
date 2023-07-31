package org.example;

import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class GetABoard {


    public void getaboard(String id) {
        Response re = given().pathParam("id", id).queryParams("key", PreRequisites.apikey, "token", PreRequisites.token)
                .header("Accept", "application/json")
                .get("https://api.trello.com/1/boards/{id}");

        Assert.assertEquals(re.statusCode(), 200);
        re.prettyPrint();


    }
}
