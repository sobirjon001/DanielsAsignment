package com.daniel.exercise.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

    Assert.assertEquals(expectedResult, actualResult);
  }
}
