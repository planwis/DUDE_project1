import chess.Cell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pieces.*;

import java.util.ArrayList;

public class TestCaseDUDE {
    private Cell boardState[][];
    private static Rook wr01,wr02,br01,br02;
    private static Knight wk01,wk02,bk01,bk02;
    private static Bishop wb01,wb02,bb01,bb02;
    private static Pawn wp[],bp[];
    private static Queen wq,bq;
    private static King wk,bk;
    pieces.Piece P;
    Cell cell;

    // set up default board
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

        //Defining all the Cells
        boardState=new Cell[8][8];
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
            {
                P=null;
                if(i==0&&j==0)
                    P=br01;
                else if(i==0&&j==7)
                    P=br02;
                else if(i==7&&j==0)
                    P=wr01;
                else if(i==7&&j==7)
                    P=wr02;
                else if(i==0&&j==1)
                    P=bk01;
                else if (i==0&&j==6)
                    P=bk02;
                else if(i==7&&j==1)
                    P=wk01;
                else if (i==7&&j==6)
                    P=wk02;
                else if(i==0&&j==2)
                    P=bb01;
                else if (i==0&&j==5)
                    P=bb02;
                else if(i==7&&j==2)
                    P=wb01;
                else if(i==7&&j==5)
                    P=wb02;
                else if(i==0&&j==3)
                    P=bk;
                else if(i==0&&j==4)
                    P=bq;
                else if(i==7&&j==3)
                    P=wk;
                else if(i==7&&j==4)
                    P=wq;
                else if(i==1)
                    P=bp[j];
                else if(i==6)
                    P=wp[j];
                cell=new Cell(i,j,P);
                boardState[i][j]=cell;
            }
    }

    @Test
    public void testBishopPossibleMove() {
        // Combination Approach: ACoC
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

        ArrayList<Cell> possibleMove;
        Cell nullBoardState[][] = null;

        // test case #1: c1b1, c2b1, c3b1
        possibleMove = null;
        possibleMove = wb01.move(boardState, 7, 2);
        Assert.assertEquals(0, possibleMove.size());

        // test case #2: c1b1, c2b1, c3b2 (failed)
        possibleMove = null;
        possibleMove = wb01.move(boardState, 1, -1);
        Assert.assertEquals(0, possibleMove.size());

        // test case #3: c1b1, c2b2, c3b1 (failed)
        possibleMove = null;
        possibleMove = wb01.move(boardState, -1, 2);
        Assert.assertEquals(0, possibleMove.size());

        // test case #4: c1b1, c2b2, c3b2 (failed)
        possibleMove = null;
        possibleMove = wb01.move(boardState, -1, -1);
        Assert.assertEquals(0, possibleMove.size());


        // test case #5: c1b2, c2b1, c3b1
        possibleMove = null;
        Assert.assertThrows(NullPointerException.class, () -> {
            wb01.move(nullBoardState, 0, 0);
        });

        // test case #6: c1b2, c2b1, c3b2
        possibleMove = null;
        Assert.assertThrows(NullPointerException.class, () -> {
            wb01.move(nullBoardState, 0, -1);
        });

        // test case #7: c1b2, c2b2, c3b1
        possibleMove = null;
        Assert.assertThrows(NullPointerException.class, () -> {
            wb01.move(nullBoardState, -1, 0);
        });

        // test case #8: c1b2, c2b2, c3b2
        possibleMove = null;
        Assert.assertThrows(NullPointerException.class, () -> {
            wb01.move(nullBoardState, -1, -1);
        });

        // -- Functionality-based --
        // C4: Bishop is not block by other chess (able to move)
        //      b1: true
        //      b2: false
        // C5: x is in range (0 - 7)
        //      b1: true
        //      b2: false
        // C6: y is in range (0 - 7)
        //      b1: true
        //      b2: false

        // set up board with no chess so chess can move freely
        Cell[][] noChessBoard = new Cell[8][8];
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
            {
                P=null;
                cell=new Cell(i,j,P);
                noChessBoard[i][j]=cell;
            }

        // test case #1: c4b1, c5b1, c6b1
        possibleMove = null;
        possibleMove = wb01.move(noChessBoard, 7, 2);
        Assert.assertEquals(7, possibleMove.size());

        // test case #2: c4b1, c5b1, c6b2 (failed)
        possibleMove = null;
        possibleMove = wb01.move(noChessBoard, 7, -1);
        Assert.assertEquals(0, possibleMove.size());

        // test case #3: c4b1, c5b2, c6b1 (failed)
        possibleMove = null;
        possibleMove = wb01.move(noChessBoard, -1, 2);
        Assert.assertEquals(0, possibleMove.size());

        // test case #4: c4b1, c5b2, c6b2 (failed)
        possibleMove = null;
        possibleMove = wb01.move(noChessBoard, -1, -1);
        Assert.assertEquals(0, possibleMove.size());

        // test case #5: c4b2, c5b1, c6b1
        possibleMove = null;
        possibleMove = wb01.move(boardState, 7, 2);
        Assert.assertEquals(0, possibleMove.size());

        // test case #6: c4b2, c5b1, c6b2
        possibleMove = null;
        possibleMove = wb01.move(boardState, 7, -1);
        Assert.assertEquals(0, possibleMove.size());

        // test case #7: c4b2, c5b2, c6b1 (failed)
        possibleMove = null;
        possibleMove = wb01.move(boardState, -1, 2);
        Assert.assertEquals(0, possibleMove.size());

        // test case #8: c4b2, c5b2, c6b2 (failed)
        possibleMove = null;
        possibleMove = wb01.move(boardState, -1, -1);
        Assert.assertEquals(0, possibleMove.size());
    }

    @Test
    public void testQueenPossibleMove() {
        // Combination Approach: MBCC
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
        // Possible test cases  = 2 + [{2 * (2 - 2)} + {2 * (2 - 1)} + {2 * (2 - 1)}]
        //                      = 6 cases
        // Multiple Base Choice = (c1b1, c2b1, c3b1) (c1b2, c2b1, c3b1)
        //           Test Cases = (c1b1, c2b2, c3b1) (c1b2, c2b2, c3b1)
        //                      = (c1b1, c2b1, c3b2) (c1b2, c2b1, c3b2)

        ArrayList<Cell> possibleMove;
        Cell nullBoardState[][] = null;

        // test case #1: c1b1, c2b1, c3b1
        possibleMove = null;
        possibleMove = wq.move(boardState, 7, 3);
        Assert.assertEquals(0, possibleMove.size());

        // test case #2: c1b2, c2b1, c3b1
        possibleMove = null;
        Assert.assertThrows(NullPointerException.class, () -> {
            wq.move(nullBoardState, 0, 0);
        });

        // test case #3: c1b1, c2b2, c3b1 (failed)
        possibleMove = null;
        possibleMove = wq.move(boardState, -1, 3);
        Assert.assertEquals(0, possibleMove.size());

        // test case #4: c1b2, c2b2, c3b1
        possibleMove = null;
        Assert.assertThrows(NullPointerException.class, () -> {
            wq.move(nullBoardState, -1, 3);
        });

        // test case #5: c1b1, c2b1, c3b2 (failed)
        possibleMove = null;
        wq.move(boardState, 7, -1);
        Assert.assertEquals(0, possibleMove.size());

        // test case #6: c1b2, c2b1, c3b2 (failed)
        possibleMove = null;
        possibleMove = wq.move(boardState, 3, -1);
        Assert.assertEquals(0, possibleMove.size());

        // -- Functionality-based --
        // C4: Queen is not block by other chess (able to move)
        //      b1: true
        //      b2: false
        // C5: x is in range (0 - 7)
        //      b1: true
        //      b2: false
        // C6: y is in range (0 - 7)
        //      b1: true
        //      b2: false
        // Possible test cases  = 2 + [{2 * (2 - 2)} + {2 * (2 - 1)} + {2 * (2 - 1)}]
        //                      = 6 cases
        // Multiple Base Choice = (c4b1, c5b1, c6b1) (c4b2, c5b1, c6b1)
        //           Test Cases = (c4b1, c5b2, c6b1) (c4b2, c5b2, c6b1)
        //                      = (c4b1, c5b1, c6b2) (c4b2, c5b1, c6b2)

        // set up board with no chess so chess can move freely
        Cell[][] noChessBoard = new Cell[8][8];
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
            {
                P=null;
                cell=new Cell(i,j,P);
                noChessBoard[i][j]=cell;
            }

        // test case #1: c4b1, c5b1, c6b1
        possibleMove = null;
        possibleMove = wq.move(noChessBoard, 7, 3);
        Assert.assertEquals(21, possibleMove.size());

        // test case #2: c4b2, c5b1, c6b1
        possibleMove = null;
        possibleMove = wq.move(boardState, 7, 3);
        Assert.assertEquals(0, possibleMove.size());

        // test case #3: c4b1, c5b2, c6b1 (failed)
        possibleMove = null;
        possibleMove = wq.move(noChessBoard, -1, 3);
        Assert.assertEquals(0, possibleMove.size());

        // test case #4: c4b2, c5b2, c6b1 (failed)
        possibleMove = null;
        possibleMove = wq.move(boardState, -1, 3);
        Assert.assertEquals(0, possibleMove.size());

        // test case #5: c4b1, c5b1, c6b2 (failed)
        possibleMove = null;
        possibleMove = wq.move(noChessBoard, 7, -1);
        Assert.assertEquals(0, possibleMove.size());

        // test case #6: c4b2, c5b1, c6b2 (failed)
        possibleMove = null;
        possibleMove = wq.move(boardState, 7, -1);
        Assert.assertEquals(0, possibleMove.size());
    }

    @Test
    public void testKingPossibleMove() {
        // Combination Approach: ACoC
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

        ArrayList<Cell> possibleMove;
        Cell nullBoardState[][] = null;

        // test case #1: c1b1, c2b1, c3b1
        possibleMove = null;
        possibleMove = wk.move(boardState, 7, 4);
        Assert.assertEquals(0, possibleMove.size());

        // test case #2: c1b1, c2b1, c3b2 (failed)
        // The program should be crashed since input -1 is invalid. However, it returns 0, which is not correct.
        possibleMove = null;
        possibleMove = wk.move(boardState, 7, -1);
        Assert.assertEquals(0, possibleMove.size());

        // test case #3: c1b1, c2b2, c3b1 (failed)
        possibleMove = null;
        possibleMove = wk.move(boardState, -1, 4);
        Assert.assertEquals(0, possibleMove.size());

        // test case #4: c1b1, c2b2, c3b2 (failed)
        possibleMove = null;
        possibleMove = wk.move(boardState, -1, -1);
        Assert.assertEquals(0, possibleMove.size());

        // test case #5: c1b2, c2b1, c3b1
        possibleMove = null;
        Assert.assertThrows(NullPointerException.class, () -> {
            wk.move(nullBoardState, 0, 0);
        });

        // test case #6: c1b2, c2b1, c3b2
        Assert.assertThrows(NullPointerException.class, () -> {
            wk.move(nullBoardState, 0, -1);
        });

        // test case #7: c1b2, c2b2, c3b1
        Assert.assertThrows(NullPointerException.class, () -> {
            wk.move(nullBoardState, -1, 0);
        });

        // test case #8: c1b2, c2b2, c3b2
        Assert.assertThrows(NullPointerException.class, () -> {
            wk.move(nullBoardState, -1, -1);
        });

        // -- Functionality-based --
        // C4: King is not block by other chess (able to move)
        //      b1: true
        //      b2: false
        // C5: x is in range (0 - 7)
        //      b1: true
        //      b2: false
        // C6: y is in range (0 - 7)
        //      b1: true
        //      b2: false

        // set up board with no chess so chess can move freely
        Cell[][] noChessBoard = new Cell[8][8];
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
            {
                P=null;
                cell=new Cell(i,j,P);
                noChessBoard[i][j]=cell;
            }

        // test case #1: c4b1, c5b1, c6b1
        possibleMove = null;
        possibleMove = wk.move(noChessBoard, 7, 4);
        Assert.assertEquals(5, possibleMove.size());

        // test case #2: c4b1, c5b1, c6b2 (failed)
        possibleMove = null;
        possibleMove = wk.move(noChessBoard, 7, -1);
        Assert.assertEquals(0, possibleMove.size());

        // test case #3: c4b1, c5b2, c6b1 (failed)
        possibleMove = null;
        possibleMove = wk.move(noChessBoard, -1, 4);
        Assert.assertEquals(0, possibleMove.size());

        // test case #4: c4b1, c5b2, c6b2 (failed)
        possibleMove = null;
        possibleMove = wk.move(noChessBoard, -1, -1);
        Assert.assertEquals(0, possibleMove.size());

        // test case #5: c4b2, c5b1, c6b1
        possibleMove = null;
        possibleMove = wk.move(boardState, 7, 4);
        Assert.assertEquals(0, possibleMove.size());

        // test case #6: c4b2, c5b1, c6b2
        possibleMove = null;
        possibleMove = wk.move(boardState, 7, -1);
        Assert.assertEquals(0, possibleMove.size());

        // test case #7: c4b2, c5b2, c6b1 (failed)
        possibleMove = null;
        possibleMove = wk.move(boardState, -1, 4);
        Assert.assertEquals(0, possibleMove.size());

        // test case #8: c4b2, c5b2, c6b2 (failed)
        possibleMove = null;
        possibleMove = wk.move(boardState, -1, -1);
        Assert.assertEquals(0, possibleMove.size());
    }

    @Test
    public void testRookPossibleMove() {
        // Combination Approach: MBCC
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
        // Base Choice = (c1b1, c2b1, c3b1) (c1b2, c2b1, c3b1)
        //   Test case = (c1b1, c2b1, c3b2) (c1b2, c2b1, c3b2)
        //             = (c1b1, c2b2, c3b1) (c1b2, c2b2, c3b1)
        // Possible test cases: 2+ [{2* (2-2)} + {2* (2-2)} + {2* (2-2)}] = 6 Cases

        ArrayList<Cell> possibleMove;
        Cell nullBoardState[][] = null;

        // test case #1: c1b1, c2b1, c3b1
        possibleMove = null;
        possibleMove = wr01.move(boardState, 7, 0);
        Assert.assertEquals(0, possibleMove.size());

        // test case #2: c1b1, c2b1, c3b2 (failed)
        possibleMove = null;
        possibleMove = wr01.move(boardState, 7, -1);
        Assert.assertEquals(0, possibleMove.size());

        // test case #3: c1b1, c2b2, c3b1 (failed)
        possibleMove = null;
        possibleMove = wr01.move(boardState, -1, 0);
        Assert.assertEquals(0, possibleMove.size());

        // test case #4: c1b2, c2b1, c3b1
        possibleMove = null;
        Assert.assertThrows(NullPointerException.class, () -> {
            wr01.move(nullBoardState, 7, 0);
        });

        // test case #5: c1b2, c2b1, c3b2
        possibleMove = null;
        Assert.assertThrows(NullPointerException.class, () -> {
            wr01.move(nullBoardState, 7, -1);
        });

        // test case #6: c1b2, c2b2, c3b1
        possibleMove = null;
        Assert.assertThrows(NullPointerException.class, () -> {
            wr01.move(nullBoardState, -1, 0);
        });

        // -- Functionality-based --
        // C4: Rook is not block by other chess (able to move)
        //      b1: true
        //      b2: false
        // C5: x is in range (0 - 7)
        //      b1: true
        //      b2: false
        // C6: y is in range (0 - 7)
        //      b1: true
        //      b2: false

        // set up board with no chess so chess can move freely
        Cell[][] noChessBoard = new Cell[8][8];
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
            {
                P=null;
                cell=new Cell(i,j,P);
                noChessBoard[i][j]=cell;
            }

        // test case #1: c4b1, c5b1, c6b1
        possibleMove = null;
        possibleMove = wr01.move(noChessBoard, 7, 0);
        Assert.assertEquals(14, possibleMove.size());

        // test case #2: c4b1, c5b1, c6b2 (failed)
        possibleMove = null;
        possibleMove = wr01.move(noChessBoard, 7, -1);
        Assert.assertEquals(0, possibleMove.size());

        // test case #3: c4b1, c5b2, c6b1 (failed)
        possibleMove = null;
        possibleMove = wr01.move(noChessBoard, -1, 0);
        Assert.assertEquals(0, possibleMove.size());

        // test case #4: c4b2, c5b1, c6b1
        possibleMove = null;
        possibleMove = wr01.move(boardState, 7, 0);
        Assert.assertEquals(0, possibleMove.size());

        // test case #5: c4b2, c5b1, c6b2 (failed)
        possibleMove = null;
        possibleMove = wr01.move(boardState, 7, -1);
        Assert.assertEquals(0, possibleMove.size());

        // test case #6: c4b2, c5b2, c6b1 (failed)
        possibleMove = null;
        possibleMove = wr01.move(boardState, -1, 0);
        Assert.assertEquals(0, possibleMove.size());
    }

    @Test
    public void testPawn1PossibleMove(){
        ArrayList<Cell> possibleMove;
        Cell nullBoardState[][] = null;
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

        //test case #1: c1b1,c2b1,c3b1
        possibleMove = null;
        possibleMove = wp[1].move(boardState, 6, 1);
        Assert.assertEquals(2, possibleMove.size());

        //test case #2: c1b2,c2b1,c3b1
        possibleMove = null;
        Assert.assertThrows(NullPointerException.class, () -> {
            wp[1].move(nullBoardState, 6, 1);
        });

        //test case #3:c1b1,c2b2,c3b1  (failed)
        possibleMove = null;
        possibleMove = wp[1].move(boardState, -1, 1);
        Assert.assertEquals(0, possibleMove.size());

        //test case #4:c1b1,c2b1,c3b2 (failed)
        possibleMove = null;
        possibleMove = wp[1].move(boardState, 6, -1);
        Assert.assertEquals(0, possibleMove.size());

        // -- Functionality-based --
        // C4: Pawn is not block by other chess (able to move)
        //      b1: true
        //      b2: false
        // C5: x is in range (0 - 7)
        //      b1: true
        //      b2: false
        // C6: y is in range (0 - 7)
        //      b1: true
        //      b2: false
        // Possible Test cases = 1 + (2 - 1) + (2 - 1) + (2 - 1) = 4 cases
        //         Base Choice = (c4b1,c5b1,c6b1)
        //          Test Cases = (c4b2,c5b1,c6b1)
        //                     = (c4b1,c5b2,c6b1)
        //                     = (c4b1,c5b1,c6b2)

        //test case #1: c4b1,c5b1,c6b1
        possibleMove = null;
        possibleMove = wp[1].move(boardState, 6, 1);
        Assert.assertEquals(2, possibleMove.size());

        //test case #2: c4b2,c5b1,c6b1
        possibleMove = null;
        Assert.assertThrows(NullPointerException.class, () -> {
            wp[1].move(nullBoardState, 6, 1);
        });

        //test case #3:c4b1,c5b2,c6b1 (failed)
        possibleMove = null;
        possibleMove = wp[1].move(boardState, -1, 1);
        Assert.assertEquals(0, possibleMove.size());

        //test case #4:c4b1,c5b1,c6b2 (failed)
        possibleMove = null;
        possibleMove = wp[1].move(boardState, 6, -1);
        Assert.assertEquals(0, possibleMove.size());
    }
}
