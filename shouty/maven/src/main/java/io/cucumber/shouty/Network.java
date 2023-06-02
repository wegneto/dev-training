package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Network {

    private final List<Person> subscribers = new ArrayList<>();

    public void subscribe(Person person) {
        subscribers.add(person);
    }

    public void broadcast(String message) {
        for (Person subscriber : subscribers) {
            subscriber.hear(message);
        }
    }
}
