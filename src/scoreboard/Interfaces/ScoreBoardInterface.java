package scoreboard.Interfaces;

import java.util.List;

public interface ScoreBoardInterface {
    
    // Method to start a match between two teams
    void startMatch(String homeTeam, String awayTeam);

    // Method to update the score of a match in progress
    void updateScore(String homeTeam, String awayTeam, int homeTeamNewScore, int awayTeamNewScore);

    // Method to finish an ongoing match
    void finishMatch(String homeTeam, String awayTeam);

    // Method to retrieve a list of matches in progress, ordered by total score
    List<MatchInterface> matchesSummary();
}
