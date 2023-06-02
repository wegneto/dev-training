package io.cucumber.shouty;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private Person alice;
    private Person bob;
    private String messageFromBob;

    @Given("Alice is located {int} metres from Bob")
    public void aliceIsLocatedMetresFromBob(int distance) {
        Network network = new Network();
        alice = new Person();
        bob = new Person();
        alice.moveTo(distance);
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

    @Given("a person named Alice")
    public void a_person_named_alice() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("a person named Bob")
    public void a_person_named_bob() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
