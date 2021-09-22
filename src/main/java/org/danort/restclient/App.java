package org.danort.restclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Java Doc to build
 */
public class App {

	public static void main(String[] args) throws Exception {

		Client client = ClientBuilder.newClient();

		// use this instead if ssl needs to be ignored
		// Client client = ignoreSSLClient();

		// optional
		// HttpAuthenticationFeature authenticator =
		// HttpAuthenticationFeature.basic("user", "password");
		// client.register(authenticator);

		WebTarget wt = client.target("http://10.8.0.1:8080/mti-iknoplus/rest").path("ldgelsa/images");

		Builder ib = wt.request(MediaType.APPLICATION_JSON);

		ib.header("one", "header");

		Response response = ib.post(Entity.entity("{json:44}", MediaType.APPLICATION_JSON));

		System.out.println("Response " + response.readEntity(String.class));

		System.out.println(response.getStatus());
	}

	public static Client ignoreSSLClient() throws Exception {

		SSLContext sslcontext = SSLContext.getInstance("TLS");

		sslcontext.init(null, new TrustManager[] { new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			}

			public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}
		} }, new java.security.SecureRandom());

		return ClientBuilder.newBuilder().sslContext(sslcontext).hostnameVerifier((s1, s2) -> true).build();
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
