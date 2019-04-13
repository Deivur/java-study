package com.elementary.task1;

import com.elementary.util.StringUtil;

public final class ChessBoardInitializer {

    private static final String runInstruction = "To run ChessBoard app you need specify at least two" +
            " number arguments: width, height of ChessBoard.";

    private ChessBoardInitializer() {
    }

    public static void start(String[] args) {

        if (isValidArgs(args)) {
            int width = Integer.parseInt(args[0]);
            int height = Integer.parseInt(args[1]);

            ChessBoard chessBoard = new ChessBoard(width, height);
            chessBoard.printBoard();

        } else {
            printRunAppInstruction();
        }
    }

    private static void printRunAppInstruction() {
        System.out.println(ChessBoardInitializer.runInstruction);
    }

    private static boolean isValidArgs(String[] args) {
        return hasRequiredNumberOfArgs(args) && argsIsNumbers(args);
    }

    private static boolean argsIsNumbers(String[] args) {
        return  StringUtil.isNumeric(args[0]) && StringUtil.isNumeric(args[1]);
    }

    private static boolean hasRequiredNumberOfArgs(String[] args) {
        int requiredNumberOfArguments = 2;
        return args.length == requiredNumberOfArguments;
    }
}
