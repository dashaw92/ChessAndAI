package com.hbh7.pieces;

import static com.hbh7.Util.*;

public class Bishop extends ChessPiece{

    public Bishop(Team owner, String position) {
        super("Bishop", owner, position);
        this.pieceValue = 3;
    }

    public boolean checkValidMove_movePatternValidCheck(int playerNum, int originalRow, String originalColumn, int newRow, String newColumn, ChessPiece[][] boardArray) {

        // Check that the move pattern requested is valid
        // Ex: Bishop can move diagonal in any direction an unlimited number of spaces until it hits the border or
        // another piece. It is stuck on one color forever.

        if(Math.abs(toArrayIndex(originalRow)-toArrayIndex(newRow)) == Math.abs(toArrayIndex(originalColumn)-toArrayIndex(newColumn))) {

            int distance = Math.abs(toArrayIndex(originalRow)-toArrayIndex(newRow));

            if(toArrayIndex(newRow) < toArrayIndex(originalRow) && toArrayIndex(newColumn) > toArrayIndex(originalColumn)) { // going to top right
                for(int i = 1; i < distance; i++) {
                    if(boardArray[toArrayIndex(originalRow)-i][toArrayIndex(originalColumn)+i] != null) {
                        System.out.println("Bishop: Invalid Move. Piece(s) obstructing path.");
                        return false;
                    }
                }
                return true;

            } else if(toArrayIndex(newRow) < toArrayIndex(originalRow) && toArrayIndex(newColumn) < toArrayIndex(originalColumn)) { // going to top left
                for(int i = 1; i < distance; i++) {
                    if(boardArray[toArrayIndex(originalRow)-i][toArrayIndex(originalColumn)-i] != null) {
                        System.out.println("Bishop: Invalid Move. Piece(s) obstructing path.");
                        return false;
                    }
                }
                return true;

            } else if(toArrayIndex(newRow) > toArrayIndex(originalRow) && toArrayIndex(newColumn) > toArrayIndex(originalColumn)) { // going to bottom right
                for(int i = 1; i < distance; i++) {
                    if(boardArray[toArrayIndex(originalRow)+i][toArrayIndex(originalColumn)+i] != null) {
                        System.out.println("Bishop: Invalid Move. Piece(s) obstructing path.");
                        return false;
                    }
                }
                return true;

            } else if(toArrayIndex(newRow) > toArrayIndex(originalRow) && toArrayIndex(newColumn) < toArrayIndex(originalColumn)) { // going to bottom left
                for(int i = 1; i < distance; i++) {
                    if(boardArray[toArrayIndex(originalRow)+i][toArrayIndex(originalColumn)-i] != null) {
                        System.out.println("Bishop: Invalid Move. Piece(s) obstructing path.");
                        return false;
                    }
                }
                return true;

            } else {
                System.out.println("Bishop: Honestly I have no idea how you got here. But now that you're here, hi! How's your day going?");
                return false;
            }

        } else {
            System.out.println("Bishop: Invalid Move. Bishop can only move diagonally.");
            return false;
        }


    }

    public PieceData aiFindSpacesToAttack(ChessPiece[][] boardArray) {
        // Pawn code, revise for specific moves
        if(boardArray[arrayPosRow + 1][arrayPosColumn+1] != null) {
            if(boardArray[arrayPosRow + 1][arrayPosColumn+1].getOwner() == Team.WHITE) {
                return new PieceData(arrayPosRow+1, arrayPosColumn+1, this.pieceValue);
            }

        } else if(boardArray[arrayPosRow + 1][arrayPosColumn-1] != null) {
            if(boardArray[arrayPosRow + 1][arrayPosColumn-1].getOwner() == Team.WHITE) {
                return new PieceData(arrayPosRow+1, arrayPosColumn-1, this.pieceValue);
            }
        } else {
            return null;
        }
        return null;
    }

}
