package org.example;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class MoveAList {

    public void moveAList(String listID, String id) {
        Response re = given().pathParams("id", listID).queryParams("value", id, "key", PreRequisites.apikey, "token", PreRequisites.token)
                .header("Accept", "application/json").contentType(ContentType.JSON).put(
                        "https://api.trello.com/1/lists/{id}/idBoard");

        re.prettyPrint();
        Assert.assertEquals(re.statusCode(), 200);


    }

}
