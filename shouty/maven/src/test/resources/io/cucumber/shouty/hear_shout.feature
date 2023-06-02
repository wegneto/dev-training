Feature: Hear shout

  Shouty allows listeners to "hear" other users "shouts" as long as they are close enough to each other.

  To do:
  - only shout to people within range

  Rule: Shouts can be heard by other users
    Scenario: Listener hears a message
      Given a person named Alice
      And a person named Bob
      When Bob shouts "free beer at Bob's"
      Then Alice should hear Bob's message

    Scenario: Listener hears a different message
      Given Alice is located 15 metres from Bob
      When Bob shouts "Free coffee!"
      Then Alice should hear Bob's message

  Rule: Shouts should only be heard if listener is within range
    Scenario: Listener is within range
    Scenario: Listener is out of range