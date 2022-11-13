package useCases.UserEnterIndrediantsInteractor;

public class UserEnterIngrediantRequestModel {

    public String Ingrediant;

    public UserEnterIngrediantRequestModel(String Ingrediant) {
        this.Ingrediant = Ingrediant;
    }

    String getIngrediant_in_String_Format() {
        return Ingrediant;
    }

    void setIngrediant(String Ingrediant) {
        this.Ingrediant = Ingrediant;
    }


}
