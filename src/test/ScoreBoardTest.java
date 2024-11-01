package test;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import scoreboard.ScoreBoard;
import scoreboard.Interfaces.MatchInterface;


class ScoreBoardTest {

    private ScoreBoard scoreBoard;

    @BeforeEach
    void setUp() {
        scoreBoard = new ScoreBoard();
    }

    /**
     * @TestingMethod: startMatch
     * This method starts a new match and add it to the matches list.
     */
    @Test
    void testStartMatchSuccessfully() {
        scoreBoard.startMatch("TeamA", "TeamB");
        List<MatchInterface> matches = scoreBoard.matchesSummary();
        
        assertEquals(1, matches.size());
        assertEquals("TeamA", matches.get(0).getHomeTeam());
        assertEquals("TeamB", matches.get(0).getAwayTeam());
    }

    /**
     * @TestingMethod: startMatch
     * This method starts new match and throws error for duplicate teams.
     */
    @Test
    void testStartMatchDuplicate() {
        scoreBoard.startMatch("TeamA", "TeamB");
        assertThrows(Error.class, () -> scoreBoard.startMatch("TeamA", "TeamB"));
    }

    /**
     * @TestingMethod: startMatch
     * This method starts new match and throws error for empty team names.
     */
    @Test
    void testStartMatchEmptyNames() {
        assertThrows(Error.class, () -> scoreBoard.startMatch("", "TeamB"));
        assertThrows(Error.class, () -> scoreBoard.startMatch("TeamA", ""));
    }

    /**
     * @TestingMethod: startMatch
     * This method starts new match and throws error for same team name.
     */
    @Test
    void testStartMatchSameTeamName() {
        assertThrows(Error.class, () -> scoreBoard.startMatch("TeamB", "TeamB"));
        assertThrows(Error.class, () -> scoreBoard.startMatch("TeamA", "TeamA"));
    }

    /**
     * @TestingMethod: updateScore
     * This method updates score of a match successfully.
     */
    @Test
    void testUpdateScoreSuccessful() {
        scoreBoard.startMatch("TeamA", "TeamB");
        scoreBoard.updateScore("TeamA", "TeamB", 2, 3);

        List<MatchInterface> matches = scoreBoard.matchesSummary();
        assertEquals(2, matches.get(0).getHomeTeamScore());
        assertEquals(3, matches.get(0).getAwayTeamScore());
    }

        
    /**
     * @TestingMethod: updateScore
     * This method updates score of a match gives error because match not found.
     */
    @Test
    void testUpdateScoreFailure() {
        assertThrows(Error.class, () -> scoreBoard.updateScore("TeamA", "TeamB", 2, 3));
    }

    /**
     * @TestingMethod: finishMatch
     * This method finishes match which was already started.
     */
    @Test
    void testFinishMatchSuccessfully() {
        scoreBoard.startMatch("TeamA", "TeamB");
        scoreBoard.finishMatch("TeamA", "TeamB");

        List<MatchInterface> matches = scoreBoard.matchesSummary();
        assertTrue(matches.isEmpty(), "The matches list should be empty.");
    }

    /**
     * @TestingMethod: finishMatch
     * This method finishes match which has never started.
     */
    @Test
    void testFinishMatchFailure() {
        assertThrows(Error.class, () -> scoreBoard.finishMatch("TeamA", "TeamB"));
    }

    /**
     * @TestingMethod: matchesSummary
     * This method shows summary of in progress matches. This method also checks the order of matches in progress.
     */
    @Test
    void testMatchesSummary() {
        scoreBoard.startMatch("TeamA", "TeamB");
        scoreBoard.updateScore("TeamA", "TeamB", 1, 1);
        
        scoreBoard.startMatch("TeamC", "TeamD");
        scoreBoard.updateScore("TeamC", "TeamD", 3, 2);

        scoreBoard.startMatch("TeamE", "TeamF");
        scoreBoard.updateScore("TeamE", "TeamF", 1, 1);

        List<MatchInterface> matchesInProgress = scoreBoard.matchesSummary();
        assertEquals(2, matchesInProgress.size());

        // Check the order based on total score
        assertEquals("TeamD", matchesInProgress.get(0).getAwayTeam());
        assertEquals("TeamA", matchesInProgress.get(0).getHomeTeam());
        assertEquals("TeamE", matchesInProgress.get(0).getHomeTeam());
    }
}
