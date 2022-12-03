package controllers;
import use_cases.searchUseCase.SearchInputBoundary;
import use_cases.searchUseCase.SearchRequestModel;

/**
 * Controller for Recipe Search use case. Used when search button clicked.
 */
public class SearchController {
    private final SearchInputBoundary userInput;
    public SearchController(SearchInputBoundary userInput) {
        this.userInput = userInput;
    }
    /**
     * Searches for recipes that can be made with inputted user's ingredients
     *
     * @param username Comma-separated ingredients to search with
     * @param mealType Type of meal (breakfast, lunch, etc.)
     * @param calories Range for calories in recipe
     * @param time     Range for time recipe takes
     */
    public void search(String username, String mealType, String calories, String time) {
        SearchRequestModel requestModel = new SearchRequestModel(username, mealType, calories, time);
        userInput.search(requestModel);
    }
}
