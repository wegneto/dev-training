package io.cucumber.shouty;

import java.util.HashMap;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private String messageFromBob;
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

    @When("Bob shouts {string}")
    public void bobShouts(String message) {
        people.get("Bob").shout(message);
        messageFromBob = message;
    }

    @Then("Alice should hear Bob's message")
    public void aliceHearsBobMessage() {
        assertEquals(asList(messageFromBob), people.get("Alice").getMessagesHeard());
    }
}
