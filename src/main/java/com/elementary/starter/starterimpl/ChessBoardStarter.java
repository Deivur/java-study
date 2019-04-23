package com.elementary.starter.starterimpl;

import com.elementary.io.IntegerConsoleWorker;
import com.elementary.starter.Starter;
import com.elementary.task.chessboard.ChessBoard;

public final class ChessBoardStarter implements Starter {

    private static final String RUN_INSTRUCTION = "To run ChessBoard app you need specify at least two" +
            " integer arguments: width, height of ChessBoard.";

    private static ChessBoardStarter CHESS_BOARD_STARTER = new ChessBoardStarter();

    private ChessBoardStarter() {
    }

    @Override
    public void start(String[] args) {
        try (IntegerConsoleWorker consoleWorker =
                     new IntegerConsoleWorker().setDefaultValue(15).setMinValue(0)) {
            consoleWorker.print(RUN_INSTRUCTION);
            int width = consoleWorker.read("Enter an integer chessboard width");
            int height = consoleWorker.read("Enter an integer chessboard height");
            ChessBoard chessBoard = new ChessBoard(width, height);
            consoleWorker.print(chessBoard.getBoard());
        }
    }

    public static ChessBoardStarter getInstance() {
        return CHESS_BOARD_STARTER;
    }
}
