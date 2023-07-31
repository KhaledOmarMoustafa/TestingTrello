package org.example;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class CreateACard {
    protected static String idcard;
    protected static String id1;
    protected static String id2;


    public void createacard(String id) {
        if (CreateAList.idlist == null || CreateAList.idlist.isEmpty()) {
            throw new IllegalStateException("'createAList()' should be executed first to get a valid IDList.");
        }
        Response re = given().queryParams("idList", id, "key", PreRequisites.apikey, "token", PreRequisites.token)
                .header("Accept", "application/json").contentType(ContentType.JSON)
                .post("https://api.trello.com/1/cards");
        idcard = re.body().jsonPath().get("id");

        if (id1 == null) {
            id1 = idcard;
        } else {
            id2 = idcard;
        }
        Assert.assertEquals(re.statusCode(), 200);
        re.prettyPrint();
    }
}
