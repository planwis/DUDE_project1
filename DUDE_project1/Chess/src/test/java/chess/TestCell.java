package chess;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pieces.*;

public class TestCell {
    private static Rook wr01,wr02,br01,br02;
    private static Knight wk01,wk02,bk01,bk02;
    private static Bishop wb01,wb02,bb01,bb02;
    private static Pawn wp[],bp[];
    private static Queen wq,bq;
    private static King wk,bk;
    pieces.Piece P;
    Cell cell;

    @Before
    public void setUp(){
        wr01=new Rook("WR01","src/main/java/chess/White_Rook.png",0);
        wr02=new Rook("WR02","src/main/java/chess/White_Rook.png",0);
        br01=new Rook("BR01","src/main/java/chess/Black_Rook.png",1);
        br02=new Rook("BR02","src/main/java/chess/Black_Rook.png",1);
        wk01=new Knight("WK01","src/main/java/chess/White_Knight.png",0);
        wk02=new Knight("WK02","src/main/java/chess/White_Knight.png",0);
        bk01=new Knight("BK01","src/main/java/chess/Black_Knight.png",1);
        bk02=new Knight("BK02","src/main/java/chess/Black_Knight.png",1);
        wb01=new Bishop("WB01","src/main/java/chess/White_Bishop.png",0);
        wb02=new Bishop("WB02","src/main/java/chess/White_Bishop.png",0);
        bb01=new Bishop("BB01","src/main/java/chess/Black_Bishop.png",1);
        bb02=new Bishop("BB02","src/main/java/chess/Black_Bishop.png",1);
        wq=new Queen("WQ","src/main/java/chess/White_Queen.png",0);
        bq=new Queen("BQ","src/main/java/chess/Black_Queen.png",1);
        wk=new King("WK","src/main/java/chess/White_King.png",0,7,3);
        bk=new King("BK","src/main/java/chess/Black_King.png",1,0,3);
        wp=new Pawn[8];
        bp=new Pawn[8];
        for(int i=0;i<8;i++)
        {
            wp[i]=new Pawn("WP0"+(i+1),"src/main/java/chess/White_Pawn.png",0);
            bp[i]=new Pawn("BP0"+(i+1),"src/main/java/chess/Black_Pawn.png",1);
        }
        cell = null;
    }

    // Combination Approach: PWC
    //-- Interface-based --
    // C1: x >=0
    //      b1: true
    //      b2: false
    // C2: y >= 0
    //      b1: true
    //      b2: false
    // C3: p is null
    //      b1: true
    //      b2: false

    // Test case = max1*max2 = 2*2 = 4

    // C1-C2: (c1b1,c2b1)X (c1b1,c2b2)X (c1b2,c2b1)X (c1b2,c2b2)X
    // C2-C3: (c2b1,c3b1)X (c2b1,c3b2)X (c2b2,c3b1)X (c2b2,c3b2)X
    // C1-C3: (c1b1,c3b1)X (c1b1,c3b2)X (c1b2,c3b1)X (c1b2,c3b2)X

    // select test case: (c1b1,c2b1,c3b2) (c1b1,c2b2,c3b1) (c1b2,c2b1,c3b1) (c1b2,c2b2,c3b2)

    // test case #1: c1b1, c2b1, c3b2
    @Test
    public void testConstructCell1() {
        P = bk01;
        cell = new Cell(0,1, P);
        Assert.assertEquals(0,cell.x);
        Assert.assertEquals(1,cell.y);
        Assert.assertEquals(bk01, cell.getpiece());
    }

    // test case #2: c1b1, c2b2, c3b1 (failed)
    @Test
    public void testConstructCell2() {
        P = null;
        // failed case, because the program doesn't allow for input -1 in the x or y
        cell = new Cell(0,-1, P);
        Assert.assertEquals(0,cell.x);
        Assert.assertEquals(-1,cell.y);
        Assert.assertEquals(null, cell.getpiece());
    }

    // test case #3: c1b2, c2b1, c3b1 (failed)
    @Test
    public void testConstructCell3() {
        P = null;
        // failed case, because the program doesn't allow for input -1 in the x or y
        cell = new Cell(-1,1, P);
        Assert.assertEquals(-1,cell.x);
        Assert.assertEquals(1,cell.y);
        Assert.assertEquals(null, cell.getpiece());
    }

    // test case #4: c1b2, c2b2, c3b2 (failed)
    @Test
    public void testConstructCell4() {
        P = bk01;
        // failed case, because the program doesn't allow for input -1 in the x or y
        cell = new Cell(-1,-1, P);
        Assert.assertEquals(-1,cell.x);
        Assert.assertEquals(-1,cell.y);
        Assert.assertEquals(bk01, cell.getpiece());
    }

    // -- Functionality-based --
    // C4: p is an object that extend piece
    //      b1: true
    //      b2: false
    // C5: x is in range (0 - 7)
    //      b1: true
    //      b2: false
    // C6: y is in range (0 - 7)
    //      b1: true
    //      b2: false

    // (c4b1,c5b1,c6b2) (c4b1,c5b2,c6b1) (c4b2,c5b1,c6b1) (c4b2,c5b2,c6b2)
    // test case #5: c4b1,c5b1,c6b2
    @Test
    public void testConstructCell5() {
        P = bk01;
        cell = new Cell(1,-1, P);
        Assert.assertEquals(1,cell.x);
        Assert.assertEquals(-1,cell.y);
        Assert.assertEquals(bk01, cell.getpiece());
        Assert.assertTrue(bk01 instanceof Piece);
    }

    // test case #6: c4b1,c5b2,c6b1
    @Test
    public void testConstructCell6() {
        P = bk01;
        cell = new Cell(-1,1, P);
        Assert.assertEquals(-1,cell.x);
        Assert.assertEquals(1,cell.y);
        Assert.assertEquals(bk01, cell.getpiece());
        Assert.assertTrue(bk01 instanceof Piece);
    }

    // test case #7: c4b2,c5b1,c6b1
    // It is a feasible case but Java compiler doesn't allow "incompatible types" assertion
    // So we still show this test case but make it as a comment.
    //    @Test
    //    public void testConstructCell7() {
    //        Player player = new Player("A");
    //        cell = new Cell(7,41, player);
    //        Assert.assertEquals(7,cell.x);
    //        Assert.assertEquals(4,cell.y);
    //    }

    // test case #8: c4b2,c5b2,c6b2
    // It is a feasible case but Java compiler doesn't allow "incompatible types" assertion
    // So we still show this test case but make it as a comment.
    //    @Test
    //    public void testConstructCell7() {
    //        Player player = new Player("A");
    //        cell = new Cell(-1,-1, player);
    //        Assert.assertEquals(-1,cell.x);
    //        Assert.assertEquals(-1,cell.y);
    //    }
}