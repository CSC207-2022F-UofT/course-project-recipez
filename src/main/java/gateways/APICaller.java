package gateways;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Gateway to request data from an API using user-inputted ingredients
 */
public class APICaller {
    /**
     *
     * @param url URL for the API endpoint
     * @return The API response for the recipes as a JSON-formatted string
     * @throws IOException when URL is invalid
     * @throws InterruptedException when API call fails
     */
    public static String send(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
