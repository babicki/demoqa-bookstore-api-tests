package com.example.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

/**
 * Utility class for building and sending HTTP requests.
 * Provides centralized request handling with consistent content type,
 * request body serialization, and optional Bearer token authentication.
 *
 * All requests sent through this class inherit the base URI configuration
 * from BaseApi and use JSON content type by default.
 */
public class CommonRequest extends BaseApi {

    /**
     * Sends a POST request to the specified endpoint with optional Bearer token authentication.
     *
     * @param endpoint the API endpoint path (e.g., "/Account/v1/Login")
     * @param body     the request body object (will be serialized to JSON)
     * @param token    the Bearer token for authorization, or null for public endpoints
     * @return the Response object containing status code, headers, and body
     *
     * @example
     * Response response = CommonRequest.send(
     *     "/BookStore/v1/Books",
     *     requestBody,
     *     "auth-token-here"
     * );
     */
    public static Response send(String endpoint, Object body, String token) {

        RequestSpecification request = given()
                .contentType(ContentType.JSON)
                .body(body);

        if (token != null) {
            request.header("Authorization", "Bearer " + token);
        }

        return request.post(endpoint);
    }
}

