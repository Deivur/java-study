package com.elementary.task;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardTest {

    @ParameterizedTest
    @CsvSource({
            "11, 5",
            "3, 4",
            "1236, 345",
            "-123, 5",
            "-76, -43"
    })
    void checkBoardGenerating(@AggregateWith(ChessBoardAggregator.class) ChessBoard chessBoard) {
        int width = chessBoard.getWidth();
        int height = chessBoard.getHeight();
        int cellCount = width * height + (height - 1);

        String board = chessBoard.getBoard();

        assertEquals(cellCount, board.length());
    }
}