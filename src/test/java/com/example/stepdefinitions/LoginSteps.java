package com.example.stepdefinitions;

import com.example.api.AuthService;
import com.example.data.UserCredentials;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static org.junit.Assert.*;

/**
 * Step definitions for user login and authentication scenarios.
 * Implements Gherkin steps defined in login.feature file and provides
 * test logic for validating successful login operations and token retrieval.
 */
public class LoginSteps {

    private Response response;
    private String token;

    /**
     * Given step: Sends a valid login request using predefined test credentials.
     * Calls the AuthService.login() method and extracts the authentication token.
     */
    @Given("the user sends a valid login request")
    public void the_user_sends_a_valid_login_request() {

        response = AuthService.login(
                UserCredentials.VALID.username(),
                UserCredentials.VALID.password()
        );

        token = response.jsonPath().getString("token");
    }

    /**
     * Then step: Asserts that the login response has HTTP status code 200 (OK).
     * Indicates successful authentication.
     */
    @Then("the response status code should be 200")
    public void the_response_status_code_should_be_200() {
        assertEquals(200, response.getStatusCode());
    }

    /**
     * Then step: Validates that the response contains a non-null and non-empty authentication token.
     * Token is required for subsequent authenticated API requests.
     */
    @Then("the response should contain an authentication token")
    public void the_response_should_contain_an_authentication_token() {
        assertNotNull(token);
        assertFalse(token.isEmpty());
    }
}

