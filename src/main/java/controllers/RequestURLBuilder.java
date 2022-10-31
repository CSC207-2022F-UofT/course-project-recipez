package controllers;

import useCases.RequestOptions;

public class RequestURLBuilder {
    private final static String appId = "c863d4be";
    private final static String appKey = "9c705fc2c472f935f32ea2e2c1494311";
    public static String createSearchURL(RequestOptions options){
        StringBuilder url = new StringBuilder("https://api.edamam.com/api/recipes/v2?type=any");
        String[] ingredients = options.getIngredients();
        url.append("&q=");
        url.append(String.join("%2C%20", ingredients));
        url.append("&app_id=");
        url.append(appId);
        url.append("&app_key=");
        url.append(appKey);
        return url.toString();
    }
}
