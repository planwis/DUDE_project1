package chess;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMain {
    private Main mainClass;

    @Before
    public void setUp(){
        Main.main(null);
        mainClass = new Main();
    }

    // ---------- Function: Main.checkmate(int color) ----------
    // Combination Approach: ECC
    // note: although 'boardState' in mainClass is one of parameter (implicit) of checkmate()
    // we can not edit the 'boardState' in mainClass because it is private attribute
    // Therefore, we can only use 'color' as our only parameter

    // -- Interface-based --
    // C1: color > 0
    //      b1: true
    //      b2: false
    // Test cases: c1b1, c1b2

    // test case #1: c1b1 (failed)
    @Test
    public void testCheckMate1() {
        Assert.assertFalse(mainClass.checkmate(2));
    }

    // test case #2: c1b2 (failed)
    @Test
    public void testCheckMate2() {
        Assert.assertFalse(mainClass.checkmate(-1));
    }


    // -- Functionality-based --
    // C2: Chess color
    //      b1: 0 (white)
    //      b2: 1 (black)
    // Test cases: c2b1, c2b2

    // test case #1: c2b1
    @Test
    public void testCheckMate3() {
        Assert.assertFalse(mainClass.checkmate(0));
    }

    // test case #2: c2b2
    @Test
    public void testCheckMate4() {
        Assert.assertFalse(mainClass.checkmate(1));
    }

    // ---------- end of testing King.move(Cell[][] state, int x, int y) ----------

}
