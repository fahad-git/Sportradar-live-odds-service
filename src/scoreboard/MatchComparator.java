package scoreboard;
import java.util.Comparator;

import scoreboard.Interfaces.MatchInterface;

public class MatchComparator implements Comparator<MatchInterface> {

    /**
     * @description: implementing compare method for custom comparision.
     * @params receive two match objects.
     * @return an integer value for sorting list of objects.
     */
    @Override
    public int compare(MatchInterface match1, MatchInterface match2) {
        // comparision total score of both matches.
        if(match1.totalScore() == match2.totalScore()){
            // if total score is equal, instead of returning 0, sorting them based on match number.
            if(match1.getMatchNumber() < match2.getMatchNumber()){
                return 1;
            } else {
                return -1;
            }

        } else if(match1.totalScore() < match2.totalScore()){
            return 1;
        } else {
            return -1;
        }
    }
}
