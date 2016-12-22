import java.io.Serializable;

/**
 * Created by SS on 2016/12/02.
 */
public class HandType implements Serializable {
    private CardType[] hand = new CardType[5];

    public HandType(DeckType deck) {
        for (int i = 0; i < hand.length; i++) {
            this.hand[i] = deck.drawCard();
        }
    }


    public CardType getHandCard(int number) {
        return this.hand[number];
    }

    public void changeHandCard(DeckType deck, RequestType changeList) {
        for (int i = 0; i < changeList.getReplacementNumber().length; i++) {
            hand[changeList.getReplacementNumber()[i]] = deck.drawCard();
        }
    }

    public void sortHandCard() {
        int i = 0;
        int j = 0;
        int min = 14;
        int number = -1;
        CardType tmp = new CardType();
        while (i < 5) {
            j = i;
            min = 14;
            number = i;
            while (j < 5) {
                if (min > hand[j].getNumber()) {
                    min = hand[j].getNumber();
                    number = j;
                }
                j++;
            }
            tmp = hand[i];
            hand[i] = hand[number];
            hand[number] = tmp;
            i++;
        }
    }

}
