package game.card.entity;

import java.util.Random;
import java.util.HashMap;

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
            for (FaceCard rank: FaceCard.values()){
                Card card = Card.getInstance(suit,rank);
                this.add(card);
            }
        }
    }

    public Card playACard(){
        if (handOfCards.size() == 0){
            generateDeck();
        }
        int index = size();
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


