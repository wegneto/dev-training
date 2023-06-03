package io.cucumber.shouty;

import java.util.Collections;
import java.util.HashMap;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private String messagesFromSean;
    private static final int DEFAULT_RANGE = 100;
    private Network network = new Network(DEFAULT_RANGE);
    private HashMap<String, Person> people;

    @Before
    public void before() {
        people = new HashMap<>();
    }

    @Given("a person named {word}")
    public void a_person_named(String name) {
        people.put(name, new Person(network, DEFAULT_RANGE));
    }

    @When("{word} shouts {string}")
    public void a_person_shouts(String person, String message) {
        people.get(person).shout(message);
        messagesFromSean = message;
    }

    @Then("{word} should hear Sean's message")
    public void LucyHearsSeanMessage(String person) {
        assertEquals(Collections.singletonList(messagesFromSean), people.get(person).getMessagesHeard());
    }

    @Then("Lucy should hear a shout")
    public void lucy_shoud_hear_a_shout() {
        assertEquals(1, people.get("Lucy").getMessagesHeard().size());
    }

    @Given("the range is {int}")
    public void the_range_is(int range) {
        this.network = new Network(range);
    }

    @Given("a person named {word} is located at {int}")
    public void a_person_named_is_located_at(String name, Integer location) {
        people.put(name, new Person(network, location));
    }

    @Then("Larry should not hear a shout")
    public void person_should_not_hear_sean_s_message() {
        assertEquals(0, people.get("Larry").getMessagesHeard().size());
    }

    @When("Sean shouts")
    public void sean_shouts() {
        people.get("Sean").shout("Hello, world");
    }

}
