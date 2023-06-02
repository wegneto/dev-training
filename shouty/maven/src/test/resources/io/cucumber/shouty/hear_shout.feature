Feature: Hear shout

  Shouty allows listeners to "hear" other users "shouts" as long as they are close enough to each other.

  To do:
  - only shout to people within range

  Background:
    Given a person named Alice
    And a person named Bob

  Rule: Shouts can be heard by other users
    Scenario: Listener hears a message
      When Bob shouts "free beer at Bob's"
      Then Alice should hear Bob's message

    Scenario: Listener hears a different message
      When Bob shouts "Free coffee!"
      Then Alice should hear Bob's message

  Rule: Shouts should only be heard if listener is within range
    Scenario: Listener is within range
    Scenario: Listener is out of range