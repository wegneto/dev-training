Feature: Hear shout

  Scenario: Listener is within range
    Given Alice is located 15 metres from Bob
    When Bob shouts "free beer at Bob's"
    Then Alice should hear Bob's message

  Scenario: Listener hears a different message
    Given Alice is located 15 metres from Bob
    When Bob shouts "Free coffee!"
    Then Alice should hear Bob's message