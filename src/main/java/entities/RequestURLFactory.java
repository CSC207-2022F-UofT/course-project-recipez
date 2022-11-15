package entities;

/**
 * Factory for creating the RequestURL to access the Recipe Search API
 */
public class RequestURLFactory {
    private final static String appId = "c863d4be";
    private final static String appKey = "9c705fc2c472f935f32ea2e2c1494311";
    private final static String[] includedFields = {"label", "url", "yield", "ingredientLines", "calories", "totalWeight", "totalTime"};

    /**
     *
     * @param ingredientsList Ingredients to search with and filters to apply
     * @return URL for accessing API endpoint
     */
    public RequestURL createRequestURL(String ingredientsList){
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
        return new RequestURL(url.toString());
    }
}
