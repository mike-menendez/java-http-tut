package com.company;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class Client {
    final static private int PORT = 5000;
    final static private String BASE_URL = "http://localhost";
    final static private int TIMEOUT = 30;
    static private int pendingVersion = 0;
    static private int localVersion = 0;

    private static HttpClient getClient(){
        return HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NEVER)
                .connectTimeout(Duration.ofSeconds(TIMEOUT))
                .build();
    }

    public static boolean checkForUpdate(){
        HttpRequest request = HttpRequest.newBuilder()
                .GET().uri(URI.create(BASE_URL + ":" + PORT + "/version"))
                .setHeader("Header-Key", "Header-Value").build();
        try{
            HttpResponse response = getClient().send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200){
                throw new IOException("Unexpected Response Code received. Expected 200, received: " + response.statusCode());
            }

            int remoteVersion = Integer.parseInt(response.body().toString().strip());

            System.out.println("The response code was: " + response.statusCode());
            System.out.println("The remote version of the file is: " + remoteVersion);
            System.out.println("Our local version is: " + localVersion);

            if (remoteVersion > localVersion){
                pendingVersion = remoteVersion;
                System.out.println("Updating our local record of the remote version, a new version is available.");
                return true;
            }
        }
        catch (IOException ioException){
            System.err.println("An IO exception occurred when doing our basic GET request.");
            System.err.println(ioException);
        }
        catch (InterruptedException interruptedException){
            System.err.println("An Interruption occurred when doing our basic GET request");
            System.err.println(interruptedException);
        }
        return false;
    }

    public static void basicGetRequest(String urlParameter){
        HttpRequest request = HttpRequest.newBuilder()
                .GET().uri(URI.create(BASE_URL + ":" + PORT + "/" + urlParameter))
                .setHeader("Header-Key", "Header-Value").build();
        try {
            HttpResponse response = getClient().send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("We received a response code on our GET request of: " + response.statusCode());
            System.out.println("The body from our GET request was: '" + response.body() + "'");
        }
        catch (IOException ioException) {
            System.err.println("An IO exception occurred when doing our basic GET request.");
            System.err.println(ioException);
        }
        catch (InterruptedException interruptedException){
            System.err.println("An Interruption occurred when doing our basic GET request");
            System.err.println(interruptedException);
        }
    }

    public static void fetchUpdate(){
        if(pendingVersion <= localVersion && !checkForUpdate()){
            System.out.println("No update available");
            return;
        }

        int tempVersion = 0;
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(BASE_URL + ":" + PORT + "/version")).build();

        try {
            tempVersion = Integer.parseInt(getClient().send(request, HttpResponse.BodyHandlers.ofString()).body().strip());
            System.out.println("Beginning update to version: " + tempVersion);
        }
        catch (IOException ioException){
            System.err.println("An IO exception occurred when updating our local version");
            System.err.println(ioException);
        }
        catch (InterruptedException interruptedException){
            System.err.println("An Interruption occurred when updating our local version");
            System.err.println(interruptedException);
        }

        request = HttpRequest.newBuilder().GET().uri(URI.create(BASE_URL + ":" + PORT + "/download")).build();

        try {
            getClient().send(request, HttpResponse.BodyHandlers.ofFile(Path.of("./" + pendingVersion + ".txt")));
            System.out.println("Finished downloading file version: " + pendingVersion);
        }
        catch (IOException ioException){
            System.err.println("An IO exception occurred when downloading the file from the server");
            System.err.println(ioException);
        }
        catch (InterruptedException interruptedException){
            System.err.println("An Interruption Exception occurred when downloading the file from the server");
            System.err.println(interruptedException);
        }
        localVersion = tempVersion > localVersion ? tempVersion : localVersion;
        System.out.println("Our local version is now: " + localVersion);
    }
}
