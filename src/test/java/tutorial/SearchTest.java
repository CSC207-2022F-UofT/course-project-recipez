package tutorial;
import database.Database;
import database.StorageObjects;
import entities.fridge.CommonFridgeFactory;
import entities.fridge.Fridge;
import entities.fridge.FridgeFactory;
import entities.ingredient.CommonIngredientFactory;
import entities.ingredient.Ingredient;
import entities.ingredient.IngredientFactory;
import entities.recipe.CommonRecipeFactory;
import entities.recipe.Recipe;
import entities.recipe.RecipeFactory;
import entities.user.CommonUserFactory;
import entities.user.User;
import entities.user.UserFactory;
import gateways.IApiGateway;
import gateways.JavaHttpGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_cases.searchUseCase.SearchInputBoundary;
import use_cases.searchUseCase.SearchInteractor;
import use_cases.searchUseCase.SearchRequestModel;
import use_cases.searchUseCase.SearchResponseModel;
import java.util.ArrayList;

/*
SearchTest class covers different types of User/Fridge input states to the use case interactor
The class starts by declaring and initializing necessary structure in order to use the Search interactor
This is further completed in the Setup method which is run before each unit test is performed.
 */
public class SearchTest{
    private Fridge BobFridge;
    private SearchInputBoundary interactor;
    private IngredientFactory ingFact;
    final StorageObjects store = new StorageObjects();

    @BeforeEach
    public void Setup(){
        UserFactory userFact = new CommonUserFactory();
        FridgeFactory fridgeFact = new CommonFridgeFactory();
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        BobFridge = fridgeFact.create(ingredients);
        User Bob = userFact.create("Bob", BobFridge);

        ingFact = new CommonIngredientFactory();
        RecipeFactory factory = new CommonRecipeFactory();
        IApiGateway apiCaller = new JavaHttpGateway();
        Database database = new Database("test");
        store.setFridge(BobFridge);
        store.setUser(Bob);
        database.store("Bob",store);
        interactor = new SearchInteractor(apiCaller, database, factory);


    }

// Checks how the API handles a Fridge with a single ingredient object in it as input
    @Test
    public void SearchWithSingleIngredients() {

        BobFridge.addIngredient(ingFact.create("Carrot"));
        SearchRequestModel request = new SearchRequestModel("Bob","Lunch/Dinner","300-800 cal", "Less than 30 minutes");
        SearchResponseModel response = interactor.search(request);
        System.out.println(response.getRecipes());
        ArrayList <Recipe> results = response.getRecipes();
        Assertions.assertEquals(results.get(0).getRecipeInfo().get("Name"), "Carrot Bread");

    }
    // Similar test but with multiple ingredient objects in Fridge

    @Test
    public void SearchWithMultipleIngredients() {

        BobFridge.addIngredient(ingFact.create("Carrot"));
        BobFridge.addIngredient(ingFact.create("Potato"));
        BobFridge.addIngredient(ingFact.create("Onion"));
        SearchRequestModel request = new SearchRequestModel("Bob","Brunch","300-800 cal", "Less than 30 minutes");
        SearchResponseModel response = interactor.search(request);
        System.out.println(response.getRecipes());
        ArrayList <Recipe> results = response.getRecipes();
        Assertions.assertEquals(results.get(0).getRecipeInfo().get("Name"), "Potato Gratin with Cream, Onion, Carrot, and Herbs");

    }

    //Checks how API handles an empty fridge
    @Test
    public void SearchEmptyFridge() {

        SearchRequestModel request = new SearchRequestModel("Bob","Brunch","300-800 cal", "Less than 30 minutes");
        SearchResponseModel response = interactor.search(request);
        System.out.println(response.getRecipes());
        ArrayList <Recipe> results = response.getRecipes();
        Assertions.assertEquals(results.get(0).getRecipeInfo().get("Name"), "Homemade Brown Sugar Recipe");

    }


    //Checks how the API behaves when it receives legal input which shouldn't yield any results
    @Test
    public void SearchNoResults() {
        BobFridge.addIngredient(ingFact.create("abcdefghijklmnopqrs"));
        SearchRequestModel request = new SearchRequestModel("Bob","Brunch","300-800 cal", "Less than 30 minutes");
        SearchResponseModel response = interactor.search(request);
        System.out.println(response.getRecipes());
        ArrayList <Recipe> results = response.getRecipes();
        Assertions.assertEquals(results.size(), 0);

    }
    //Checks how the API handles multiple ingredients in Fridge with the same name
    @Test
    public void SearchDuplicateIngredients() {
        BobFridge.addIngredient(ingFact.create("Carrot"));
        BobFridge.addIngredient(ingFact.create("Carrot"));
        SearchRequestModel request = new SearchRequestModel("Bob","Brunch","300-800 cal", "Less than 30 minutes");
        SearchResponseModel response = interactor.search(request);
        System.out.println(response.getRecipes());
        ArrayList <Recipe> results = response.getRecipes();
        Assertions.assertEquals(results.get(0).getRecipeInfo().get("Name"), "Sweet And Sour Pork");

    }




}
