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
  
  * Functionality-based
    | Characteristic     | b1     | b2     |
    | ------------- | ------------- | -------- |
    | C4: Bishop is not block by other chess (able to move)| True| False |
    | C5: x is in range of chess board (0 - 7) | True| False |
    |C6: y is in range of chess board (0 - 7)|True| False |
* ISP Criteria: ACoC
* Test values and expected values:
Actually the expected value should be Arraylist of possible move.
However, we measure it by checking the size of that Arraylist and if there is possible move we will also assert moveable cell.
   | Test Values   | Expected Values   | 
   | ------------- | -------------     | 
   |  (7,2)        |        2          |
   |  (1,-1)       |        0           |
   |  (-1,2)         |        0            |
   |  (-1,-1)         |       0             |
   |  (0,0)         |    NullPointerException               |
   |  (0,-1)         |   NullPointerException                 |
   |  (-1,0)         |         NullPointerException          |
   |  (-1,-1)         |     NullPointerException              |
 
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
  
  * Functionality-based
    | Characteristic     | b1     | b2     |
    | ------------- | ------------- | -------- |
    | C4: Bishop is not block by other chess (able to move)| True| False |
    | C5: x is in range of chess board (0 - 7) | True| False |
    |C6: y is in range of chess board (0 - 7)|True| False |
* ISP Criteria: MBCC
* Test values and expected values:
Actually the expected value should be Arraylist of possible move.
However, we measure it by checking the size of that Arraylist and if there is possible move we will also assert moveable cell.
   | Test Values   | Expected Values   | 
   | ------------- | -------------     | 
   |  (7,3)        |        0          |
   |  (0,0)       |        NullPointerException             |
   |  (-1,3)         |        0            |
   |  (-1,3)         |       NullPointerException             |
   |  (7,-1)         |    0              |
   |  (3,-1)         |   0                 |

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
   
  * Functionality-based
    | Characteristic     | b1     | b2     |b3     |
    | ------------- | ------------- | -------- | -------- |
    | C3: Comparison of gameswon and gamesplayed| b1: gameswon < gamesplayed| b2: gameswon = gamesplayed |b3: gameswon > gamesplayed |
   
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
   |  (7,4)        |        0          |
   |  (7,-1)       |        0            |
   |  (-1,4)         |      0              |
   |  (-1,-1)         |      0            |
   |  (0,0)         |      NullPointerException            |
   |  (0,-1)         |      NullPointerException              |
   |  (-1,0)         |      NullPointerException              |
   |  (-1,-1)         |      NullPointerException              |
   |  infeasible        |      -           |
   |  infeasible         |      -              |
 
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
* ISP Criteria: BCC
* Test values and expected values:
Actually the expected value should be Arraylist of possible move.
However, we measure it by checking the size of that Arraylist and if there is possible move we will also assert moveable cell.
   | Test Values   | Expected Values   | 
   | ------------- | -------------     | 
   |  (7,1)        |        2          |
   |  (7,1)       |        NullPointerException    |
   |  (-1,1)         |      0              |
   |  (7,-1)         |      0            |

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
* ISP Criteria: MBCC
* Test values and expected values:
Actually the expected value should be Arraylist of possible move.
However, we measure it by checking the size of that Arraylist and if there is possible move we will also assert moveable cell.
   | Test Values   | Expected Values   | 
   | ------------- | -------------     | 
   |  (7,0)        |        0          |
   |  (7,-1)       |        0    |
   |  (-1,0)         |      0              |
   |  (7,0)         |      NullPointerException            |
   |  (7,-1)         |      NullPointerException              |
   |  (-1,0)         |      NullPointerException            |
