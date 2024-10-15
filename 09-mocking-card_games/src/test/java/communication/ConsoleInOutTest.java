package communication;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import game.Player; 
import game.card.entity.Hand;
import game.card.entity.CompetitorType;


public class ConsoleInOutTest {

    Scanner mockScanner = mock(Scanner.class);
    ConsoleInOut consoleInOut = new ConsoleInOut();

    @BeforeEach
    private void setUp(){
        consoleInOut.setScanner(mockScanner);
        consoleInOut.setOutputOn(false);
    }

    @Test
    void testGetInputString() {
        when(mockScanner.nextLine()).thenReturn("Derek");
        assertEquals("Derek", consoleInOut.getInputString("Message"));
    }

    @Test
    void testGetInputStringIgnoreSecond() {
        when(mockScanner.nextLine()).thenReturn("Xi").thenReturn("Derek");
        assertEquals("Xi", consoleInOut.getInputString("Message"));
    }

    @Test
    void testGetInteger(){
        when(mockScanner.nextLine()).thenReturn("2");
        assertEquals(2, consoleInOut.getInteger());
    }

    @Test
    void testGetIntegerSecondTime(){
        when(mockScanner.nextLine()).thenReturn("Del").thenReturn("3");
        assertEquals(3, consoleInOut.getInteger());
    }
    
    @Test
    void testGetInputInteger() {
        when(mockScanner.nextLine()).thenReturn("2");
        assertEquals(2, consoleInOut.getInputInteger("Message"));
    }

    @Test
    void testGetInputIntegerSecondTime() {
        when(mockScanner.nextLine()).thenReturn("Del").thenReturn("2");
        assertEquals(2, consoleInOut.getInputInteger("Message"));
    }

    @Test
    void testGetListIndex() {
        when(mockScanner.nextLine()).thenReturn("1");
        assertEquals(1, consoleInOut.getListIndex(Arrays.asList("One", "Two")));
    }

    @Test
    void testGetListIndexSecondTime() {
        when(mockScanner.nextLine()).thenReturn("3").thenReturn("1");
        assertEquals(1, consoleInOut.getListIndex(Arrays.asList("One", "Two")));
    }

    @Test
    void testGetListIndexWithQuestion() {
        when(mockScanner.nextLine()).thenReturn("1");
        assertEquals(1, consoleInOut.getListIndex("Question", Arrays.asList("One", "Two")));
    }
 
    @Test
    void testGetPlayersCard() {
        when(mockScanner.nextLine()).thenReturn("1");
        Player player = new Player(null, null);
        player.addHand(new Hand("C3,C4,C5"));
        
        assertEquals("C4", consoleInOut.getPlayersCard(player).toString());
    }

    @Test
    void testGetYesOrNoYes() {
        when(mockScanner.nextLine()).thenReturn("Yes");
        assertEquals(YesOrNo.YES, consoleInOut.getYesOrNo("Question"));
    }

    @Test
    void testGetYesOrNoY() {
        when(mockScanner.nextLine()).thenReturn("Y");
        assertEquals(YesOrNo.YES, consoleInOut.getYesOrNo("Question"));
    }

    @Test
    void testGetYesOrNoNo() {
        when(mockScanner.nextLine()).thenReturn("N");
        assertEquals(YesOrNo.NO, consoleInOut.getYesOrNo("Question"));
    }

    @Test
    void testGetYesOrNoOther() {
        when(mockScanner.nextLine()).thenReturn("");
        assertEquals(YesOrNo.NO, consoleInOut.getYesOrNo("Question"));
    }
}
