import java.io.Serializable;

public class PlayerType implements Serializable {
    private HandType hand;

    public PlayerType(DeckType deck) {
        this.hand = new HandType(deck);
    }

    public void drawHand(DeckType deck, RequestType request) {
        this.hand.changeHandCard(deck, request);
    }

    public HandType getHand() {
        return this.hand;
    }

}
