package com.wcc.interview.rest.test.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Client class to test the REST service. 
 * This Jersey client was created just to test the DB connection, HTTP authentication and 
 * other features of the REST service. 
 */
public class PostalCodeDistanceClient{
	 /**
	  * Method main.
	  * @param args String[]
	  */
	 public static void main(String[] args) {
			try {
		 
				Client client = Client.create();
		 
				WebResource webResource = client
				   .resource("http://localhost:8080/WCCPostalCode/rest/PostalCodeDistance/YO51/YO61");
		 
				String authHeader = "Basic YWRtaW46YWRtaW4xMjM=";
				ClientResponse response = webResource.accept("application/json")
							.header("Authorization", authHeader)
		                   .get(ClientResponse.class);
		 
				if (response.getStatus() != 200) {
				   throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus() + "\n" + response.getEntity(String.class));
				}
		 
				String output = response.getEntity(String.class);
		 
				System.out.println("Output from Server .... \n");
				System.out.println(output);
		 
			  } catch (Exception e) {
		 
				e.printStackTrace();
		 
			  }
		 
			}
}