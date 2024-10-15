package game.card;

import communication.SelectFromList;

public enum DiscardDeckHelp implements SelectFromList {
    DISCARD("Pick from discarded pile"),
    DECK("Pick from Deck");

    private String description;
    
    DiscardDeckHelp(String description) {
        this.description = description;
    }    
    
}
