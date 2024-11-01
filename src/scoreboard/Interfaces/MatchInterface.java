package scoreboard.Interfaces;

public interface MatchInterface {

     // updates match score
     void updateScore(int homeTeamScore, int awayTeamScore);

     // finishes an in progress match.
     void finishMatch();

     // calculates total score
     int totalScore();

     // returns home team name.
     String getHomeTeam();

     // returns away team name.
     String getAwayTeam();

     // returns home team score.
     int getHomeTeamScore();

     // returns away team score.
     int getAwayTeamScore();
 
     boolean isMatchInProgress();

     int getMatchNumber();
}
