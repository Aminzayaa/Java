package jp.co.axiz.app;

public class DartsGameApp extends GameApp {

    public DartsGameApp() {
        super();
        setPlayTime("10");
    }

    public DartsGameApp(String _item) {
        super(_item);
        setPlayTime("10");
    }

    @Override
    protected String play() {
        return " Throw 10 times and compete for the highest total score.";
    }
}
