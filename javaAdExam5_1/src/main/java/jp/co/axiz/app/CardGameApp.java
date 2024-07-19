package jp.co.axiz.app;

public class CardGameApp extends GameApp {

    public CardGameApp() {
        super();
        setPlayTime("5");
    }

    public CardGameApp(String _item) {
        super(_item);
        setPlayTime("5");
    }

    @Override
    protected String play() {
        return " Play Old Maid.";
    }
}
