package gateways;

/**
 * Interface defining interactions with external Rest APIs
 */
public interface IApiGateway {
    /**
     * Get JSON response from calling the API with the specified URL
     * @param ingredientsList Comma-separated ingredients to search with
     * @param mealType Type of meal (breakfast, lunch, etc.)
     * @param calories Range for calories in recipe
     * @param time Range for time recipe takes
     * @return The API response for the recipes as a JSON-formatted string
     */
    String send(String ingredientsList, String mealType, String calories, String time);
}
