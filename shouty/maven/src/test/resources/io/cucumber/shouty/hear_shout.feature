Feature: Hear shout

  Shouty allows listeners to "hear" other users "shouts" as long as they are close enough to each other.

  To do:
  - only shout to people within range

  Rule: Shouts can be heard by other users
    Scenario: Listener hears a message
      Given a person named Lucy
      And a person named Sean
      When Sean shouts "free beer at Sean's"
      Then Lucy should hear Sean's message

  Scenario: Creating a new scenario
    Given this is new scenario
    When I do something
    Then I should see something

  Rule: Shouts should only be heard if listener is within range
    Scenario: Listener is within range
      Given the range is 100
      And people are located at
        | name     | Sean | Lucy |
        | location | 0    | 50   |
      When Sean shouts
      Then Lucy should hear a shout

    @focus
    Scenario: Listener is out of range
      Given the range is 100
      And people are located at
        | name     | Sean | Larry |
        | location | 0    | 150   |
      When Sean shouts
      Then Larry should not hear a shout

  Rule: Listener should be able to hear multiple shouts

    Scenario: Two shouts
      Given a person named Lucy
      And a person named Sean
      When Sean shouts "free beer at Sean's"
      And Sean shouts "free coffee at Sean's"
      Then Lucy hears the following messages:
        | free beer at Sean's   |
        | free coffee at Sean's |

  Rule: Maximum length of message is 180 characters
    Scenario: Message is too long
      Given a person named Sean
      And a person named Lucy
      When Sean shouts the following message
        """
        This is a really long message
        so long in fact that I am not going to
        be allowed to send it, at least if I keep
        typing like this until the length is over
        the limit of 180 characters.
        """
      Then Lucy should not hear a shout