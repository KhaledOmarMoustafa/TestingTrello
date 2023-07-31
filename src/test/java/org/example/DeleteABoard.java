package org.example;

import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class DeleteABoard {
    public void deleteABoard(String id){
        Response re = given().pathParams("id",id).queryParams("key", PreRequisites.apikey, "token", PreRequisites.token).
                delete("https://api.trello.com/1/boards/{id}");
        Assert.assertEquals(re.statusCode(),200);


    }
}
