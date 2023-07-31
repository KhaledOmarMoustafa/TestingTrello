package org.example;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class UpdateBoard {
    public void updateBoard(String id, String newName) {
        Response re = given().pathParam("id", id)
                .queryParams("name", newName, "key", PreRequisites.apikey, "token", PreRequisites.token)
                .contentType(ContentType.JSON).put("https://api.trello.com/1/boards/{id}");

        Assert.assertEquals(re.statusCode(), 200);

    }
}
