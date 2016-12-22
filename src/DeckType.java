
public class DeckType {
    private CardType[] cardArray = new CardType[52];
    private int address = 0;

    public DeckType() {
        for (int i = 0; i < cardArray.length; i++) {
            cardArray[i] = new CardType();
            while (checkDeck(i)) {
                cardArray[i] = new CardType();
            }
        }
    }

    private boolean checkDeck(int purpose) {
        int now = 0;
        boolean flag = false;
        while (now < purpose) {
            if (cardArray[now].getNumber() == cardArray[purpose].getNumber() && cardArray[now].getMark() == cardArray[purpose].getMark()) {
                flag = true;
            }
            now++;
        }
        return flag;
    }

    public CardType drawCard() {
        this.address++;
        return cardArray[address - 1];
    }
}
