package com.elementary.starter.starterimpl;

import com.elementary.io.InputValidator;
import com.elementary.starter.Starter;
import com.elementary.task.chessboard.ChessBoard;

public final class ChessBoardStarter implements Starter {

    private static final String runInstruction = "To run ChessBoard app you need specify at least two" +
            " number arguments: width, height of ChessBoard.";

    private static final int requiredNumberOfArguments = 2;

    public ChessBoardStarter() {
    }

    public static void main(String[] args) {
        ChessBoardStarter chessBoardStarter = new ChessBoardStarter();
        chessBoardStarter.start(args);
    }

    public void start(String[] args) {

        if (InputValidator.isValidNumberArgs(args, requiredNumberOfArguments)) {
            int width = Integer.parseInt(args[0]);
            int height = Integer.parseInt(args[1]);

            ChessBoard chessBoard = new ChessBoard(width, height);
            chessBoard.printBoardIntoConsole();

        } else {
            printRunAppInstruction();
        }
    }

    public void printRunAppInstruction() {
        System.out.println(ChessBoardStarter.runInstruction);
    }
}
