import java.io.Serializable;

public class CardType implements Serializable {

    private int number;
    private int mark;

    public CardType() {
        this.number = (int) (Math.random() * 13) + 1;
        this.mark = (int) (Math.random() * 4) + 1;
    }

    public int getNumber() {
        return this.number;
    }

    public int getMark() {
        return this.mark;
    }
}
