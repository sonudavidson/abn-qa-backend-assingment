package com.abnamro.assignment;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.abnamro.utils.Constants;
import com.abnamro.utils.RestAPI;

public class GitIssuesAssignmentTest {
    
    RestAPI restAPI;
    
    /**
     * Verify only limited number of records are fetched instead of all the records
     */
    @Test
    void apiPaginationIssue() {
        restAPI = new RestAPI(Constants.APISERVER, "posts");
        restAPI.get();
        Assert.assertEquals(200, restAPI.response.getStatusCode());
        int currentRecordCount = restAPI.response.jsonPath().getInt("limit");
        int totalRecordCount = restAPI.response.jsonPath().getInt("total");

        Assert.assertTrue(currentRecordCount < totalRecordCount);

        restAPI = new RestAPI(Constants.APISERVER, "posts?limit=0");
        restAPI.get();
        Assert.assertEquals(200, restAPI.response.getStatusCode());
        currentRecordCount = restAPI.response.jsonPath().getInt("limit");
        totalRecordCount = restAPI.response.jsonPath().getInt("total");

        Assert.assertTrue(currentRecordCount == totalRecordCount);
    }


}
