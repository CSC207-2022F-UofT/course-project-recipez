package presenters;

import entities.recipe.Recipe;

import java.util.ArrayList;

/**
 * View Model Interface for Results Page
 */

public interface ResultsPageViewModelInterface {
    public void resultsSuccess(ArrayList<Recipe> recipes);
    public void resultsFailure(String errorMessage);
}

