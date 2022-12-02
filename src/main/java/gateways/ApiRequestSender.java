package gateways;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Facade part for sending API request and getting response
 */
public class ApiRequestSender {
    private final String url;

    public ApiRequestSender(String url) {
        this.url = url;
    }

    /**
     * Calls API endpoint using url from instance variable
     * @return response from API call
     */
    public HttpResponse<String> send() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
