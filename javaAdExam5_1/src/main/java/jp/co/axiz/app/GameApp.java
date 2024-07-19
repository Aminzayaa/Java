package jp.co.axiz.app;


public abstract class GameApp implements App {

    private String item;
    private String playTime;

    protected abstract String play();

    public GameApp() {
    }

    public GameApp(String _item) {
        item = _item;
    }

    public String start(String userName) {
        String startMessage =  "Starts a game with " + userName  + item + ".";
        String playMessage = play();
        String playTimeMessage = "Execution time: " + playTime + " minutes.";
        return startMessage + "\n" + playMessage + "\n" + playTimeMessage;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }
}
