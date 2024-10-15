package game.card.game.snap;

import communication.YesOrNo;
import game.Player;
import game.card.CardGame;
import game.card.entity.Hand;

public class Snap extends CardGame{

    public final static String wantToSnap = "Do you want to Snap?";
    public final static String discardPileMessage = "Discard Pile";

    public Snap(String override){
        super(override);
    }

    public Snap(){
        this("");
    }

    protected static int noOfCards = 0;

    protected void dealCards() {
        setNoOfCards(noOfCards);
        super.dealCards();
    }
    
    protected boolean hasSnapped(YesOrNo isSnap, Hand discardPile){
        return isSnap == YesOrNo.YES && discardPile.getLastCard().getFaceCard() == discardPile.getSecondLastCard().getFaceCard();
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
