import entities.User;

public class main {
    public static void main(String[] args) {
        User shaffaan = new User("shaffan", new String[]{"banana"});
        System.out.println(shaffaan.getUsername());

    }
}
