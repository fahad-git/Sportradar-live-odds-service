package scoreboard;

import scoreboard.Interfaces.MatchInterface;

public class Match implements MatchInterface{
    

    private String homeTeam;
    private String awayTeam;

    private int homeTeamScore;
    private int awayTeamScore;

    private boolean matchInProgress;
    private int matchNumber;


    public Match(){ 
        // default constructor
    };

    public Match(String homeTeam, String awayTeam, int matchNumber){
        // This constructor should initialize the properties

        //assigning values to the teams (Assuming data is already validated)
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;

        //initializing match with default score
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;

        //setting match number;
        this.matchNumber = matchNumber;

        //starting match
        this.matchInProgress = true;

    }


    /**
     * @description: This method taske homeTeamScore and awayTeamScore and update the value of both the fields.
     * @param homeTeamScore
     * @param awayTeamScore
     */

    public void updateScore(int homeTeamScore, int awayTeamScore) {
        //checking if this match is in progress otherwise throw an error.
        if(!matchInProgress){
            throw new Error("MATCH NOT IN PROGRESS: This match is not in progress.");
        } else if(homeTeamScore < 0 || awayTeamScore < 0){
            //team score cannot be negative. Throwing an error
            throw new Error("NEGATIVE VALUE: Team score can not be negative.");
        } else{
            //updating score of teams.
            this.homeTeamScore = homeTeamScore;
            this.awayTeamScore = awayTeamScore;
        }
    }


    /**
     * @description: This method will finish an existing, in progress match.
     */
    public void finishMatch() {
        //stopping match in progress
        this.matchInProgress = false;
    }


    /**
     * @description: This method will return total score of match by adding both teams score.
     * @return
     */
    public int totalScore(){
        //addition of both team score makes total score
        return this.homeTeamScore + this.awayTeamScore;
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
