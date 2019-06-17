package com.ikno.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

/**
 * Java Doc to build
 */
public class App {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        HttpAuthenticationFeature authenticator = HttpAuthenticationFeature.basic("mtiqasyner", "789xy321");
        client.register(authenticator);

        WebTarget wt = client.target("http://10.8.0.1:8080/mti-iknoplus/rest").path("ldgelsa/images");

        Builder ib = wt.request(MediaType.APPLICATION_JSON);

        ib.header("one", "header");

        Response response = ib.post(Entity.entity("{json:44}", MediaType.APPLICATION_JSON));

        System.out.println("Response " + response.readEntity(String.class));

        System.out.println(response.getStatus());
    }
}

// MAVEN DEPENDENCIES

// <dependency>
// <groupId>org.glassfish.jersey.core</groupId>
// <artifactId>jersey-client</artifactId>
// <version>2.27</version>
// </dependency>
// <dependency>
// <groupId>org.glassfish.jersey.containers</groupId>
// <!-- if your container implements Servlet API older than 3.0, use
// 'jersey-container-servlet-core' -->
// <artifactId>jersey-container-servlet</artifactId>
// <version>2.27</version>
// </dependency>
// <dependency>
// <groupId>org.glassfish.jersey.inject</groupId>
// <artifactId>jersey-hk2</artifactId>
// <version>2.27</version>
// </dependency>
