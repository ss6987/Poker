/**
 * Created by SS on 2016/12/16.
 */
public class HandJudgeType {
    private int handRanking = 0;
    private int highCard = 0;

    public void judgement(HandType hand){
        CardType[] card = new CardType[5];
        for(int i = 0;i < card.length;i++){
            card[i] = hand.getHandCard(i);
        }

        if(judgeRoyalStraightFlush(card)){
            handRanking = 9;
        }else if(judgeStraightFlush(card)){
            handRanking = 8;
        }else if(judgeFourOfAKind(card)){
            handRanking = 7;
        }else if(judgeFullHouse(card)){
            handRanking = 6;
        }else if(judgeFlush(card)){
            handRanking = 5;
        }else if(judgeStraight(card)){
            handRanking = 4;
        }else if(judgeThreeOfAKind(card)){
            handRanking = 3;
        }else if(judgeTwoPair(card)){
            handRanking = 2;
        }else if(judgeOnePair(card)){
            handRanking = 1;
        }else{
            handRanking = 0;
        }

    }

    private Boolean judgeRoyalStraightFlush(CardType card[]){
        if(card[0].getNumber() == 1 && card[1].getNumber() == 10 && card[2].getNumber() == 11 && card[3].getNumber() == 12 && card[4].getNumber() == 13
                && card[1].getMark() == card[0].getMark()&& card[2].getMark() == card[0].getMark()&& card[3].getMark() == card[0].getMark()&& card[4].getMark() == card[0].getMark()){
            highCard = card[4].getNumber();
            return true;
        }
        return false;
    }
    private Boolean judgeStraightFlush(CardType card[]){
        if(card[1].getNumber() == card[0].getNumber() + 1 && card[2].getNumber() == card[0].getNumber() + 2 && card[3].getNumber() == card[0].getNumber() + 3 && card[4].getNumber() == card[0].getNumber() + 4
                && card[1].getMark() == card[0].getMark()&& card[2].getMark() == card[0].getMark()&& card[3].getMark() == card[0].getMark()&& card[4].getMark() == card[0].getMark()){
            highCard = card[4].getNumber();
            return true;
        }
        return false;
    }
    private Boolean judgeFourOfAKind(CardType card[]){
        if(card[1].getNumber() == card[0].getNumber() && card[2].getNumber() == card[0].getNumber() && card[3].getNumber() == card[0].getNumber()){
            highCard = card[3].getNumber();
            return true;
        }else if(card[2].getNumber() == card[1].getNumber() && card[3].getNumber() == card[1].getNumber() && card[4].getNumber() == card[1].getNumber()){
            highCard = card[4].getNumber();
            return true;
        }
        return false;
    }
    private Boolean judgeFullHouse(CardType card[]){
        if(card[1].getNumber() == card[0].getNumber() && card[2].getNumber() == card[0].getNumber() && card[4].getNumber() == card[3].getNumber()
                || (card[1].getNumber() == card[0].getNumber() && card[3].getNumber() == card[2].getNumber() && card[4].getNumber() == card[2].getNumber())){
            highCard = card[4].getNumber();
            return true;
        }
        return false;
    }
    private Boolean judgeFlush(CardType card[]){
        if(card[1].getMark() == card[0].getMark() && card[2].getMark() == card[0].getMark() && card[3].getMark() == card[0].getMark() && card[4].getMark() == card[0].getMark()){
            highCard = card[4].getNumber();
            return true;
        }
        return false;
    }
    private Boolean judgeStraight(CardType card[]){
        if(card[1].getNumber() == card[0].getNumber() + 1 && card[2].getNumber() == card[0].getNumber() + 2 && card[3].getNumber() == card[0].getNumber() + 3 && card[4].getNumber() == card[0].getNumber() + 4){
            highCard = card[4].getNumber();
            return true;
        }
        return false;
    }
    private Boolean judgeThreeOfAKind(CardType card[]){
        if(card[1].getNumber() == card[0].getNumber() && card[2].getNumber() == card[0].getNumber()){
            highCard = card[2].getNumber();
            return true;
        }else if(card[2].getNumber() == card[1].getNumber() && card[3].getNumber() == card[1].getNumber()){
            highCard = card[3].getNumber();
            return true;
        }else if(card[3].getNumber() == card[2].getNumber() && card[4].getNumber() == card[2].getNumber()){
            highCard = card[4].getNumber();
            return true;
        }
        return false;
    }
    private Boolean judgeTwoPair(CardType card[]){
        if(card[1].getNumber() == card[0].getNumber() && card[3].getNumber() == card[2].getNumber()){
            highCard = card[3].getNumber();
            return true;
        }else if(card[1].getNumber() == card[0].getNumber() && card[4].getNumber() == card[3].getNumber()){
            highCard = card[4].getNumber();
            return true;
        }else if(card[2].getNumber() == card[1].getNumber() && card[4].getNumber() == card[3].getNumber()){
            highCard = card[4].getNumber();
            return true;
        }
        return false;
    }
    private Boolean judgeOnePair(CardType card[]){
        if(card[1].getNumber() == card[0].getNumber()){
            highCard = card[1].getNumber();
            return true;
        }else if(card[2].getNumber() == card[1].getNumber()){
            highCard = card[2].getNumber();
            return true;
        }else if(card[3].getNumber() == card[2].getNumber()){
            highCard = card[3].getNumber();
            return true;
        }else if(card[4].getNumber() == card[3].getNumber()){
            highCard = card[4].getNumber();
        }
        return false;
    }
    public int getHandRanking(){
        return handRanking;
    }
    public  int getHighCard(){
        return highCard;
    }
    public String pokerRankingString(){
        switch (handRanking){
            case 9: return "Royal Straight Flush";
            case 8: return "Straight Flush";
            case 7: return "Four Of A Kind";
            case 6: return "Full House";
            case 5: return "Flush";
            case 4: return "Straight";
            case 3: return "Three Of A Kind";
            case 2: return "Two Pair";
            case 1: return "One Pair";
            default: return "High Card";
        }
    }
}
