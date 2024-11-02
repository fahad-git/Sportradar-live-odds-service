package scoreboard;

import java.util.ArrayList;
import java.util.Comparator;
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
        // validating team names.
        this.validateTeams(homeTeam, awayTeam);

        // check if match is already in progress throw an error.
        if(this.findMatch(homeTeam, awayTeam) != null){
            throw new Error("MATCH IN PROGRESS: Cannot start a match that is already in progress.");
        }

        // creating new object of Match and adding it to the list of matches.
        MatchInterface newMatch = new Match(homeTeam, awayTeam, matchCounter++);
        matches.add(newMatch);
    }

    /**
     * @description: This method will update score and do basic validation on team names.
     */
    @Override
    public void updateScore(String homeTeam, String awayTeam, int homeTeamNewScore, int awayTeamNewScore) {
        // validating team names.
        this.validateTeams(homeTeam, awayTeam);
        // retrieving an existing match
        MatchInterface existingMatch = findMatch(homeTeam, awayTeam);
        // checking if there is an existing match.
        if(existingMatch == null){
            throw new Error("MATCH NOT FOUND: There is no match between these teams in progress.");
        } 
        // updating score of existing match.
        existingMatch.updateScore(homeTeamNewScore, awayTeamNewScore);
    }

    /**
     * @description: This method will finish an existing match.
     */
    @Override
    public void finishMatch(String homeTeam, String awayTeam) {
        // retrieving an existing matvh
        MatchInterface existingMatch = findMatch(homeTeam, awayTeam);
        // if there is a match, finish the match.
        if(existingMatch != null){
            // finish match.
            existingMatch.finishMatch();
            // this is valid only when requirements are for permanent delete.
            matches.remove(existingMatch);
        } else {            
            throw new Error("MATCH NOT FOUND: There is no match between these teams in progress.");
        }
    }

    /**
     * @description: This method will print matches summary
     * @returns sorted list of matches in progress.
     */
    @Override
    public List<MatchInterface> matchesSummary() {
        // creating a new list for matches in progress.
        List<MatchInterface> matchesInProgress = new ArrayList<>();
        // extracting matches in progress.
        for (MatchInterface match : matches) {
            if(match.isMatchInProgress()){
                matchesInProgress.add(match);
            }
        }
        // sorting match in progress collection with match comparator.
        return matchesInProgress.stream()
                .sorted(
                Comparator.comparingInt(MatchInterface::totalScore)
                        .thenComparingInt(MatchInterface::getMatchNumber).reversed()
                ).toList();
    }
    

    /**
     * @description: This method validate both teams.
     * @param homeTeam
     * @param awayTeam
     */
    private void validateTeams(String homeTeam, String awayTeam){
        //verifying team names not empty.
        homeTeam = homeTeam.trim();
        awayTeam = awayTeam.trim();
        
        if(homeTeam.length() == 0 || awayTeam.length() == 0){
            throw new Error("EMPTY TEAM NAME: Team name can not be empty.");
        }else if(homeTeam.toLowerCase().equals(awayTeam.toLowerCase())){
            throw new Error("SAME TEAM NAME: Both teams can not be same.");
        }
    }

    /**
     * @description: This method find an specific match.
     * @param homeTeam
     * @param awayTeam
     * @return an object of type MatchInterface.
     */

    private MatchInterface findMatch(String homeTeam, String awayTeam) {
        return matches.stream()
            .filter(match -> homeTeam.equals(match.getHomeTeam()) && awayTeam.equals(match.getAwayTeam()) && match.isMatchInProgress())
            .findFirst()
            .orElse(null);
        }
}
