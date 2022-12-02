package gateways;

import java.net.http.HttpResponse;

/**
 * Implements IApiGateway using the JavaHttp library
 * Uses Facade design pattern
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
        ApiUrlBuilder urlBuilder = new ApiUrlBuilder();
        String url = urlBuilder
                .addAuthentication(appId, appKey)
                .addIngredients(ingredientsList)
                .addFilterOptions(mealType, calories, time)
                .addResponseFields(includedFields)
                .build();

        ApiRequestSender requestSender = new ApiRequestSender(url);
        HttpResponse<String> response = requestSender.send();

        ApiStatusCodeHandler statusCodeHandler = new ApiStatusCodeHandler(response.statusCode());
        statusCodeHandler.checkErrorStatus();

        return response.body();
    }
}
