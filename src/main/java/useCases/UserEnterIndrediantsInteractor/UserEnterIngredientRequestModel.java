package useCases.UserEnterIndrediantsInteractor;

public class UserEnterIngredientRequestModel {

    public String Ingredient;

    public UserEnterIngredientRequestModel(String Ingredient) {
        this.Ingredient = Ingredient;
    }

    String getIngredient_in_String_Format() {
        return Ingredient;
    }

    void setIngredient(String Ingredient) {
        this.Ingredient = Ingredient;
    }


}
