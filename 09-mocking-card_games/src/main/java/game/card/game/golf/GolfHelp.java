package game.card.game.golf;

import communication.SelectFromList;

public enum GolfHelp implements SelectFromList {
    DISCARD("Pick from discarded pile"),
    DECK("Pick from Deck");

    private String description;
    
    GolfHelp(String description) {
        this.description = description;
    }    
    
}
