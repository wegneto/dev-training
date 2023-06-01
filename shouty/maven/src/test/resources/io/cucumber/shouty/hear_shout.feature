Feature: Hear shout
  Scenario: Listener is within range
    Given Alice is located 15 metres from Bob
    When Bob shouts "free beer at Bob's"
    Then Alice hears Bob's message