public class DecisionUnit {
    private int winnerNumber;
    private int ranking = -1;
    private int highCard = -1;
    private boolean drawFlag;
    private boolean drawList[];
    private HandRankingType[] judgeResult;

    public DecisionUnit(PlayerType[] playerList) {
        drawList = new boolean[playerList.length];
         judgeResult = new HandRankingType[playerList.length];

        for (int playerNumber = 0; playerNumber < playerList.length; playerNumber++) {
            judgeResult[playerNumber] = new HandRankingType(playerList[playerNumber].getHand());
            int tmpRanking = judgeResult[playerNumber].getHandRanking();
            int tmpHighCard = judgeResult[playerNumber].getHighCard();
            if (tmpRanking > this.ranking || (tmpRanking == this.ranking && tmpHighCard > this.highCard)) {
                this.ranking = tmpRanking;
                this.highCard = tmpHighCard;
                this.winnerNumber = playerNumber;
            } else if (tmpRanking == this.ranking && tmpHighCard == this.highCard) {
                drawFlag = true;
                drawList[winnerNumber] = true;
                drawList[playerNumber] = true;
            }
        }
    }

    public boolean[] getWinner() {
        if (drawFlag) {
            return this.drawList;
        } else {
            boolean[] winner = new boolean[drawList.length];
            winner[winnerNumber] = true;
            return winner;
        }
    }

    public HandRankingType[] getJudgeResult(){
        return judgeResult;
    }
}
