package com.abnamro.utils;

import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Set;

import org.junit.Assert;

import io.restassured.*;

public class RestAPI {
    public Response response;
    private RequestSpecification request;
    private String _path;

    public RestAPI(String baseUrl, String path) {

        this._path = path;

        RestAssured.baseURI = baseUrl;

        System.out.println("Base URL:" + RestAssured.baseURI);

        request = RestAssured.given().log().all(true);
    }

    public void get() {
        get(null);
    }

    public void get(HashMap<String, String> queryParams) {
        try {
            if (queryParams == null || queryParams.size() == 0) {
                response = request.get(this._path);
            } else {

                if (this.request != null) {
                    Set<String> keys = ((FilterableRequestSpecification) this.request).getQueryParams().keySet();
                    if (keys.size() > 0) {
                        keys.forEach(key -> ((FilterableRequestSpecification) this.request).removeQueryParam(key));
                    }
                }
                response = request.when().queryParams(queryParams).get(this._path);
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            printResponseInfo();
        }
    }

    public void delete(String path) {
        try {
            response = request.when().delete(path);
        } finally {
            printResponseInfo();
        }
    }

    public void post(Object serializedJsonRequest) {
        sendNewRequest("", "post", serializedJsonRequest);
    }

    public void put(String path, Object serializedJsonRequest) {
        sendNewRequest(path, "put", serializedJsonRequest);
    }

    private void sendNewRequest(String path, String requestType, Object serializedRequest) {
        try {
            System.out.println("Request Method: " + requestType);
            System.out.println("Request Paylod: " + serializedRequest);

            request.accept("*/*");
            request.contentType("application/json");

            switch (requestType.toLowerCase()) {
                case "post":
                    response = request.with().body(serializedRequest).when().post(this._path);
                    break;
                case "put":
                    if(path != null && path.length() > 0)
                    {
                        response = request.with().body(serializedRequest).when().put(this._path + "/" + path);
                        break;
                    }
                    else
                    {
                        response = request.with().body(serializedRequest).when().put(this._path);
                        break;
                    }
            }
        } finally {
            printResponseInfo();
        }
    }

    private void printResponseInfo() {
        if (response != null) {
            System.out.println("Response status: " + response.statusCode());
            System.out.println("Response from server: " + response.asPrettyString());
        }
    }
}
