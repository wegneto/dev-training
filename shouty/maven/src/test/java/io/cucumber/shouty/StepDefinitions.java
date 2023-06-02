package io.cucumber.shouty;

import java.util.HashMap;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private String messageSent;
    private Network network;
    private HashMap<String, Person> people;

    @Before
    public void createNetwork() {
        network = new Network();
        people = new HashMap<>();
    }

    @Given("a person named {word}")
    public void a_person_named(String name) {
        people.put(name, new Person(network));
    }

    @When("{person} shouts {string}")
    public void personShouts(Person person, String message) {
        people.get(person.getName()).shout(message);
        messageSent = message;
    }

    @Then("{person} should hear Bob's message")
    public void aliceHearsBobMessage(Person person) {
        assertEquals(asList(messageSent), people.get(person.getName()).getMessagesHeard());
    }
}
