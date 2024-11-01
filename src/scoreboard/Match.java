package scoreboard;

import scoreboard.Interfaces.MatchInterface;

public class Match implements MatchInterface{
    

    private String homeTeam;
    private String awayTeam;

    private int homeTeamScore;
    private int awayTeamScore;

    private boolean matchInProgress;
    private int matchNumber;


    public Match(){ };

    public Match(String homeTeam, String awayTeam, int matchNumber){
        // This constructor should initialize the properties
    }


    /**
     * @description: This method taske homeTeamScore and awayTeamScore and update the value of both the fields.
     * @param homeTeamScore
     * @param awayTeamScore
     */

    public void updateScore(int homeTeamScore, int awayTeamScore) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateScore'");
    }


    /**
     * @description: This method will finish an existing, in progress match.
     */
    public void finishMatch() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finishMatch'");
    }


    /**
     * @description: This method will return total score of match by adding both teams score.
     * @return
     */
    public int totalScore(){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finishMatch'");
    }

    /**
     * 
     * Getter and Setter Methods
     */

    public String getHomeTeam() {
        return this.homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return this.awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeTeamScore() {
        return this.homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getAwayTeamScore() {
        return this.awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public boolean isMatchInProgress() {
        return this.matchInProgress;
    }

    public void setMatchInProgress(boolean matchInProgress) {
        this.matchInProgress = matchInProgress;
    }

    public int getMatchNumber() {
        return this.matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

}
