package useCases.searchUseCase;

/**
 * Input model for search use case
 */
public class SearchRequestModel {
    private String ingredientsList;
    private String mealType;
    private String calories;
    private String time;

    public SearchRequestModel(String ingredientsList, String mealType, String calories, String time){
        this.ingredientsList = ingredientsList;
    }

    public String getIngredientsList() {
        return this.ingredientsList;
    }
    public String getMealType() {
        return this.mealType;
    }
    public String getCalories() {
        return this.calories;
    }
    public String getTime() {
        return this.time;
    }
    public void setIngredientsList(String ingredientsList) {
        this.ingredientsList = ingredientsList;
    }
}
