package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private final List<String> messagesHeard = new ArrayList<>();
    private final Network network;
    private String name;

    private int location;

    public Person(Network network, int location) {
        this.network = network;
        this.location = location;
        network.subscribe(this);
    }

    public void shout(String message) {
        network.broadcast(message, location);
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

    public int getLocation() {
        return location;
    }
}
