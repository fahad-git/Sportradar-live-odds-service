package scoreboard;

import java.util.ArrayList;
import java.util.List;

import scoreboard.Interfaces.MatchInterface;
import scoreboard.Interfaces.ScoreBoardInterface;

public class ScoreBoard implements ScoreBoardInterface{


    private List<MatchInterface> matches = new ArrayList<>();
    private int matchCounter = 1;

    public ScoreBoard(){
        //default constructor
    }

    /**
     * @description: This method will start match ad validate team names.
     */

    @Override
    public void startMatch(String homeTeam, String awayTeam) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'startMatch'");
    }

    /**
     * @description: This method will update score and do basic validation on team names.
     */
    @Override
    public void updateScore(String homeTeam, String awayTeam, int homeTeamNewScore, int awayTeamNewScore) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateScore'");
    }

    /**
     * @description: This method will finish an existing match.
     */
    @Override
    public void finishMatch(String homeTeam, String awayTeam) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finishMatch'");
    }

    /**
     * This method will print matches summary
     */
    @Override
    public List<MatchInterface> matchesSummary() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'matchesSummary'");
    }
    
}
