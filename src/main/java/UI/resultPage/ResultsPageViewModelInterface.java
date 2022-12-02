package UI.resultPage;

import entities.recipe.Recipe;

import java.util.ArrayList;
import java.util.Dictionary;

/**
 * View Model Interface for Results Page
 */

public interface ResultsPageViewModelInterface {
    public void resultsSuccess(ArrayList<Dictionary<String, Object>> recipes);
    public void resultsFailure(String errorMessage);
}

