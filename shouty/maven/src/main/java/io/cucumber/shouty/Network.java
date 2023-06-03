package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Network {

    private final List<Person> subscribers = new ArrayList<>();
    private final int range;

    public Network(int range) {
        this.range = range;
    }

    public void subscribe(Person person) {
        subscribers.add(person);
    }

    public void broadcast(String message, int shouterLocation) {
        for (Person subscriber : subscribers) {
            boolean withinRange = Math.abs(subscriber.getLocation() - shouterLocation) <= range;
            boolean shortEnough = message.length() <= 180;
            if (withinRange && shortEnough) {
                subscriber.hear(message);
            }
        }
    }
}
