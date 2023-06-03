package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private String messageFromSean;
    private static final int DEFAULT_RANGE = 100;
    private Network network = new Network(DEFAULT_RANGE);
    private HashMap<String, Person> people;

    static class Whereabouts {
        public String name;
        public Integer location;

        public Whereabouts(String name, int location) {
            this.name = name;
            this.location = location;
        }
    }

    @DataTableType
    public Whereabouts definePerson(Map<String, String> entry) {
        return new Whereabouts(entry.get("name"), Integer.parseInt(entry.get("location")));
    }

    @Before
    public void before() {
        people = new HashMap<>();
    }

    @Given("a person named {word}")
    public void a_person_named(String name) {
        people.put(name, new Person(network, DEFAULT_RANGE));
    }

    @Given("people are located at")
    public void people_are_located_at(@Transpose List<Whereabouts> whereabouts) {
        whereabouts.forEach(w -> people.put(w.name, new Person(network, w.location)));
    }

    @When("{word} shouts {string}")
    public void a_person_shouts(String person, String message) {
        people.get(person).shout(message);
        messageFromSean = message;
    }

    @Then("{word} should hear Sean's message")
    public void LucyHearsSeanMessage(String person) {
        assertEquals(Collections.singletonList(messageFromSean), people.get(person).getMessagesHeard());
    }

    @Then("Lucy should hear a shout")
    public void lucy_shoud_hear_a_shout() {
        assertEquals(1, people.get("Lucy").getMessagesHeard().size());
    }

    @Given("the range is {int}")
    public void the_range_is(int range) {
        this.network = new Network(range);
    }

    @Then("{word} should not hear a shout")
    public void person_should_not_hear_sean_s_message(String name) {
        assertEquals(0, people.get(name).getMessagesHeard().size());
    }

    @When("Sean shouts")
    public void sean_shouts() {
        people.get("Sean").shout("Hello, world");
    }

    @Then("Lucy hears the following messages:")
    public void lucy_hears_the_following_messages(DataTable expectedMessages) {
        List<List<String>> actualMessages = new ArrayList<>();
        List<String> heard = people.get("Lucy").getMessagesHeard();
        for (String message : heard) {
            actualMessages.add(Collections.singletonList(message));
        }

        expectedMessages.diff(DataTable.create(actualMessages));
    }

    @When("Sean shouts the following message")
    public void sean_shouts_the_following_message(String message) {
        people.get("Sean").shout(message);
        messageFromSean = message;
        System.out.println("Sean shouts: " + message.length());
    }
}
