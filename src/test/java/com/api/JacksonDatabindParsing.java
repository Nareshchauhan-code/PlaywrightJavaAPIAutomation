package com.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class JacksonDatabindParsing {

    @Test
    void getAPICall() throws IOException {

        Playwright playwright = Playwright.create();
        APIRequest apiRequest = playwright.request();
        APIRequestContext apiRequestContext = apiRequest.newContext();
        APIResponse apiResponse = apiRequestContext.get("https://gorest.co.in/public/v2/users");

        // Verify the status code and assert with Testng
        int statusCode = apiResponse.status();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);
        System.out.println(apiResponse.statusText());

        // Parsing Json Body

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(apiResponse.body());

        System.out.println(jsonNode.toPrettyString());


    }
}
