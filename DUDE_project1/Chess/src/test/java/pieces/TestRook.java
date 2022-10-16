package pieces;

import chess.Cell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pieces.*;

import java.util.ArrayList;

public class TestRook {
    private Cell boardState[][];
    private Cell noChessBoard[][];
    private Cell nullBoardState[][] = null;

    private ArrayList<Cell> possibleMove;
    private static Rook wr01, wr02, br01, br02;
    private static Knight wk01, wk02, bk01, bk02;
    private static Bishop wb01, wb02, bb01, bb02;
    private static Pawn wp[], bp[];
    private static Queen wq, bq;
    private static King wk, bk;
    pieces.Piece P;
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
    }

    // ---------- Function: Rook.move(Cell[][] state, int x, int y) ----------

    // ---------- end of testing Rook.move(Cell[][] state, int x, int y) ----------
}