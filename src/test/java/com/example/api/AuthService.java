package com.example.api;

import io.restassured.response.Response;

/**
 * Authentication service wrapper for login operations.
 * Abstracts the login endpoint and provides a simple interface for obtaining
 * authentication tokens and user identification.
 *
 * This class is part of the API layer and delegates actual HTTP communication
 * to CommonRequest class.
 */
public class AuthService {

    /**
     * Sends a login request with the provided credentials to the authentication endpoint.
     *
     * @param username the user's username
     * @param password the user's password
     * @return the Response object containing the authentication token and userId
     *
     * @example
     * Response response = AuthService.login("walton.goggins", "A9b!X@r2");
     * String token = response.jsonPath().getString("token");
     */
    public static Response login(String username, String password) {

        String body = """
            {
              "userName": "%s",
              "password": "%s"
            }
            """.formatted(username, password);

        return CommonRequest.send(
                "/Account/v1/Login",
                body,
                null
        );
    }
}

