package com.epam.microservice.cucumberglue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class TrainingActionSteps {

    private Response response;

    public TrainingActionSteps() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Given("I have a training request with {string} action")
    public void i_have_a_training_request_with_action(String action) {
        String requestBody = createRequestBody(action, null);
        sendPostRequest(requestBody);
    }

    @Given("I have a training request without an action")
    public void i_have_a_training_request_without_an_action() {
        String requestBody = "{}";
        sendPostRequest(requestBody);
    }

    @Given("I have a training request with {string} action for a non-existent user")
    public void i_have_a_training_request_with_action_for_a_non_existent_user(String action) {
        String nonExistentUserSpecifier = ", \"userId\": \"nonExistentUserId\"";
        String requestBody = createRequestBody(action, nonExistentUserSpecifier);
        sendPostRequest(requestBody);
    }

    private String createRequestBody(String action, String additionalAttributes) {
        String baseJson = "{\"action\":\"" + action + "\"";
        if (additionalAttributes != null) {
            baseJson += additionalAttributes;
        }
        baseJson += "}";
        return baseJson;
    }

    private void sendPostRequest(String requestBody) {
        this.response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/Workloads");
    }

    @When("I send the training request to the actionTraining endpoint")
    public void i_send_the_training_request_to_the_action_training_endpoint() {
        String requestBody = "<your_previously_constructed_request_body>";
        this.response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/Workloads"); // Send the request here
    }

    @When("the system processes the action")
    public void the_system_processes_the_action() {
        System.out.println("Assuming immediate processing by the backend...");
    }

    // Example for a parameterized request
    @When("I send a {string} training request for user {string}")
    public void i_send_a_specific_training_request_for_user(String action, String userId) {
        // Constructing requestBody with parameters
        String requestBody = String.format("{\"action\":\"%s\", \"userId\":\"%s\"}", action, userId);
        this.response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/Workloads");
    }


    @Then("I should receive a {int} status code")
    public void i_should_receive_a_status_code(int expectedStatusCode) {
        Assert.assertEquals("The expected status code did not match the actual status code.",
                expectedStatusCode, response.getStatusCode());
    }
}
