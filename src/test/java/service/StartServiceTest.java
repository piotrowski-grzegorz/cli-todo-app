package service;

import org.junit.Test;
import utils.IntegerAsker;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


public class StartServiceTest {

    StartService startService = new StartService();

    @Test
    public void getTaskNameFromUser() {
        //given
        StartService startService = new StartService();

        String userInput = "test";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        assertEquals("test", startService.getTaskNameFromUser());
    }

    @Test
    public void getDescriptionNameFromUser() {
        //given
        String userInput = "test";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        assertEquals("test", startService.getDescriptionNameFromUser());
    }

    @Test
    public void shouldGetsIntegerWhenWithinBounds() {



        IntegerAsker asker = mock(IntegerAsker.class);
        when(asker.ask(anyString())).thenReturn(3);

        assertEquals(startService.getBoundIntegerFromUser(asker), 3);

    }

    @Test
    public void asksForNewIntegerWhenOutSideBoundsOfOneToTen() {

        IntegerAsker asker = mock(IntegerAsker.class);
        when(asker.ask("Give a number between 1 and 10")).thenReturn(99);
        when(asker.ask("Wrong number, try again.")).thenReturn(3);

        startService.getBoundIntegerFromUser(asker);

        verify(asker).ask("Wrong number, try again.");
    }
}