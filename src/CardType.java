import java.io.Serializable;

/**
 * Created by SS on 2016/12/02.
 */

public class CardType implements Serializable {

    private int number;
    private int mark;

    public CardType(){
        int newNumber = (int) (Math.random() * 13) + 1;
        int newMark = (int) (Math.random() * 4) + 1;
        this.number = newNumber;
        this.mark = newMark;
    }

    public int getNumber() {
        return this.number;
    }

    public int getMark() {
        return this.mark;
    }

    public String getMarkString() {
        String return_String = new String();
        switch (this.mark) {
            case 1:
                return_String = "スペード";
                break;
            case 2:
                return_String = "クローバー";
                break;
            case 3:
                return_String = "ダイヤ";
                break;
            case 4:
                return_String = "ハート";
                break;
        }
        return return_String;
    }
}
