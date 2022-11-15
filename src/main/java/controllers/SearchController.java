package controllers;
import useCases.searchUseCase.SearchInputBoundary;
import useCases.searchUseCase.SearchRequestModel;
import useCases.searchUseCase.SearchResponseModel;

import java.io.IOException;

/**
 * Controller for Recipe Search use case. Used when search button clicked.
 */
public class SearchController {
    private final SearchInputBoundary userInput;
    public SearchController(SearchInputBoundary userInput) {
        this.userInput = userInput;
    }

    // TODO: Add filter options entity as parameter

    /**
     * Searches for recipes that can be made with inputted ingredients
     * @param ingredientsList Comma-separated ingredients to search with
     * @return Recipe results
     * @throws IOException if an I/O error occurs when sending or receiving
     * @throws InterruptedException if the operation is interrupted
     */
    public SearchResponseModel search(String ingredientsList) throws IOException, InterruptedException {
        SearchRequestModel requestModel = new SearchRequestModel(ingredientsList);
        return userInput.search(requestModel);
    }
}
