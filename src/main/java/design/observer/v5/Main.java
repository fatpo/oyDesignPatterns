package design.observer.v5;

import java.util.ArrayList;
import java.util.List;

interface ActionListener {
    void doAction(ActionEvent e);
}

public class Main {
    public static void main(String[] args) {
        Button button = new Button();
        button.addListener(new PressActionListener());
        button.addListener(new Press2ActionListener());

        button.press();
    }
}

class Button {
    private final List<ActionListener> actionListeners = new ArrayList<>();

    public void addListener(ActionListener actionListener) {
        this.actionListeners.add(actionListener);
    }

    public void press() {
        ActionEvent event = new ActionEvent(System.currentTimeMillis(), this);

        for (ActionListener actionListener : actionListeners) {
            actionListener.doAction(event);
        }
    }
}

class ActionEvent {
    long timestamp;
    Button source;

    public ActionEvent(long timestamp, Button source) {
        this.timestamp = timestamp;
        this.source = source;
    }
}

class PressActionListener implements ActionListener {

    @Override
    public void doAction(ActionEvent e) {
        System.out.println("点击1 ..");
    }
}

class Press2ActionListener implements ActionListener {

    @Override
    public void doAction(ActionEvent e) {
        System.out.println("点击2 ..");
    }
}


