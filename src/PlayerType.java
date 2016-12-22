/**
 * Created by SS on 2016/12/16.
 */
public class PlayerType {
    private HandType hand;
    private HandJudgeType judgeResult;

    public PlayerType(DeckType deck){
        this.hand = new HandType(deck);
        this.hand.sortHandCard();
        this.judgeResult = new HandJudgeType();
        this.judgeResult.judgement(this.hand);
    }

    public void drowHand(DeckType deck, RequestType request){
        this.hand.changeHandCard(deck,request);
        this.hand.sortHandCard();
    }

    public void judgeHand(){
        this.hand.sortHandCard();
        this.judgeResult.judgement(hand);
    }

    public HandType getHand(){
        return this.hand;
    }

    public HandJudgeType getJudgeResult(){
        return this.judgeResult;
    }
}
