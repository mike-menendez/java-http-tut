package com.company;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class Client {
    final static private int PORT; // TODO: Declare the port number we will be connecting to.
    final static private String BASE_URL; // TODO: Declare the base url that resolves to our server.
    final static private int TIMEOUT; // TODO: Declare our client's timeout.
    static private int pendingVersion; // TODO: Implement caching of the latest file version on last server check.
    static private int localVersion; // TODO: Track what version we are using locally

    private static HttpClient getClient(){
        // TODO: Method is for generating a http client as all configuration is the same, we only need one client, with a singular configuration.
    }

    public static void basicGetRequest(String urlParameter){
        // TODO: Performs a GET request to the server, will use url parameters
        // Notes: Probably start with this one as they build off this
    }

    public static boolean checkForUpdate(){
        // TODO: Method is for checking if there is an update on the server.
        // Notes: Caching comes in play here, probably do this second.
    }

    public static void fetchUpdate(){
        // TODO: Method is for downloading the updated file from the server
        // Notes: Do this after checkForUpdate, caching comes into play again. May want to validate there is an update before attempting to update to minimize transfers.
    }
}
