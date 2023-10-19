package com.abnamro.assignment;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.abnamro.stubs.Isbn;
import com.abnamro.stubs.User;
import com.abnamro.stubs.Userbooks;
import com.abnamro.utils.Constants;
import com.abnamro.utils.GenericFunctions;
import com.abnamro.utils.RestAPI;
import com.google.gson.Gson;

import io.restassured.path.json.JsonPath;

public class AssignmentTest {

    public RestAPI objRestRequests;

    // @Test
    // @DisplayName("TC1: Create new user")
    void createNewUser() {
        String userName = GenericFunctions.getUniqueName("");
        Constants.LOGINUSERNAME = userName;

        objRestRequests = new RestAPI(Constants.URL, Constants.USERACCOUNT);
        Gson gson = new Gson();
        String jsonString = gson.toJson(new User(userName, Constants.LOGINPASSWORD));
        
        objRestRequests.post(jsonString);
        assertTrue((objRestRequests.response.statusCode() == 201));

        JsonPath responseJson = new JsonPath(objRestRequests.response.toString());
        Constants.USERID = UUID.fromString(responseJson.get("useID").toString()); 
    }

    @Test
    @DisplayName("TC2: Update users books")
    void updateUsersBooksList() {
        objRestRequests = new RestAPI(Constants.URL, Constants.BOOKSTORE);
        Gson gson = new Gson();
        
        Isbn[] books = new Isbn[];

        String jsonString = gson.toJson(new Userbooks(Constants.USERID, books)));
    }
}
