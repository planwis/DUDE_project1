# 2022-ITCS473-Dude Project 1
### 1). TestBishopPossibleMove
* Goal : Test the possible move of Bishop
* Testable function: Bishop.move(Cell[][] state, int x, int y)
* Parameters: Cell[][] state, int x, int y
* Return type: ArrayList<Cell>
* Return value: The ArrayList of possible move
* exceptional behavior:- 
* Input domain:
  * interface-based
    | Characteristic     | b1     | b2     |
    | ------------- | ------------- | -------- |
    | C1: boardState is not null | True| False |
    | C2: x >= 0         | True| False |
    |C3: y >= 0|True| False |
  * Possible Test = 2 * 2 * 2 = 8 test cases
 
  * Functionality-based
    | Characteristic     | b1     | b2     |
    | ------------- | ------------- | -------- |
    | C4: Bishop is not block by other chess (able to move)| True| False |
    | C5: x is in range of chess board (0 - 7) | True| False |
    |C6: y is in range of chess board (0 - 7)|True| False |
   * Possible Test = 2 * 2 * 2 = 8 test cases
* ISP Criteria: ACoC
* Test values and expected values:
Actually the expected value should be Arraylist of possible move.
However, we measure it by checking the size of that Arraylist and if there is possible move we will also assert moveable cell.
   | Test Values   | Expected Values   | 
   | ------------- | -------------     | 
   |  (boardState, 7, 2)        |        ArrayList[]         |
   |  (boardState, 1, -1)       |        ArrayList[]           |
   |  (boardState, -1, 2)         |        ArrayList[]            |
   |  (boardState, -1, -1)         |       ArrayList[]             |
   |  (nullBoardState, 0, 0)         |    NullPointerException               |
   |  (nullBoardState, 0, -1)         |   NullPointerException                 |
   |  (nullBoardState, -1, 0)         |         NullPointerException          |
   |  (nullBoardState, -1, -1)         |     NullPointerException              |
   |  (noChessBoard, 7, 2)        |        ArrayList[(5,0)(6,1)(6,3)(5,4)(4,5)(3,6)(2,7)]          |
   |  (noChessBoard, 7, -1)        |        ArrayList[]          |
   |  (noChessBoard, -1, 2)        |        ArrayList[]          |
   |  (noChessBoard, -1, -1)        |        ArrayList[]          |
   |  (boardState, 7, 2)        |        ArrayList[]          |
   |  (boardState, 7, -1)        |        ArrayList[]         |
   |  (boardState, -1, 2)        |        ArrayList[]          |
   |  (boardState, -1, -2)        |        ArrayList[]          |
  * nullBoardState = Chess board that contain null value
  * noChessBoard = Chess board with no chess on the board
  * boardState = Chess board with all chess that are in normal starting position
 ### 2). TestQueenPossibleMove
* Goal : Test the possible move of Queen
* Testable function: Queen.move(Cell[][] state, int x, int y)
* Parameters: Cell[][] state, int x, int y
* Return type: ArrayList<Cell>
* Return value: The ArrayList of possible move
* exceptional behavior:- 
* Input domain:
  * interface-based
    | Characteristic     | b1     | b2     |
    | ------------- | ------------- | -------- |
    | C1: boardState is not null | True| False |
    | C2: x >= 0         | True| False |
    |C3: y >= 0|True| False |
* Possible Test = 2 + [{2 * (2 - 2)} + {2 * (2 - 1)} + {2 * (2 - 1)}] = 6 cases
    * Multiple Base Choice = (c1b1, c2b1, c3b1), (c1b2, c2b1, c3b1)
    * Test Cases = (c1b1, c2b2, c3b1),(c1b2, c2b2, c3b1),(c1b1, c2b1, c3b2),(c1b2, c2b1, c3b2)
* ISP Criteria: MBCC
  * Functionality-based
    | Characteristic     | b1     | b2     |
    | ------------- | ------------- | -------- |
    | C4: Bishop is not block by other chess (able to move)| True| False |
    | C5: x is in range of chess board (0 - 7) | True| False |
    |C6: y is in range of chess board (0 - 7)|True| False |
* Possible Test = 2 + [{2 * (2 - 2)} + {2 * (2 - 1)} + {2 * (2 - 1)}] = 6 cases
    * Multiple Base Choice = (c4b1, c5b1, c6b1), (c4b2, c5b1, c6b1)
    * Test Cases = (c4b1, c5b2, c6b1),(c4b2, c5b2, c6b1),(c4b1, c5b1, c6b2),(c4b2, c5b1, c6b2)
* ISP Criteria: MBCC
* Test values and expected values:
Actually the expected value should be Arraylist of possible move.
However, we measure it by checking the size of that Arraylist and if there is possible move we will also assert moveable cell.
   | Test Values   | Expected Values   | 
   | ------------- | -------------     | 
   |  (boardState, 7, 3))        |        ArrayList[]          |
   |  (nullBoardState, 0, 0)       |        NullPointerException             |
   |  (boardState, -1, 3)         |        ArrayList[]            |
   |  (nullBoardState, -1, 3)         |       NullPointerException             |
   |  (boardState, 7, -1)         |    ArrayList[]              |
   |  (boardState, 3, -1)         |   ArrayList[]                 |
   |  (noChessBoard, 7, 3)        |       ArrayList [(7,0),(7,1),(7,2),(7,3),(6,3),(5,2),(4,1),(3,0),(6,4),(5,4),(4,4),(3,4),(2,4),(1,4),(0,4),(6,5),(5,6),(4,7),(7,5),(7,6),(7,7)]|
   |  (boardState, 7, 3)       |        ArrayList[]             |
   |  (noChessBoard, -1, 3)         |        ArrayList[]            |
   |  (boardState, -1, 3)         |       ArrayList[]             |
   |  (noChessBoard, 7, -1)         |    ArrayList[]              |
   |  (boardState, 7, -1)         |   ArrayList[]                 |

 ### 3). TestPlayer
* Goal : The win percentage of the player
* Testable function: winpercent()
* Parameters: gameswon, gamesplayed (implicit parameter)
* Return type:  Integer
* Return value: win percentage
* Exceptional behavior:- 
* Input domain:
  * interface-based
    | Characteristic     | b1     | b2     |
    | ------------- | ------------- | -------- |
    | C1: value of gameswon | greater than 0| equal to 0 |
    | C2: value of gameplayed      | greater than 0| equal to 0 |
* Possible test cases = 3 * 2 = 6 test cases
  * Functionality-based
    | Characteristic     | b1     | b2     |b3     |
    | ------------- | ------------- | -------- | -------- |
    | C3: Comparison of gameswon and gamesplayed| b1: gameswon < gamesplayed| b2: gameswon = gamesplayed |b3: gameswon > gamesplayed |
* Possible test cases = 3 * 2 = 6 test cases
    * Test Cases = (c1b1, c2b1, c3b1), (c1b1, c2b2, c3b3), (c1b2, c2b1, c3b2), (c1b2, c2b2, c3b1), (c1b1, c2b2, c3b2), (c1b2, c2b1, c3b3)
* ISP Criteria: PWC
* Test values and expected values:
   | Test Values   | Expected Values   | 
   | ------------- | -------------     | 
   |  (4,5)        |        80          |
   |  (4,0)       |     ArithmeticException         |
   |     infeasible       |       -          |
   |     infeasible       |      -            |
   |    infeasible     |       -    |
   |     infeasible      |      -         |
 

 ### 4). TestKingPossibleMove
*  Goal : Test the possible move of King
* Testable function: King.move(Cell[][] state, int x, int y)
* Parameters: Cell[][] state, int x, int y
* Return type: ArrayList<Cell>
* Return value: The ArrayList of possible move
* Exceptional behavior:- 
* Input domain:
  * interface-based
    | Characteristic     | b1     | b2     |
    | ------------- | ------------- | -------- |
    | C1: boardState is not null | True| False |
    | C2: x >= 0         | True| False |
    | C3: y >= 0|True| False |
  
  * Functionality-based
    | Characteristic     | b1     | b2     |
    | ------------- | ------------- | -------- |
    | C4: King is not block by other chess (able to move)| True| False |
    | C5: x is in range of chess board (0 - 7) | True| False |
    | C6: y is in range of chess board (0 - 7)|True| False |
* ISP Criteria: ACoC
* Test values and expected values:
Actually the expected value should be Arraylist of possible move.
However, we measure it by checking the size of that Arraylist and if there is possible move we will also assert moveable cell.
   | Test Values   | Expected Values   | 
   | ------------- | -------------     | 
   |  (boardState, 7, 4)       |        ArrayList[]          |
   |  (boardState, 7, -1)       |        ArrayList[]            |
   |  (boardState, -1, 4)         |      ArrayList[]              |
   |  (boardState, -1, -1)         |      ArrayList[]            |
   |  (nullBoardState, 0, 0)         |      NullPointerException            |
   |  (nullBoardState, 0, -1)         |      NullPointerException              |
   |  (nullBoardState, -1, 0)          |      NullPointerException              |
   |  (nullBoardState, -1, -1)          |      NullPointerException              |

   |  (noChessBoard, 7, 4)       |        ArrayList[(7,3)(6,3)(6,4)(6,5)(7,5)]         |
   |  (noChessBoard, 7, -1)       |        ArrayList[]            |
   |  (noChessBoard, -1, 4)         |      ArrayList[]              |
   |  (noChessBoard, -1, -1)         |      ArrayList[]            |
   |  (boardState, 7, 4)         |      ArrayList[]             |
   |  (boardState, 7, -1)         |      ArrayList[]               |
   |  (boardState, -1, 4)          |      ArrayList[]              |
   |  (boardState, -1, -1)          |      ArrayList[]               |

 ### 5). TestKnightPossibleMove
* Goal : Test the possible move of Knight
* Testable function: Knight.move(Cell[][] state, int x, int y)
* Parameters: Cell[][] state, int x, int y
* Return type: ArrayList<Cell>
* Return value: The ArrayList of possible move
* Exceptional behavior:- 
* Input domain:
  * interface-based
    | Characteristic     | b1     | b2     |
    | ------------- | ------------- | -------- |
    | C1: boardState is not null | True| False |
    | C2: x >= 0         | True| False |
    | C3: y >= 0|True| False |
  
  * Functionality-based
    | Characteristic     | b1     | b2     |
    | ------------- | ------------- | -------- |
    | C4: King is not block by other chess (able to move)| True| False |
    | C5: x is in range of chess board (0 - 7) | True| False |
    | C6: y is in range of chess board (0 - 7)|True| False |
* Possible Test = 1 + (2 - 1) + (2 - 1) + (2 - 1) = 4 cases
    * Base Choice = (c1b1,c2b1,c3b1)
    * Test Cases = (c1b2,c2b1,c3b1),(c1b1,c2b2,c3b1),(c1b1,c2b1,c3b2)
* ISP Criteria: BCC
* Test values and expected values:
Actually the expected value should be Arraylist of possible move.
However, we measure it by checking the size of that Arraylist and if there is possible move we will also assert moveable cell.
   | Test Values   | Expected Values   |  
   | ------------- | -------------     | 
   |  (boardState, 7, 1)        | ArrayList[(5,0),(5,2)]                |
   |  (nullBoardState, 7, 1)       |        NullPointerException    |
   |  (boardState, -1, 1)         |     ArrayList[]               |
   |  (boardState, 7, -1)         |     ArrayList[]            |
   |  (noChessBoard, 7, 1)         |    ArrayList[(5,0),(5,2),(6,3)]          |
   |  (knightCantMove, 7, 1)         |      ArrayList[]          |
   |  (noChessBoard, -1, 1)         |      ArrayList[]            |
   |  (noChessBoard, 7, -1)         |      ArrayList[]           |
  * nullBoardState = Chess board that contain null value
  * noChessBoard = Chess board with no chess on the board
  * boardState = Chess board with all chess that are in normal starting position
  * knightCantMove = Chess board that set white knight1 on cell (7,1) and was blocked by pawn at cell (5,0) (5,2) and (6,3)
### 6). TestRookPossibleMove
* Goal : Test the possible move of Rook
* Testable function: Rook.move(Cell[][] state, int x, int y)
* Parameters: Cell[][] state, int x, int y
* Return type: ArrayList<Cell>
* Return value: The ArrayList of possible move
* Exceptional behavior:- 
* Input domain:
  * interface-based
    | Characteristic     | b1     | b2     |
    | ------------- | ------------- | -------- |
    | C1: boardState is not null | True| False |
    | C2: x >= 0         | True| False |
    | C3: y >= 0|True| False |
  
  * Functionality-based
    | Characteristic     | b1     | b2     |
    | ------------- | ------------- | -------- |
    | C4: Rook is not block by other chess (able to move)| True| False |
    | C5: x is in range of chess board (0 - 7) | True| False |
    | C6: y is in range of chess board (0 - 7)|True| False |
 * Possible Test cases = 2+ [{2* (2-2)} + {2* (2-2)} + {2* (2-2)}] = 6 Cases
    * Multiple Base Choice = (c1b1, c2b1, c3b1) (c1b2, c2b1, c3b1)
    * Test Cases = (c1b1, c2b1, c3b2),(c1b2, c2b1, c3b2),(c1b1, c2b2, c3b1),(c1b2, c2b2, c3b1)
* ISP Criteria: MBCC
* Test values and expected values:
Actually the expected value should be Arraylist of possible move.
However, we measure it by checking the size of that Arraylist and if there is possible move we will also assert moveable cell.
   | Test Values   | Expected Values   | 
   | ------------- | -------------     | 
   |  (boardState, 7, 0)        |        ArrayList[]          |
   |  (boardState, 7, -1)       |        ArrayList[]    |
   |  (boardState, -1, 0)         |      ArrayList[]              |
   |  (nullBoardState, 7, 0)         |      NullPointerException            |
   |  (nullBoardState, 7, -1)         |      NullPointerException              |
   |  (nullBoardState, -1, 0)         |      NullPointerException            |
    |  (noChessBoard, 7, 0)        |        ArrayList[(6,0),(5,0),(4,0),(3,0),(2,0),(1,0),(0,0),(7,1),(7,2),(7,3),(7,4),(7,5),(7,6),(7,7)]          |
    |  (noChessBoard, 7, -1)        |        ArrayList[]          |
    |  (noChessBoard, -1, 0)        |        ArrayList[]          |
    |  (boardState, 7, 0)        |        ArrayList[]          |
    |  (boardState, 7, -1)        |        ArrayList[]          |
    |  (boardState, -1, 0)        |        ArrayList[]          |
  * nullBoardState = Chess board that contain null value
  * noChessBoard = Chess board with no chess on the board
  * boardState = Chess board with all chess that are in normal starting position
 ### 7). TestPawnPossibleMove
* Goal : Test the possible move of Rook
* Testable function: Pawn.move(Cell[][] state, int x, int y)
* Parameters: Cell[][] state, int x, int y
* Return type: ArrayList<Cell>
* Return value: The ArrayList of possible move
* Exceptional behavior:- 
* Input domain:
  * interface-based
    | Characteristic     | b1     | b2     |
    | ------------- | ------------- | -------- |
    | C1: boardState is not null | True| False |
    | C2: x >= 0         | True| False |
    | C3: y >= 0|True| False |
  
  * Functionality-based
    | Pawn is not block by other chess (able to move)  | b1     | b2     |
    | ------------- | ------------- | -------- |
    | C4: Rook is not block by other chess (able to move)| True| False |
    | C5: x is in range of chess board (0 - 7) | True| False |
    | C6: y is in range of chess board (0 - 7)|True| False |
* Possible Test cases = 1 + (2 - 1) + (2 - 1) + (2 - 1) = 4 cases
    * Base Choice = (c4b1,c5b1,c6b1)
    * Test Cases = (c4b2,c5b1,c6b1),(c4b1,c5b2,c6b1),(c4b1,c5b1,c6b2)
* ISP Criteria: BCC
* Test values and expected values:
Actually the expected value should be Arraylist of possible move.
However, we measure it by checking the size of that Arraylist and if there is possible move we will also assert moveable cell.
| Test Values   | Expected Values   | 
   | ------------- | -------------     | 
   |  (boardState,6,1)        |        ArrayList[(5,1)(4,1)]         |
   |  (nullBoardState,6,1)       |        NullPointerException   |
   |  (boardState,-1,1)         |      ArrayList[]              |
   |  (boardState, 6, -1)         |      ArrayList[]          |
   |  (boardState, 6, 1)         |      ArrayList[(5,1)(4,1)]              |
   |  (nullBoardState, 6, 1)         |      NullPointerException            |
   |  (boardState, -1, 1)         |      ArrayList[]          |
   |  (boardState, 6, -1)         |      ArrayList[]           |
  * nullBoardState = Chess board that contain null value
  * noChessBoard = Chess board with no chess on the board
  * boardState = Chess board with all chess that are in normal starting position
 ### 8). testKingIsInDanger
* Goal : Test that king is under threat or not
* Parameters: Cell state[][]
* Return type: Boolean
* Return value: True if king was attacked from the opposite color otherwise False
* Input domain:
  * interface-based(C1) + Functionality-based(C2)
    | Characteristic     | b1     | b2     |
    | ------------- | ------------- | -------- |
    | C1: state is null | True| False |
    | C2: king has no legal moves (Stalemate)| True| False |
* ISP Criteria: PWC
* Possible Test = 2 * 2 = 4 cases
* ISP Criteria: PWC
* Test values and expected values:

   | Test Values   | Expected Values   |  
   | ------------- | -------------     | 
   |  infeasible test        | -                |
   |  infeasible test       |        -    |
   |  (kingGotStaleMateBoard)         |     True               |
   |  (boardState)         |     False            |

C1-C2: (c1b1,c2b1) (c1b1,c2b2) (c1b2,c2b1) (c1b2,c2b2)

C2-C1: (c2b1,c1b1) (c2b1,c1b2) (c2b2,c1b1) (c2b2,c1b2)

select test case: (c1b1,c2b1) (c1b1,c2b2) (c1b2,c2b1) (c1b2,c2b2)

// test case #1: c1b1, c2b1
// test case #2: c1b1, c2b2
// test case #3: c1b2, c2b1
// test case #4: c1b2, c2b2
  
