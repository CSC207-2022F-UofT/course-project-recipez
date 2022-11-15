package gateways;
import entities.ApiAccountError;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Implements IApiGateway using the JavaHttp library
 */
public class JavaHttpGateway implements IApiGateway{
    /**
     * Calls API endpoint and gets response
     * @param url URL for the API endpoint
     * @return The API response for the recipes as a JSON-formatted string
     * @throws IOException if an I/O error occurs when sending or receiving
     * @throws InterruptedException if the operation is interrupted
     */
    public String send(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new ApiAccountError("API call unsuccessful. Account may have incorrect credentials or reached quota.");
        }
        return response.body();
    }
}
