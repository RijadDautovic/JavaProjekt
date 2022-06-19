package app.controllers.events;

public class EventBus {

    private final LoginEvent loginEvent = new LoginEvent();

    public LoginEvent getLoginEvent() {
        return loginEvent;
    }
}
