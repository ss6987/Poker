import java.util.ArrayList;

/**
 * Created by SS on 2016/12/05.
 */
public class RequestType {
    private boolean changeNumber[] = new boolean[5];

    public RequestType(int[] RequestTumber){
        for(int i=0;i < RequestTumber.length;i++){
            changeNumber[RequestTumber[i]] = true;
        }
    }

    public boolean[] getRequestNumber(){
        return this.changeNumber;
    }

    public int[] getReplacementNumber(){
        ArrayList<Integer> true_list = new ArrayList<Integer>();
        int[] return_list;
        for(int i = 0;i < this.changeNumber.length;i++){
            if(changeNumber[i] == true){
                true_list.add(i);
            }
        }
        return_list = new int[true_list.size()];
        for(int j = 0;j < return_list.length;j++){
            return_list[j] = true_list.get(j);
        }
        return return_list;
    }
}
