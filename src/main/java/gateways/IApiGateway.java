package gateways;

/**
 * Interface defining interactions with external Rest APIs
 */
public interface IApiGateway {
    /**
     * Get JSON response from calling the API with the specified URL
     * @param ingredientsList ingredients list to search with
     * @return The API response for the recipes as a JSON-formatted string
     */
    String send(String ingredientsList);
}
