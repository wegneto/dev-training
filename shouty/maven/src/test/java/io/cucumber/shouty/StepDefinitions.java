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
        alice = new Person();
        bob = new Person();
        alice.moveTo(distance);
    }

    @When("Bob shouts {string}")
    public void bobShouts(String message) {
        bob.shout(message);
        messageFromBob = message;
    }

    @Then("Alice hears Bob's message")
    public void aliceHearsBobMessage() {
        //import junit assertions
        assertEquals(asList(messageFromBob), alice.getMessagesHeard());
    }
}
