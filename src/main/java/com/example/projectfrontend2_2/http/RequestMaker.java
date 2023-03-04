package com.example.projectfrontend2_2.http;

import com.example.projectfrontend2_2.Login.LoginDTO;
import com.example.projectfrontend2_2.Student.StudentDTO;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.net.*;
import java.util.ArrayList;

public class RequestMaker {

    private String url = "http://localhost:8080";
    private Gson gson;

    public RequestMaker() {
        gson = new Gson();
        url = "http://localhost:8080";
    }

    public StudentDTO login_attempt(LoginDTO ldto , String path) throws IOException, InterruptedException {

        gson = new Gson();

        System.out.println(gson.toJson(ldto));
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(url + path)).
                POST(HttpRequest.BodyPublishers.ofString(gson.toJson(ldto))).
                header("Content-Type" , "application/json").
                build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body().toString());
            StudentDTO sdto = gson.fromJson(response.body().toString() , StudentDTO.class);



        return sdto;
    }

}
