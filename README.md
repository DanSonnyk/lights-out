CHALLENGE: Lights Out
Goal:
    Arrange all pieces on a board such that cell on the board has a final value of 0.

    Restrictions:
    Board: each cell starts with an initial value and a Global "depth" value.
    Placing a piece increments the valid value of overlapping cells on the board.
    If a cell's value reaches the "depth" of the placed piece, it resets to 0.
    The boards and pieces can have many shapes and sizes
    All pieces needs to be used
    The pieces cannot be rotated or exceed the board limits
    The x,y seams columns, lines coordinates
    After verify all pieces on the board returns the coordinate for each piece that all board = 0

Principal Approach: combinatorial analysis approach

Steps to solve:
- parse initial rows to board 
- parse initialPieces to piece in board 
- Generate all possible positions for a piece in the board
- Apply depth rules in a combinatorial analysis approach

Stack to run:
- Java 22
- Junit 5

To Run:
Run MainTest class.
