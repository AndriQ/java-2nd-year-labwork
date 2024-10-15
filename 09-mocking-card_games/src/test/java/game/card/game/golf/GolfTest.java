package game.card.game.golf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import communication.ConsoleInOut;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import game.card.entity.Hand;
import game.card.entity.Card;
import game.card.entity.CompetitorType;
import game.Player;


public class GolfTest {

    Scanner mockScanner = mock(Scanner.class);
    ConsoleInOut consoleInOut = new ConsoleInOut();
    Golf golf = new Golf();

    @BeforeEach
    private void setUp(){
        consoleInOut.setScanner(mockScanner);
        golf.setInOut(consoleInOut, false);
    }

    @Test
    void testCheckIfKnock(){
        Player player = new Player(CompetitorType.USER, "Derek");
        when(mockScanner.nextLine()).thenReturn("Yes");
        golf.checkIfKnock(player);
       
        assertTrue(player.hasWon());
    }

    @Test
    void testCheckIfKnockNot(){
        Player player = new Player(CompetitorType.USER, "Derek");
        when(mockScanner.nextLine()).thenReturn("No");
        golf.checkIfKnock(player);
       
        assertFalse(player.hasWon());
    }

    @Test
    void testMakeUserCardsVisible(){
        Player player = new Player(CompetitorType.USER, "Derek");
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();

        hand1.add(new Card("S5"), false);
        hand1.add(new Card("S2"), false);
        hand2.add(new Card("SQ"), false);
        hand2.add(new Card("S3"), false);

        player.addHand(hand1);
        player.addHand(hand2);
        
        when(mockScanner.nextLine()).thenReturn("0", "2");
        golf.makeUserCardsVisible(player);
        
        assertEquals("Derek\n0 - S5, 1 - *\n2 - SQ, 3 - *", player.displayHandWithVisibility());
    }

}
