package com.hbh7;

public class Knight extends ChessPiece{

    public Knight(String owner) {
        super(owner);
        pieceType = "Knight";
        pointValue = 2;
    }

    boolean checkValidMove(String currentPos, String nextPos) {

        // Run some checks first to make sure it's a valid move
        boolean moveValid = false;

        // Override atm lol
        moveValid = true;

        return moveValid;

    }
}
