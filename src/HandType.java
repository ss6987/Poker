import java.io.Serializable;

public class HandType implements Serializable {
    private CardType[] handCard = new CardType[5];

    public HandType(DeckType deck) {
        for (int handNumber = 0; handNumber < handCard.length; handNumber++) {
            this.handCard[handNumber] = deck.drawCard();
        }
        sortHandCard();
    }

    private void sortHandCard() {
        int noExchangeNumber = 0, exchangeNumber, minimum, number;
        CardType tmpCard;

        while (noExchangeNumber < 5) {
            exchangeNumber = noExchangeNumber;
            minimum = 14;
            number = noExchangeNumber;
            while (exchangeNumber < 5) {
                if (minimum > handCard[exchangeNumber].getNumber()) {
                    minimum = handCard[exchangeNumber].getNumber();
                    number = exchangeNumber;
                }
                exchangeNumber++;
            }
            tmpCard = handCard[noExchangeNumber];
            handCard[noExchangeNumber] = handCard[number];
            handCard[number] = tmpCard;
            noExchangeNumber++;
        }
    }

    public void changeHandCard(DeckType deck, RequestType changeList) {
        for (int changeNumber = 0; changeNumber < changeList.getReplacementNumber().length; changeNumber++) {
            handCard[changeList.getReplacementNumber()[changeNumber]] = deck.drawCard();
        }
        sortHandCard();
    }

    public CardType getHandCard(int number) {
        return this.handCard[number];
    }

}
