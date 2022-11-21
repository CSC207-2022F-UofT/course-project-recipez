package gateways;
import entities.ApiAccountError;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

/**
 * Implements IApiGateway using the JavaHttp library
 */
public class JavaHttpGateway implements IApiGateway{
    private final static String appId = "c863d4be";
    private final static String appKey = "9c705fc2c472f935f32ea2e2c1494311";
    private final static String[] includedFields = {"label", "url", "image", "yield", "ingredientLines", "calories", "totalWeight", "totalTime"};
    /**
     * Calls API endpoint and gets response
     * @param ingredientsList Comma-separated ingredients to search with
     * @param mealType Type of meal (breakfast, lunch, etc.)
     * @param calories Range for calories in recipe
     * @param time Range for time recipe takes
     * @return The API response for the recipes as a JSON-formatted string
     */
    public String send(String ingredientsList, String mealType, String calories, String time) {
        String url = createRequestURL(ingredientsList, mealType, calories, time);
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

    public String createRequestURL(String ingredientsList, String mealType, String calories, String time) {
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
        url.append(createFilterOptions(mealType, calories, time));
        for (String field : includedFields) {
            url.append("&field=");
            url.append(field);
        }
        return url.toString();
    }

    public String createFilterOptions(String mealType, String calories, String time) {
        StringBuilder filterFields = new StringBuilder();

        HashMap<String, String> convertMealType = new HashMap<>();
        convertMealType.put("Breakfast", "&mealType=Breakfast");
        convertMealType.put("Brunch", "");
        convertMealType.put("Lunch/dinner", "&mealType=Lunch&mealType=Dinner");
        convertMealType.put("Snack", "&mealType=Snack");
        convertMealType.put("Teatime", "&mealType=Teatime");

        HashMap<String, String> convertCookTime = new HashMap<>();
        convertCookTime.put("Less than 30 minutes", "&time=30");
        convertCookTime.put("30-60 minutes", "&time=30-60");
        convertCookTime.put("More than 1 hour", "&time=60%2B");

        HashMap<String, String> convertCalories = new HashMap<>();
        convertCalories.put("Less than 300 cal", "&calories=300");
        convertCalories.put("300-800 cal", "&calories=300-800");
        convertCalories.put("More than 800 cal", "&calories=800%2B");

        if (convertMealType.containsKey(mealType)) {
            filterFields.append(convertMealType.get(mealType));
        }

        if (convertCalories.containsKey(calories)) {
            filterFields.append(convertCalories.get(calories));
        }

        if (convertCookTime.containsKey(time)) {
            filterFields.append(convertCookTime.get(mealType));
        }

        return filterFields.toString();
    }
}
