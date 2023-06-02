package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private final List<String> messagesHeard = new ArrayList<>();
    private final Network network;

    public Person(Network network) {
        this.network = network;
        network.subscribe(this);
    }

    public Person(String name) {
        this.name = name;
        this.network = null;
    }

    public void shout(String message) {
        network.broadcast(message);
    }

    public void hear(String message) {
        messagesHeard.add(message);
    }

    public List<String> getMessagesHeard() {
        return messagesHeard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
