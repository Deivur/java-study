package com.elementary.starter;

import com.elementary.io.IntegerConsoleWorker;
import com.elementary.task.ChessBoard;

public final class ChessBoardStarter implements Starter {

    private static final String RUN_INSTRUCTION = "To run ChessBoard app you need specify at least two" +
            " integer arguments: width, height of ChessBoard.";

    private static ChessBoardStarter CHESS_BOARD_STARTER = new ChessBoardStarter();

    private ChessBoardStarter() {
    }

    @Override
    public void start(String[] args) {
        try (IntegerConsoleWorker consoleWorker =
                     new IntegerConsoleWorker().setDefaultValue(11).setMinValue(0)) {
            consoleWorker.print(RUN_INSTRUCTION);
            int width = consoleWorker.read("Enter an integer chessboard width");
            int height = consoleWorker.read("Enter an integer chessboard height");
            ChessBoard blackChessBoard = new ChessBoard(width, height, true);
            consoleWorker.print(blackChessBoard.getBoard());
            consoleWorker.print("----------------");
            ChessBoard whiteChessBoard = new ChessBoard(width, height, false);
            consoleWorker.print(whiteChessBoard.getBoard());
        }
    }

    public static ChessBoardStarter getInstance() {
        return ChessBoardStarter.CHESS_BOARD_STARTER;
    }
}
