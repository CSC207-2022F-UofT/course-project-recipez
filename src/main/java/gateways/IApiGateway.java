package gateways;

import java.io.IOException;

/**
 * Interface defining interactions with external Rest APIs
 */
public interface IApiGateway {
    /**
     * Get JSON response from calling the API with the specified URL
     * @param url URL for the API endpoint
     * @return The API response for the recipes as a JSON-formatted string
     * @throws IOException if an I/O error occurs when sending or receiving
     * @throws InterruptedException if the operation is interrupted
     */
    String send(String url) throws IOException, InterruptedException;
}
