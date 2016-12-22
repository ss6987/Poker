/**
 * Created by SS on 2016/12/05.
 */
public class DecisionUnit {
    int winner_number;
    int ranking = 0;
    int hight = 0;
    boolean drowflag;
    boolean drowlist[];

    public DecisionUnit(PlayerType player[]){
        drowlist = new boolean[player.length];

        for(int i = 0;i < player.length;i++){
            int tmp_ranking = player[i].getJudgeResult().getHandRanking();
            int tmp_hight = player[i].getJudgeResult().getHighCard();
            if(tmp_ranking > this.ranking || (tmp_ranking == this.ranking && tmp_hight > this.hight)){
                this.ranking = tmp_ranking;
                this.hight = tmp_hight;
                this.winner_number = i;
            }else if(tmp_ranking == this.ranking && tmp_hight == this.hight){
                drowflag = true;
                drowlist[winner_number] = true;
                drowlist[i] = true;
            }
        }


    }

    public String getwinnerString(){
        String return_String = "";
        if(drowflag == true){
            for(int i = 0;i < drowlist.length;i++){
                if(drowlist[i] == true){
                    return_String = return_String + "player" + i + "と";
                }
            }
            return_String = return_String + "で引き分けです。";
        }else{
            return_String = "player" + winner_number + "の勝ちです。";
        }
        return return_String;
    }
}
