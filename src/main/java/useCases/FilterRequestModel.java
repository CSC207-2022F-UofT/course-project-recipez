package useCases;

// Use Case Layer

public class FilterRequestModel {
    private final String mealType;

    private final String calories;

    private final String time;

    public FilterRequestModel(String mealType, String calories, String time) {
        this.mealType = mealType;
        this.calories = calories;
        this.time = time;
    }

    public String getMealType() {
        return mealType;
    }

    public String getCalories() {
        return calories;
    }

    public String getTime() {
        return time;
    }
}
