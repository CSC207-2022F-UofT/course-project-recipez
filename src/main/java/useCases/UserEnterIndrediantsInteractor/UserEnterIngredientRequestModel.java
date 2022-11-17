package useCases.UserEnterIndrediantsInteractor;

public class UserEnterIngredientRequestModel {

    public String Ingrediant;

    public UserEnterIngredientRequestModel(String Ingrediant) {
        this.Ingrediant = Ingrediant;
    }

    String getIngredient_in_String_Format() {
        return Ingrediant;
    }

    void setIngrediant(String Ingrediant) {
        this.Ingrediant = Ingrediant;
    }


}
