package org.example;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class ArchiveAList {
    public void archiveAList(String listID) {
        Response re = given().pathParams("id",listID).queryParams( "value",true,"key", PreRequisites.apikey, "token", PreRequisites.token)
                .header("Accept", "application/json").contentType(ContentType.JSON).put(
                        "https://api.trello.com/1/lists/{id}/closed");

        re.prettyPrint();
        Assert.assertEquals(re.statusCode(), 200);


    }
}
