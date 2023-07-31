package org.example;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class CreateAList {
    protected static String idlist;
    protected static String id1;
    protected static String id2;

    public void createalist(String id, String listName) {

        if (CreateABoard.id == null || CreateABoard.id.isEmpty()) {
            throw new IllegalStateException("'createBoard()' should be executed first to get a valid ID.");
        }

        Response re = given().pathParam("id", id).
                queryParams("name", listName, "key", PreRequisites.apikey, "token", PreRequisites.token)
                .header("Accept", "application/json").contentType(ContentType.JSON)
                .post("https://api.trello.com/1/boards/{id}/lists");

        idlist = re.body().jsonPath().get("id");


        if (id1 == null) {
            id1 = idlist;
        } else {
            id2 = idlist;
        }
        re.prettyPrint();

        Assert.assertEquals(re.statusCode(), 200);
    }

}
