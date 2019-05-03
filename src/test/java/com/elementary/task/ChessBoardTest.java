package com.elementary.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardTest {

    @Test
    void checkBoardGenerating() {
        int width = 11;
        int height = 5;
        int cellCount = width * height + (height - 1);
        ChessBoard chessBoard = new ChessBoard(width, height);

        String board = chessBoard.getBoard();

        assertEquals(cellCount, board.length());
    }
}