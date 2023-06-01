package io.cucumber.shouty;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
    @Given("Alice is located {int} metres from Bob")
    public void aliceIsLocatedMetresFromBob(int distance) {
    }

    @When("Bob shouts {string}")
    public void bobShouts(String arg0) {
    }

    @Then("Alice hears Bob's message")
    public void aliceHearsBobSMessage() {
    }
}
