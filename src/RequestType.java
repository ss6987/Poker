import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by SS on 2016/12/05.
 */
public class RequestType implements Serializable {
    private boolean[] changeNumber = new boolean[5];

    public RequestType(boolean[] requestNumber) {
        for (int handNumber = 0; handNumber < requestNumber.length; handNumber++) {
            this.changeNumber[handNumber] = requestNumber[handNumber];
        }
    }

    public int[] getReplacementNumber() {
        ArrayList<Integer> trueList = new ArrayList<>();
        int[] returnList;
        for (int handNumber = 0; handNumber < this.changeNumber.length; handNumber++) {
            if (changeNumber[handNumber] == true) {
                trueList.add(handNumber);
            }
        }
        returnList = new int[trueList.size()];
        for (int cardNumber = 0; cardNumber < returnList.length; cardNumber++) {
            returnList[cardNumber] = trueList.get(cardNumber);
        }
        return returnList;
    }
}
