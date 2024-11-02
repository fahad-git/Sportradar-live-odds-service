package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import scoreboard.Match;

public class MatchTest {
    
    private Match match;

    @BeforeEach
    void setUp() {
        match = new Match("TeamA", "TeamB", 1);
    }

    /**
     * @TestingMethod: Match - Constructor
     * This testcase tests if constructor is initilizing fields correctly or not.
     */
    @Test
    void testConstructors() {
        assertEquals("TeamA", match.getHomeTeam());
        assertEquals("TeamB", match.getAwayTeam());
        assertEquals(0, match.getHomeTeamScore());
        assertEquals(0, match.getAwayTeamScore());
        assertTrue(match.isMatchInProgress());
        assertEquals(1, match.getMatchNumber());
    }


    /**
     * @TestingMethod: updateScore
     * This test case tests if updte score method is updating values correctly
     */

    @Test
    void testUpdateScoreValidUpdate() {
        match.updateScore(2, 3);
        assertEquals(2, match.getHomeTeamScore());
        assertEquals(3, match.getAwayTeamScore());
    }

    /**
     * @TestingMethod: updateScore
     * This method tests the response when trying to update score of a finished match.
     */
    @Test
    void testUpdateScoreOfFinishedMatch() {
        match.finishMatch();
        assertThrows(Error.class, () -> match.updateScore(2, 3));
        assertEquals(0, match.getHomeTeamScore());
        assertEquals(0, match.getAwayTeamScore());
    }


    /**
     * @TestingMethod: updateScore
     * This method tests the response when trying to update score with negative values.
     */
    @Test
    void testUpdateScore_negativeScore_throwsError() {
        assertThrows(Error.class, () -> match.updateScore(-1, 2));
        assertThrows(Error.class, () -> match.updateScore(2, -1));
    }

    /**
     * @TestingMethod: finishMatch
     * This method tests the response when finishing a match.
     */
    @Test
    void testFinishMatch() {
        match.finishMatch();
        assertFalse(match.isMatchInProgress());
    }

    /**
     * @TestingMethod: totalScore
     * This method tests the total score of a match.
     */
    @Test
    void testTotalScore() {
        match.updateScore(2, 3);
        assertEquals(5, match.totalScore());
    }


    /**
     * @TestingMethod: setHomeTeam/getHomeTeam
     * This method tests the getter and setter for homeTeam.
     */
    @Test
    void testGetterSetterHomeTeam() {
        match.setHomeTeam("NewHomeTeam");
        assertEquals("NewHomeTeam", match.getHomeTeam());
    }

    /**
     * @TestingMethod: setAwayTeam/getAwayTeam
     * This method tests the getter and setter for awayTeam.
     */
    @Test
    void testGetterSetterAwayTeam() {
        match.setAwayTeam("NewAwayTeam");
        assertEquals("NewAwayTeam", match.getAwayTeam());
    }

    /**
     * @TestingMethod: setHomeTeamScore/getHomeTeamScore
     * This method tests the getter and setter for homeTeamScore.
     */
    @Test
    void testGetterSetterHomeTeamScore() {
        match.setHomeTeamScore(5);
        assertEquals(5, match.getHomeTeamScore());
    }

    /**
     * @TestingMethod: setAwayTeamScore/getAwayTeamScore
     * This method tests the getter and setter for awayTeamScore.
     */
    @Test
    void testGetterSetterAwayTeamScore() {
        match.setAwayTeamScore(4);
        assertEquals(4, match.getAwayTeamScore());
    }

    
    /**
     * @TestingMethod: setMatchNumber/getMatchNumber
     * This method tests the getter and setter for homeTeamScore.
     */
    @Test
    void testGetterSetterMatchNumber() {
        match.setMatchNumber(2);
        assertEquals(2, match.getMatchNumber());
    }

    /**
     * @TestingMethod: setMaterInProgress/isMatchInProgress
     * This method tests the getter and setter for homeTeamScore.
     */
    @Test
    void testGetterSetterMatchInProgress() {
        match.setMatchInProgress(false);
        assertFalse(match.isMatchInProgress());
    }

}
