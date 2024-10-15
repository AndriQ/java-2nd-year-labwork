package game.card.game.Snap;

import communication.YesOrNo;
import game.Player;
import game.card.CardGame;
import game.card.entity.Card;
import game.card.entity.Deck;
import game.card.entity.Hand;

public class Snap extends CardGame{

    public final static String wantToSnap = "Do you want to Snap?";
    public final static String discardPileMessage = "Discard Pile";

    protected static int noOfCards = 0;

    public Snap() {
        this("");
    }

    public Snap(String override) {
        super(override);
        setNoOfCards(noOfCards);
    }

    protected void dealCards() {
        super.dealCards();
    }
    
    protected boolean hasSnapped(YesOrNo isSnap, Hand discardPile){
        if (isSnap == YesOrNo.YES) {
            
            Card lastCard = discardPile.getLastCard();
            Card secondLastCard = discardPile.getSecondLastCard();
                
            if (lastCard != null && secondLastCard != null) {
                return lastCard.getFaceCard().equals(secondLastCard.getFaceCard());
            }
        }
        return false;
    }

    protected void playerPlaysHand(Player player) {
        Player user = getUser();
        discardPile.add(player.getHand().playACard());
        displayCard(discardPileMessage, discardPile.getLastCard());
        YesOrNo isSnap = inOut.getYesOrNo(wantToSnap);
        user.setWinner(hasSnapped(isSnap, discardPile));
        setFinishGame(user.hasWon());
    }

    public static void main(String[] args) {
        Snap snap = new Snap();
        snap.play();
    }
}
