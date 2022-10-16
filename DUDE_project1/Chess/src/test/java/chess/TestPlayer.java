/* Copyright (C) 2022 Rachata Chopdamrongtham, Nattapon Lertkijroongrueng, Pattamaporn Pongpaew, Kantapon Srigadphach, Wish Suchalermkul - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the MIT license. */

package chess;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPlayer {
    private Player playerA;

    @Before
    public void setUp() {
        // set up Player A
        playerA = new Player("a");
    }

    // ---------- Function: Player.winpercent() ----------
    // winpercent() has 2 implicit parameters which are 'gameswon' and 'gameplayed'
    // note: these two variable are always initiated to be 0 and increase by 1 at a time
    // Combination Approach: PWC
    // -- Interface-based --
    // C1: value of gameswon
    //      b1: greater than 0
    //      b2: equal to 0
    // C2: value of gameplayed
    //      b1: greater than 0
    //      b2: equal to 0
    // -- Functionality-based --
    // C3: comparison of gameswon and gamesplayed
    //      b1: gameswon < gamesplayed
    //      b2: gameswon = gamesplayed
    //      b3: gameswon > gamesplayed
    // Possible test cases = 3 * 2 = 6
    // C1, C2 => (c1b1, c2b1)x, (c1b1, c2b2)x, (c1b2, c2b1)x, (c1b2, c2b2)x
    // C2, C3 => (c2b1, c3b1)x, (c2b1, c3b2)x, (c2b1, c3b3)x
    //           (c2b2, c3b1)x, (c2b2, c3b2)x, (c2b2, c3b3)x
    // C3, C1 => (c3b1, c1b1)x, (c3b1, c1b2)x,
    //           (c3b2, c1b1)x, (c3b2, c1b2)x,
    //           (c3b3, c1b1)x, (c3b3, c1b2)x
    // test cases = (c1b1, c2b1, c3b1), (c1b1, c2b2, c3b3), (c1b2, c2b1, c3b2),
    //              (c1b2, c2b2, c3b1), (c1b1, c2b2, c3b2), (c1b2, c2b1, c3b3)

    // test cases #1: c1b1, c2b1, c3b1
    @Test
    public void testWinPercent1() {
        for (int i = 0; i < 4; i++) {
            playerA.updateGamesWon();
        }
        Assert.assertEquals(Integer.valueOf(4), playerA.gameswon());
        for (int i = 0; i < 5; i++) {
            playerA.updateGamesPlayed();
        }
        Assert.assertEquals(Integer.valueOf(5), playerA.gamesplayed());
        Assert.assertTrue(playerA.gameswon() < playerA.gamesplayed());
        Assert.assertEquals(Integer.valueOf(80), playerA.winpercent());
    }

    // test cases #2: c1b1, c2b2, c3b3
    @Test
    public void testWinPercent2() {
        for (int i = 0; i < 4; i++) {
            playerA.updateGamesWon();
        }
        Assert.assertEquals(Integer.valueOf(4), playerA.gameswon());
        Assert.assertEquals(Integer.valueOf(0), playerA.gamesplayed());
        Assert.assertTrue(playerA.gameswon() > playerA.gamesplayed());
        // divide by 0
        Assert.assertThrows(ArithmeticException.class, () -> {
            playerA.winpercent();
        });

    }

    // test cases #3: c1b2, c2b1, c3b2
    // infeasible case since gameswon = gamesplayed, but gamewon = 0 and gameplayed > 0

    // test cases #4: c1b2, c2b2, c3b1
    // infeasible case since gameswon < gamesplayed, but gamewon = 0 and gameplayed = 0

    // test cases #5: c1b1, c2b2, c3b2
    // infeasible case since gameswon = gamesplayed, but gamewon > 0 and gameplayed = 0

    // test cases #6: c1b2, c2b1, c3b3
    // infeasible case since gameswon > gamesplayed, but gamewon = 0 and gameplayed > 0

    // ---------- end of testing Player.winpercent() ----------
}
