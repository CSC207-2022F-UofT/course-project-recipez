package useCases.searchUseCase;

/**
 * Input model for search use case
 */
public class SearchRequestModel {
    private final String username;
    private final String mealType;
    private final String calories;
    private final String time;

    public SearchRequestModel(String username, String mealType, String calories, String time){
        this.username = username;
        this.mealType = mealType;
        this.calories = calories;
        this.time = time;
    }

    public String getUsername() {
        return this.username;
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
}
