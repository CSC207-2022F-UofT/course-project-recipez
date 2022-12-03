package test_search_use_case;
import UI.resultPage.ResultsPageViewModel;
import UI.resultPage.ResultsPageViewModelInterface;
import database.Database;
import database.StorageObjects;
import entities.fridge.CommonFridge;
import entities.fridge.CommonFridgeFactory;
import entities.ingredient.CommonIngredient;
import entities.ingredient.CommonIngredientFactory;
import entities.ingredient.IngredientFactory;
import entities.recipe.CommonRecipeFactory;
import entities.recipe.RecipeFactory;
import entities.user.CommonUserFactory;
import entities.user.User;
import entities.user.UserFactory;
import gateways.IApiGateway;
import gateways.JavaHttpGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import presenters.search.SearchFormatter;
import presenters.search.SearchPresenter;
import use_cases.searchUseCase.SearchInputBoundary;
import use_cases.searchUseCase.SearchInteractor;
import use_cases.searchUseCase.SearchRequestModel;
import use_cases.searchUseCase.SearchResponseModel;

import java.util.ArrayList;
import java.util.Dictionary;

/*
SearchTest class covers different types of User/Fridge input states to the use case interactor
The class starts by declaring and initializing necessary structure in order to use the Search interactor
This is further completed in the Setup method which is run before each unit test is performed.
 */
public class TestSearchUseCase{
    private CommonFridge BobFridge;
    private SearchInputBoundary interactor;
    private IngredientFactory ingFact;
    final StorageObjects store = new StorageObjects();

    @BeforeEach
    public void Setup(){
        UserFactory userFact = new CommonUserFactory();
        CommonFridgeFactory fridgeFact = new CommonFridgeFactory();
        ArrayList<CommonIngredient> ingredients = new ArrayList<>();
        BobFridge = (CommonFridge) fridgeFact.create(ingredients);
        User Bob = userFact.create("Bob", BobFridge);
        ResultsPageViewModelInterface rpv = new ResultsPageViewModel();
        SearchPresenter presenter = new SearchFormatter(rpv);

        ingFact = new CommonIngredientFactory();
        RecipeFactory factory = new CommonRecipeFactory();
        IApiGateway apiCaller = new JavaHttpGateway();
        Database database = new Database("test");
        store.setFridge(BobFridge);
        store.setUser(Bob);
        database.store("Bob",store);
        interactor = new SearchInteractor(apiCaller, database, factory,presenter);


    }
    // Checks how the API handles a Fridge with a single ingredient object in it as input
    @Test
    public void SearchWithSingleIngredients() {

        BobFridge.addIngredient((CommonIngredient) ingFact.create("Carrot"));
        SearchRequestModel request = new SearchRequestModel("Bob","Lunch/Dinner","300-800 cal", "Less than 30 minutes");
        SearchResponseModel response = interactor.search(request);
        ArrayList<Dictionary<String, Object>> results = response.formatJson();
        Assertions.assertEquals(results.get(0).get("Name"), "Carrot Bread");

    }
    // Similar test but with multiple ingredient objects in Fridge
    @Test
    public void SearchWithMultipleIngredients() {

        BobFridge.addIngredient((CommonIngredient) ingFact.create("Carrot"));
        BobFridge.addIngredient((CommonIngredient) ingFact.create("Potato"));
        BobFridge.addIngredient((CommonIngredient) ingFact.create("Onion"));
        SearchRequestModel request = new SearchRequestModel("Bob","Brunch","300-800 cal", "Less than 30 minutes");
        SearchResponseModel response = interactor.search(request);
        ArrayList<Dictionary<String, Object>> results = response.formatJson();
        Assertions.assertEquals(results.get(0).get("Name"), "Potato Gratin with Cream, Onion, Carrot, and Herbs");

    }

    //Checks how API handles an empty fridge
    @Test
    public void SearchEmptyFridge() {

        SearchRequestModel request = new SearchRequestModel("Bob","Brunch","300-800 cal", "Less than 30 minutes");
        SearchResponseModel response = interactor.search(request);
        ArrayList<Dictionary<String, Object>> results = response.formatJson();
        Assertions.assertEquals(results.get(0).get("Name"), "Time for a Drink: Eve Recipe");

    }


    //Checks how the API behaves when it receives legal input which shouldn't yield any results
    @Test
    public void SearchNoResults() {
        BobFridge.addIngredient((CommonIngredient) ingFact.create("abcdefghijklmnopqrs"));
        SearchRequestModel request = new SearchRequestModel("Bob","Brunch","300-800 cal", "Less than 30 minutes");
        SearchResponseModel response = interactor.search(request);
        ArrayList<Dictionary<String, Object>> results = response.formatJson();
        Assertions.assertEquals(results.size(), 0);

    }
    //Checks how the API handles multiple ingredients in Fridge with the same name
    @Test
    public void SearchDuplicateIngredients() {
        BobFridge.addIngredient((CommonIngredient) ingFact.create("Carrot"));
        BobFridge.addIngredient((CommonIngredient) ingFact.create("Carrot"));
        SearchRequestModel request = new SearchRequestModel("Bob","Brunch","300-800 cal", "Less than 30 minutes");
        SearchResponseModel response = interactor.search(request);
        ArrayList<Dictionary<String, Object>> results = response.formatJson();
        Assertions.assertEquals(results.get(0).get("Name"), "Sweet And Sour Pork");

    }




}
