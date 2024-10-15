package game.card.entity;
import java.util.HashMap;
import java.util.Map;

public enum CardFace {
    TWO("Two"),
    THREE( "Three"),
    FOUR("Four"),
    FIVE( "Five"),
    SIX("Six"),
    SEVEN("Seven"),
    EIGHT("Eight"),
    NINE("Nine"),
    TEN( "Ten"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King"),
    ACE("Ace");

    private String camelCase;

    protected static final Map<String, CardFace> lookup = new HashMap<String, CardFace>();

    static {
        for (CardFace rank : CardFace.values()) {
            lookup.put(rank.shortDisplay(), rank);
        }
    }

    CardFace(String camelCase){
        this.camelCase = camelCase;
    }

    public int getValue(){
        int value = getRank();
        if (value == CardFace.ACE.getRank()){
            value = 11;
        } else if (value > 10) {
            return 10;
        }
        return value;
    }
    public int getRank(){
        return ordinal() + 2;
    }
    public String displayCamelCase(){
        return camelCase;
    }

    public String shortDisplay(){
        String display;
        int rank = getRank();
        if (rank <= CardFace.TEN.getRank()) {
            display = Integer.toString(rank);
        } else {
            display = camelCase.substring(0,1);
        }
        return display;
    }

    public String toString(){
        return shortDisplay();
    }

    public static CardFace getCardRank(String shortCode){
        return lookup.get(shortCode);
    }
}
