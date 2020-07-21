package com.httpclient.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * In this tutorial, we show you how to create a RESTful Java client with Java
 * build-in HTTP client library. It’s simple to use and good enough to perform
 * basic operations for REST service.
 * 
 * The RESTful services from last “Jackson + JAX-RS” RESTEasyWithJSON project
 * will be reused, and we will use “java.net.URL” and
 * “java.net.HttpURLConnection” to create a simple Java client to send “GET” and
 * “POST” request.
 * 
 * @author Administrator
 *
 */
public class NetClientGet {

	// http://localhost:8080/RESTfulExample/json/product/get
	public static void main(String[] args) {

		try {

			URL url = new URL(
					"http://localhost:8080/RESTEasyWithJSON/rest/json/product/get");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}