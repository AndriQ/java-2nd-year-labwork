package game.card.entity;
import java.util.Collections;
import java.util.Random;

public class Deck extends Hand{

    private Boolean override = false;
    private Random random = new Random();

    public Deck(){
        super();
        generateDeck();
    }

    public Deck(String deckOverride){
        super(deckOverride);
        if (deckOverride == ""){
            generateDeck();
        } else {
            this.override = true;
        }
    }

    

    public void generateDeck() {
        this.clear();
        for (Suit suit: Suit.values()){
            for (CardFace rank: CardFace.values()){
                Card card = Card.getInstance(suit,rank);
                this.add(card);
            }
        }
    }

    public Card playACard(int index){
        if (handOfCards.size() == 0){
            generateDeck();
        }
        if (!override && index > 0 ){
            index = random.nextInt(size()-1);
        }
        return super.playACard(index);
    }

    public static void main(String[ ] args) {
        Deck deck = new Deck();
        System.out.println(deck.toString());
    }
}


