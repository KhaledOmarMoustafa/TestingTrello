package org.example;

import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class CreateABoard {
    protected static String id;
    protected static String id1;
    protected static String id2;


    public void createaBoard(String name,String body) {
        Response create = given().
                queryParams("name", name, "key", PreRequisites.apikey, "token", PreRequisites.token)
                .body(body)
                .post("https://api.trello.com/1/boards/");


        id = create.body().jsonPath().get("id");
        if (id1 == null) {
            id1 = id;
        } else {
            id2 = id;
        }
        create.prettyPrint();
        Assert.assertEquals(create.statusCode(), 200);
    }

}


