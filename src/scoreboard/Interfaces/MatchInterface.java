package scoreboard.Interfaces;

public interface MatchInterface {

     // Methods to update the match score
     void updateScore(int homeTeamScore, int awayTeamScore);

     // Method to finish the match
     void finishMatch();

     int totalScore();
 
}
