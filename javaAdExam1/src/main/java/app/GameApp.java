package app;

public class GameApp {
    private String item;

    public void setItem(String item) {
        this.item = item;
    }

    public String start(String name) {
        return "Start a game with " + name + " is the username you entered";
    }
}
