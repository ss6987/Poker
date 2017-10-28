import java.io.Serializable;

public class HandRankingType implements Serializable {
    private int handRanking = 0;
    private int highCard = 0;

    public HandRankingType(HandType hand) {
        if (judgeRoyalStraightFlush(hand)) {
            this.handRanking = 9;
        } else if (judgeStraightFlush(hand)) {
            this.handRanking = 8;
        } else if (judgeFourOfAKind(hand)) {
            this.handRanking = 7;
        } else if (judgeFullHouse(hand)) {
            this.handRanking = 6;
        } else if (judgeFlush(hand)) {
            this.handRanking = 5;
        } else if (judgeStraight(hand)) {
            this.handRanking = 4;
        } else if (judgeThreeOfAKind(hand)) {
            this.handRanking = 3;
        } else if (judgeTwoPair(hand)) {
            this.handRanking = 2;
        } else if (judgeOnePair(hand)) {
            this.handRanking = 1;
        } else {
            this.handRanking = 0;
        }
    }

    private Boolean judgeRoyalStraightFlush(HandType hand) {
        if (hand.getHandCard(0).getNumber() == 1 && hand.getHandCard(1).getNumber() == 10 && hand.getHandCard(2).getNumber() == 11 && hand.getHandCard(3).getNumber() == 12 && hand.getHandCard(4).getNumber() == 13
                && hand.getHandCard(1).getMark() == hand.getHandCard(0).getMark() && hand.getHandCard(2).getMark() == hand.getHandCard(0).getMark() && hand.getHandCard(3).getMark() == hand.getHandCard(0).getMark() && hand.getHandCard(4).getMark() == hand.getHandCard(0).getMark()) {
            highCard = hand.getHandCard(4).getNumber();
            return true;
        }
        return false;
    }

    private Boolean judgeStraightFlush(HandType hand) {
        if (hand.getHandCard(1).getNumber() == hand.getHandCard(0).getNumber() + 1 && hand.getHandCard(2).getNumber() == hand.getHandCard(0).getNumber() + 2 && hand.getHandCard(3).getNumber() == hand.getHandCard(0).getNumber() + 3 && hand.getHandCard(4).getNumber() == hand.getHandCard(0).getNumber() + 4
                && hand.getHandCard(1).getMark() == hand.getHandCard(0).getMark() && hand.getHandCard(2).getMark() == hand.getHandCard(0).getMark() && hand.getHandCard(3).getMark() == hand.getHandCard(0).getMark() && hand.getHandCard(4).getMark() == hand.getHandCard(0).getMark()) {
            highCard = hand.getHandCard(4).getNumber();
            return true;
        }
        return false;
    }

    private Boolean judgeFourOfAKind(HandType hand) {
        if (hand.getHandCard(1).getNumber() == hand.getHandCard(0).getNumber() && hand.getHandCard(2).getNumber() == hand.getHandCard(0).getNumber() && hand.getHandCard(3).getNumber() == hand.getHandCard(0).getNumber()) {
            highCard = hand.getHandCard(3).getNumber();
            return true;
        } else if (hand.getHandCard(2).getNumber() == hand.getHandCard(1).getNumber() && hand.getHandCard(3).getNumber() == hand.getHandCard(1).getNumber() && hand.getHandCard(4).getNumber() == hand.getHandCard(1).getNumber()) {
            highCard = hand.getHandCard(4).getNumber();
            return true;
        }
        return false;
    }

    private Boolean judgeFullHouse(HandType hand) {
        if (hand.getHandCard(1).getNumber() == hand.getHandCard(0).getNumber() && hand.getHandCard(2).getNumber() == hand.getHandCard(0).getNumber() && hand.getHandCard(4).getNumber() == hand.getHandCard(3).getNumber()
                || (hand.getHandCard(1).getNumber() == hand.getHandCard(0).getNumber() && hand.getHandCard(3).getNumber() == hand.getHandCard(2).getNumber() && hand.getHandCard(4).getNumber() == hand.getHandCard(2).getNumber())) {
            highCard = hand.getHandCard(4).getNumber();
            return true;
        }
        return false;
    }

    private Boolean judgeFlush(HandType hand) {
        if (hand.getHandCard(1).getMark() == hand.getHandCard(0).getMark() && hand.getHandCard(2).getMark() == hand.getHandCard(0).getMark() && hand.getHandCard(3).getMark() == hand.getHandCard(0).getMark() && hand.getHandCard(4).getMark() == hand.getHandCard(0).getMark()) {
            highCard = hand.getHandCard(4).getNumber();
            return true;
        }
        return false;
    }

    private Boolean judgeStraight(HandType hand) {
        if (hand.getHandCard(1).getNumber() == hand.getHandCard(0).getNumber() + 1 && hand.getHandCard(2).getNumber() == hand.getHandCard(0).getNumber() + 2 && hand.getHandCard(3).getNumber() == hand.getHandCard(0).getNumber() + 3 && hand.getHandCard(4).getNumber() == hand.getHandCard(0).getNumber() + 4) {
            highCard = hand.getHandCard(4).getNumber();
            return true;
        }
        return false;
    }

    private Boolean judgeThreeOfAKind(HandType hand) {
        if (hand.getHandCard(1).getNumber() == hand.getHandCard(0).getNumber() && hand.getHandCard(2).getNumber() == hand.getHandCard(0).getNumber()) {
            highCard = hand.getHandCard(2).getNumber();
            return true;
        } else if (hand.getHandCard(2).getNumber() == hand.getHandCard(1).getNumber() && hand.getHandCard(3).getNumber() == hand.getHandCard(1).getNumber()) {
            highCard = hand.getHandCard(3).getNumber();
            return true;
        } else if (hand.getHandCard(3).getNumber() == hand.getHandCard(2).getNumber() && hand.getHandCard(4).getNumber() == hand.getHandCard(2).getNumber()) {
            highCard = hand.getHandCard(4).getNumber();
            return true;
        }
        return false;
    }

    private Boolean judgeTwoPair(HandType hand) {
        if (hand.getHandCard(1).getNumber() == hand.getHandCard(0).getNumber() && hand.getHandCard(3).getNumber() == hand.getHandCard(2).getNumber()) {
            highCard = hand.getHandCard(3).getNumber();
            return true;
        } else if (hand.getHandCard(1).getNumber() == hand.getHandCard(0).getNumber() && hand.getHandCard(4).getNumber() == hand.getHandCard(3).getNumber()) {
            highCard = hand.getHandCard(4).getNumber();
            return true;
        } else if (hand.getHandCard(2).getNumber() == hand.getHandCard(1).getNumber() && hand.getHandCard(4).getNumber() == hand.getHandCard(3).getNumber()) {
            highCard = hand.getHandCard(4).getNumber();
            return true;
        }
        return false;
    }

    private Boolean judgeOnePair(HandType hand) {
        if (hand.getHandCard(1).getNumber() == hand.getHandCard(0).getNumber()) {
            highCard = hand.getHandCard(1).getNumber();
            return true;
        } else if (hand.getHandCard(2).getNumber() == hand.getHandCard(1).getNumber()) {
            highCard = hand.getHandCard(2).getNumber();
            return true;
        } else if (hand.getHandCard(3).getNumber() == hand.getHandCard(2).getNumber()) {
            highCard = hand.getHandCard(3).getNumber();
            return true;
        } else if (hand.getHandCard(4).getNumber() == hand.getHandCard(3).getNumber()) {
            highCard = hand.getHandCard(4).getNumber();
            return true;
        }
        return false;
    }

    public int getHandRanking() {
        return handRanking;
    }

    public int getHighCard() {
        return highCard;
    }

    public String pokerRankingString() {
        switch (handRanking) {
            case 9:
                return "Royal Straight Flush";
            case 8:
                return "Straight Flush";
            case 7:
                return "Four Of A Kind";
            case 6:
                return "Full House";
            case 5:
                return "Flush";
            case 4:
                return "Straight";
            case 3:
                return "Three Of A Kind";
            case 2:
                return "Two Pair";
            case 1:
                return "One Pair";
            default:
                return "High Card";
        }
    }
}
