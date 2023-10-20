package com.abnamro.assignment;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.junit.jupiter.api.DisplayName;

import com.abnamro.models.Product;
import com.abnamro.utils.Constants;
import com.abnamro.utils.RestAPI;
import com.google.gson.Gson;

import io.restassured.path.json.JsonPath;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssignmentTest {

    RestAPI restAPI;

    /**
     * 
     */
    @Test
    @DisplayName("TC1: Get Products")
    void tc1_GetProductsFromServer() {
        restAPI = new RestAPI(Constants.APISERVER, "products");
        restAPI.get();
        Assert.assertEquals(200, restAPI.response.getStatusCode());
    }

    @Test
    void tc2_AddNewProduct() {
        restAPI = new RestAPI(Constants.APISERVER, "products/add");
        Gson gson = new Gson();
        String newPrdJsonContent = gson.toJson(new Product("Identifier200", "ABN AMRO E-Identifier",
         5.50, 0, 5, 90, "ABN AMRO", "Banking", 
         null, null));

         restAPI.post(newPrdJsonContent);
         Assert.assertEquals(200, restAPI.response.getStatusCode());

         String jsonString = restAPI.response.asString();
         JsonPath jsonResponse = new JsonPath(jsonString);

         Assert.assertTrue(jsonResponse.get("id").toString().length() > 0);

         Constants.NEWPRDID = jsonResponse.get("id").toString();

         System.out.println("NewPRDID:" + Constants.NEWPRDID);
    }

    @Test
    void tc3_UpdateProductInfo() {
        restAPI = new RestAPI(Constants.APISERVER, "products");
        Gson gson = new Gson();
        Product prd = new Product("Identifier201", "ABN AMRO E-Identifier",
        7.50, 0, 5, 90, "ABN AMRO", "Banking", 
        null, null);
        String updatedPrdJsonContent = gson.toJson(prd);

         restAPI.put("1", updatedPrdJsonContent);
         Assert.assertEquals(200, restAPI.response.getStatusCode());
    }

    @Test
    void tc4_DeleteProduct() {
        restAPI = new RestAPI(Constants.APISERVER, "products");
        restAPI.delete("products/1");
        Assert.assertEquals(200, restAPI.response.getStatusCode());
    }
}
