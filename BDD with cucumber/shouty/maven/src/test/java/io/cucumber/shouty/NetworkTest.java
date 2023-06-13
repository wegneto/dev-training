package io.cucumber.shouty;

import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class NetworkTest {
    private int range = 100;
    private Network network = new Network(range);

    @Test
    public void does_not_broadcast_a_message_over_180_characters() {
        int seanLocation = 0;

        char[] chars = new char[181];
        Arrays.fill(chars, 'x');
        String longMessage = new String(chars);

        Person lucy = mock(Person.class);
        network.subscribe(lucy);
        network.broadcast(longMessage, seanLocation);

        verify(lucy, never()).hear(longMessage);
    }
}
