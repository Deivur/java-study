package com.elementary.starter.starterimpl;

import com.elementary.io.InputValidator;
import com.elementary.starter.Starter;
import com.elementary.task.chessboard.ChessBoard;

public final class ChessBoardStarter implements Starter {

    private static final String runInstruction = "To run ChessBoard app you need specify at least two" +
            " integer arguments: width, height of ChessBoard.";

    private static final int requiredNumberOfArguments = 2;

    private static ChessBoardStarter CHESS_BOARD_STARTER = new ChessBoardStarter();

    private ChessBoardStarter() {
    }

    @Override
    public void start(String[] args) {

        if (InputValidator.hasRequiredNumberOfArgs(args, requiredNumberOfArguments)) {
            int width = InputValidator.getInt(args[0]);
            int height = InputValidator.getInt(args[1]);

            ChessBoard chessBoard = new ChessBoard(width, height);
            chessBoard.printBoardIntoConsole();

        } else {
            printSubAppRunInstruction();
        }
    }

    @Override
    public void printSubAppRunInstruction() {
        System.out.println(ChessBoardStarter.runInstruction);
    }

    public static ChessBoardStarter getInstance() {
        return CHESS_BOARD_STARTER;
    }
}
