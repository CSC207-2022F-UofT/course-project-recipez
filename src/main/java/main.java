import database.Database;
import database.DatabaseGateway;
import fridge.Fridge;
import fridge.Ingredient;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Fridge fridgeOne = new Fridge();
        Ingredient t = new Ingredient();
        t.setName("Tomato");

        Ingredient l = new Ingredient();
        l.setName("Lettuce");

        fridgeOne.addIngredient(l);
        fridgeOne.addIngredient(t);

        DatabaseGateway database = new Database("Test");

        ArrayList<Object> list = new ArrayList<>();

        list.add(fridgeOne);
        String username = "Test";
        database.store(username, list);

        ArrayList<Object> test = database.get(username);
    }
}
