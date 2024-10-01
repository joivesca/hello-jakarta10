package com.onndoo.ws.client;

import java.util.List;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class CosumeFake {
	public static void main(String[] args) {
				
		Client client  = ClientBuilder.newClient().register(FakeReader.class);
		
		//First form
		String name = client.target("https://fakestoreapi.com/products").request(MediaType.APPLICATION_JSON).get(String.class);
		
		//Second form
		//WebTarget base = client.target("https://fakestoreapi.com/products");
		// WebTarget at http://example.com/webapi/read
		//WebTarget read = base.path("read");
		// WebTarget at http://example.com/webapi/write
		//WebTarget write = base.path("write");
		
		/*WebTarget myResource = client.target("http://example.com/webapi/read")
		        .path("{userName}")
		        .resolveTemplate("userName", "janedoe")
		        .queryParam("chapter", "1");*/
		// http://example.com/webapi/read/janedoe?chapter=1
		//Response response = myResource.request(...).get();
		
		/*
		WebTarget myResource1 = client.target("https://fakestoreapi.com/products");
		String response = myResource1.request(MediaType.TEXT_PLAIN)
		        .get(String.class);
		        
		        System.out.println(response);
		*/
		
		
		//Fake fake = new Fake();
		/*WebTarget myResource = client.target("https://fakestoreapi.com/products");
		List<Fake> trackingNumber = myResource.request(MediaType.APPLICATION_JSON)
		                                   .get(new GenericType<List<Fake>>() {});
		
		System.out.println(trackingNumber);
		*/
		
		Fake fake =
	            client.target("https://fakestoreapi.com/products")
	            .path("1")
	            .request(MediaType.APPLICATION_XML)
	            .get(Fake.class);
		
		System.out.println(fake);
		
		
		List<Fake> returnedEvents = client.target("https://fakestoreapi.com/products")
	                //.path("all")
	                .request(MediaType.APPLICATION_XML)
	                .get(new GenericType<List<Fake>>() {
	        });
		
		for(Fake item :returnedEvents){
			System.out.println(item.getTitle());
		}
			
		client.close();
		
		//System.out.println(name);
	}
	
		
}
