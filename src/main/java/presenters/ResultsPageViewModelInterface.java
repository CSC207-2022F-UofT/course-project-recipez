package presenters;

import entities.recipe.Recipe;

import java.util.ArrayList;

/**
 * View Model Interface for Results Page
 */

public interface ResultsPageViewModelInterface {
    public void results_success(ArrayList<Recipe> recipes);
    public void results_failure(String errorMessage);
}

