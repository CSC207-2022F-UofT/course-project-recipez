package UI.resultPage;

import entities.recipe.Recipe;

import java.util.ArrayList;
import java.util.Dictionary;

/**
 * View Model for Results Page UI. Interface Adapters Layer.
 */

public class ResultsPageViewModel implements ResultsPageViewModelInterface {

    public ArrayList<Dictionary<String, Object>> recipes;
    public String errorMessage;

    public ResultsPageViewModel() {
        this.recipes = new ArrayList<>();
        this.errorMessage = null;
    }

    @Override
    public void resultsSuccess(ArrayList<Dictionary<String, Object>> recipes) {
        this.recipes = recipes;
    }

    @Override
    public void resultsFailure(String errorMessage) {
        this.errorMessage = errorMessage;
        this.recipes = new ArrayList<>(); //Makes an empty ArrayList for the if condition in ResultsPageView
        System.out.println(this.errorMessage);
    }
}
