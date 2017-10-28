
public class DeckType {
    private CardType[] cardArray = new CardType[52];
    private int numberOfDeck = 0;

    public DeckType() {
        for (int cardNumber = 0; cardNumber < cardArray.length; cardNumber++) {
            cardArray[cardNumber] = new CardType();
            while (checkDeck(cardNumber)) {
                cardArray[cardNumber] = new CardType();
            }
        }
    }

    private boolean checkDeck(int purpose) {
        int now = 0;
        boolean overlapFlag = false;
        while (now < purpose) {
            if (cardArray[now].getNumber() == cardArray[purpose].getNumber() && cardArray[now].getMark() == cardArray[purpose].getMark()) {
                overlapFlag = true;
            }
            now++;
        }
        return overlapFlag;
    }

    public CardType drawCard() {
        this.numberOfDeck++;
        return cardArray[numberOfDeck - 1];
    }
}
