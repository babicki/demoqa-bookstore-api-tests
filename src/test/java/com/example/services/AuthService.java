package com.example.services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * Service layer for authentication operations.
 * Manages authentication state by caching the authentication token and user ID
 * across multiple test steps to avoid redundant login calls.
 *
 * This class provides static methods for retrieving cached authentication data
 * with automatic login fallback if data is not yet available.
 *
 * Note: This class is stateful and maintains session data in static fields.
 * For test isolation, consider clearing static state between test scenarios if needed.
 */
public class AuthService {

    private static String token;
    private static String userId;

    /**
     * Authenticates a user and caches the authentication token and user ID.
     * Makes a direct REST API call to the login endpoint.
     *
     * @param username the user's username
     * @param password the user's password
     *
     * @example
     * AuthService.login("walton.goggins", "A9b!X@r2");
     * String token = AuthService.getToken();
     */
    public static void login(String username, String password) {
        String requestBody = """
            {
              "userName": "%s",
              "password": "%s"
            }
        """.formatted(username, password);

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("https://demoqa.com/Account/v1/Login");

        token = response.jsonPath().getString("token");
        userId = response.jsonPath().getString("userId");
    }

    /**
     * Retrieves the cached authentication token.
     * If the token is not yet cached, performs an automatic login with default credentials.
     *
     * @return the authentication Bearer token
     */
    public static String getToken() {
        if (token == null) login("walton.goggins", "A9b!X@r2");
        return token;
    }

    /**
     * Retrieves the cached user ID.
     * If the user ID is not yet cached, performs an automatic login with default credentials.
     *
     * @return the authenticated user's ID
     */
    public static String getUserId() {
        if (userId == null) login("walton.goggins", "A9b!X@r2");
        return userId;
    }
}

