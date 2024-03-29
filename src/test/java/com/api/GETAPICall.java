package com.api;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GETAPICall {

    @Test
    void getAPICall() {

        Playwright playwright = Playwright.create();
        APIRequest apiRequest = playwright.request();
        APIRequestContext apiRequestContext = apiRequest.newContext();
        APIResponse apiResponse = apiRequestContext.get("https://gorest.co.in/public/v2/users");
        // Assertion
        int statusCode = apiResponse.status();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode,200);
        System.out.println(apiResponse.toString());
        System.out.println(apiResponse.text());

    }
}
