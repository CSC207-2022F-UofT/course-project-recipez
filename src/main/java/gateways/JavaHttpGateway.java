package gateways;
import entities.ApiAccountError;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Implements IApiGateway using the JavaHttp library
 */
public class JavaHttpGateway implements IApiGateway{
    private final static String appId = "c863d4be";
    private final static String appKey = "9c705fc2c472f935f32ea2e2c1494311";
    private final static String[] includedFields = {"label", "url", "yield", "ingredientLines", "calories", "totalWeight", "totalTime"};
    /**
     * Calls API endpoint and gets response
     * @param ingredientsList Comma-separated ingredients to search with
     * @return The API response for the recipes as a JSON-formatted string
     */
    public String send(String ingredientsList) {
        String url = createRequestURL(ingredientsList);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (response.statusCode() != 200) {
            throw new ApiAccountError("API call unsuccessful. Account may have incorrect credentials or reached quota.");
        }
        return response.body();
    }

    public String createRequestURL(String ingredientsList){
        StringBuilder url = new StringBuilder("https://api.edamam.com/api/recipes/v2?type=any");
        String ingredientsURLFormat = ingredientsList
                .replace(" ", "%20")
                .replace(",", "%2C");
        url.append("&q=");
        url.append(ingredientsURLFormat);
        url.append("&app_id=");
        url.append(appId);
        url.append("&app_key=");
        url.append(appKey);
        for (String field : includedFields) {
            url.append("&field=");
            url.append(field);
        }
        return url.toString();
    }
}
