package com.example.data;

/**
 * Enum containing predefined user credentials for testing.
 * Provides type-safe access to various credential scenarios including valid,
 * invalid, and edge-case credentials used throughout the test suite.
 *
 * Each enum constant represents a different test scenario:
 * - VALID: Legitimate credentials for successful authentication
 * - INVALID_PASSWORD: Valid username with wrong password
 * - INVALID_USER: Non-existent username with correct password format
 * - EMPTY: Empty string credentials for null/empty validation
 */
public enum UserCredentials {

    // Demo credentials for testing various scenarios
    VALID("walton.goggins", "A9b!X@r2"),
    INVALID_PASSWORD("walton.goggins", "wrongPass"),
    INVALID_USER("wrong.user", "A9b!X@r2"),
    EMPTY("", "");

    private final String username;
    private final String password;

    /**
     * Constructs a UserCredentials enum constant.
     *
     * @param username the username for login
     * @param password the password for login
     */
    UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Retrieves the username for this credential set.
     *
     * @return the username string
     */
    public String username() {
        return username;
    }

    /**
     * Retrieves the password for this credential set.
     *
     * @return the password string
     */
    public String password() {
        return password;
    }
}

