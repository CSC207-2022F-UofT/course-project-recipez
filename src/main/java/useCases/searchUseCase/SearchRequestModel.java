package useCases.searchUseCase;

public class SearchRequestModel {
    private String ingredientsList;
    // TODO: Add filter options entity as parameter
    public SearchRequestModel(String ingredientsList){
        this.ingredientsList = ingredientsList;
    }

    public String getIngredientsList() {
        return this.ingredientsList;
    }

    public void setIngredientsList(String ingredientsList) {
        this.ingredientsList = ingredientsList;
    }
}
