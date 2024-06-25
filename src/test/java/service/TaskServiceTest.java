package service;

import org.junit.Test;
import utils.IntegerAsker;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class TaskServiceTest {
    TaskService taskService = new TaskService();

//    @Test
//    public void shouldCheckIfTheKeyOfTaskIsWithinRange() {
//
//
//
//        IntegerAsker asker = mock(IntegerAsker.class);
//        when(asker.ask(anyString())).thenReturn(3);
//
//        assertEquals(taskService.checkIfTheKeyOfTaskIsWithinRange(asker), 3);
//
//    }

//    @Test
//    public void asksForNewIntegerWhenOutsideOfRange() {
//
//        IntegerAsker asker = mock(IntegerAsker.class);
//        when(asker.ask("Give a number between 1 and 10")).thenReturn(99);
//        when(asker.ask("Wrong number, try again.")).thenReturn(3);
//
//        taskService.checkIfTheKeyOfTaskIsWithinRange(asker);
//
//        verify(asker).ask("Wrong number, try again.");
//    }

    @Test
    public void getTable() {
    }

    @Test
    public void addRecord() {
    }

    @Test
    public void removeRecord() {
    }

    @Test
    public void updateRecord() {
    }

    @Test
    public void updateStatus() {
    }

    @Test
    public void generateKey() {
    }
}