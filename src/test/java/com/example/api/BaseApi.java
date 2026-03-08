package com.example.api;

import io.restassured.RestAssured;

/**
 * Base API class for setting up common REST Assured configuration.
 * Initializes the base URI for all API requests to the DemoQA Book Store application.
 *
 * This class uses a static initializer block to configure REST Assured with the base URL,
 * ensuring all REST Assured calls will target the correct API endpoint.
 */
public class BaseApi {

    static {
        RestAssured.baseURI = "https://demoqa.com";
    }
}

