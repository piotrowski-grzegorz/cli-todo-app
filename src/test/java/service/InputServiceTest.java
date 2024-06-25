package service;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class InputServiceTest {
    @Test
    public void getTaskNameFromUser() {
        //given
        StartService startService = new StartService();
        InputService inputService = new InputService();

        String userInput = "test";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        assertEquals("test", inputService.setTaskNameInput());
    }
}
