package controllers;

import entities.RequestOptions;

public class RequestURLBuilder {
    private final static String appId = "c863d4be";
    private final static String appKey = "9c705fc2c472f935f32ea2e2c1494311";
    private final static String[] includedFields = {"label", "url", "yield", "ingredientLines", "calories", "totalWeight", "totalTime"};
    public static String createSearchURL(RequestOptions options){
        StringBuilder url = new StringBuilder("https://api.edamam.com/api/recipes/v2?type=any");
        String[] ingredientsList = options.getIngredients();
        String ingredientsString = String.join(", ", ingredientsList);
        String ingredientsURLFormat = ingredientsString
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
