package test;

import scoreboard.Interfaces.MatchInterface;

public class MatchStub implements MatchInterface {

    private int totalScore;
    private int matchNumber;

    // Constructor to initialize the stub with specific values
    public MatchStub(int totalScore, int matchNumber) {
        this.totalScore = totalScore;
        this.matchNumber = matchNumber;
    }

    @Override
    public int totalScore() {
        return totalScore;
    }

    @Override
    public int getMatchNumber() {
        return matchNumber;
    }

    // Other methods from MatchInterface can be left unimplemented or return default values
    @Override
    public String getHomeTeam() { return ""; }

    @Override
    public String getAwayTeam() { return ""; }

    @Override
    public int getHomeTeamScore() { return 0; }

    @Override
    public int getAwayTeamScore() { return 0; }

    @Override
    public boolean isMatchInProgress() { return false; }

    @Override
    public void finishMatch() { }

    @Override
    public void updateScore(int homeTeamScore, int awayTeamScore) { }

}