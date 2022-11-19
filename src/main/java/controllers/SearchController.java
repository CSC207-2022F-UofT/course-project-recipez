package controllers;
import useCases.searchUseCase.SearchInputBoundary;
import useCases.searchUseCase.SearchRequestModel;
import useCases.searchUseCase.SearchResponseModel;

/**
 * Controller for Recipe Search use case. Used when search button clicked.
 */
public class SearchController {
    private final SearchInputBoundary userInput;
    public SearchController(SearchInputBoundary userInput) {
        this.userInput = userInput;
    }
    // TODO: Get ingredients from fridge database instead of as String
    /**
     * Searches for recipes that can be made with inputted user's ingredients
     * @param username Comma-separated ingredients to search with
     * @param mealType Type of meal (breakfast, lunch, etc.)
     * @param calories Range for calories in recipe
     * @param time Range for time recipe takes
     * @return Recipe results
     */
    public SearchResponseModel search(String username, String mealType, String calories, String time) {
        SearchRequestModel requestModel = new SearchRequestModel(username, mealType, calories, time);
        return userInput.search(requestModel);
    }
}
