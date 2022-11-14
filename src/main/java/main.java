import database.Database;
import database.DatabaseGateway;
import fridge.Fridge;
import fridge.Ingredient;

import java.io.IOException;
import java.util.Arrays;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Fridge f = new Fridge();
        Ingredient t = new Ingredient();
        t.setName("Tomato");

        Ingredient l = new Ingredient();
        l.setName("Lettuce");

        f.addIngredient(l);
        f.addIngredient(t);

        Database database = new Database("Fridge");
        database.store("Eric", f);


        Database loadedDatabase = new Database("Fridge");
        Fridge loadedFridge = (Fridge) loadedDatabase.get("Eric");
        System.out.println("Welcome Back " +  database.getUsername() + " " + Arrays.toString(loadedFridge.allIngredientValues()));
    }
}
