package presenters;

import entities.recipe.Recipe;

import java.util.ArrayList;

/**
 * View Model for Results Page UI. Interface Adapters Layer.
 */

public class ResultsPageViewModel implements ResultsPageViewModelInterface {

    public ArrayList<Recipe> recipes;
    public String errorMessage;


    @Override
    public void results_success(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public void results_failure(String errorMessage) {
        this.errorMessage = errorMessage;
        System.out.println(this.errorMessage);
    }
}
