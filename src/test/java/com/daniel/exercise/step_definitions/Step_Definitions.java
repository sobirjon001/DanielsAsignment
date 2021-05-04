package com.daniel.exercise.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.messages.internal.com.google.common.base.Verify;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

import io.restassured.http.ContentType;
import org.junit.Assert;
import com.daniel.exercise.pojo.Exercise;

public class Step_Definitions {

  @Given("Student input numerical value {string}")
  public void student_input_numerical_value(String inputNum) {
    Exercise.exercise = new Exercise();
    Exercise.exercise.setInput(inputNum);
  }

  @Given("Student input unit of measure as {string}")
  public void student_input_unit_of_measure_as(String inputUnit) {
    Exercise.exercise.setInputUnit(inputUnit);
  }

  @Given("Student input target unit of measure as {string}")
  public void student_input_target_unit_of_measure_as(String targetUnit) {
    Exercise.exercise.setTargetUnit(targetUnit);
  }

  @Given("Student input his response as {string}")
  public void student_input_his_response_as(String response) {
    Exercise.exercise.setResponse(response);
  }

  @Then("Application output should be {string}")
  public void application_output_should_be(String expectedResult) {
    String actualResult = com.daniel.app.App.assignment(
            Exercise.exercise.getInput(),
            Exercise.exercise.getInputUnit(),
            Exercise.exercise.getTargetUnit(),
            Exercise.exercise.getResponse()
    );

//    Assert.assertEquals(expectedResult, actualResult);
    Verify.verify(expectedResult.equals(actualResult));
  }

  @Then("Application output should be {string} from Mock API for {int} test")
  public void application_output_should_be_from_mock_api(String expectedResult, int exercise ) {
    baseURI = "https://c18fa1a1-0807-4bbe-bc00-d779cfafc7d7.mock.pstmn.io";

    given()
            .accept(ContentType.JSON)
            .pathParam("num", exercise)
            .contentType(ContentType.JSON)
            .body(Exercise.exercise).
    when()
            .get("/exercise/{num}").
    then()
            .log().all()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("output", is(expectedResult))
    ;

  }
}
