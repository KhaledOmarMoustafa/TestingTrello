package org.example;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class GetLists {
    protected static ArrayList<String> listid;

    public void getlists(String id) {
        Response re = given().pathParams("id", id).queryParams("key", PreRequisites.apikey, "token", PreRequisites.token)
                .header("Accept", "application/json").contentType(ContentType.JSON).get("\n" +
                        "https://trello.com/1/boards/{id}/lists");

        re.prettyPrint();
        Assert.assertEquals(re.statusCode(), 200);
        listid = re.body().jsonPath().get("id");
        System.out.println("This is the list of ids " + listid.get(1));

    }
}
