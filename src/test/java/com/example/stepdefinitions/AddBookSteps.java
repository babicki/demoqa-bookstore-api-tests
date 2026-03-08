package com.example.stepdefinitions;

import com.example.api.AuthService;
import com.example.api.CommonRequest;
import com.example.data.UserCredentials;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.Assert.*;

/**
 * Step definitions for book addition scenarios.
 * Implements Gherkin steps defined in add_book.feature file and provides
 * test logic for user authentication and adding books to personal collection.
 */
public class AddBookSteps {

    private Response response;
    private String token;
    private String userId;
    private String isbn;

    /**
     * Given step: Authenticates a user for book addition operations.
     * Performs login using valid credentials and validates successful authentication
     * by checking response status code and extracting token and userId.
     */
    @Given("the user is logged in for adding a book")
    public void the_user_is_logged_in_for_adding_a_book() {

        Response loginResponse = AuthService.login(
                UserCredentials.VALID.username(),
                UserCredentials.VALID.password()
        );

        assertEquals(200, loginResponse.getStatusCode());

        token = loginResponse.jsonPath().getString("token");
        userId = loginResponse.jsonPath().getString("userId");

        assertNotNull(token);
        assertNotNull(userId);
    }

    /**
     * When step: Adds a book from the global catalog to the user's personal collection.
     * Retrieves the first available book from the catalog and sends an authenticated
     * POST request to add it to the user's collection.
     */
    @When("the user adds a book from the catalog to their collection")
    public void the_user_adds_a_book_from_the_catalog_to_their_collection() {

        Response booksResponse = RestAssured.get("/BookStore/v1/Books");
        isbn = booksResponse.jsonPath().getString("books[0].isbn");

        String addBody = """
            {
              "userId": "%s",
              "collectionOfIsbns": [
                { "isbn": "%s" }
              ]
            }
            """.formatted(userId, isbn);

        response = CommonRequest.send(
                "/BookStore/v1/Books",
                addBody,
                token
        );
    }

    /**
     * Then step: Verifies that the book was successfully added to the user's collection.
     * Asserts HTTP 201 (Created) status code which indicates successful resource creation.
     */
    @Then("the book should be added successfully")
    public void the_book_should_be_added_successfully() {
        assertEquals(201, response.getStatusCode());
    }
}

