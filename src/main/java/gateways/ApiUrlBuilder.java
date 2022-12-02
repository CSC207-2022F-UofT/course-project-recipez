package gateways;

import java.util.HashMap;

/**
 * Facade part for creating API request URL using Builder design
 */
public class ApiUrlBuilder {
    private final StringBuilder url;

    public ApiUrlBuilder() {
        this.url = new StringBuilder("https://api.edamam.com/api/recipes/v2?type=any");
    }

    /**
     * Builds url
     * @return url as a string
     */

    public String build() {
        return this.url.toString();
    }
    public ApiUrlBuilder addAuthentication(String appId, String appKey) {
        this.url.append("&app_id=");
        this.url.append(appId);
        this.url.append("&app_key=");
        this.url.append(appKey);
        return this;
    }

    public ApiUrlBuilder addIngredients(String ingredientsList) {
        String ingredientsURLFormat = ingredientsList
                .replace(" ", "%20")
                .replace(",", "%2C");
        this.url.append("&q=");
        this.url.append(ingredientsURLFormat);
        return this;
    }

    public ApiUrlBuilder addResponseFields(String[] includedFields) {
        for (String field : includedFields) {
            this.url.append("&field=");
            this.url.append(field);
        }
        return this;
    }

    public ApiUrlBuilder addFilterOptions(String mealType, String calories, String time) {
        HashMap<String, String> convertMealType = new HashMap<>();
        convertMealType.put("Breakfast", "&mealType=Breakfast");
        convertMealType.put("Brunch", "&mealType=Breakfast&mealType=Lunch");
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
            this.url.append(convertMealType.get(mealType));
        }

        if (convertCalories.containsKey(calories)) {
            this.url.append(convertCalories.get(calories));
        }

        if (convertCookTime.containsKey(time)) {
            this.url.append(convertCookTime.get(time));
        }

        return this;
    }
}
