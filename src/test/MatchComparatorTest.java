package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import scoreboard.MatchComparator;
import scoreboard.Interfaces.MatchInterface;

class MatchComparatorTest {

    private MatchComparator comparator;
    private MatchInterface match1;
    private MatchInterface match2;

    @BeforeEach
    void setUp() {
        comparator = new MatchComparator();
    }

     /**
     * @TestingMethod: compare
     * This test case tests compare method returns asc order.
     */
    @Test
    void testCompareAsc() {
        match1 = new MatchStub(10, 1);
        match2 = new MatchStub(5, 2);

        assertTrue(comparator.compare(match1, match2) < 0, "Match1 should come before match2 due to higher score");
        assertTrue(comparator.compare(match2, match1) > 0, "Match2 should come after match1 due to lower score");
    }
       
    /**
     * @TestingMethod: compare
     * This test case tests compare method returns desc order.
     */

    @Test
    void testCompareDesc() {
        match1 = new MatchStub(3, 1);
        match2 = new MatchStub(7, 2);

        assertTrue(comparator.compare(match1, match2) > 0, "Match1 should come after match2 due to lower score");
        assertTrue(comparator.compare(match2, match1) < 0, "Match2 should come before match1 due to higher score");
    }

    /**
     * @TestingMethod: compare
     * This test case tests compare method returns force desc order.
     */

    @Test
    void testCompareSameDesc() {
        match1 = new MatchStub(5, 1);
        match2 = new MatchStub(5, 1);

        assertEquals(-1, comparator.compare(match1, match2), "Matches with same score but force sorted to desc.");
    }
}
