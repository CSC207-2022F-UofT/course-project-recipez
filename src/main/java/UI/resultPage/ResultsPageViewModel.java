package UI.resultPage;

import entities.recipe.Recipe;

import java.util.ArrayList;

/**
 * View Model for Results Page UI. Interface Adapters Layer.
 */

public class ResultsPageViewModel implements ResultsPageViewModelInterface {

    public ArrayList<Recipe> recipes;
    public String errorMessage;


    @Override
    public void resultsSuccess(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public void resultsFailure(String errorMessage) {
        this.errorMessage = errorMessage;
        this.recipes = new ArrayList<>(); //Makes an empty ArrayList for the if condition in ResultsPageView
        System.out.println(this.errorMessage);
    }
}
