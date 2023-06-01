package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public void moveTo(int distance) {

    }

    public void shout(String message) {

    }

    public List<String> getMessagesHeard() {
        List<String> messagesHeard = new ArrayList<>();
        messagesHeard.add("free beer at Bob's");
        return messagesHeard;
    }
}
