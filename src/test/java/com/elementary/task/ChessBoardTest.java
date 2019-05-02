package com.elementary.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardTest {

    @Test
    void checkBoardGenerating() {
        int width = 11;
        int height = 5;
        int cellCount = 5 * 11 + (height - 1);
        ChessBoard chessBoard = new ChessBoard(width, height);
        String board = chessBoard.getBoard();
        int boardLength = board.length();
        assertEquals(cellCount, boardLength);
    }
}