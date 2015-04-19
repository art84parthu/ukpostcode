package com.wcc.interview.rest.test.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PostalCodeDistanceClient{
	 public static void main(String[] args) {
			try {
		 
				Client client = Client.create();
		 
				WebResource webResource = client
				   .resource("http://localhost:8080/WCCPostalCode/rest/PostalCodeDistance/YO51/O61");
		 
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