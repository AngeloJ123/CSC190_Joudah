# CSC190_Joudah
Final project for software Engineering, CSC 190


*IMPORTANT* - In order to run the MilanChess.exe file, you will need a Java Runtime Environment version of 15.0.2. The libraries for JavaFX are included in the exe file. The rest of the code in the file is uploaded for viewing purposes. Here's a summary:

                            1. game.java - this file is extremley important, it contains the class game() which handles all virtual actions on
                            the board. The board is represented as a 2d array/matrix of type Piece[][]. Despite the type, it will only ever hold
                            subclasses of the superclass Piece, since all pieces are subclasses of the Piece class.
                            2. PieceModel.java - this file is an abstract class for subclasses that will inherit its attributes and methods
                            Files like knight.java, bishop.java, etc. will inherit the method create and attribute Shape p. Both are used in
                            creating and assigning the visual model of the piece to the board
                            3. Piece.java - another abstract class used for the virtual models of pieces.
                            4. MatrixSearcher.java - a class with a function called Search. Search is an overloaded method that can take different
                            subclass instantiations of Piece (i.e KingPiece, BishopPiece, etc.) and searches the 2d matrix in the game class for
                            possible moves for the pieces.
                            5. CoordNode - a node class that stores x and y coordinates of where the user clicks on the screen
                            6. Board.java - Holds the primary window "Primary Stage" in the start function. This file handles the user input via
                            event driven programming.
                            7. PromotionBox - handles promotions by opening a new window. When a promotion is selected for the pawn, the window is closed.
