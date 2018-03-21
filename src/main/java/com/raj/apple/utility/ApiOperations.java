package com.raj.apple.utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raj.apple.rest.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by kshitij on 3/20/18.
 */
public class ApiOperations {

    public HttpResponse executeGetCall(String url) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGetRequest = new HttpGet(url);
        HttpResponse httpResponse = httpClient.execute(httpGetRequest);

        return httpResponse;
    }

    public List<User> makeUserPojoFromRequest(HttpResponse httpResponse) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        ObjectMapper mapper = new ObjectMapper();

        List<User> userPojo = mapper.reader().
                forType(new TypeReference<List<User>>() {
                }).readValue(result.toString());

        return userPojo;
    }
}
