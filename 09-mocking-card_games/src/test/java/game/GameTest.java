package game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import communication.ConsoleInOut;
import game.card.CardGame;
import game.card.entity.CompetitorType;


public class GameTest {

    Scanner mockScanner = mock(Scanner.class);
    ConsoleInOut consoleInOut = new ConsoleInOut();

    private Game game = new Game() {

        @Override
        protected void afterPlayOfRound() {  
        }

        @Override
        protected void beforePlayOfRound() {
        }

        @Override
        protected void computerPlays(Player competitor) {
        }

        @Override
        public int getScore(Player player) {
            return 0;
        }

        @Override
        protected void initiate() { 
        }

        @Override
        protected void userPlays(Player competitor) {
        }
    };
    
    @BeforeEach
    private void setUp() {
        consoleInOut.setScanner(mockScanner);
        game.setInOut(consoleInOut, false);
    }

    @Test
    void testGetComputerPlayersNamesDealer() {
        when(mockScanner.hasNextLine()).thenReturn(true, false);
        when(mockScanner.nextLine()).thenReturn("DEALER,Derek");
        
        game.setLoadScanner(mockScanner, Game.playerNamesFile);
        HashMap<CompetitorType, String[]> map = game.getComputerPlayersNames();
        
        assertEquals("Derek", map.get(CompetitorType.DEALER)[0]);
    }

    @Test
    void testGetComputerPlayersNamesSecondComputer(){
        when(mockScanner.hasNextLine()).thenReturn(true, true, false);
        when(mockScanner.nextLine()).thenReturn("COMPUTER,Derek").thenReturn("COMPUTER,Xi");
        
        game.setLoadScanner(mockScanner, Game.playerNamesFile);
        HashMap<CompetitorType, String[]> map = game.getComputerPlayersNames();
        
        assertEquals("Xi", map.get(CompetitorType.COMPUTER)[1]);
    }

    @Test
    void testCreateComputerCompetitors() {
        when(mockScanner.hasNextLine()).thenReturn(true, true, false);
        when(mockScanner.nextLine()).thenReturn("DEALER,Derek").thenReturn("COMPUTER,Xi");

        game.setLoadScanner(mockScanner, Game.playerNamesFile);
        game.createComputerCompetitors(2);

        List<Player> players = game.getPlayers();
        Player firstPlayer = players.get(0);

        assertEquals("Xi", firstPlayer.getName());
    }


    @Test
    void testGetInputInteger() {
        when(mockScanner.hasNextLine()).thenReturn(true, false);
        when(mockScanner.nextLine()).thenReturn("2");

        assertEquals(2, consoleInOut.getInputInteger("Message"));
    }

    @Test
    void testGetInputString() {
        when(mockScanner.hasNextLine()).thenReturn(true, false);
        when(mockScanner.nextLine()).thenReturn("Derek");

        assertEquals("Derek", consoleInOut.getInputString("Message"));
    }

    @Test
    void testGetNumberOfPlayers() {
        when(mockScanner.hasNextLine()).thenReturn(true, false);
        when(mockScanner.nextLine()).thenReturn("3");

        assertEquals(3, game.getNumberOfPlayers());
    }

    @Test
    void testInitiatePlayers() {
        when(mockScanner.hasNextLine()).thenReturn(true, false);
        when(mockScanner.nextLine()).thenReturn("3");
        game.initiatePlayers();
    
        assertEquals(3, game.getPlayersSize());
    }
}
