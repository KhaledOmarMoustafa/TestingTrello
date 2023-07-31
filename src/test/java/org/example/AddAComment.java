package org.example;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class AddAComment {


    public void addacomment(String id, String txt) {
        if (CreateACard.idcard == null || CreateACard.idcard.isEmpty()) {
            throw new IllegalStateException("'createACard()' should be executed first to get a valid iDCard.");
        }
        Response re = given().pathParam("id", id)
                .queryParams("text", txt, "key", PreRequisites.apikey, "token", PreRequisites.token)
                .header("Accept", "application/json").contentType(ContentType.JSON)
                .post("https://api.trello.com/1/cards/{id}/actions/comments");

        Assert.assertEquals(re.statusCode(), 200);
        re.prettyPrint();

    }
}
