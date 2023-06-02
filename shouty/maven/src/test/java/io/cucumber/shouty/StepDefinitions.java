package io.cucumber.shouty;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private Person alice;
    private Person bob;
    private String messageFromBob;
    private Network network;

    @Before
    public void createNetwork() {
        network = new Network();
    }

    @Given("a person named Alice")
    public void a_person_named_alice() {
        alice = new Person(network);
    }

    @Given("a person named Bob")
    public void a_person_named_bob() {
        bob = new Person(network);
    }

    @When("Bob shouts {string}")
    public void bobShouts(String message) {
        bob.shout(message);
        messageFromBob = message;
    }

    @Then("Alice should hear Bob's message")
    public void aliceHearsBobMessage() {
        assertEquals(asList(messageFromBob), alice.getMessagesHeard());
    }
}
