package com.daniel.restAssuret;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.contains;

public class SwaggerPets {

  public static void main(String[] args) {
    String id = 19939 + "";
    List<String> ids =
    given().accept(ContentType.JSON).queryParam("status", "available").when().
    get("https://petstore.swagger.io/v2/pet/findByStatus").jsonPath().getList("id", String.class);
//    System.out.println("ids = " + ids);
    System.out.println("ids.contains(id) = " + ids.contains(id));
    Assert.assertTrue(ids.contains(id));
  }
}
