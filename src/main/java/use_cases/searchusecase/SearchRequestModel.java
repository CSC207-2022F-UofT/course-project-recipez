package use_cases.searchusecase;

/**
 * Input model for search use case
 */
public class SearchRequestModel {
    private final String username;
    private final String mealType;
    private final String calories;
    private final String time;

    /**
     * Constructor
     *
     * @param username as a String
     * @param mealType as a String
     * @param calories as a String
     * @param time as a String
     */
    public SearchRequestModel(String username, String mealType, String calories, String time){
        this.username = username;
        this.mealType = mealType;
        this.calories = calories;
        this.time = time;
    }

    /**
     * Getter function for the username
     *
     * @return the username as a String
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Getter function for the meal type
     *
     * @return the mealType as a String
     */
    public String getMealType() {
        return this.mealType;
    }
    /**
     * Getter function for calories
     *
     * @return the calories as a String
     */
    public String getCalories() {
        return this.calories;
    }
    /**
     * Getter function for the time
     *
     * @return the time as a String
     */
    public String getTime() {
        return this.time;
    }
}
