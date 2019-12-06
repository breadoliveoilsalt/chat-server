package chatServer.models;

public class Moderator extends Client {

    private String clientName;

    @Override
    public String getClientName() {
        return clientName;
    }

    public Moderator() {
        this.clientName = "Moderator";
    }

    @Override
    public void sendMessage(String message) {
    }

    @Override
    public String getMessage() {
        return null;
    }
}
