package com.rmgYantraTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import sdet27.GenericUtility.BaseAPIClass;
import sdet27.GenericUtility.EndPoints;

import static io.restassured.RestAssured.*;

public class UpdateResourceAndVerifyInDtabase extends BaseAPIClass {

	@Test
	public void updateResourceAndVerifyInDb() throws Throwable {
		
		
		//String proId = "TY_PROJ_008";
		PojoClass pojo = new PojoClass("Usha123", "Acc12", "Completed", 100);
		Response resp = given()
				.body(pojo)
				.contentType(ContentType.JSON)
				
			.when()
				.put(EndPoints.updateProjects+"/TY_PROJ_008");
		
		
		String expData = rLib.getJSONData(resp, "createdBy");
		System.out.println(expData);
	
		String query = "select * from project;";
		String actData = dLib.executeQueryAndGetData(query, 2, expData);
		Reporter.log(actData,true);
		
		Assert.assertEquals(expData, actData);
		Reporter.log("data verification succesfull", true);
		
	}
}
