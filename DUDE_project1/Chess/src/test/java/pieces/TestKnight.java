package pieces;

import chess.Cell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestKnight {
    private Cell boardState[][];
    private Cell noChessBoard[][];
    private Cell nullBoardState[][] = null;
    private Cell knightCantMove[][];

    private ArrayList<Cell> possibleMove;
    private static Rook wr01, wr02, br01, br02;
    private static Knight wk01, wk02, bk01, bk02;
    private static Bishop wb01, wb02, bb01, bb02;
    private static Pawn wp[], bp[];
    private static Queen wq, bq;
    private static King wk, bk;
    Piece P;
    Cell cell;

    // set up default board
    @Before
    public void setUp() {
        wr01 = new Rook("WR01", "src/main/java/chess/White_Rook.png", 0);
        wr02 = new Rook("WR02", "src/main/java/chess/White_Rook.png", 0);
        br01 = new Rook("BR01", "src/main/java/chess/Black_Rook.png", 1);
        br02 = new Rook("BR02", "src/main/java/chess/Black_Rook.png", 1);
        wk01 = new Knight("WK01", "src/main/java/chess/White_Knight.png", 0);
        wk02 = new Knight("WK02", "src/main/java/chess/White_Knight.png", 0);
        bk01 = new Knight("BK01", "src/main/java/chess/Black_Knight.png", 1);
        bk02 = new Knight("BK02", "src/main/java/chess/Black_Knight.png", 1);
        wb01 = new Bishop("WB01", "src/main/java/chess/White_Bishop.png", 0);
        wb02 = new Bishop("WB02", "src/main/java/chess/White_Bishop.png", 0);
        bb01 = new Bishop("BB01", "src/main/java/chess/Black_Bishop.png", 1);
        bb02 = new Bishop("BB02", "src/main/java/chess/Black_Bishop.png", 1);
        wq = new Queen("WQ", "src/main/java/chess/White_Queen.png", 0);
        bq = new Queen("BQ", "src/main/java/chess/Black_Queen.png", 1);
        wk = new King("WK", "src/main/java/chess/White_King.png", 0, 7, 3);
        bk = new King("BK", "src/main/java/chess/Black_King.png", 1, 0, 3);
        wp = new Pawn[8];
        bp = new Pawn[8];
        for (int i = 0; i < 8; i++) {
            wp[i] = new Pawn("WP0" + (i + 1), "src/main/java/chess/White_Pawn.png", 0);
            bp[i] = new Pawn("BP0" + (i + 1), "src/main/java/chess/Black_Pawn.png", 1);
        }

        //Defining all the Cells
        boardState = new Cell[8][8];
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                P = null;
                if (i == 0 && j == 0)
                    P = br01;
                else if (i == 0 && j == 7)
                    P = br02;
                else if (i == 7 && j == 0)
                    P = wr01;
                else if (i == 7 && j == 7)
                    P = wr02;
                else if (i == 0 && j == 1)
                    P = bk01;
                else if (i == 0 && j == 6)
                    P = bk02;
                else if (i == 7 && j == 1)
                    P = wk01;
                else if (i == 7 && j == 6)
                    P = wk02;
                else if (i == 0 && j == 2)
                    P = bb01;
                else if (i == 0 && j == 5)
                    P = bb02;
                else if (i == 7 && j == 2)
                    P = wb01;
                else if (i == 7 && j == 5)
                    P = wb02;
                else if (i == 0 && j == 3)
                    P = bk;
                else if (i == 0 && j == 4)
                    P = bq;
                else if (i == 7 && j == 3)
                    P = wk;
                else if (i == 7 && j == 4)
                    P = wq;
                else if (i == 1)
                    P = bp[j];
                else if (i == 6)
                    P = wp[j];
                cell = new Cell(i, j, P);
                boardState[i][j] = cell;
            }

        // set up board with no chess where chess can move freely
        noChessBoard = new Cell[8][8];
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                P = null;
                cell = new Cell(i, j, P);
                noChessBoard[i][j] = cell;
            }

        possibleMove = null;

        // set up board with no chess so chess can move freely
        noChessBoard = new Cell[8][8];
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                P = null;
                cell = new Cell(i, j, P);
                noChessBoard[i][j] = cell;
            }

        // set up board with pawn so knight can not move
        knightCantMove = new Cell[8][8];
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                P = null;
                if(i==5&&j==0)
                    P=wp[5];
                else if(i==5&&j==2)
                    P=wp[6];
                else if(i==6&&j==3)
                    P=wp[7];
                cell = new Cell(i, j, P);
                knightCantMove[i][j] = cell;
            }

    }

    // ---------- Function: Knight.move(Cell[][] state, int x, int y) ----------
    // Combination Approach: BCC
    // -- Interface-based --
    // C1: boardState is not null
    //      b1: true
    //      b2: false
    // C2: x >= 0
    //      b1: true
    //      b2: false
    // C3: y >= 0
    //      b1: true
    //      b2: false
    // Possible Test cases = 1 + (2 - 1) + (2 - 1) + (2 - 1) = 4 cases
    //         Base Choice = (c1b1,c2b1,c3b1)
    //          Test Cases = (c1b2,c2b1,c3b1)
    //                     = (c1b1,c2b2,c3b1)
    //                     = (c1b1,c2b1,c3b2)
    // test case #1: c1b1, c2b1, c3b1

    @Test
    public void testKnightPossibleMove1() {
        possibleMove = wk01.move(boardState, 7, 1);
        Assert.assertEquals(2, possibleMove.size());
        // There is conflict in 'Cell' class on method getX(), and getY()
        // since there is x, y public attribute there would be getter for them
        // however, JPanel also has this method which has the same name
        // It ends up using the getX() and getY() from JPanel
        // we cannot test it directly, so we test the size of 'possibleMove' instead

//        int[] cellXAssertion = {5, 5};
//        int[] cellYAssertion = {0, 2};
//        int numberOfXYPair = 0;
//        for (int i = 0; i < cellXAssertion.length; i++) {
//            for (Cell cell: possibleMove) {
//                System.out.println(cell.getX() +""+ cell.getY() );
//                if (cell.getX() == cellXAssertion[i] && cell.getY() == cellYAssertion[i]) {
//                    numberOfXYPair++;
//                }
//            }
//        }
//        // if all possible move from ('cellXAssertion' and 'cellYAssertion') are in 'possibleMove'
//        // then the function return the correct result.
//        Assert.assertEquals(cellXAssertion.length, numberOfXYPair);
    }

    // test case #2: c1b2, c2b1, c3b1
    @Test
    public void testKnightPossibleMove2() {
        Assert.assertThrows(NullPointerException.class, () -> {
            wk01.move(nullBoardState, 7, 1);
        });
    }

    // test case #3: c1b1, c2b2, c3b1 (failed)
    @Test
    public void testKnightPossibleMove3() {
        possibleMove = wk01.move(boardState, -1, 1);
        Assert.assertEquals(0, possibleMove.size());
    }

    //test case #4: c1b1, c2b1, c3b2 (failed)
    @Test
    public void testKnightPossibleMove4() {
        possibleMove = wk01.move(boardState, 7, -1);
        Assert.assertEquals(0, possibleMove.size());
    }

    // -- Functionality-based --
    // C4: Knight is not block by other chess (able to move)
    //      b1: true
    //      b2: false
    // C5: x is in range (0 - 7)
    //      b1: true
    //      b2: false
    // C6: y is in range (0 - 7)
    //      b1: true
    //      b2: false
    // Possible Test cases = 1 + (2 - 1) + (2 - 1) + (2 - 1) = 4 cases
    //         Base Choice = (c1b1,c2b1,c3b1)
    //          Test Cases = (c1b2,c2b1,c3b1)
    //                     = (c1b1,c2b2,c3b1)
    //                     = (c1b1,c2b1,c3b2)

    //test case #5: c4b1, c5b1, c6b1
    @Test
    public void testKnightPossibleMove5() {
        possibleMove = wk01.move(noChessBoard, 7, 1);
        Assert.assertEquals(3, possibleMove.size());

        // There is conflict in 'Cell' class on method getX(), and getY()
        // since there is x, y public attribute there would be getter for them
        // however, JPanel also has this method which has the same name
        // It ends up using the getX() and getY() from JPanel
        // we cannot test it directly, so we test the size of 'possibleMove' instead

//        int[] cellXAssertion = {5, 5, 6};
//        int[] cellYAssertion = {0, 2, 3};
//        int numberOfXYPair = 0;
//        for (int i = 0; i < cellXAssertion.length; i++) {
//            for (Cell cell: possibleMove) {
//                System.out.println(cell.getX() +""+ cell.getY() );
//                if (cell.getX() == cellXAssertion[i] && cell.getY() == cellYAssertion[i]) {
//                    numberOfXYPair++;
//                }
//            }
//        }
//        // if all possible move from ('cellXAssertion' and 'cellYAssertion') are in 'possibleMove'
//        // then the function return the correct result.
//        Assert.assertEquals(cellXAssertion.length, numberOfXYPair);
    }

    //test case #6: c4b1, c5b1, c6b1
    @Test
    public void testKnightPossibleMove6() {
        possibleMove = wk01.move(knightCantMove, 7, 1);
        Assert.assertEquals(0, possibleMove.size());
    }

    //test case #7: c4b1, c5b2, c6b1 (failed)
    @Test
    public void testKnightPossibleMove7() {
        possibleMove = wk01.move(noChessBoard, -1, 1);
        Assert.assertEquals(0, possibleMove.size());
    }

    //test case #8: c4b1, c5b2, c6b1 (failed)
    @Test
    public void testKnightPossibleMove8() {
        possibleMove = wk01.move(noChessBoard, 7, -1);
        Assert.assertEquals(0, possibleMove.size());
    }

    // ---------- end of testing Knight.move(Cell[][] state, int x, int y) ----------
    }