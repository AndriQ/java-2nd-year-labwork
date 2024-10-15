package game;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

import game.card.CardGame;
import game.card.entity.Card;

import java.io.IOException;
import java.util.List;
import java.util.Scanner; 



public class LoadCSVTest {

    LoadCSV loadCSV = new LoadCSV();

    @Test
    void testCreateCSVReader() throws Exception {
        try {
            Scanner scanner = loadCSV.createCSVreader(Game.playerNamesFile);
            assertTrue(scanner.hasNextLine());
        } catch (IOException e) {
        }
    }

    @Test 
    void testCreateCSVReaderException(){
        assertThrows(IOException.class, () -> loadCSV.createCSVreader("rubish path"));
    }

    @Test
    void testGetCSVReader() {
        try {
            Scanner scanner = loadCSV.getCSVReader(Game.playerNamesFile);
            assertTrue(scanner.hasNextLine());
        } catch (Exception e) {
        }
    }

    @Test
    void testGetCSVReaderException() {
        assertThrows(IOException.class, () -> loadCSV.getCSVReader("rubish path"));

    }

    @Test
    void testGetCSVRows() {
        assertEquals(7, loadCSV.getCSVRows(Game.playerNamesFile).size());
    }

    @Test
    void testGetCSVReaderMockFirstRow(){
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.hasNextLine()).thenReturn(true, false);
        when(mockScanner.nextLine()).thenReturn("Line", "One");
 
        loadCSV.setCSVReader(mockScanner, "rubbish path");
        List<String[]> result = loadCSV.getCSVRows("rubbish path");
 
        assertEquals(1, result.size());
    }

    @Test
    void testGetCSVReaderMockSize(){
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.hasNextLine()).thenReturn(true, true, false);
        when(mockScanner.nextLine()).thenReturn("Line, One").thenReturn("Line, Two");
 
        loadCSV.setCSVReader(mockScanner, "rubbish path");
        List<String[]> result = loadCSV.getCSVRows("rubbish path");
 
        assertEquals(2, result.size());
    }

    @Test
    void testSetCSVReader() {
        Scanner scanner = new Scanner("rubbish path");
        loadCSV.setCSVReader(scanner, Game.playerNamesFile);
        
        assertEquals(scanner, loadCSV.csvReader);
    }
 
    @Test
    void testSetCSVReaderConfig() {
        String configPath = "config/path";
        Scanner scanner = new Scanner("rubbish path");
 
        loadCSV.setCSVReader(scanner, configPath);
 
        assertEquals(configPath, loadCSV.configPath);
    }  
}
